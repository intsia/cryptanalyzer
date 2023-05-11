package com.javarush.cryptanalyzer.platonov.interfaces;

import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.core.constants.EncryptionMachineTypes;

import java.util.ArrayList;
import java.util.HashMap;

public interface IApplication
{
    public void createEncryptionMachine(EncryptionMachineTypes type);
    public void setEncryptionAlphabet(ArrayList<Character> encryptionAlphabet);
    public void setEncryptionKey(int key);
    public void setEncryptionKey(String keyword);
    public void uploadEncryptionKey(String path);
    public void setEncryptionText(String text);
    public void uploadEncryptionText(String path);


    public char getRotorActiveValue(RotorsTypes type, int shift);
    public int getRotorActivePosition(RotorsTypes type, int shift);
    public char getRotorValueOfIndex(RotorsTypes type, int index, int shift);
    public int getRotorIndexOfValue(RotorsTypes type, char value, int shift);
    public void turnRotorUp(RotorsTypes type);
    public void turnRotorDown(RotorsTypes type);
    public ArrayList<HashMap<Enum, Integer>> Encrypt ();
    public ArrayList<HashMap<Enum, Integer>> Decrypt();
    public String getResult();

    public int getTextSize();
    public String getText();
}
