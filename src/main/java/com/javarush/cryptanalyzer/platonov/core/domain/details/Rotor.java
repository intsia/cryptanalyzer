package com.javarush.cryptanalyzer.platonov.core.domain.details;

import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;

import java.util.ArrayList;
import java.util.HashMap;

public class Rotor
{
    private final ArrayList<Character> symbols;
    private final int rotorSize;
    private int activeSymbol;

    public Rotor(EncryptionAlphabet alphabet)
    {
        rotorSize = alphabet.getSize();
        symbols = alphabet.getAlphabet();
        setOnPosition(0);
    }

    public char getActiveSymbolValue()
    {
        return symbols.get(activeSymbol);
    }
    public int getActiveSymbolIndex()
    {
        return activeSymbol;
    }
    public void setOnPosition(int shift)
    {
        activeSymbol = (shift + rotorSize) % rotorSize;
    }

}
