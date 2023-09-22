package com.javarush.cryptanalyzer.platonov.gui.desktop.creators;

import com.javarush.cryptanalyzer.platonov.gui.desktop.controllers.BottomWindow;
import com.javarush.cryptanalyzer.platonov.gui.desktop.controllers.ContactsWindow;
import com.javarush.cryptanalyzer.platonov.gui.desktop.controllers.RotorsWindow;
import com.javarush.cryptanalyzer.platonov.gui.desktop.controllers.TopWindow;
import com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers.Heroes;
import com.javarush.cryptanalyzer.platonov.gui.desktop.elements.Chat;
import javafx.scene.layout.BorderPane;

public class GUILoader
{
    private static GUILoader GUILoader = new GUILoader();
    private static Chat mainChat;
    private GUILoader()
    {
        mainChat = new Chat();
        borderPane = new BorderPane();
       // borderPane.setPrefSize(1920, 1980);
        borderPane.setCenter(mainChat.getControlNode());
        borderPane.setLeft(ContactsWindow.getInstance().getControlNode());
        borderPane.setRight(RotorsWindow.getInstance().getControlNode());
        borderPane.setBottom(BottomWindow.getInstance().getControlNode());
        borderPane.setTop(TopWindow.getInstance().getControlNode());

        mainChat.sendMessage(Heroes.USER, "Работает, мать вашу фдвалрфдлыврадлофрывдлародлфыор фвылдоардлфоывралдфор фывдлоардлф орывфдалор длфорвыалд орфлывора длорфывлда орфыдлв оар лорфывлдоар фывлдаор лдфоывра лорфдл рдлфвыоар \n ывалорывлаопфлоыпвалп");
        mainChat.sendMessage(Heroes.UI, "Еще как работает");
        mainChat.sendMessage(Heroes.CREATOR, "Я сделяль");
    };

    BorderPane borderPane;

    public static GUILoader getInstance()
    {
        return GUILoader;
    }

    public BorderPane getControlNode()
    {
        return borderPane;
    }
    public Chat getMainChatControl()
    {
        return mainChat;
    }
}
