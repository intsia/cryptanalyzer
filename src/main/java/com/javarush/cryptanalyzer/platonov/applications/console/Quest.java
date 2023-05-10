package com.javarush.cryptanalyzer.platonov.applications.console;

import com.javarush.cryptanalyzer.platonov.applications.console.console.ConsoleStoryTeller;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class Quest
{
    protected Locale locale;
    protected Scanner console;
    protected ResourceBundle text;
    protected ConsoleStoryTeller storyTeller;

    public Quest(String resourceBundle, Locale locale)
    {
        this.locale = locale;
        console = new Scanner(System.in);
        text = ResourceBundle.getBundle(resourceBundle, locale);
        storyTeller = new ConsoleStoryTeller(locale);
    }
}
