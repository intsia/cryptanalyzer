package com.javarush.cryptanalyzer.platonov;

import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIApplication extends Application
{
    public static FXMLLoader fxmlLoader;
    public static Controller controller;
    @Override
    public void start(Stage stage) throws IOException
    {
        fxmlLoader = new FXMLLoader(GUIApplication.class.getResource("hello-view.fxml"));
        controller = fxmlLoader.getController();

        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void launchGUIApp()
    {
        launch();
    }
}