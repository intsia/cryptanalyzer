package com.javarush.cryptanalyzer.platonov.oldshit.gui.quest;

import com.javarush.cryptanalyzer.platonov.oldshit.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers.GuiAppController;
import com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers.Heroes;
import com.javarush.cryptanalyzer.platonov.oldshit.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.gui.desktop.creators.GUILoader;
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

        GuiAppController guiController = fxmlLoader.getController();

        ArrayList<HashMap<Enum, Integer>> workLog = guiController.coreController.Decrypt();

        step = 0;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent ->
        {
            HashMap<Enum, Integer> stepLog = workLog.get(step++);
            char first = guiController.coreController.getRotorValueOfIndex(RotorsTypes.BASE, stepLog.get(RotorsTypes.BASE), 0);
            char second = guiController.coreController.getRotorValueOfIndex(RotorsTypes.FIRST, stepLog.get(RotorsTypes.FIRST), 0);

            int shift = stepLog.get(RotorsTypes.FIRST) - stepLog.get(RotorsTypes.BASE);
            guiController.setFirstRotorValue( stepLog.get(RotorsTypes.FIRST), shift, guiController.coreController);
            guiController.setBaseRotorValue(stepLog.get(RotorsTypes.BASE),guiController.coreController);


            GUILoader.getInstance().getMainChatControl().sendMessage(Heroes.UI, resourceBundle.getString("REPLACE") + "'" + first + "'" + resourceBundle.getString("WITH") + "'" + second + "'");
        }));
        timeline.setCycleCount(guiController.coreController.getTextSize());
        timeline.play();

        timeline.setOnFinished(actionEvent ->
        {
            GUILoader.getInstance().getMainChatControl().sendMessage(Heroes.UI,guiController.coreController.getResult());
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
