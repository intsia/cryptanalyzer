package com.javarush.cryptanalyzer.platonov.applications.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller
{
    private ResourceBundle textBundle = ResourceBundle.getBundle("test");


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private TextFlow message;

    @FXML
    private Text messageText;

    @FXML
    private VBox scrollPane;

    @FXML
    void initialize()
    {
        button.setOnAction(actionEvent ->
        {
            printMessage(textBundle.getString("hello"));
        });
    }

    void printMessage(String messageText)
    {
        TextFlow textFlow = new TextFlow();
        textFlow.setStyle("-fx-border-color: #222020; -fx-border-radius: 5;");
        textFlow.setMaxWidth(1000);
        scrollPane.getChildren().add(textFlow);
        Insets insets = new Insets(10, 10, 10, 100);
        scrollPane.setMargin(textFlow, insets);

        Text text = new Text(messageText);
        Font font = new Font(30.0);

        textFlow.getChildren().add(text);

        text.setFont(font);
        Insets paddingInsens = new Insets(10, 10, 10, 10);
        textFlow.setPadding(paddingInsens);
    }
}