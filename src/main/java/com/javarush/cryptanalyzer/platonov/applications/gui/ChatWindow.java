package com.javarush.cryptanalyzer.platonov.applications.gui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class ChatWindow
{
    public static Image avatar = new Image("C:\\Program\\Projects\\javarush\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\platonov\\applications\\gui\\robot.png");

    public static void printMessageLeft(VBox scrollPane, String messageText, String name)
    {
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
        BorderPane.setAlignment(textFlow, Pos.TOP_LEFT);
        borderPane.setLeft(vbox);
        scrollPane.getChildren().add(borderPane);
    }

    public static void printMessageRight(VBox scrollPane, String messageText, String name)
    {
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
        BorderPane.setAlignment(textFlow, Pos.TOP_RIGHT);
        borderPane.setRight(vbox);
        borderPane.setAlignment(vbox, Pos.TOP_RIGHT);
        scrollPane.getChildren().add(borderPane);
    }
}
