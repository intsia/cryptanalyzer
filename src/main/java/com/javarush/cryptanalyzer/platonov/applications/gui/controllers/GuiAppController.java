package com.javarush.cryptanalyzer.platonov.applications.gui.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import com.javarush.cryptanalyzer.platonov.GUIApplication;
import com.javarush.cryptanalyzer.platonov.adaptors.CoreController;
import com.javarush.cryptanalyzer.platonov.applications.gui.VigenerePrint;
import com.javarush.cryptanalyzer.platonov.applications.gui.quest.HelloQuest;
import com.javarush.cryptanalyzer.platonov.applications.gui.quest.Quest;
import com.javarush.cryptanalyzer.platonov.core.constants.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.core.constants.EncryptionMachineTypes;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GuiAppController
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text baseRotorBottomSignBottom;

    @FXML
    private Text baseRotorBottomSignTop;

    @FXML
    private Text baseRotorBottomSymbol;

    @FXML
    private Text baseRotorMainSignBottom;

    @FXML
    private Text baseRotorMainSignTop;

    @FXML
    private Text baseRotorMainSymbol;

    @FXML
    private Text baseRotorTopSignBottom;

    @FXML
    private Text baseRotorTopSignTop;

    @FXML
    private Text baseRotorTopSymbol;

    @FXML
    private Button buttonBaseRotorDown;

    @FXML
    private Button buttonBaseRotorUp;

    @FXML
    private Button buttonFirsRotorDown;

    @FXML
    private Button buttonFirstRotorUp;

    @FXML
    private VBox buttonPane;
    @FXML
    private ScrollPane scroll;

    @FXML
    private Circle circleAvatar;

    @FXML
    private Text firstRotorBottomSymbol;

    @FXML
    private Text firstRotorBottomSymbolBottom;

    @FXML
    private Text firstRotorBottomSymbolTop;

    @FXML
    private Text firstRotorMainSymbol;

    @FXML
    private Text firstRotorMainSymbolBottom;

    @FXML
    private Text firstRotorMainSymbolTop;

    @FXML
    private Text firstRotorTopSymbol;

    @FXML
    private Text firstRotorTopSymbolBottom;

    @FXML
    private Text firstRotorTopSymbolTop;

    @FXML
    private VBox scrollPane;

    public ResourceBundle bundle = ResourceBundle.getBundle("guielements");


    int i = 0;

    public static Locale locale = new Locale("ru", "RU");
    public static GuiAppController guiAppController;
    public static FXMLLoader fxmlLoader;
    @FXML
    void initialize()
    {
        fxmlLoader = GUIApplication.fxmlLoader;
        guiAppController = fxmlLoader.getController();

        IApplication coreController = new CoreController();
        coreController.setEncryptionAlphabet(AlphabetsCollection.ALPHABET_EN_UPPER_CASE);
        coreController.uploadEncryptionKey("C:\\Program\\key.txt");
        coreController.uploadEncryptionText("C:\\Program\\text.txt");

        coreController.createEncryptionMachine(EncryptionMachineTypes.VIGENERE);

        Locale localeEN = new Locale("en", "US");
        Locale localeRU = new Locale("ru", "RU");


//        setLocale(localeEN);
//        setLocale(localeRU);
        HelloQuest helloQuest = new HelloQuest();
        //helloQuest.launchQuest();
        VigenerePrint.launch(coreController.Decrypt(), coreController);
    }

    public void cleanButtonPane()
    {
        buttonPane.getChildren().clear();
    }
    public ArrayList<Button> createButtons(String[] answers)
    {
        Pane pane = new Pane();
        pane.setPrefHeight(0);
        buttonPane.getChildren().add(pane);

        ArrayList<Button> result = new ArrayList<>();

        for (String str : answers)
        {
            result.add(createButton(str));
        }

        return result;
    }
    public Button createButton(String text)
    {
        BorderPane borderPane = new BorderPane();
        Button button = new Button();
        Font font = new Font(24);

        button.setPrefWidth(400);
        button.setFont(font);
        button.setText(text);

        borderPane.setCenter(button);
        buttonPane.getChildren().add(borderPane);

        return button;
    }

    public VBox getScrollPane()
    {
        return scrollPane;
    }

    public ScrollPane getScroll()
    {
        return scroll;
    }


    public void setLocale(Locale locale)
    {
        Heroes.setLocale(locale);
        Quest.setLocale(locale);
    }


    public void setFirstRotorValue(int state, int shift, IApplication coreController) //TODO жуткая срань, надо с этим что-то делать
    {
        char topSymbolValue = coreController.getRotorValueOfIndex(RotorsTypes.FIRST, state, -1);
        firstRotorTopSymbol.setText(String.valueOf(topSymbolValue));
        char mainSymbolValue = coreController.getRotorValueOfIndex(RotorsTypes.FIRST, state, 0);
        firstRotorMainSymbol.setText(String.valueOf(mainSymbolValue));
        char bottomSymbolValue = coreController.getRotorValueOfIndex(RotorsTypes.FIRST, state, 1);
        firstRotorBottomSymbol.setText(String.valueOf(bottomSymbolValue));

        int topSymbolTopValue = coreController.getRotorIndexOfValue(RotorsTypes.FIRST, topSymbolValue, 0);
        firstRotorTopSymbolTop.setText(bundle.getString("INDEX") + topSymbolTopValue);
        firstRotorTopSymbolBottom.setText(bundle.getString("SHIFT") + shift);


        firstRotorMainSymbolTop.setText(bundle.getString("INDEX") + state);
        firstRotorMainSymbolBottom.setText(bundle.getString("SHIFT") + shift);

        int bottomSymbolTopValue = coreController.getRotorIndexOfValue(RotorsTypes.FIRST, bottomSymbolValue, 0);
        firstRotorBottomSymbolTop.setText(bundle.getString("INDEX") + bottomSymbolTopValue);
        firstRotorBottomSymbolBottom.setText(bundle.getString("SHIFT") + shift);
    }
    public void setBaseRotorValue(int state, IApplication coreController) //TODO и про это не забудь
    {
        char topSymbolValue = coreController.getRotorValueOfIndex(RotorsTypes.BASE, state, -1);
        baseRotorTopSymbol.setText(String.valueOf(topSymbolValue));
        char mainSymbolValue = coreController.getRotorValueOfIndex(RotorsTypes.BASE, state, 0);
        baseRotorMainSymbol.setText(String.valueOf(mainSymbolValue));
        char bottomSymbolValue = coreController.getRotorValueOfIndex(RotorsTypes.BASE, state, 1);
        baseRotorBottomSymbol.setText(String.valueOf(bottomSymbolValue));

        int topSymbolTopValue = coreController.getRotorIndexOfValue(RotorsTypes.BASE, topSymbolValue, 0);
        baseRotorTopSignTop.setText(bundle.getString("INDEX") + topSymbolTopValue);
        baseRotorTopSignBottom.setText(bundle.getString("BASE"));

        baseRotorMainSignTop.setText(bundle.getString("INDEX") + state);
        baseRotorMainSignBottom.setText(bundle.getString("BASE"));

        int bottomSymbolTopValue = coreController.getRotorIndexOfValue(RotorsTypes.BASE, bottomSymbolValue, 0);
        baseRotorBottomSignTop.setText(bundle.getString("INDEX") + bottomSymbolTopValue);
        baseRotorBottomSignBottom.setText(bundle.getString("BASE"));
    }

}





