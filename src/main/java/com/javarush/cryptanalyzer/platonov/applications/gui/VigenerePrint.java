package com.javarush.cryptanalyzer.platonov.applications.gui;

import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;

public class VigenerePrint
{
    public static void launch(ArrayList<HashMap<Enum, Integer>> workLog, VBox window, IApplication controller)
    {
        String name = "Encryption Bot";

        HashMap<Enum, Integer> stepLog;
        for (int i = 0; i < controller.getTextSize(); i++)
        {
            stepLog = workLog.get(i);
            char first = controller.getRotorValueOfIndex(RotorsTypes.BASE, stepLog.get(RotorsTypes.BASE), 0);
            char second = controller.getRotorValueOfIndex(RotorsTypes.FIRST, stepLog.get(RotorsTypes.FIRST), 0);

            ChatWindow.printMessageLeft(window, "Заменяю символ " + "'" + first + "'" + " на символ " + "'" + second + "'", name);
        }
        ChatWindow.printMessageRight(window, controller.getResult(), name);

    }
}
