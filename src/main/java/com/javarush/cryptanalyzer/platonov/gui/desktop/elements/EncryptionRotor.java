package com.javarush.cryptanalyzer.platonov.gui.desktop.elements;

import com.javarush.cryptanalyzer.platonov.oldshit.core.devices.Rotor;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class EncryptionRotor
{
    private Carousel rotor;
    private ArrayList <RotorElement> elements;
    {
        elements = new ArrayList<>();
    }

    public EncryptionRotor(ArrayList<Character> alphabet)
    {
        createElements(alphabet);
        rotor = new Carousel(getControlNodes());
    }

    private void createElements(ArrayList<Character> alphabet)
    {
        for (char character:
             alphabet)
        {
            RotorElement element = new RotorElement();
            element.setValueOfElement(Character.toString(character));
            elements.add(element);
        }
    }

    private ArrayList<BorderPane> getControlNodes()
    {
        ArrayList<BorderPane> controlNodes = new ArrayList<>();
        for (RotorElement element:
             elements)
        {
            controlNodes.add(element.getFrameOfElement());
        }
        return controlNodes;
    }

    public Carousel getControlNode()
    {
        return rotor;
    }
}
