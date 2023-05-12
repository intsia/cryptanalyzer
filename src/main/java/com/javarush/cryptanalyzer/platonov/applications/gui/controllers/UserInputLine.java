package com.javarush.cryptanalyzer.platonov.applications.gui.controllers;

import com.javarush.cryptanalyzer.platonov.GUIApplication;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import javafx.fxml.FXMLLoader;

public class UserInputLine
{
    private static FXMLLoader fxmlLoader = GUIApplication.fxmlLoader;
    private static String userName = "User";
    private static String robotName = "Robot";

    public static String onClick(String str)
    {
        return str;
    }

}
