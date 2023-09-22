package com.javarush.cryptanalyzer.platonov.gui.desktop.controllers;

import javafx.scene.layout.VBox;

public class ContactsWindow
{
    private static ContactsWindow contactsWindow = new ContactsWindow();
    private VBox vBox;
    private ContactsWindow()
    {
        vBox = new VBox();
        vBox.setPrefWidth(200);
    }

    public static ContactsWindow getInstance()
    {
        return contactsWindow;
    }

    public VBox getControlNode()
    {
        return vBox;
    }
}
