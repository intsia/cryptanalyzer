package com.javarush.cryptanalyzer.platonov.oldshit.core.devices;

import com.javarush.cryptanalyzer.platonov.oldshit.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.oldshit.core.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.oldshit.core.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.oldshit.core.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.oldshit.core.variables.EncryptionText;

public abstract class EncryptionMachine implements IEncryptionMachine
{
    protected static EncryptionKey key;
    protected static EncryptionAlphabet alphabet;
    protected static EncryptionText text;
    protected static String result;
    protected static Rotor baseRotor;
    protected static Rotor firstRotor;

    public EncryptionMachine(EncryptionAlphabet alphabet, EncryptionKey key, EncryptionText text)
    {
        this.alphabet = alphabet;
        this.key = key;
        this.text = text;

        baseRotor = new Rotor(alphabet);
        firstRotor = new Rotor(alphabet);
    }

    @Override
    public String getResult()
    {
        return result;
    }

    @Override
    public int getRotorActivePosition(RotorsTypes type, int shift)
    {
        switch (type)
        {
            case BASE ->
            {
                return baseRotor.getActiveSymbolIndex(shift);
            }
            case FIRST ->
            {
                return firstRotor.getActiveSymbolIndex(shift);
            }
            default ->
            {
                System.out.println("Error. Type of rotor not found"); //TODO тут просто кидать эксепшен по хорошему
                return 0;
            }
        }
    }

    @Override
    public char getRotorActiveValue(RotorsTypes type, int shift)
    {
        switch (type)
        {
            case BASE ->
            {
                return baseRotor.getActiveSymbolValue(shift);
            }
            case FIRST ->
            {
                return firstRotor.getActiveSymbolValue(shift);
            }
            default ->
            {
                System.out.println("Error. Type of rotor not found"); //TODO тут просто кидать эксепшен по хорошему
                return 0;
            }
        }
    }

    @Override
    public char getRotorValueOfIndex(RotorsTypes type, int index, int shift)
    {
        switch (type)
        {
            case BASE ->
            {
                return baseRotor.getSymbolValueOfIndex(index, shift);
            }
            case FIRST ->
            {
                return firstRotor.getSymbolValueOfIndex(index, shift);
            }
            default ->
            {
                System.out.println("Error. Type of rotor not found"); //TODO тут просто кидать эксепшен по хорошему
                return 0;
            }
        }
    }

    @Override
    public int getRotorIndexOfValue(RotorsTypes type, char value, int shift)
    {
        switch (type)
        {
            case BASE ->
            {
                return baseRotor.getSymbolIndexOfValue(value, shift);
            }
            case FIRST ->
            {
                return firstRotor.getSymbolIndexOfValue(value, shift);
            }
            default ->
            {
                System.out.println("Error. Type of rotor not found"); //TODO тут просто кидать эксепшен по хорошему
                return 0;
            }
        }
    }

    @Override
    public void turnRotorUp(RotorsTypes type)
    {
        switch (type)
        {
            case BASE ->
            {
                baseRotor.turn(-1);
            }
            case FIRST ->
            {
                firstRotor.turn(-1);
            }
        }
    }

    @Override
    public void turnRotorDown(RotorsTypes type)
    {
        switch (type)
        {
            case BASE ->
            {
                baseRotor.turn(1);
            }
            case FIRST ->
            {
                firstRotor.turn(1);
            }
        }
    }
}

