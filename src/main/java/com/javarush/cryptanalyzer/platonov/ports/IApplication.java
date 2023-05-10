package com.javarush.cryptanalyzer.platonov.ports;

import com.javarush.cryptanalyzer.platonov.core.usecases.launcher.constants.EncryptionMachineTypes;
import com.javarush.cryptanalyzer.platonov.core.domain.devices.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;

import java.util.ArrayList;

public interface IApplication
{
    public void createEncryptionMachine(EncryptionMachineTypes type);
    public void setEncryptionAlphabet(ArrayList<Character> encryptionAlphabet);
    public void setEncryptionKey();
    public void uploadEncryptionKey(String path);
    public void setEncryptionText(String text);
    public void uploadEncryptionText(String path);
    public ArrayList<String> Encryption();
    public ArrayList<String> Decryption();
}
