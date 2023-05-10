package com.javarush.cryptanalyzer.platonov.core.usecases.io;

import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionKey;
import com.javarush.cryptanalyzer.platonov.core.domain.variables.EncryptionText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

/*
TODO тут по хорошему добавить какой-то обработчик строк, чтобы не заморачиваться с двойными // и другими ошибками. Как-то поудобнее сварганить. Но пока работает.
TODO еще можно просто создавать папочку на условном рабочем столе и предлагать положить файлик прямо туда и не париться
*/
public class FileUploaderController
{
    private static String upload(Path path)
    {
        try
                (
                        RandomAccessFile file = new RandomAccessFile(path.toFile(), "r");
                        FileChannel channel = file.getChannel();
                )
        {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            StringBuilder builder = new StringBuilder();
            channel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining())
            {
                builder.append((char) byteBuffer.get());
            }
            return builder.toString();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public static EncryptionText uploadTextFile(Path path)
    {
        return new EncryptionText(upload(path));
    }


    public static EncryptionKey uploadKeyFile(Path path)
    {
        return new EncryptionKey(upload(path));
    }
}
