package com.javarush.cryptanalyzer.platonov.core.usecases.launcher;

import com.javarush.cryptanalyzer.platonov.core.domain.devices.interfaces.IEncryptionMachine;

import java.util.ArrayList;

public class EncryptionMachineLauncher
{
    public ArrayList<String> Encrypt(IEncryptionMachine encryptionMachine)
    {
        return encryptionMachine.Encrypt();
    }

    public ArrayList<String> Decrypt(IEncryptionMachine encryptionMachine)
    {
        return encryptionMachine.Decrypt();
    }
}
