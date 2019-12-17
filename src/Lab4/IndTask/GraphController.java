package Lab4.IndTask;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.abs;

public class GraphController  implements Initializable {
    @FXML private TextField Fx;
    @FXML private TextField Gx;
    @FXML private TextField aText;
    @FXML private TextField bText;
    @FXML private TextField XFrom;
    @FXML private TextField XTo;
    @FXML private TextField XStep;
    @FXML private TextField YFrom;
    @FXML private TextField YTo;
    @FXML private TextField YStep;
    @FXML private Button Run;
    @FXML private Button Clear;
    @FXML private BorderPane graph;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        NumberAxis xAxis = new NumberAxis(-5,5,1);
        NumberAxis yAxis = new NumberAxis(-5,5,1);
        graph.getChildren().clear();
        graph.setCenter(new LineChart<Number,Number>(xAxis,yAxis));
    }

    @FXML private void constructClick(Event event){
        try{
            NumberAxis xAxis = new NumberAxis(Double.parseDouble(XFrom.getText()),Double.parseDouble(XTo.getText()),Double.parseDouble(XStep.getText()));
            NumberAxis yAxis = new NumberAxis(Double.parseDouble(YFrom.getText()),Double.parseDouble(YTo.getText()),Double.parseDouble(YStep.getText()));
            if(Double.parseDouble(YFrom.getText())>=Double.parseDouble(YTo.getText()) || Double.parseDouble(XFrom.getText())>=Double.parseDouble(XTo.getText())){
                throw new Exception();
            }
            if((Double.parseDouble(YTo.getText())-Double.parseDouble(YFrom.getText()))<(Double.parseDouble(YStep.getText())) || (Double.parseDouble(XTo.getText())-Double.parseDouble(XFrom.getText()))<(Double.parseDouble(XStep.getText()))){
                throw new IllegalArgumentException();
            }
            LineChart<Number,Number> newChart = new LineChart<>(xAxis,yAxis);
            newChart.setCreateSymbols(false);
            graph.getChildren().clear();
            graph.getChildren().add(newChart);
            double h = abs((Double.parseDouble(XFrom.getText())-Double.parseDouble(XTo.getText())) / 100);
            double a = Double.parseDouble(aText.getText());
            double b = Double.parseDouble(bText.getText());
            XYChart.Series<Number,Number> gSeries = new XYChart.Series<>();
            for(double x = Double.parseDouble(XFrom.getText());x <= Double.parseDouble(XTo.getText());x+=h){
                gSeries.getData().add(new XYChart.Data<>(x,(a - MetaProg.f(Fx.getText(),x))*( b + MetaProg.f(Gx.getText(),x))));
            }
            newChart.getData().add(gSeries);
            graph.getChildren().clear();
            graph.setCenter(newChart);
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.showAndWait();
        }
    }

    @FXML private void clearClick(Event event){
        NumberAxis xAxis = new NumberAxis(-5,5,1);
        NumberAxis yAxis = new NumberAxis(-5,5,1);
        graph.getChildren().clear();
        graph.setCenter(new LineChart<Number,Number>(xAxis,yAxis));
        XFrom.setText("");
        XTo.setText("");
        XStep.setText("");
        YFrom.setText("");
        YTo.setText("");
        YStep.setText("");
        Fx.setText("");
        Gx.setText("");
        aText.setText("");
        bText.setText("");
    }

}

