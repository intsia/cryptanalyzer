package com.javarush.cryptanalyzer.platonov.core.domain.variables;

import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionAlphabet;

import java.text.Format;
import java.util.Arrays;

public class EncryptionKey
{
    int[] keys;
    int key;
    String keyword;

    public EncryptionKey(int[] keys)
    {
        this.keys = Arrays.copyOf(keys, keys.length);
    }

    public EncryptionKey(int key)
    {
        this.key = key;
    }

    public EncryptionKey(String keyword)
    {
        this.keyword = keyword;
    }

    public int[] getKeys()
    {
        return keys;
    }
    public int[] getKeys(boolean mode)
    {
        if (mode)
        {
            return keys;
        }
        else
        {
            int[] reverseKeys = Arrays.copyOf(keys, keys.length);
            for (int i = 0; i < reverseKeys.length; i++)
            {
                reverseKeys[i] *= -1;
            }
            return reverseKeys;
        }
    }

    public int getKey()
    {
        return key;
    }
    public int getKey(boolean mode)
    {
        if (mode)
        {
            return getKey();
        }
        else
        {
            return getKey() * -1;
        }
    }

    public String getKeyword()
    {
        return keyword;
    }
    public String generateKeysFromKeyword(EncryptionAlphabet alphabet)
    {
        StringBuilder progressLog = new StringBuilder();

        progressLog.append("Начинаю генерацию последовательности ключей из ключевого слова..." + "\n");
        int size = alphabet.getSize();
        char[] keywordCharArray = keyword.toCharArray();
        keys = new int[keywordCharArray.length];
        progressLog.append("Длина последовательности ключей = " + keywordCharArray.length +"\n");
        //System.out.println("Длина последовательности ключей = " + keywordCharArray.length);
        for (int i = 0; i < keys.length; i++)
        {
            keys[i] = alphabet.getIndexOfChar(keywordCharArray[i]);
            progressLog.append(i + " значение ключа = " + keys[i] + "\n");
            //System.out.println(i + " значение ключа = " + keys[i]);
        }
        progressLog.append("Последовательность ключей успешно сгенерирована: " + "\n");
        //System.out.print("Последовательность ключей успешно сгенерирована: ");
        for (int i = 0; i < keys.length; i++)
        {
            progressLog.append(keys[i] + " ");
            //System.out.print(keys[i] + " ");
        }
        progressLog.append("\n");
        //System.out.println();
        return progressLog.toString();
    }

}

