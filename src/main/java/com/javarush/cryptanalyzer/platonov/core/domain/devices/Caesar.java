package com.javarush.cryptanalyzer.platonov.core.domain.devices;


import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;

import java.util.ArrayList;
import java.util.Locale;

public class Caesar extends RotorMachine
{

    public Caesar(EncryptionAlphabet alphabet, EncryptionKey key, EncryptionText text, Locale locale)
    {
        super(alphabet, key, text, locale);
    }

    private ArrayList<String> encryptionAlgorithm(boolean mode)
    {
        rotors.setOnPosition(key.getKey(mode));
        char[] buffer = text.getText().toCharArray();
        for (int i = 0; i < buffer.length; i++)
        {
            buffer[i] = rotors.getActiveValueFromIndex(alphabet.getIndexOfChar(buffer[i]));
        }
        ArrayList<String> result = new ArrayList<>();
                result.add(new String(buffer));
        return result;
    }
    @Override
    public ArrayList<String> Encrypt()
    {
        return encryptionAlgorithm(true);
    }

    @Override
    public ArrayList<String> Decrypt()
    {
        return encryptionAlgorithm(false);
    }
}
