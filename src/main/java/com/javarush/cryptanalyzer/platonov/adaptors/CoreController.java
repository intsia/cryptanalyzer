package com.javarush.cryptanalyzer.platonov.adaptors;

import com.javarush.cryptanalyzer.platonov.core.devices.EncryptionMachineCreator;
import com.javarush.cryptanalyzer.platonov.core.constants.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.core.constants.EncryptionMachineTypes;
import com.javarush.cryptanalyzer.platonov.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionText;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import com.javarush.cryptanalyzer.platonov.interfaces.ITextFileUploader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CoreController implements IApplication
{
    private Locale language = new Locale("ru", "RU");
    private IEncryptionMachine encryptionMachine;
    private EncryptionAlphabet encryptionAlphabet = new EncryptionAlphabet(AlphabetsCollection.ALPHABET_EN_UPPER_CASE);
    private EncryptionKey encryptionKey; //TODO подумать про дефолтные значения
    private EncryptionText encryptionText; //TODO подумать про дефолтные значения

    private String result;

    public CoreController() {}

    @Override
    public String getText()
    {
        return encryptionText.getText();
    }

    @Override
    public int getTextSize()
    {
        return encryptionText.getText().length();
    }


    @Override
    public void createEncryptionMachine(EncryptionMachineTypes type)
    {
        encryptionMachine = EncryptionMachineCreator.createEncryptionMachine(type, encryptionAlphabet, encryptionKey, encryptionText);
    }

    @Override
    public void setEncryptionAlphabet(ArrayList<Character> encryptionAlphabet)
    {
        this.encryptionAlphabet = new EncryptionAlphabet(encryptionAlphabet);
    }

    @Override
    public void setEncryptionKey(int key)
    {
        encryptionKey = new EncryptionKey(key);
    }

    @Override
    public void setEncryptionKey(String keyword)
    {
        encryptionKey = new EncryptionKey(keyword);
    }

    @Override
    public void uploadEncryptionKey(String path)
    {
       encryptionKey = ITextFileUploader.uploadKeyFile(path);
    }

    @Override
    public void setEncryptionText(String text)
    {
        encryptionText = new EncryptionText(text);
    }

    @Override
    public void uploadEncryptionText(String path)
    {
       encryptionText = ITextFileUploader.uploadTextFile(path);
    }

    @Override
    public char getRotorActiveValue(RotorsTypes type, int shift)
    {
        return encryptionMachine.getRotorActiveValue(type, shift);
    }

    @Override
    public int getRotorActivePosition(RotorsTypes type, int shift)
    {
        return encryptionMachine.getRotorActivePosition(type, shift);
    }

    @Override
    public char getRotorValueOfIndex(RotorsTypes type, int index, int shift)
    {
        return encryptionMachine.getRotorValueOfIndex(type, index, shift);
    }

    @Override
    public int getRotorIndexOfValue(RotorsTypes type, char value, int shift)
    {
        return encryptionMachine.getRotorIndexOfValue(type, value, shift);
    }

    @Override
    public void turnRotorUp(RotorsTypes type)
    {
        encryptionMachine.turnRotorUp(type);
    }

    @Override
    public void turnRotorDown(RotorsTypes type)
    {
        encryptionMachine.turnRotorDown(type);
    }

    @Override
    public ArrayList<HashMap<Enum, Integer>> Encrypt()
    {
        return encryptionMachine.Encrypt();
    }

    @Override
    public ArrayList<HashMap<Enum, Integer>> Decrypt()
    {
        return encryptionMachine.Decrypt();
    }

    @Override
    public String getResult()
    {
        return encryptionMachine.getResult();
    }
}
