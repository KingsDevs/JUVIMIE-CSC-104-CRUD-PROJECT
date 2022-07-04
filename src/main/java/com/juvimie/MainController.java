package com.juvimie;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController 
{
    @FXML
    void buy(ActionEvent event) 
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("Coming Soon!");
        alert.show();
    }

    @FXML
    void sell(ActionEvent event) throws IOException 
    {
        App.setRoot("seller");
    }
}
