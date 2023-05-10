module com.javarush.cryptanalyzer.platonov.cryptanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires com.almasb.fxgl.all;

    opens com.javarush.cryptanalyzer.platonov to javafx.fxml;
    exports com.javarush.cryptanalyzer.platonov;
    exports com.javarush.cryptanalyzer.platonov.applications.gui;
    opens com.javarush.cryptanalyzer.platonov.applications.gui to javafx.fxml;
}