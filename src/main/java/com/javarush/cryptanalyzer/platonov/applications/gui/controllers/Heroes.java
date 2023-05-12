package com.javarush.cryptanalyzer.platonov.applications.gui.controllers;

import com.javarush.cryptanalyzer.platonov.GUIApplication;
import javafx.fxml.FXMLLoader;
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

public abstract class Heroes
{
    private static FXMLLoader fxmlLoader = GUIApplication.fxmlLoader;

    public final static Hero UI = new Hero("UI", Hero.Avatars.UI_AVATAR, Hero.SideOfPrintMessage.LEFT);
    public static Hero creator;
    public static Hero user;

    public static class Hero
    {
        public Hero(String name, Image avatar, SideOfPrintMessage sideOfPrintMessage)
        {
            this.name = name;
            this.avatar = avatar;
            this.sideOfPrintMessage = sideOfPrintMessage;
        }
        private static String name;
        private static Image avatar;
        private static SideOfPrintMessage sideOfPrintMessage;
        public enum SideOfPrintMessage
        {
            LEFT,
            RIGHT
        }
        public abstract static class Avatars
        {
            public final static Image UI_AVATAR = new Image("C:\\Program\\Projects\\javarush\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\platonov\\applications\\gui\\robot.png");
        }

        public static void sentMessage(String messageText)
        {
            Controller controller = fxmlLoader.getController();
            VBox scrollPane = controller.getScrollPane();

            TextFlow textFlow = new TextFlow();
            textFlow.setStyle("-fx-border-color: #222020; -fx-border-radius: 5; -fx-background-color: #FFFFFF;");
            textFlow.setMaxWidth(1000);
            Insets paddingInsens = new Insets(10, 10, 10, 10);
            textFlow.setPadding(paddingInsens);

            Text text = new Text(name + " :\n" + messageText);
            Font font = new Font(30.0);
            text.setFont(font);

            Circle circle = new Circle();
            circle.setRadius(50);
            circle.setFill(new ImagePattern(avatar));
            circle.setStrokeWidth(5.0);
            circle.setStrokeType(StrokeType.INSIDE);
            circle.setStroke(Paint.valueOf("#82828d"));

            VBox vbox = new VBox(circle);
            Insets vboxInsets = new Insets(10, 10, 10, 10);
            vbox.setMargin(circle, vboxInsets);

            textFlow.getChildren().add(text);

            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(textFlow);

            switch (sideOfPrintMessage)
            {
                case LEFT ->
                {

                    BorderPane.setAlignment(textFlow, Pos.TOP_LEFT);
                    borderPane.setLeft(vbox);
                }
                case RIGHT ->
                {
                    BorderPane.setAlignment(textFlow, Pos.TOP_RIGHT);
                    borderPane.setRight(vbox);
                    borderPane.setAlignment(vbox, Pos.TOP_RIGHT);
                }
            }

            scrollPane.getChildren().add(borderPane);
        }
    }
}
