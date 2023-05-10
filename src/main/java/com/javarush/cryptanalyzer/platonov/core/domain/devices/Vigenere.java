package com.javarush.cryptanalyzer.platonov.core.domain.devices;


import com.javarush.cryptanalyzer.platonov.core.domain.alphabetbuilder.constans.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Vigenere extends RotorMachine
{
    private ResourceBundle comments = ResourceBundle.getBundle("vigenere", locale);
    public Vigenere(EncryptionAlphabet alphabet, EncryptionKey key, EncryptionText text, Locale locale)
    {
        super(alphabet, key, text, locale);
    }

    private ArrayList<String> encryptionAlgorithm(boolean mode)
    {
        ArrayList<String> workLog = new ArrayList<>();
        String getKeyWordLog = key.generateKeysFromKeyword(alphabet);
        int [] keys = key.getKeys(mode);
        int steps = keys.length;
        char[] buffer = text.getText().toCharArray();

        workLog.add("Запускаю машину Виженера" + "\n");
        workLog.add("Ключом выступает слово " + key.getKeyword() + "\n");
        workLog.add(getKeyWordLog);
        workLog.add("В соответствии с длиной последовательности ключей, закрепляю " + steps + "рабочих положений ротора" +"\n");
        workLog.add("Загружаю в работу текст " + text.getText() + "\n");
        workLog.add("Запускаю последовательность шифрования..." + "\n");

        int step = 0;
        while (step < buffer.length)
        {
            StringBuilder progressLog;

            for (int j = 0; j < steps && step < buffer.length; j++)
            {
                rotors.setOnPosition(keys[j]);

                progressLog = new StringBuilder();
                progressLog.append("Беру в работу символ # " + step + " = " + buffer[step] + "\n");
                progressLog.append("Базовая последовательность символов: " + "\n" + AlphabetsCollection.printIndexValueBlockLine(alphabet.getAlphabet()));
                progressLog.append("Выставляю ротор в рабочее положение под индексом " + keys[j] + " " + "\n");
                progressLog.append(rotors.printActiveLineValue());
                progressLog.append("Заменяю символ " + buffer[step] + " на символ " + rotors.getActiveValueFromIndex(alphabet.getIndexOfChar(buffer[step])) + "\n");
                workLog.add(progressLog.toString());

                buffer[step] = rotors.getActiveValueFromIndex(alphabet.getIndexOfChar(buffer[step]));
                step++;
            }
        }

        workLog.add(new String(buffer));
        return workLog;
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
