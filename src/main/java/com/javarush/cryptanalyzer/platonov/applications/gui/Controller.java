package com.javarush.cryptanalyzer.platonov.applications.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import com.javarush.cryptanalyzer.platonov.adaptors.ApplicationController;
import com.javarush.cryptanalyzer.platonov.core.constants.AlphabetsCollection;
import com.javarush.cryptanalyzer.platonov.core.constants.RotorsTypes;
import com.javarush.cryptanalyzer.platonov.core.constants.EncryptionMachineTypes;
import com.javarush.cryptanalyzer.platonov.interfaces.IApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public class Controller
{
    public ResourceBundle bundle = ResourceBundle.getBundle("guielements");



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
    private Button button;

    @FXML
    private Button buttonBaseRotorDown;

    @FXML
    private Button buttonBaseRotorUp;

    @FXML
    private Button buttonFirsRotorDown;

    @FXML
    private Button buttonFirstRotorUp;

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

    @FXML
    private TextField userTextLine;


    int i = 0;

    @FXML
    void initialize()
    {

        IApplication controller = new ApplicationController();
        controller.setEncryptionAlphabet(AlphabetsCollection.ALPHABET_EN_UPPER_CASE);
        controller.uploadEncryptionKey("C:\\Program\\key.txt");
        controller.uploadEncryptionText("C:\\Program\\text.txt");

        controller.createEncryptionMachine(EncryptionMachineTypes.VIGENERE);

        ArrayList<HashMap<Enum, Integer>> workLog = controller.Decrypt();

        VigenerePrint.launch(workLog, scrollPane, controller);

        button.setOnAction(actionEvent -> {
            ChatWindow.printMessageLeft(scrollPane,"asdasfadhgdhgdhgdhgdhgdhgfdhgfdgdhgfdhgdhgdhgdfhgdhgdhgfdhgdhgfdhgdfhgdhgfdhgfdghdfhgdhgdhgdhgfdhgdfhgdfhgdhgdfhgdhgdfhgfdhgdfhgfdhgdhgfdhgdfhgdhgdfhgfdsdfasdf", "Nikita");
            ChatWindow.printMessageRight(scrollPane,"asdasfadhgdhgdhgdhgdhgdhgfdhgfdgdhgfdhgdhgdhgdfhgdhgdhgfdhgdhgfdhgdfhgdhgfdhgfdghdfhgdhgdhgdhgfdhgdfhgdfhgdhgdfhgdhgdfhgfdhgdfhgfdhgdhgfdhgdfhgdhgdfhgfdsdfasdf", "Nikita");
        });
    }


        public void setFirstRotorValue ( int state, int shift, IApplication controller) //TODO жуткая срань, надо с этим что-то делать
        {
            firstRotorTopSymbol.setText(String.valueOf(controller.getRotorValueOfIndex(RotorsTypes.FIRST, state, -1)));
            firstRotorMainSymbol.setText(String.valueOf(controller.getRotorValueOfIndex(RotorsTypes.FIRST, state, 0)));
            firstRotorBottomSymbol.setText(String.valueOf(controller.getRotorValueOfIndex(RotorsTypes.FIRST, state, 1)));

            firstRotorTopSymbolTop.setText(bundle.getString("INDEX") + state);
            firstRotorTopSymbolBottom.setText(bundle.getString("SHIFT") + shift);

            firstRotorMainSymbolTop.setText(bundle.getString("INDEX") + state);
            firstRotorMainSymbolBottom.setText(bundle.getString("SHIFT") + shift);

            firstRotorBottomSymbolTop.setText(bundle.getString("INDEX") + state);
            firstRotorBottomSymbolBottom.setText(bundle.getString("SHIFT") + shift);
        }

        public void setBaseRotorValue ( int state, IApplication controller) //TODO и про это не забудь
        {
            baseRotorTopSymbol.setText(String.valueOf(controller.getRotorValueOfIndex(RotorsTypes.BASE, state, -1)));
            baseRotorMainSymbol.setText(String.valueOf(controller.getRotorValueOfIndex(RotorsTypes.BASE, state, 0)));
            baseRotorBottomSymbol.setText(String.valueOf(controller.getRotorValueOfIndex(RotorsTypes.BASE, state, 1)));

            baseRotorTopSignTop.setText(bundle.getString("INDEX") + state);
            baseRotorTopSignBottom.setText(bundle.getString("BASE"));

            baseRotorMainSignTop.setText(bundle.getString("INDEX") + state);
            baseRotorMainSignBottom.setText(bundle.getString("BASE"));

            baseRotorBottomSignTop.setText(bundle.getString("INDEX") + state);
            baseRotorBottomSignBottom.setText(bundle.getString("BASE"));
        }

    }





