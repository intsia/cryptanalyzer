package com.javarush.cryptanalyzer.platonov.gui.desktop.controllers;

import com.javarush.cryptanalyzer.platonov.gui.desktop.elements.EncryptionRotor;
import com.javarush.cryptanalyzer.platonov.gui.desktop.elements.RotorWithButtons;
import com.javarush.cryptanalyzer.platonov.oldshit.core.constants.AlphabetsCollection;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RotorsWindow
{
    private static RotorsWindow rotorsWindow = new RotorsWindow();

    private HBox hBox;

    private RotorsWindow()
    {
        hBox = new HBox();
        RotorWithButtons firstRotor = new RotorWithButtons(AlphabetsCollection.ALPHABET_EN_UPPER_CASE);
        RotorWithButtons secondRotor = new RotorWithButtons(AlphabetsCollection.ALPHABET_EN_LOWER_CASE);
        hBox.getChildren().add(firstRotor.getControlNode());
        hBox.getChildren().add(secondRotor.getControlNode());

//        EncryptionRotor firstRotor = new EncryptionRotor(AlphabetsCollection.ALPHABET_EN_UPPER_CASE);
//        StackPane stackPane = new StackPane(firstRotor.getControlNode().getCarousel());
//        stackPane.setMaxHeight(500);
//        stackPane.setMaxWidth(500);
//        hBox.getChildren().add(stackPane);


        rotateAnimation(firstRotor.getRotor().getControlNode().getCarousel(), firstRotor.getRotor().getControlNode().getAngleOfElement());

    }

    public void rotateAnimation(Group group, Double angle) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), group);
        rotateTransition.setByAngle(angle); // Угол вращения равен 360 градусов, поделенный на количество элементов
        rotateTransition.setCycleCount(Animation.INDEFINITE); // Бесконечное вращение
        rotateTransition.setAxis(Rotate.X_AXIS); // Ось вращения (Y, чтобы кольцо вращалось вокруг вертикальной оси)
        rotateTransition.play();
    }

    public static RotorsWindow getInstance()
    {
        return rotorsWindow;
    }

    public HBox getControlNode()
    {
        return hBox;
    }
}
