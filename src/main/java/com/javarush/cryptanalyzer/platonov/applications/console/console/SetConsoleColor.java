package com.javarush.cryptanalyzer.platonov.applications.console.console;

import com.javarush.cryptanalyzer.platonov.applications.console.constants.ConsoleColorANSI;

public class SetConsoleColor
{
    public static void reset()
    {
        System.out.printf(ConsoleColorANSI.ANSI_RESET);
    }

    public static void black()
    {
        System.out.printf(ConsoleColorANSI.ANSI_BLACK);
    }

    public static void red()
    {
        System.out.printf(ConsoleColorANSI.ANSI_RED);
    }

    public static void green()
    {
        System.out.printf(ConsoleColorANSI.ANSI_GREEN);
    }

    public static void yellow()
    {
        System.out.printf(ConsoleColorANSI.ANSI_YELLOW);
    }

    public static void blue()
    {
        System.out.printf(ConsoleColorANSI.ANSI_BLUE);
    }

    public static void purple()
    {
        System.out.printf(ConsoleColorANSI.ANSI_PURPLE);
    }

    public static void cyan()
    {
        System.out.printf(ConsoleColorANSI.ANSI_CYAN);
    }

    public static void white()
    {
        System.out.printf(ConsoleColorANSI.ANSI_WHITE);
    }
}
