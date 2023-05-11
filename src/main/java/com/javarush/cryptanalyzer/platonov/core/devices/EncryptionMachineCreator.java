package com.javarush.cryptanalyzer.platonov.core.devices;


import com.javarush.cryptanalyzer.platonov.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionText;
import com.javarush.cryptanalyzer.platonov.core.constants.EncryptionMachineTypes;

public abstract class EncryptionMachineCreator
{
    public static IEncryptionMachine createEncryptionMachine(EncryptionMachineTypes type, EncryptionAlphabet encryptionAlphabet, EncryptionKey encryptionKey, EncryptionText encryptionText)
    {

        switch (type)
        {
//            case caesar ->
//            {
//                return new Caesar(encryptionAlphabet, encryptionKey, encryptionText, locale);
//            }
            case VIGENERE ->
            {
                return new Vigenere(encryptionAlphabet, encryptionKey, encryptionText);
            }
            default ->
            {
                return null;
            }
        }
    }
}
