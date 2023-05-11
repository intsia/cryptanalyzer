package com.javarush.cryptanalyzer.platonov.core.variables;

public class EncryptionText
{
    private String text;
    private int size;

    public EncryptionText(String text)
    {
        this.text = text;
        size = text.length();
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

}
