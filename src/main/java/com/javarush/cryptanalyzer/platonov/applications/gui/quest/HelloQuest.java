package com.javarush.cryptanalyzer.platonov.applications.gui.quest;

import com.javarush.cryptanalyzer.platonov.applications.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Heroes;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloQuest extends Quest
{

    public HelloQuest()
    {
        super();
    }

    @Override
    protected void setResourceBundle()
    {
        RESOURCE_BUNDLE_ID = ResourceBundleList.HELLO_QUEST;
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_ID, locale);
    }

    @Override
    protected void setAllowedAnswers()
    {
        allowedAnswers = new String[] {"QWERTY"};
    }

    @Override
    public void launchQuest()
    {
        Heroes.UI.sentMessage(resourceBundle.getString("HELLO"));
        allowedAnswers = new String[]{resourceBundle.getString("MY_CONDOLENCES")};
        ArrayList<Button> buttons = guiAppController.createButtons(allowedAnswers);
        Button condolences = buttons.get(0);
        condolences.setOnAction(actionEvent ->
        {
            guiAppController.cleanButtonPane();
            Heroes.USER.sentMessage(allowedAnswers[0]);
            helloQuestPartTwo();
        });


    }
    private void helloQuestPartTwo()
    {
        ArrayList<String> messages = new ArrayList<>();
        ArrayList<Heroes.Hero> autor = new ArrayList<>();

        messages.add(resourceBundle.getString("THANK_YOU"));
        autor.add(Heroes.UI);
        messages.add(resourceBundle.getString("WHAT_THE_HELL"));
        autor.add(Heroes.CREATOR);
        messages.add(resourceBundle.getString("MEET_CREATOR"));
        autor.add(Heroes.UI);
        messages.add(resourceBundle.getString("I_HOPE"));
        autor.add(Heroes.CREATOR);
        messages.add(resourceBundle.getString("PIECE_OF_MEAT"));
        autor.add(Heroes.UI);
        messages.add(resourceBundle.getString("I_CAN"));
        autor.add(Heroes.UI);
        messages.add(resourceBundle.getString("TELL_ABOUT_ENIGMA"));
        autor.add(Heroes.CREATOR);
        messages.add(resourceBundle.getString("EVERYONE_TIRED"));
        autor.add(Heroes.UI);
        messages.add(resourceBundle.getString("DISCLAIMER"));
        autor.add(Heroes.UI);
        messages.add(resourceBundle.getString("ROBOT_LAWS"));
        autor.add(Heroes.UI);
        messages.add(resourceBundle.getString("ROBOT_ZERO_LAW"));
        autor.add(Heroes.UI);

        step = 0;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent ->
        {
            autor.get(step).sentMessage(messages.get(step));
            ScrollPane scroll = guiAppController.getScroll();
            scroll.setVvalue(scroll.getVmax());
            step++;
        }));
        timeline.setCycleCount(messages.size());
        timeline.play();

        timeline.setOnFinished(actionEvent ->
        {
            helloQuestPartThree();
        });
    }
    private void helloQuestPartThree()
    {
        allowedAnswers = new String[]{resourceBundle.getString("I_PROMISE")};
        ArrayList<Button> buttons = guiAppController.createButtons(allowedAnswers);
        Button promise = buttons.get(0);
        promise.setOnAction(actionEvent ->
        {
            guiAppController.cleanButtonPane();
            Heroes.USER.sentMessage(allowedAnswers[0]);


            ScrollPane scroll = guiAppController.getScroll();
            scroll.setVvalue(scroll.getVmax());
        });
    }
}
