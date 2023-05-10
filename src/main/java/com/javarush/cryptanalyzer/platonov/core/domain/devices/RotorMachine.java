package com.javarush.cryptanalyzer.platonov.core.domain.devices;

import com.javarush.cryptanalyzer.platonov.core.domain.devices.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.core.domain.details.Rotors;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;

import java.util.Locale;

public abstract class RotorMachine implements IEncryptionMachine
{
    protected EncryptionKey key;
    protected EncryptionAlphabet alphabet;
    protected Rotors rotors;
    protected EncryptionText text;
    protected Locale locale;

    public RotorMachine(EncryptionAlphabet alphabet, EncryptionKey key, EncryptionText text, Locale locale)
    {
        this.alphabet = alphabet;
        this.key = key;
        this.text = text;
        this.locale = locale;
        rotors = new Rotors(alphabet);
        rotors.setOnStartPosition();
    }
}
