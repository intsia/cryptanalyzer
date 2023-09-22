package com.javarush.cryptanalyzer.platonov.oldshit.gui.quest;

import com.javarush.cryptanalyzer.platonov.oldshit.gui.ResourceBundleList;
import com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers.Heroes;
import com.javarush.cryptanalyzer.platonov.gui.desktop.creators.GUILoader;
import javafx.scene.control.Button;

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
        GUILoader.getInstance().getMainChatControl().sendMessage(Heroes.UI, resourceBundle.getString("HELLO"));
        allowedAnswers = new String[]{resourceBundle.getString("MY_CONDOLENCES")};
        ArrayList<Button> buttons = guiAppController.createButtons(allowedAnswers);
        Button condolences = buttons.get(0);
        condolences.setOnAction(actionEvent ->
        {
            guiAppController.cleanButtonPane();
            GUILoader.getInstance().getMainChatControl().sendMessage(Heroes.USER, allowedAnswers[0]);
            helloQuestPartTwo();
        });


    }

    private void helloQuestPartTwo()
    {
        ArrayList<String> messages = new ArrayList<>();
        ArrayList<Heroes.Hero> author = new ArrayList<>();

        messages.add(resourceBundle.getString("THANK_YOU"));
        author.add(Heroes.UI);
        messages.add(resourceBundle.getString("WHAT_THE_HELL"));
        author.add(Heroes.CREATOR);
        messages.add(resourceBundle.getString("MEET_CREATOR"));
        author.add(Heroes.UI);
        messages.add(resourceBundle.getString("I_HOPE"));
        author.add(Heroes.CREATOR);
        messages.add(resourceBundle.getString("PIECE_OF_MEAT"));
        author.add(Heroes.UI);
        messages.add(resourceBundle.getString("I_CAN"));
        author.add(Heroes.UI);
        messages.add(resourceBundle.getString("TELL_ABOUT_ENIGMA"));
        author.add(Heroes.CREATOR);
        messages.add(resourceBundle.getString("EVERYONE_TIRED"));
        author.add(Heroes.UI);
        messages.add(resourceBundle.getString("DISCLAIMER"));
        author.add(Heroes.UI);
        messages.add(resourceBundle.getString("ROBOT_LAWS"));
        author.add(Heroes.UI);
        messages.add(resourceBundle.getString("ROBOT_ZERO_LAW"));
        author.add(Heroes.UI);

        allowedAnswers = new String[]{resourceBundle.getString("NEXT")};
        buttons = guiAppController.createButtons(allowedAnswers);
        Button next = buttons.get(0);
        step = 0;
        next.setOnAction(actionEvent ->
        {
            GUILoader.getInstance().getMainChatControl().sendMessage(author.get(step), messages.get(step));

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
            GUILoader.getInstance().getMainChatControl().sendMessage(Heroes.USER, allowedAnswers[0]);


            VigenereQuest vigenereQuest = new VigenereQuest();
            vigenereQuest.launchQuest();
        });
    }

    private void helloQuestPartFour()
    {
        ArrayList<String> messages = new ArrayList<>();
        ArrayList<Heroes.Hero> author = new ArrayList<>();
    }
}
