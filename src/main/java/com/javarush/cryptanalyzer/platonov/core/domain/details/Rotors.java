package com.javarush.cryptanalyzer.platonov.core.domain.details;

import com.javarush.cryptanalyzer.platonov.core.domain.alphabetbuilder.constans.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;

import java.util.ArrayList;

public class Rotors
{
    private Rotor[] rotors;
    private int size;

    ArrayList<Character> activeLineValues = new ArrayList<>();
    ArrayList<Integer> activeLineIndexes = new ArrayList<>();

    private void setRotors(EncryptionAlphabet alphabet)
    {
        rotors = new Rotor[alphabet.getSize()];
        for (int i = 0; i < alphabet.getSize(); i++)
        {
            rotors[i] = new Rotor(alphabet);
            activeLineValues.add(rotors[i].getActiveSymbolValue());
            activeLineIndexes.add(i);
        }
    }

    private void setSize(EncryptionAlphabet alphabet)
    {
        size = alphabet.getSize();
    }

    public Rotors(EncryptionAlphabet alphabet)
    {
        setSize(alphabet);
        setRotors(alphabet);
    }
    public void setOnPosition(int shift)
    {
        setOnStartPosition();
        for (int i = 0; i < size; i++)
        {
            rotors[i].setOnPosition((rotors[i].getActiveSymbolIndex() + shift) % size);
            activeLineIndexes.set(i, rotors[i].getActiveSymbolIndex());
            activeLineValues.set(i, rotors[i].getActiveSymbolValue());
        }
    }

    public void setOnStartPosition()
    {
        for (int i = 0; i < size; i++)
        {
            rotors[i].setOnPosition(i);
        }
    }

    public char getActiveValueFromIndex(int index)//TODO чет странная фигня мне не нравится
    {
        return rotors[index].getActiveSymbolValue();
    }

    public String printActiveLineValue()
    {
        StringBuilder str = new StringBuilder();

        str.append(AlphabetsCollection.printSeparateLine(size));
        str.append(AlphabetsCollection.printIndexIntLine(activeLineIndexes));
        str.append(AlphabetsCollection.printValueLine(activeLineValues));
        str.append(AlphabetsCollection.printSeparateLine(size));

        return str.toString();
    }
}
