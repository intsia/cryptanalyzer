package com.javarush.cryptanalyzer.platonov;

import com.javarush.cryptanalyzer.platonov.gui.desktop.creators.GUILoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIApplication extends Application
{
    public static FXMLLoader fxmlLoader;
    @Override
    public void start(Stage stage) throws IOException
    {
        Scene scene = new Scene(GUILoader.getInstance().getControlNode());

        stage.setScene(scene);
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.show();
    }

    public static void launchGUIApp()
    {
        launch();
    }
}
