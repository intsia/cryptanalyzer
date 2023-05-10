package com.javarush.cryptanalyzer.platonov.core.usecases.launcher;

import com.javarush.cryptanalyzer.platonov.core.domain.devices.Caesar;
import com.javarush.cryptanalyzer.platonov.core.domain.devices.Vigenere;
import com.javarush.cryptanalyzer.platonov.core.domain.devices.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;
import com.javarush.cryptanalyzer.platonov.core.usecases.launcher.constants.EncryptionMachineTypes;

import java.util.Locale;

public class EncryptionMachineCreator
{
    EncryptionAlphabet encryptionAlphabet;
    EncryptionKey encryptionKey;

    EncryptionText encryptionText;
    Locale locale;

    public EncryptionMachineCreator(EncryptionAlphabet encryptionAlphabet, EncryptionKey encryptionKey, EncryptionText encryptionText, Locale locale)
    {
        this.encryptionAlphabet = encryptionAlphabet;
        this.encryptionKey = encryptionKey;
        this.encryptionText = encryptionText;
        this.locale = locale;
    }

    public IEncryptionMachine createEncryptionMachine(EncryptionMachineTypes type)
    {

        switch (type)
        {
            case caesar ->
            {
                return new Caesar(encryptionAlphabet, encryptionKey, encryptionText, locale);
            }
            case vigenere ->
            {
                return new Vigenere(encryptionAlphabet, encryptionKey, encryptionText, locale);
            }
            default ->
            {
                //TODO как-то обрабатывать надо если ввели не то
                return null;
            }
        }
    }
}
