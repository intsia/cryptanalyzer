package com.javarush.cryptanalyzer.platonov.applications.console.console;

import java.util.Scanner;

public abstract class ConsoleValidator
{
    public static String getStringFromUser(String[] valideValues, Scanner console)
    {
        boolean validationSucсess = false;
        String inputData = null;

        while (validationSucсess == false)
        {
            inputData = console.nextLine();

            for (String str : valideValues)
            {
                if (inputData.equals(str))
                {
                    validationSucсess = true;
                }
            }
            if (validationSucсess == false)
            {
                System.out.printf("Вы ввели %s, а я попросил вас выбрать из следующих значений:", inputData);
                for (int i = 0; i < valideValues.length; i++)
                {
                    System.out.printf("[%s]", valideValues[i]);
                }
                System.out.println("Попробуйте еще раз :)");
            }
        }
        return inputData;
    }
}
