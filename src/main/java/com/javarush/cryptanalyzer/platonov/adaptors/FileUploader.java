package com.javarush.cryptanalyzer.platonov.adaptors;

import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;
import com.javarush.cryptanalyzer.platonov.core.usecases.io.FileUploaderController;
import com.javarush.cryptanalyzer.platonov.ports.ITextFileUploader;

import java.nio.file.Path;

public class FileUploader implements ITextFileUploader
{
    @Override
    public EncryptionText uploadTextFile(String path)
    {
        return FileUploaderController.uploadTextFile(Path.of(path));
    }

    @Override
    public EncryptionKey uploadKeyFile(String path)
    {
        return FileUploaderController.uploadKeyFile(Path.of(path));
    }
}


