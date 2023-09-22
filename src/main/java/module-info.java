module com.javarush.cryptanalyzer.platonov.cryptanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires com.almasb.fxgl.all;
    requires annotations;

    opens com.javarush.cryptanalyzer.platonov to javafx.fxml;
    exports com.javarush.cryptanalyzer.platonov;
    exports com.javarush.cryptanalyzer.platonov.oldshit.gui;
    opens com.javarush.cryptanalyzer.platonov.oldshit.gui to javafx.fxml;
    exports com.javarush.cryptanalyzer.platonov.oldshit.gui.quest;
    opens com.javarush.cryptanalyzer.platonov.oldshit.gui.quest to javafx.fxml;
    exports com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers;
    opens com.javarush.cryptanalyzer.platonov.oldshit.gui.controllers to javafx.fxml;
}