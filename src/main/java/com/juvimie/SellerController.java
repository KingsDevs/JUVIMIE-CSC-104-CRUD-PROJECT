package com.juvimie;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SellerController 
{

    @FXML
    private TableColumn<?, ?> QuantityCol;

    @FXML
    private Button addProductBtn;

    @FXML
    private Button backBtn;

    @FXML
    private TableColumn<?, ?> countryOfOrigin;

    @FXML
    private Button editProductBtn;

    @FXML
    private TableColumn<?, ?> prizeCol;

    @FXML
    private TableColumn<?, ?> productNameCol;

    @FXML
    private Button removeProductBtn;

    @FXML
    private TableView<?> storeTable;

    @FXML
    private TableColumn<?, ?> typeOfProductCol;

    @FXML
    void addProduct(ActionEvent event) {

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
