package com.juvimie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DialogController 
{

    @FXML
    private ChoiceBox<?> countryOfOriginField;

    @FXML
    private Button okButton;

    @FXML
    private TextField prizeField;

    @FXML
    private TextField productNameField;

    @FXML
    private ChoiceBox<?> productTypeField;

    @FXML
    private TextField quantityField;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void comfirm(ActionEvent event) 
    {

    }

}
