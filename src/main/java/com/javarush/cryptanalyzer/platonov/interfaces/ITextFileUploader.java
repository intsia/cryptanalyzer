package com.javarush.cryptanalyzer.platonov.interfaces;

import com.javarush.cryptanalyzer.platonov.core.io.FileUploader;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.variables.EncryptionText;

import java.nio.file.Path;

public interface ITextFileUploader

{
    public static EncryptionText uploadTextFile(String path)
    {
        return new EncryptionText(FileUploader.upload(Path.of(path)));
    };
    public static EncryptionKey uploadKeyFile(String path)
    {
        return new EncryptionKey(FileUploader.upload(Path.of(path)));
    };

}
