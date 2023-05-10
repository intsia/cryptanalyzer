package com.javarush.cryptanalyzer.platonov.applications.console;


import com.javarush.cryptanalyzer.platonov.adaptors.ApplicationController;
import com.javarush.cryptanalyzer.platonov.core.domain.alphabetbuilder.constans.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.usecases.launcher.constants.EncryptionMachineTypes;
import com.javarush.cryptanalyzer.platonov.ports.IApplication;

import java.util.ArrayList;

public class ConsoleApp
{
    public static void Launch()
    {
        IApplication controller = new ApplicationController();
        controller.setEncryptionAlphabet(AlphabetsCollection.alphabetEnUpperCase);
        controller.uploadEncryptionKey("C:\\Program\\key.txt");
        controller.uploadEncryptionText("C:\\Program\\text.txt");

        controller.createEncryptionMachine(EncryptionMachineTypes.vigenere);

        ArrayList<String> result = controller.Decryption();

        for(String str : result)
        {
            System.out.println(str);
        }
    }
}
