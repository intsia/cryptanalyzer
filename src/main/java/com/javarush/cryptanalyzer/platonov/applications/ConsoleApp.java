package com.javarush.cryptanalyzer.platonov.applications;


import com.javarush.cryptanalyzer.platonov.adaptors.CoreController;
import com.javarush.cryptanalyzer.platonov.core.constants.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.constants.EncryptionMachineTypes;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ConsoleApp
{
    public static void Launch()
    {
        IApplication controller = new CoreController();
        controller.setEncryptionAlphabet(AlphabetsCollection.ALPHABET_EN_UPPER_CASE);
        controller.uploadEncryptionKey("C:\\Program\\key.txt");
        controller.uploadEncryptionText("C:\\Program\\text.txt");

        controller.createEncryptionMachine(EncryptionMachineTypes.VIGENERE);

        ArrayList<HashMap<Enum, Integer>> workLog = controller.Decrypt();

//        workLog.add(String.valueOf(countOfStartMessages));
//        workLog.add("Запускаю машину Виженера" + "\n");
//        workLog.add("Ключом выступает слово " + key.getKeyword() + "\n");
//        workLog.add(getKeyWordLog);
//        workLog.add("Загружаю в работу текст " + text.getText() + "\n");
//        workLog.add("Запускаю последовательность шифрования..." + "\n");

        System.out.println((controller.getResult()));
    }
}
