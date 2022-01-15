module fr.firiz.controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.graphics;


    opens fr.firiz.gnomebook to javafx.fxml;
    exports fr.firiz.gnomebook;
    exports fr.firiz.controller;
    opens fr.firiz.controller to javafx.fxml;
}