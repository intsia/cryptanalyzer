package com.javarush.cryptanalyzer.platonov.gui.desktop.elements;

import com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers.Heroes;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class Chat
{
    private VBox messages;
    {
        messages = new VBox();
    }
    private ScrollPane chat;
    {
        chat = new ScrollPane(messages);
        chat.setFitToHeight(true);
        chat.setFitToWidth(true);
        chat.setStyle("-fx-background-color: #F0F8FF;");
        chat.setStyle("-fx-border-color: #B0C4DE;");

        //chat.setMaxHeight(800);
    }

    public ScrollPane getControlNode()
    {
        return chat;
    }

    public void sendMessage(Heroes.Hero hero, String messageText)
    {
        Message message = new Message(hero, messageText);
        messages.getChildren().add(message.getControlNode());
    }
}
