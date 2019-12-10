package Lab3.Dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DictFX extends Application {

    @Override
    public void start(Stage primaryStage){
        try{
            BorderPane root = FXMLLoader.load(getClass().getResource("Dictionary.fxml"));
            Scene scene = new Scene(root, 900,700);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Dictionary");
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { launch(args);}
}
