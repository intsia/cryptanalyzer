package com.javarush.cryptanalyzer.platonov.gui.desktop.elements;

import com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers.Heroes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Message
{

        public Message(Heroes.Hero hero, String messageText)
        {
            setMessageText(hero.getName(), messageText);
            setAvatarImage(hero.getAvatar());
            switch (hero.getSideOfPrintMessage())
            {
                case LEFT -> createLeftMessage();
                case RIGHT -> createRightMessage();
            }
        }

        public BorderPane getControlNode() {return messageFrame;}
        private final static Insets MESSAGE_INSETS = new Insets(10, 10, 10, 10);
        private final static Insets AVATAR_INSETS = new Insets(10, 10, 10, 10);
        private final static Font FONT_OF_MESSAGE = new Font(30.0);

        private Text text;
        {
            text = new Text();
            text.setFont(FONT_OF_MESSAGE);
        }

        private TextFlow textFrame;
        {
            textFrame = new TextFlow(text);
            textFrame.setStyle("-fx-border-color: #222020; -fx-border-radius: 5; -fx-background-color: #FFFFFF;");
            textFrame.setPrefWidth(100);
            textFrame.setMaxWidth(1000);
            textFrame.setPadding(MESSAGE_INSETS);
        }
        private Circle avatar;
        {
            avatar = new Circle();
            avatar.setRadius(50);
            avatar.setStrokeWidth(5.0);
            avatar.setStrokeType(StrokeType.INSIDE);
            avatar.setStroke(Paint.valueOf("#82828d"));
        }
        private VBox avatarFrame;
        {
            avatarFrame = new VBox(avatar);
            avatarFrame.setMargin(avatar, AVATAR_INSETS);
        }

        private BorderPane messageFrame;
        {
            messageFrame = new BorderPane();
            messageFrame.setCenter(textFrame);
        }
        private void setMessageText(String name, String messageText)
        {
            text.setText(name + " :\n" + messageText);
        }

        private void setAvatarImage(Image avatar)
        {
            this.avatar.setFill(new ImagePattern(avatar));
        }

        private void createLeftMessage()
        {
            BorderPane.setAlignment(textFrame, Pos.TOP_LEFT);
            messageFrame.setLeft(avatarFrame);
        }

        private void createRightMessage()
        {
            BorderPane.setAlignment(textFrame, Pos.TOP_RIGHT);
            messageFrame.setRight(avatarFrame);
            messageFrame.setAlignment(avatarFrame, Pos.TOP_RIGHT);
        }

}
