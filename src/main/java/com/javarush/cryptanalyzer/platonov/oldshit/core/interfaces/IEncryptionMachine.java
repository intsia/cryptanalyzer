package com.javarush.cryptanalyzer.platonov.oldshit.core.interfaces;

import com.javarush.cryptanalyzer.platonov.oldshit.core.constants.RotorsTypes;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEncryptionMachine
{
    public char getRotorActiveValue(RotorsTypes type, int shift);
    public int getRotorActivePosition(RotorsTypes type, int shift);
    public char getRotorValueOfIndex(RotorsTypes type, int index, int shift);
    public int getRotorIndexOfValue(RotorsTypes type, char value, int shift);
    public void turnRotorUp(RotorsTypes type);
    public void turnRotorDown(RotorsTypes type);
    public ArrayList<HashMap<Enum, Integer>> Encrypt ();
    public ArrayList<HashMap<Enum, Integer>> Decrypt();
    public String getResult();

}
