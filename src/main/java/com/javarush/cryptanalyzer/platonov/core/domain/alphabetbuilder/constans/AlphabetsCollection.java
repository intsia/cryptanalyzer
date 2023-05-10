package com.javarush.cryptanalyzer.platonov.core.domain.alphabetbuilder.constans;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AlphabetsCollection
{
    public final static ArrayList <Character> alphabetRuLowerCase = new ArrayList<>(Arrays.asList('а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'));
    public final static ArrayList <Character> alphabetRuUpperCase = new ArrayList<>(Arrays.asList('А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'));
    public final static ArrayList <Character> alphabetEnLowerCase = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
    public final static ArrayList <Character> alphabetEnUpperCase = new ArrayList<>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', ' '));
    public final static ArrayList <Character> arabicNumeralsZeroEnd = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));


    public static final ArrayList<ArrayList<Character>> alphabetsCollection =  new ArrayList<>(Arrays.asList(alphabetEnUpperCase, alphabetEnLowerCase, alphabetRuUpperCase, alphabetRuLowerCase, arabicNumeralsZeroEnd));

    public static String printSeparateLine(int size)
    {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < size; i++)
        {
            str.append(String.format("-----"));
            //System.out.print("-----");
        }
        str.append("\n");
        //System.out.println();
        return str.toString();
    }


    public static String printIndexIntLine(ArrayList<Integer> array)
    {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < array.size(); i++)
        {
            str.append(String.format("[%03d]", array.get(i)));
            //System.out.printf(" %03d ", array.get(i));
        }
        str.append("\n");
        //System.out.println();
        return str.toString();
    }
    public static String printIndexLine(ArrayList<Character> array)
    {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < array.size(); i++)
        {
            str.append(String.format("[%03d]", i));
            //System.out.printf(" %03d ", i);
        }
        str.append("\n");
        //System.out.println();
        return str.toString();
    }

    public static String printValueLine(ArrayList<Character> array)
    {
        StringBuilder str = new StringBuilder();

        for (Character character : array)
        {
            str.append(String.format("[ %c ]", character));
            //System.out.printf("[ %c ]", character);
        }
            str.append("\n");
        //System.out.println();
        return str.toString();
    }
    public static String printIndexValueBlockLine(ArrayList<Character> array)
    {
        StringBuilder str = new StringBuilder();

        str.append(printSeparateLine(array.size()));
        str.append(printIndexLine(array));
        str.append(printValueLine(array));
        str.append(printSeparateLine(array.size()));

        return str.toString();
    }
}
