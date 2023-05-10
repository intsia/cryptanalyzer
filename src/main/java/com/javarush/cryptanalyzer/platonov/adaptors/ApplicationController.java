package com.javarush.cryptanalyzer.platonov.adaptors;

import com.javarush.cryptanalyzer.platonov.core.domain.alphabetbuilder.constans.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.usecases.io.FileUploaderController;
import com.javarush.cryptanalyzer.platonov.core.usecases.launcher.constants.EncryptionMachineTypes;
import com.javarush.cryptanalyzer.platonov.core.domain.devices.interfaces.IEncryptionMachine;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;
import com.javarush.cryptanalyzer.platonov.core.domain.alphabetbuilder.CustomEncryptionAlphabetCreator;
import com.javarush.cryptanalyzer.platonov.core.usecases.launcher.EncryptionMachineCreator;
import com.javarush.cryptanalyzer.platonov.core.usecases.launcher.EncryptionMachineLauncher;
import com.javarush.cryptanalyzer.platonov.ports.IApplication;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;

public class ApplicationController implements IApplication
{
    private Locale language = new Locale("ru" ,"RU");
    private IEncryptionMachine encryptionMachine;
    private EncryptionAlphabet encryptionAlphabet = new EncryptionAlphabet(AlphabetsCollection.alphabetEnUpperCase);
    private EncryptionKey encryptionKey; //TODO подумать про дефолтные значения
    private EncryptionText encryptionText; //TODO подумать про дефольные значения
    private FileUploader uploader = new FileUploader();
    private String result;

    public ApplicationController() {}

    @Override
    public void createEncryptionMachine(EncryptionMachineTypes type)
    {
        EncryptionMachineCreator creator = new EncryptionMachineCreator(encryptionAlphabet, encryptionKey, encryptionText, language);
        this.encryptionMachine = creator.createEncryptionMachine(type);
    }

//    @Override
//    public void setLanguage()
//    {
//        Locale langauage = new Locale("ru", "RU");
//    }

    @Override
    public void setEncryptionAlphabet(ArrayList<Character> encryptionAlphabet)
    {
        this.encryptionAlphabet = new EncryptionAlphabet(encryptionAlphabet);
    }

    @Override
    public void setEncryptionKey()
    {

    }

    @Override
    public void uploadEncryptionKey(String path)
    {
         encryptionKey = uploader.uploadKeyFile(path);
    }

    @Override
    public void setEncryptionText(String text)
    {
        encryptionText = new EncryptionText(text);
    }

    @Override
    public void uploadEncryptionText(String path)
    {
        encryptionText = uploader.uploadTextFile(path);
    }

    @Override
    public ArrayList<String> Encryption()
    {
        EncryptionMachineLauncher encryption = new EncryptionMachineLauncher();
        return encryption.Encrypt(encryptionMachine);
    }

    @Override
    public ArrayList<String> Decryption()
    {
        EncryptionMachineLauncher decryption = new EncryptionMachineLauncher();
        return decryption.Decrypt(encryptionMachine);
    }
}
