package com.javarush.cryptanalyzer.platonov.applications.gui.quest;

import com.javarush.cryptanalyzer.platonov.GUIApplication;
import com.javarush.cryptanalyzer.platonov.applications.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.GuiAppController;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Heroes;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Quest
{
    protected static FXMLLoader fxmlLoader = GUIApplication.fxmlLoader;
    protected static GuiAppController guiAppController = fxmlLoader.getController();
    protected static Locale locale; //TODO возможно можно сделать приватным

    protected static final String RESOURCE_BUNDLE_CONTROLLER_ID = ResourceBundleList.QUEST_CONTROLLER;
    protected static ResourceBundle controllerResourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_CONTROLLER_ID);

    protected String RESOURCE_BUNDLE_ID;
    protected ResourceBundle resourceBundle;
    protected String userAnswer;
    protected String[] allowedAnswers;
    protected ArrayList<Button> buttons;
    protected int step;
    public Quest ()
    {
//        locale = GuiAppController.locale;
        setResourceBundleID();
        setAllowedAnswers();
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_ID, locale);
    }
    protected abstract void launchQuest();
    protected abstract void setResourceBundleID();
    protected abstract void setAllowedAnswers();
    public static void setLocale(Locale newLocale)
    {
        Quest.locale = newLocale;
        controllerResourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_CONTROLLER_ID, locale);
    }

    protected boolean checkAnswer()
    {
        for (String answer : allowedAnswers)
        {
            if (answer.equals(userAnswer)) return true;
        }
        return false;
    }

    protected void tryAgain()
    {
        StringBuilder result = new StringBuilder();
        result.append(controllerResourceBundle.getString("YOU_WROTE"));
        result.append(userAnswer);
        result.append(controllerResourceBundle.getString("TRY_AGAIN"));
        for(String answer : allowedAnswers)
        {
            result.append("\n- " + answer);
        }

        Heroes.UI.sendMessage(result.toString());
    }
}
