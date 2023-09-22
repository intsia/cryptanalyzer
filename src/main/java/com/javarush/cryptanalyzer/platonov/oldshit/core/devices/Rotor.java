package com.javarush.cryptanalyzer.platonov.oldshit.core.devices;

import com.javarush.cryptanalyzer.platonov.oldshit.core.variables.EncryptionAlphabet;

import java.util.ArrayList;
import java.util.HashMap;

public class Rotor
{
    private final ArrayList<Character> rotorSymbolsSubsequenceKeyInteger;
    private final HashMap<Character, Integer> rotorSymbolsSubsequenceKeyCharacter = new HashMap<>();
    private final int rotorSize;
    private int activeSymbol;

    public Rotor(EncryptionAlphabet alphabet)
    {
        rotorSize = alphabet.getSize();
        rotorSymbolsSubsequenceKeyInteger = alphabet.getAlphabet();
        for (int i = 0; i < rotorSize; i++)
        {
            rotorSymbolsSubsequenceKeyCharacter.put(rotorSymbolsSubsequenceKeyInteger.get(i), i);
        }

        set(0);
    }


    public int getActiveSymbolIndex()
    {
        return activeSymbol;
    }


    public int getActiveSymbolIndex(int shift)
    {
        return (rotorSize + activeSymbol + shift) % rotorSize;
    }


    public char getActiveSymbolValue()
    {
        return rotorSymbolsSubsequenceKeyInteger.get(activeSymbol);
    }


    public char getActiveSymbolValue(int shift)
    {
        return rotorSymbolsSubsequenceKeyInteger.get((rotorSize + activeSymbol + shift) % rotorSize);
    }


    public int getSymbolIndexOfValue(char value, int shift)
    {
        return (rotorSymbolsSubsequenceKeyCharacter.get(value) + rotorSize + shift) % rotorSize;
    }


    public char getSymbolValueOfIndex(int index, int shift)
    {
        return rotorSymbolsSubsequenceKeyInteger.get((index + rotorSize + shift) % rotorSize);
    }


    public void turn(int steps)
    {
        set((rotorSize + activeSymbol + steps) % rotorSize);
    }


    public void set(int index)
    {
        activeSymbol = (rotorSize + index) % rotorSize;
    }
}
