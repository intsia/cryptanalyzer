package com.javarush.cryptanalyzer.platonov.applications.gui.quest;

import com.javarush.cryptanalyzer.platonov.applications.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.GuiAppController;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Heroes;
import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;

public class VigenereQuest extends Quest
{

    @Override
    protected void launchQuest()
    {
        String name = "Encryption Bot";

        GuiAppController guiController = fxmlLoader.getController();

        ArrayList<HashMap<Enum, Integer>> workLog = guiController.coreController.Decrypt();

        step = 0;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), actionEvent ->
        {
            HashMap<Enum, Integer> stepLog = workLog.get(step++);
            char first = guiController.coreController.getRotorValueOfIndex(RotorsTypes.BASE, stepLog.get(RotorsTypes.BASE), 0);
            char second = guiController.coreController.getRotorValueOfIndex(RotorsTypes.FIRST, stepLog.get(RotorsTypes.FIRST), 0);

            int shift = stepLog.get(RotorsTypes.FIRST) - stepLog.get(RotorsTypes.BASE);
            guiController.setFirstRotorValue( stepLog.get(RotorsTypes.FIRST), shift, guiController.coreController);
            guiController.setBaseRotorValue(stepLog.get(RotorsTypes.BASE),guiController.coreController);

            Heroes.UI.sentMessage( "Заменяю символ " + "'" + first + "'" + " на символ " + "'" + second + "'");
        }));
        timeline.setCycleCount(guiController.coreController.getTextSize());
        timeline.play();

        timeline.setOnFinished(actionEvent ->
        {
            Heroes.UI.sentMessage(guiController.coreController.getResult());
        });
    }

    @Override
    protected void setResourceBundleID()
    {
        RESOURCE_BUNDLE_ID = ResourceBundleList.VIGENERE_QUEST;
    }

    @Override
    protected void setAllowedAnswers()
    {

    }
}
