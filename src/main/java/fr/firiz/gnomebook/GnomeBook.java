package fr.firiz.gnomebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GnomeBook extends Application {

    static Stage mainStage;
    static String version;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GnomeBook.class.getResource("gnomebook.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        setVersion();
        mainStage = stage;
        stage.setTitle(getVersion());
        stage.setScene(scene);
        stage.setWidth(680);
        stage.setHeight(340);
        stage.show();
    }

    static String getVersion() {
        return version;
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setVersion() throws IOException {
        File file = new File("./src/main/java/datas/version.data");
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String line;
        while ((line = bf.readLine()) != null) {
            version = line;
        }
        fr.close();
        bf.close();
    }
}
