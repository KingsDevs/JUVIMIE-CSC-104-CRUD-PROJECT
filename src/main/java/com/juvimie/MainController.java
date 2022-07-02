package com.juvimie;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController 
{
    @FXML
    void buy(ActionEvent event) 
    {

    }

    @FXML
    void sell(ActionEvent event) throws IOException 
    {
        App.setRoot("seller");
    }
}
