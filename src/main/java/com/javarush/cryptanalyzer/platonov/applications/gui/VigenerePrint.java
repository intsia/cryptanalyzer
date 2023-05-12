package com.javarush.cryptanalyzer.platonov.applications.gui;

import com.javarush.cryptanalyzer.platonov.GUIApplication;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Controller;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Heroes;

import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;

public class VigenerePrint
{
    private static FXMLLoader fxmlLoader = GUIApplication.fxmlLoader;
    private static int step;
    public static void launch(ArrayList<HashMap<Enum, Integer>> workLog,  IApplication coreController)
    {
        String name = "Encryption Bot";

        Controller guiController = fxmlLoader.getController();

        step = 0;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent ->
        {
            HashMap<Enum, Integer> stepLog = workLog.get(step++);
            char first = coreController.getRotorValueOfIndex(RotorsTypes.BASE, stepLog.get(RotorsTypes.BASE), 0);
            char second = coreController.getRotorValueOfIndex(RotorsTypes.FIRST, stepLog.get(RotorsTypes.FIRST), 0);

            int shift = stepLog.get(RotorsTypes.FIRST) - stepLog.get(RotorsTypes.BASE);
            guiController.setFirstRotorValue( stepLog.get(RotorsTypes.FIRST), shift, coreController);
            guiController.setBaseRotorValue(stepLog.get(RotorsTypes.BASE),coreController);

            Heroes.UI.sentMessage( "Заменяю символ " + "'" + first + "'" + " на символ " + "'" + second + "'");
        }));
        timeline.setCycleCount(coreController.getTextSize());
        timeline.play();

        timeline.setOnFinished(actionEvent ->
        {
            Heroes.UI.sentMessage(coreController.getResult());
        });

    }
}
