package com.javarush.cryptanalyzer.platonov.applications.gui.quest;

import com.javarush.cryptanalyzer.platonov.GUIApplication;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class Quest
{
    public Quest(TextField userTextLine, IApplication coreController)
    {
        fxmlLoader = GUIApplication.fxmlLoader;
        this.coreController = coreController;
        this.userTextLine = userTextLine;
    }
    private FXMLLoader fxmlLoader;
    private IApplication coreController;
    private TextField userTextLine;
    private QuestList nextQuest;


    public void launch(String userTextLine)
    {
        switch (nextQuest)
        {
            case HELLO ->
            {
                helloQuest(userTextLine);
            }
            case WHAT_IS_YOUR_NAME ->
            {
                whatIsYourNameQuest(userTextLine);
            }
        }
    }

    private void helloQuest(String userTextLine)
    {

    }

    private void whatIsYourNameQuest(String userTextLine)
    {

    }

    private void uploadEncryptionTextQuest(String userTextLine)
    {

    }

    private void uploadEncryptionKeyQuest(String userTextLine)
    {

    }
}
