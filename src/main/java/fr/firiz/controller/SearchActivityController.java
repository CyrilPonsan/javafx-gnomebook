package fr.firiz.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchActivityController {

    @FXML
    TextField textField;
    @FXML
    AnchorPane anchorPane;

    public void goSearchButtonClicked(ActionEvent actionEvent) {
        Label label = new Label();
        label.setText(textField.getText());
        anchorPane.getChildren().add(label);
    }
}
