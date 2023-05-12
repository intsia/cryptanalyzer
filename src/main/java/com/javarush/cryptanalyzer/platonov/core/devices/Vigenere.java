package com.javarush.cryptanalyzer.platonov.core.devices;


import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionText;

import java.util.ArrayList;
import java.util.HashMap;

public class Vigenere extends EncryptionMachine
{
    public Vigenere(EncryptionAlphabet alphabet, EncryptionKey key, EncryptionText text)
    {
        super(alphabet, key, text);
    }

    private ArrayList<HashMap<Enum, Integer>> encryptionAlgorithm(boolean mode)
    {
        ArrayList<HashMap<Enum, Integer>> workLog = new ArrayList<>();
        key.generateKeysFromKeyword(alphabet);
        int [] keys = key.getKeys(mode);
        int steps = keys.length;
        char[] buffer = text.getText().toCharArray();
        int shift;
        int indexOfSymbolInWork;
        char charOfSymbolInWork;
        int step = 0;

        while (step < buffer.length)
        {
            for (int j = 0; j < steps && step < buffer.length; j++)
            {
                shift = keys[j];
                charOfSymbolInWork = buffer[step];
                indexOfSymbolInWork = baseRotor.getSymbolIndexOfValue(charOfSymbolInWork,0);

                baseRotor.set(indexOfSymbolInWork);
                firstRotor.set(indexOfSymbolInWork + shift);

                HashMap<Enum, Integer> stepLog = new HashMap<>();
                stepLog.put(RotorsTypes.BASE, baseRotor.getActiveSymbolIndex());
                stepLog.put(RotorsTypes.FIRST, firstRotor.getActiveSymbolIndex());
                workLog.add(stepLog);

                buffer[step] = firstRotor.getActiveSymbolValue();
                step++;
            }
        }
        result = new String(buffer);
        return workLog;
    }

    @Override
    public ArrayList<HashMap<Enum, Integer>> Encrypt()
    {
        return encryptionAlgorithm(true);
    }

    @Override
    public ArrayList<HashMap<Enum, Integer>> Decrypt()
    {
        return encryptionAlgorithm(false);
    }

}
