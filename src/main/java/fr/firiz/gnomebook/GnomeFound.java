package fr.firiz.gnomebook;

import fr.firiz.modele.Gnome;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GnomeFound extends Application {
    static Stage stage;
    static Gnome gnome;
    @FXML Label name;
    
    public GnomeFound(Stage newStage, Gnome truc) throws Exception {
        stage = newStage;
        gnome = truc;
        start(newStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(GnomeFound.class.getResource("gnome_found.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setHeight(400);
        primaryStage.setWidth(750);
        primaryStage.setTitle(gnome.getNom());
        /*
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setGridLinesVisible(true);
        ImageView imageView = new ImageView();
        System.out.println("toto" + gnome.getAvatar());
        Image image = new Image(gnome.getAvatar(), 300, 300, true, true);
        imageView.setImage(image);
        grid.add(imageView, 0, 0, 1, 5);
        Text nameText = new Text(gnome.getNom());
        nameText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 60));
        grid.add(nameText, 2, 0, 4, 3);
        Text classeText = new Text(gnome.getMetier());
        nameText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(classeText, 2, 3, 3, 4);
        Text iLevelText = new Text(gnome.getNiveau());
        nameText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(iLevelText, 2, 4, 3, 5);
        Scene scene = new Scene(grid);
        */
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
