package Lab3.IndTask;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StationFX extends Application {
    @Override
    public void start(Stage primaryStage){
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Station.fxml"));
            Scene scene = new Scene(root, 900,700);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Tram Stations");
            primaryStage.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) { launch(args);}
}
