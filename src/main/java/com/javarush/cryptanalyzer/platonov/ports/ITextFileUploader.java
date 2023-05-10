package com.javarush.cryptanalyzer.platonov.ports;

import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;

import java.nio.file.Path;

public interface ITextFileUploader

{
    public EncryptionText uploadTextFile(String path);
    public EncryptionKey uploadKeyFile(String path);

}
