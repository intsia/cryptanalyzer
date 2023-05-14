package com.javarush.cryptanalyzer.platonov.applications.gui.controllers;

import com.javarush.cryptanalyzer.platonov.GUIApplication;
import com.javarush.cryptanalyzer.platonov.applications.gui.ResourceBundleList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Locale;
import java.util.ResourceBundle;

public class Heroes
{
    private final static String RESOURCE_BUNDLE_ID = ResourceBundleList.HEROES;
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_ID);

    public static Hero UI = new Hero(resourceBundle.getString("UI_NAME"), Hero.Avatars.UI_AVATAR, Hero.SideOfPrintMessage.LEFT);
    public static Hero CREATOR = new Hero(resourceBundle.getString("CREATOR_NAME"), Hero.Avatars.CREATOR_AVATAR, Hero.SideOfPrintMessage.RIGHT);
    public static Hero USER = new Hero("Anonymous", Hero.Avatars.USER_AVATAR, Hero.SideOfPrintMessage.RIGHT);

    public static void setLocale(Locale locale)
    {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_ID, locale);
        UI = new Hero(resourceBundle.getString("UI_NAME"), Hero.Avatars.UI_AVATAR, Hero.SideOfPrintMessage.LEFT);
        CREATOR = new Hero(resourceBundle.getString("CREATOR_NAME"), Hero.Avatars.CREATOR_AVATAR, Hero.SideOfPrintMessage.RIGHT);
        USER = new Hero("Anonymous", Hero.Avatars.USER_AVATAR, Hero.SideOfPrintMessage.RIGHT);
    }

    public static class Hero
    {
        private static FXMLLoader fxmlLoader = GUIApplication.fxmlLoader;
        public enum SideOfPrintMessage
        {
            LEFT,
            RIGHT
        }
        public static class Avatars
        {
            public final static Image UI_AVATAR = new Image("C:\\Program\\Projects\\javarush\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\platonov\\applications\\gui\\images\\robot.png");
            public final static Image CREATOR_AVATAR = new Image("C:\\Program\\Projects\\javarush\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\platonov\\applications\\gui\\images\\creator.png");
            public final static Image USER_AVATAR = new Image("C:\\Program\\Projects\\javarush\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\platonov\\applications\\gui\\images\\anonymous.png");

        }
        public Hero(String name, Image avatar, SideOfPrintMessage sideOfPrintMessage)
        {
            this.name = name;
            this.avatar = avatar;
            this.sideOfPrintMessage = sideOfPrintMessage;
        }
        private String name;
        private Image avatar;
        private SideOfPrintMessage sideOfPrintMessage;

        public void sendMessage(String messageText) //TODO разбить на функции поменьше и сделать нормальный нейминг
        {
            GuiAppController controller = fxmlLoader.getController();
            VBox scrollPane = controller.getScrollPane();

            ScrollPane scroll = controller.getScroll();

            scroll.setVvalue(scroll.getVmax());

            TextFlow textFlow = new TextFlow();
            textFlow.setStyle("-fx-border-color: #222020; -fx-border-radius: 5; -fx-background-color: #FFFFFF;");
            textFlow.setPrefWidth(100);
            textFlow.setMaxWidth(1000);
            Insets paddingInsens = new Insets(10, 10, 10, 10);
            textFlow.setPadding(paddingInsens);

            Text text = new Text(name + " :\n" + messageText);
            Font font = new Font(30.0);
            text.setFont(font);

            Circle circle = new Circle();
            circle.setRadius(50);
            circle.setFill(new ImagePattern(avatar));
            circle.setStrokeWidth(5.0);
            circle.setStrokeType(StrokeType.INSIDE);
            circle.setStroke(Paint.valueOf("#82828d"));

            VBox vbox = new VBox(circle);
            Insets vboxInsets = new Insets(10, 10, 10, 10);
            vbox.setMargin(circle, vboxInsets);

            textFlow.getChildren().add(text);

            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(textFlow);

            switch (sideOfPrintMessage)
            {
                case LEFT ->
                {
                    BorderPane.setAlignment(textFlow, Pos.TOP_LEFT);
                    borderPane.setLeft(vbox);
                }
                case RIGHT ->
                {
                    BorderPane.setAlignment(textFlow, Pos.TOP_RIGHT);
                    borderPane.setRight(vbox);
                    borderPane.setAlignment(vbox, Pos.TOP_RIGHT);
                }
            }

            scrollPane.getChildren().add(borderPane);



            scroll.layout();
            scroll.setVvalue(1);
        }
    }
}
