package com.javarush.cryptanalyzer.platonov.applications.gui.quest;

import com.javarush.cryptanalyzer.platonov.applications.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.applications.gui.controllers.Heroes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.ArrayList;

public class HelloQuest extends Quest
{

    public HelloQuest()
    {
        super();
    }

    @Override
    protected void setResourceBundleID()
    {
        RESOURCE_BUNDLE_ID = ResourceBundleList.HELLO_QUEST;
    }

    @Override
    protected void setAllowedAnswers()
    {

    }

    @Override
    public void launchQuest()
    {
        Heroes.UI.sendMessage(resourceBundle.getString("HELLO"));
        allowedAnswers = new String[]{resourceBundle.getString("MY_CONDOLENCES")};
        ArrayList<Button> buttons = guiAppController.createButtons(allowedAnswers);
        Button condolences = buttons.get(0);
        condolences.setOnAction(actionEvent ->
        {
            guiAppController.cleanButtonPane();
            Heroes.USER.sendMessage(allowedAnswers[0]);
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

        allowedAnswers = new String[]{resourceBundle.getString("NEXT")};
        buttons = guiAppController.createButtons(allowedAnswers);
        Button next = buttons.get(0);
        step = 0;
        next.setOnAction(actionEvent ->
        {
            autor.get(step).sendMessage(messages.get(step));
            step++;
            if (step == messages.size())
            {
                guiAppController.cleanButtonPane();
                helloQuestPartThree();
            }
        });
    }

    private void helloQuestPartThree()
    {
        allowedAnswers = new String[]{resourceBundle.getString("I_PROMISE")};
        buttons = guiAppController.createButtons(allowedAnswers);
        Button promise = buttons.get(0);
        promise.setOnAction(actionEvent ->
        {
            guiAppController.cleanButtonPane();
            Heroes.USER.sendMessage(allowedAnswers[0]);

            VigenereQuest vigenereQuest = new VigenereQuest();
            vigenereQuest.launchQuest();
        });
    }
}
