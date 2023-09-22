package com.javarush.cryptanalyzer.platonov.gui.desktop.controllers;

public class ChatGuiWindow
{
//    private VBox messages;
//    {
//        messages = new VBox();
//    }
//    private ScrollPane chat;
//    {
//        chat = new ScrollPane(messages);
//        chat.setFitToHeight(true);
//        chat.setFitToWidth(true);
//        chat.setStyle("-fx-background-color: #F0F8FF;");
//        chat.setStyle("-fx-border-color: #B0C4DE;");
//    }
//
//    public ScrollPane getControlNode()
//    {
//        return chat;
//    }
//
//    public void sendMessage(Heroes.Hero hero, String messageText)
//    {
//        Message message = new Message(hero, messageText);
//        messages.getChildren().add(message.getControlNode());
//    }
//
//
//
//    public class Message
//    {
//        public Message(Heroes.Hero hero, String messageText)
//        {
//            setMessageText(hero.getName(), messageText);
//            setAvatarImage(hero.getAvatar());
//            switch (hero.getSideOfPrintMessage())
//            {
//                case LEFT -> createLeftMessage();
//                case RIGHT -> createRightMessage();
//            }
//        }
//
//        public BorderPane getControlNode() {return messageFrame;}
//        private final static Insets messageInsets = new Insets(10, 10, 10, 10);
//        private final static Insets avatarInsets = new Insets(10, 10, 10, 10);
//        private final static Font fontOfMessage = new Font(30.0);
//
//        private Text text;
//        {
//            text = new Text();
//            text.setFont(fontOfMessage);
//        }
//
//        private TextFlow textFrame;
//        {
//            textFrame = new TextFlow(text);
//            textFrame.setStyle("-fx-border-color: #222020; -fx-border-radius: 5; -fx-background-color: #FFFFFF;");
//            textFrame.setPrefWidth(100);
//            textFrame.setMaxWidth(1000);
//            textFrame.setPadding(messageInsets);
//        }
//        private Circle avatar;
//        {
//            avatar = new Circle();
//            avatar.setRadius(50);
//            avatar.setStrokeWidth(5.0);
//            avatar.setStrokeType(StrokeType.INSIDE);
//            avatar.setStroke(Paint.valueOf("#82828d"));
//        }
//        private VBox avatarFrame;
//        {
//            avatarFrame = new VBox(avatar);
//            avatarFrame.setMargin(avatar, avatarInsets);
//        }
//
//        private BorderPane messageFrame;
//        {
//            messageFrame = new BorderPane();
//            messageFrame.setCenter(textFrame);
//        }
//        private void setMessageText(String name, String messageText)
//        {
//            text.setText(name + " :\n" + messageText);
//        }
//
//        private void setAvatarImage(Image avatar)
//        {
//            this.avatar.setFill(new ImagePattern(avatar));
//        }
//
//        private void createLeftMessage()
//        {
//            BorderPane.setAlignment(textFrame, Pos.TOP_LEFT);
//            messageFrame.setLeft(avatarFrame);
//        }
//
//        private void createRightMessage()
//        {
//            BorderPane.setAlignment(textFrame, Pos.TOP_RIGHT);
//            messageFrame.setRight(avatarFrame);
//            messageFrame.setAlignment(avatarFrame, Pos.TOP_RIGHT);
//        }
//    }
}

