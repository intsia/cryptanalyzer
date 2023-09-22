package com.javarush.cryptanalyzer.platonov.gui.desktop.elements;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

/*
    Класс реализующий анимированный элемент интерфейса "Карусель"
    Создает кольцо из элементов в проекции XZ
*/


public class Carousel
{
    private Group carousel;
    {
        carousel = new Group();
    }
    private ArrayList<? extends Node> elements;

    private final double CIRCLE_DEGREES = 360.0;

    private int countOfElements;

    private double angleOfElement;

    private double radiusOfCarousel;

    int elementWidth = 200;
    int elementHeight = 150;

    private Point3D pivotOfCarousel;


    int indexOfFrontElement = 0;

    public Carousel(ArrayList<? extends Node> elements)
    {
        this.elements = elements;

        countOfElements = elements.size();

        angleOfElement = CIRCLE_DEGREES / countOfElements;

        radiusOfCarousel = (elementHeight/2) / Math.tan(Math.toRadians(angleOfElement/2));

        pivotOfCarousel = new Point3D(elementWidth/2, elementHeight/2, radiusOfCarousel * -1);

        createCarousel();
    }

    private void createCarousel()
    {
        for(int i = 0; i < countOfElements; i++)
        {
            carousel.getChildren().add(elements.get(i));
            elements.get(i).getTransforms().add(createRotationByIndex(i));
        }
    }


    private Rotate createRotationByIndex(int index)
    {
        Rotate rotate = new Rotate(angleOfElement * index, Rotate.X_AXIS);
        setPivot(rotate, pivotOfCarousel);
        return rotate;
    }

    private void setPivot(Rotate rotate, Point3D pivot)
    {
        rotate.setPivotZ(pivot.getZ());
        rotate.setPivotX(pivot.getX());
        rotate.setPivotY(pivot.getY());
    }

    public Group getCarousel()
    {
        return carousel;
    }

    public double getAngleOfElement()
    {
        return angleOfElement;
    }
}
