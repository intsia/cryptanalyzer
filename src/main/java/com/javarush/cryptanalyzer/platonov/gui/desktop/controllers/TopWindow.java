package com.javarush.cryptanalyzer.platonov.gui.desktop.controllers;

import javafx.scene.layout.HBox;

public class TopWindow
{
    private static TopWindow topWindow = new TopWindow();
    private HBox hBox;

    private TopWindow()
    {
        hBox = new HBox();
       // hBox.setPrefHeight(200);
        hBox.setMaxHeight(200);
        hBox.setMaxWidth(50);
    }

    public static TopWindow getInstance()
    {
        return topWindow;
    }

    public HBox getControlNode()
    {
        return hBox;
    }
}
