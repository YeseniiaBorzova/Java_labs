package Lab3.IndTask;

import Lab1.IndTask.Hour;

import Lab2.IndTask.JAXBScheme.TramStation;
import Lab2.IndTask.XMLTram;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class StationController implements Initializable {
    XMLTram station = new XMLTram();

    public TextField enterCount;
    public Button searchBtn;
    public TextArea resultArea;
    public TextField addCout;
    public TextField addComments;
    public Button addBtn;
    public TextField nameStation;
    public TextField routesOfStation;
    public TableView<TableRow> stationTable;
    public TableColumn<TableRow,String> hourCol;
    public TableColumn<TableRow,String> countCol;
    public TableColumn<TableRow,String> commentsCol;

    public class TableRow{
        SimpleIntegerProperty count,hour;
        SimpleStringProperty comments;
        public TableRow(int hour, int count, String comments){
            this.comments = new SimpleStringProperty(comments);
            this.count = new SimpleIntegerProperty(count);
            this.hour = new SimpleIntegerProperty(hour);
        }

        public String getComments(){return comments.get();}
        public int getCount(){return count.get();}
        public int getHour(){return  hour.get();}

    }

    @Override
    public void initialize(URL location, ResourceBundle resources){ stationTableInit();}

    private void stationTableInit(){
        ObservableList<TableRow> rows = FXCollections.observableArrayList();
        List<TramStation.Hour> lst = station.getTram().getHour();
        for(int i = 0; i < lst.size(); i++){
            rows.add(new TableRow(i+1, lst.get(i).getCount(), lst.get(i).getComments()));
        }
        stationTable.setItems(rows);
        hourCol.setCellValueFactory((new PropertyValueFactory<>("hour")));
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
        commentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        nameStation.setText(station.getTram().getName());
        routesOfStation.setText(station.getTram().getArrOfRoutes());
    }

    @FXML
    private void doNew(javafx.event.ActionEvent event){
        station = new XMLTram();
        stationTableInit();
        enterCount.setText("");
        resultArea.setText("");
        addCout.setText("");
        addComments.setText("");
    }

    @FXML
    private void doOpen(javafx.event.ActionEvent event){
        FileChooser fileChooser = getFileChooser("Open XML File");
        File file;
        if((file = fileChooser.showOpenDialog(null)) != null){
            try{
                station.fileRead(file.getCanonicalPath());
                stationTableInit();
                stationTable.setItems(null);
                stationTableInit();
            }catch (IOException ex){
                showError("No such file!");
            }
        }
    }

    @FXML
    private void doSave(javafx.event.ActionEvent event){
        FileChooser fileChooser = getFileChooser("Save XML file");
        File file;
        if((file = fileChooser.showSaveDialog(null)) != null){
            try{
                station.fileWrite(file.getCanonicalPath());
                showMessage("Results ere saved!");
            }catch (IOException ex){
                showError("Error writing to file occur!");
            }
        }
    }

    @FXML
    private void doAdd(javafx.event.ActionEvent event){
        if( addCout.getText().isEmpty() || addComments.getText().isEmpty()){
            throw new NullPointerException();
        }
        station.getTram().addHour(new TramStation.Hour(Integer.parseInt(addCout.getText()), addComments.getText()));
        stationTableInit();
    }

    @FXML
    private void doSearch(){
        String result= "";
        if(enterCount.getText().isEmpty()){
            throw new NullPointerException();
        }
        for(int i = 0; i < station.getTram().getHour().size(); i++){
            if(station.getTram().getHour().get(i).getCount() == Integer.parseInt(enterCount.getText())){
                result += "Hour #" +  (i+1) + ", " + station.getTram().getHour().get(i).toString() + '\n';
            }
        }
        resultArea.setText(result);
    }

    @FXML
    private void doCountSort(javafx.event.ActionEvent event){
        station.sortByCount();
        stationTableInit();
    }

    @FXML
    private void doCommSort(javafx.event.ActionEvent event){
        station.sortByComment();
        stationTableInit();
    }

    @FXML
    private void doAbout(javafx.event.ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About program...");
        alert.setHeaderText("App shows information about Station");
        alert.setContentText("Version 1.0");
        alert.showAndWait();
    }

    private static void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private static void showMessage(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public static FileChooser getFileChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));
        fileChooser.setTitle(title);
        return fileChooser;
    }

}
