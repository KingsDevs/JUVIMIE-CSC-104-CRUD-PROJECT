package com.juvimie;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DialogController implements Initializable
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

    private int mode;
    public final static int ADD_MODE = 1;
    public final static int UPDATE_MODE = 2;

    public void setMode(int mode)
    {
        this.mode = mode;
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


    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage =  (Stage)okButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void comfirm(ActionEvent event) 
    {

    }

}
