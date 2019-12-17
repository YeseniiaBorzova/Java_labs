package Lab4.IndTask;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GraphFX extends Application {
    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage){
        try{
            BorderPane root = FXMLLoader.load(getClass().getResource("Graph.fxml"));
            Scene scene = new Scene(root, 700,800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Graph");
            primaryStage.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
