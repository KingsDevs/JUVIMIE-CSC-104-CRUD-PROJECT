package com.juvimie;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SellerController implements Initializable
{

    @FXML
    private TableColumn<Product, Integer> QuantityCol;

    @FXML
    private Button addProductBtn;

    @FXML
    private Button backBtn;

    @FXML
    private TableColumn<Product, String> countryOfOrigin;

    @FXML
    private Button editProductBtn;

    @FXML
    private TableColumn<Product, Double> prizeCol;

    @FXML
    private TableColumn<Product, String> productNameCol;

    @FXML
    private Button removeProductBtn;

    @FXML
    private TableView<Product> storeTable;

    @FXML
    private TableColumn<Product, String> typeOfProductCol;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        productNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        prizeCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrize"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        typeOfProductCol.setCellValueFactory(new PropertyValueFactory<Product, String>("productType"));
        countryOfOrigin.setCellValueFactory(new PropertyValueFactory<Product, String>("productOrigin"));

        try {
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateTable() throws SQLException, IOException
    {
        ObservableList<Product> productList = storeTable.getItems();
        productList.clear();

        ResultSet products = Product.getAllProducts();
        while (products.next()) 
        {
            productList.add(
                new Product(products.getInt("product_id"),
                            products.getString("product_name"), 
                            products.getDouble("product_prize"), 
                            products.getInt("quantity"), 
                            products.getString("product_type"), 
                            products.getString("product_origin"))
            );    
        }

    }

    @FXML
    void addProduct(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(App.loadFXMLloader("dialog"));
        Parent root = loader.load();
        
        DialogController dialogController = loader.getController();
        dialogController.setMode();

        App.createModal(root, addProductBtn.getScene().getWindow(), "Add Product");
      
    }

    @FXML
    void back(ActionEvent event) throws IOException 
    {
        App.setRoot("main");
    }

    @FXML
    void editProduct(ActionEvent event) {

    }

    @FXML
    void removeProduct(ActionEvent event) {

    }

}
