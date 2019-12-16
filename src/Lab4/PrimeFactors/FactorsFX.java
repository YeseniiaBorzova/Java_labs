package Lab4.PrimeFactors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class FactorsFX extends Application {

    @Override
    public void start(Stage primaryStage){
        try{
            BorderPane root = FXMLLoader.load(getClass().getResource("Factors.fxml"));
            Scene scene = new Scene(root,700,800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Primary Factors");
            primaryStage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) { launch(args); }
}
