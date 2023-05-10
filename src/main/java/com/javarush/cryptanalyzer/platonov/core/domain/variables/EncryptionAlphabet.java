package com.javarush.cryptanalyzer.platonov.core.domain.variables;

import com.javarush.cryptanalyzer.platonov.core.domain.alphabetbuilder.constans.AlphabetsCollection;

import java.util.ArrayList;
import java.util.HashMap;

public class EncryptionAlphabet extends AlphabetsCollection
{
    private final HashMap<Character, Integer> alphabetKeyCharacterValueInteger = new HashMap<>();
    private final ArrayList<Character> alphabetKeyIntegerValueCharacter;
    private final int alphabetSize;

    public EncryptionAlphabet(ArrayList<Character> encryptionAlphabet)
    {
        alphabetKeyIntegerValueCharacter = encryptionAlphabet;
        alphabetSize = alphabetKeyIntegerValueCharacter.size();
        for (int i = 0; i < alphabetSize; i++)
        {
            alphabetKeyCharacterValueInteger.put(alphabetKeyIntegerValueCharacter.get(i),i);
        }
    }

    public ArrayList<Character> getAlphabet()
    {
        return alphabetKeyIntegerValueCharacter;
    }
    public int getSize()
    {
        return alphabetSize;
    }

    public int getIndexOfChar(char ch)
    {
        return alphabetKeyCharacterValueInteger.get(ch);
    }


}
