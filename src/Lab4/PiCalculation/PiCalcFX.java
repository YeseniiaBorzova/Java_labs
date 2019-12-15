package Lab4.PiCalculation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PiCalcFX extends Application {
    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage){
        try{
            BorderPane root = FXMLLoader.load(getClass().getResource("PiCalc.fxml"));
            Scene scene = new Scene(root, 900,900);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Prime Factors");
            primaryStage.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
