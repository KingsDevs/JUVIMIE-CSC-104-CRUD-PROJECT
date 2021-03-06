package com.juvimie;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DialogController implements Initializable
{

    @FXML
    private ChoiceBox<String> countryOfOriginField;

    @FXML
    private Button okButton;

    @FXML
    private TextField prizeField;

    @FXML
    private TextField productNameField;

    @FXML
    private ChoiceBox<String> productTypeField;

    @FXML
    private TextField quantityField;

    private int mode;
    public final static int ADD_MODE = 1;
    public final static int UPDATE_MODE = 2;

    private SellerController sellerController;
    private Product productToEdit;

    public void setMode()
    {
        this.mode = ADD_MODE;
    }

    public void setMode(Product product)
    {
        this.mode = UPDATE_MODE;
        productToEdit = product;

        productNameField.setText(product.getProductName());
        prizeField.setText(product.getProductPrize().toString());
        quantityField.setText(product.getQuantity().toString());
        productTypeField.setValue(product.getProductType());
        countryOfOriginField.setValue(product.getProductOrigin());
    }

    public void setSellerController(SellerController sellerController)
    {
        this.sellerController = sellerController;
    }

    private Product getProductFromFields()
    {
        String productName = productNameField.getText();
        String productPrizeStr = prizeField.getText();
        String quantityStr = quantityField.getText();
        String productType = productTypeField.getValue();
        String productOrigin = countryOfOriginField.getValue();

        if(!(
            (productName.isEmpty() || productName.isBlank()) &&
            (productPrizeStr.isEmpty() || productPrizeStr.isBlank()) &&
            (quantityStr.isEmpty() || quantityStr.isBlank()) &&
            (productType.isEmpty() || productType.isBlank()) &&
            (productOrigin.isEmpty() || productOrigin.isBlank())
        ))
        {
            Double productPrize = Double.parseDouble(productPrizeStr);
            int quantity = Integer.parseInt(quantityStr);

            return new Product(productName, productPrize, quantity, productType, productOrigin);
        }

        return null;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        quantityField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    quantityField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        prizeField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) 
                {
                    prizeField.setText(oldValue);
                }
            }
        });

        try {
            ResultSet productTypes = Product.getProductTypes();

            while (productTypes.next()) 
            {
                String productType = productTypes.getString(1);
                productTypeField.getItems().add(productType);
            }

            ResultSet countries = Product.getCountries();

            while (countries.next()) 
            {
                String country = countries.getString(1);
                countryOfOriginField.getItems().add(country);
            }
        } 
        catch (SQLException | IOException e) {
            
            e.printStackTrace();
        }

    }


    private void addProduct() throws IOException, SQLException
    {
        Product newProduct = getProductFromFields();

        if(newProduct != null)
        {
            Product.insertProduct(newProduct);
            cancel(new ActionEvent());
        }
    }

    private void editProduct() throws IOException, SQLException
    {
        Product oldProduct = getProductFromFields();
        
        if(oldProduct != null)
        {
            oldProduct.setProductId(productToEdit.getProductId());
            

            Alert confirmToUpdate = new Alert(AlertType.CONFIRMATION);
            confirmToUpdate.setContentText("Are you sure to edit this product " + productToEdit.getProductName() + "?");

            confirmToUpdate.showAndWait().ifPresent(response -> {
                if(response == ButtonType.OK)
                {
                    try {
                        Product.editProduct(oldProduct);
                        cancel(new ActionEvent());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            
        }
        
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage =  (Stage)okButton.getScene().getWindow();
        try {
            sellerController.updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.close();
    }

    @FXML
    void comfirm(ActionEvent event) throws IOException, SQLException
    {
        if(mode == ADD_MODE)
            addProduct();
        else if(mode == UPDATE_MODE)
            editProduct();

        
    }

}
