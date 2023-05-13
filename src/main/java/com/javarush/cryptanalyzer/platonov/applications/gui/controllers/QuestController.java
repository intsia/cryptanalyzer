package com.javarush.cryptanalyzer.platonov.applications.gui.controllers;

import com.javarush.cryptanalyzer.platonov.applications.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.applications.gui.quest.HelloQuest;
import com.javarush.cryptanalyzer.platonov.applications.gui.quest.QuestList;


import java.util.Locale;
import java.util.ResourceBundle;

public abstract class QuestController
{
    private static QuestList nextQuest;// TODO инициализировать
    private static Locale locale = new Locale("en", "US"); //TODO инициализировать
    private final static String RESOURCE_BUNDLE_ID = ResourceBundleList.QUEST_CONTROLLER;
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_ID, locale);

    public static void setNextQuest(QuestList nextQuest)
    {
        QuestController.nextQuest = nextQuest;
    }
    public static void setLocale(Locale locale)
    {
        QuestController.locale = locale;
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_ID, locale);
    }


    public void startQuest(String userTextLine)
    {
        switch (nextQuest)
        {
            case HELLO ->
            {
                new HelloQuest();
            }
            case WHAT_IS_YOUR_NAME ->
            {
                whatIsYourNameQuest(userTextLine);
            }
        }
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
