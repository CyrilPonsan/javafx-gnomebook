package fr.firiz.gnomebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PopUp  extends Application  {

    static String message;

    static public String getMessage() {
        return message;
    }

    public PopUp(String msg, Stage stage) throws Exception {
        message = msg;
        this.start(stage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(PopUp.class.getResource("popup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle(GnomeBook.getVersion());
        primaryStage.show();
    }
}
