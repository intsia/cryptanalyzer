package com.javarush.cryptanalyzer.platonov.gui.desktop.controllers;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BottomWindow
{
    private static BottomWindow bottomWindow = new BottomWindow();
    private VBox vBox;

    private BottomWindow()
    {
        vBox = new VBox();
        vBox.setMinHeight(200);
        vBox.setMinWidth(200);
        Text text = new Text("BOTTOM");
        vBox.getChildren().add(text);
    }

    public static BottomWindow getInstance()
    {
        return bottomWindow;
    }

    public VBox getControlNode()
    {
        return vBox;
    }
}
