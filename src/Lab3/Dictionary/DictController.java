package Lab3.Dictionary;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;

public class DictController implements Initializable {
    private HashMap<String,String> dict;
    private String fileName = "src/Lab3/Dictionary/Source.txt";
    public TextField inputWord;
    public Button searchBtn;
    public TableView tableSearch;
    public TableColumn<Map.Entry<String,String>,String> rusSearchCol;
    public TableColumn<Map.Entry<String,String>,String> engSearchCol;
    public TextField rusWord;
    public TextField engWord;
    public Button addBtn;
    public Button saveBtn;
    public TableView tableDict;
    public TableColumn<Map.Entry<String,String>,String> rusCol;
    public TableColumn<Map.Entry<String,String>,String> engCol;

    @FXML
    private void search(){
        String word = inputWord.getText();
        if(!word.isEmpty()){
            HashMap<String, String> map = new HashMap<>();
            for(Map.Entry entry : dict.entrySet()){
                if((entry.getValue().toString().indexOf(word)==0) || (entry.getKey().toString().indexOf(word)==0)){
                    map.put(entry.getKey().toString(),entry.getValue().toString());
                }
            }
         searchTableInit(map);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        dict = new HashMap<>();
        readData();
        mainTableInit();
    }

    public void readData(){
        try{
            FileReader fr = new FileReader(fileName);
            Scanner scan = new Scanner(fr);
            StringTokenizer st;
            try{
                while(scan.hasNextLine()){
                    st = new StringTokenizer(scan.nextLine());
                    dict.put(st.nextToken(),st.nextToken());
                }
            }finally {
                scan.close();
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void addWord(){
        if(!(rusWord.getText().isEmpty() || engWord.getText().isEmpty())){
            dict.put(rusWord.getText(),engWord.getText());
            mainTableInit();
        }
    }

    public void save(){
        try{
            FileWriter fw = new FileWriter("src/Lab3/Dictionary/Source.txt");
            PrintWriter pw = new PrintWriter(fw);
            for(Map.Entry entry : dict.entrySet()){
                pw.println(entry.getKey().toString()+' '+entry.getValue().toString());
            }
            pw.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void searchTableInit(Map<String,String> map){
        tableSearch.setItems(FXCollections.observableArrayList(map.entrySet()));
         rusSearchCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
             @Override
             public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> param) {
                 return new SimpleStringProperty(param.getValue().getKey());
             }
         });

         engSearchCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
             @Override
             public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> param) {
                 return new SimpleStringProperty(param.getValue().getValue());
             }
         });
    }

    private void mainTableInit(){
        tableDict.setItems(FXCollections.observableArrayList(dict.entrySet()));
        rusCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> param) {
                return new SimpleStringProperty(param.getValue().getKey());
            }
        });

        engCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> param) {
                return new SimpleStringProperty(param.getValue().getValue());
            }
        }
        );
    }
}
