package com.javarush.cryptanalyzer.platonov.oldshit.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public abstract class FileUploader
{
    public static String upload(Path path)
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
}

