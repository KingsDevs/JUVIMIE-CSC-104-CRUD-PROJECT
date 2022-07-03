package com.juvimie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"));
        stage.setScene(scene);
        stage.setTitle("Sari Sari Store");
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static URL loadFXMLloader(String fxmlName)
    {
        URL fileUrl = App.class.getResource(fxmlName + ".fxml");
        return fileUrl;
        
    }



    public static void createModal(Parent root, Window window, String title)
    {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setResizable(false);

        Scene sc = new Scene(root);
        stage.setScene(sc);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(window);
        stage.show();
    }

    
    public static void main(String[] args) throws Exception 
    {
        ConnSqlite.getStatement();
        
        launch();
    }

}