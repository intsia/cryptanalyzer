package com.javarush.cryptanalyzer.platonov.gui.desktop.elements;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RotorElement
{
    private BorderPane frameOfElement;
    {
        frameOfElement = new BorderPane();
        frameOfElement.setStyle("-fx-border-color:  #222020");
        frameOfElement.setOpacity(0.9);
        frameOfElement.setMinSize(200,150);
        frameOfElement.setMaxSize(200,150);
    }
    double angle;
    private Text valueOfElement;
    {
        valueOfElement = new Text();
        valueOfElement.setFont(new Font(20));
        frameOfElement.setCenter(valueOfElement);
    }
    private Text indexOfElement;
    private Text valueOfShift;

    public RotorElement()
    {
        indexOfElement = new Text("TOP");
        valueOfShift = new Text("BOTTOM");

        //frameOfElement.setTop(indexOfElement);
        //frameOfElement.setBottom(valueOfShift);

    }

    public void setValueOfElement(String str)
    {
        valueOfElement.setText(str);
    }


    public BorderPane getFrameOfElement()
    {
        return frameOfElement;
    }
}
