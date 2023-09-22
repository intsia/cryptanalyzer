package com.javarush.cryptanalyzer.platonov.oldshit.core.devices;


import com.javarush.cryptanalyzer.platonov.oldshit.core.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.oldshit.core.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.oldshit.core.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.oldshit.core.variables.EncryptionText;
import com.javarush.cryptanalyzer.platonov.oldshit.core.constants.EncryptionMachineTypes;

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
                throw new IllegalArgumentException("Unknown encryption machine type" + type);
            }
        }
    }
}
