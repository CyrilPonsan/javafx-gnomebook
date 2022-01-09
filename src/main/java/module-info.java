module fr.firiz.gnomebook {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.firiz.gnomebook to javafx.fxml;
    exports fr.firiz.gnomebook;
}