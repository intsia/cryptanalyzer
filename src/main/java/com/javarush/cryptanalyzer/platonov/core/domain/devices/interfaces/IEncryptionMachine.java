package com.javarush.cryptanalyzer.platonov.core.domain.devices.interfaces;

import java.util.ArrayList;

public interface IEncryptionMachine
{
    public ArrayList<String> Encrypt ();
    public ArrayList<String> Decrypt();

}
