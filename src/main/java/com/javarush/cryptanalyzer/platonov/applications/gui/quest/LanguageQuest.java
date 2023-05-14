package com.javarush.cryptanalyzer.platonov.applications.gui.quest;

import com.javarush.cryptanalyzer.platonov.applications.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Heroes;
import javafx.scene.control.Button;
import org.w3c.dom.events.Event;

import java.util.Locale;

public class LanguageQuest extends Quest
{
    private final static String LANGUAGE_ENGLISH = "English";
    private final static String LANGUAGE_RUSSIAN = "Русский";
    private final static Locale localeEn = new Locale("en", "US");
    private final static Locale localeRu = new Locale("ru", "RU");

    @Override
    public void launchQuest()
    {
        Heroes.UI.sendMessage(resourceBundle.getString("CHOOSE"));

        buttons = guiAppController.createButtons(allowedAnswers);
        Button english = buttons.get(0);
        Button russian = buttons.get(1);


        english.setOnAction(actionEvent ->
        {
            guiAppController.setLocale(localeEn);
            guiAppController.cleanButtonPane();
            HelloQuest helloQuest = new HelloQuest();
            helloQuest.launchQuest();
        });

        russian.setOnAction(actionEvent ->
        {
            guiAppController.setLocale(localeRu);
            guiAppController.cleanButtonPane();
            HelloQuest helloQuest = new HelloQuest();
            helloQuest.launchQuest();
        });
    }

    @Override
    protected void setResourceBundleID()
    {
        RESOURCE_BUNDLE_ID = ResourceBundleList.LANGUAGE_QUEST;
    }

    @Override
    protected void setAllowedAnswers()
    {
        allowedAnswers = new String[]{LANGUAGE_ENGLISH, LANGUAGE_RUSSIAN};
    }
}
