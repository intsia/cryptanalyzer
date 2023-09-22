package com.javarush.cryptanalyzer.platonov.gui.desktop.elements;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class RotorWithButtons
{
    private BorderPane frame;
    private EncryptionRotor rotor;
    private Button turnUp;
    private Button turnDown;

    private Rectangle mask = new Rectangle(210,800);

    public RotorWithButtons(ArrayList<Character> alphabet)
    {
        frame = new BorderPane();
        rotor = new EncryptionRotor(alphabet);
        turnDown = new Button("Down");
        turnUp = new Button("Up");

//        mask.setClip(rotor.getControlNode().getCarousel());
//        mask.setFill(Color.TRANSPARENT);
//        mask.setOpacity(0.0);

//        rotor.getControlNode().getCarousel().setTranslateX(105);
//        rotor.getControlNode().getCarousel().setTranslateY(400);
//        rotor.getControlNode().getCarousel().setTranslateZ(0);

        frame.setCenter(rotor.getControlNode().getCarousel());
        frame.setBottom(turnDown);
        frame.setTop(turnUp);
    }

    public BorderPane getControlNode()
    {
        return frame;
    }

    public EncryptionRotor getRotor()
    {
        return rotor;
    }
}
