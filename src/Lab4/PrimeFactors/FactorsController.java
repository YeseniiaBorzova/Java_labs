package Lab4.PrimeFactors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FactorsController implements Initializable {
    @FXML private TextField fromText;
    @FXML private TextField toText;
    @FXML private Button startBtn;
    @FXML private Button suspendBtn;
    @FXML private Button resumeBtn;
    @FXML private Button stopBtn;
    @FXML private ProgressBar progressBar;
    @FXML private TextArea resultext;

    private FactorProcess primeNumbers = new FactorProcess(this::addToTextArea, this::setProgress,this::finish);

    @Override
    public void initialize(URL location, ResourceBundle resources){
        startBtn.setDisable(false);
        suspendBtn.setDisable(true);
        resumeBtn.setDisable(true);
        stopBtn.setDisable(true);
    }

    @FXML private void startClick(ActionEvent actionEvent){
        try {
            primeNumbers.setFrom(Integer.parseInt(fromText.getText()));
            primeNumbers.setTo(Integer.parseInt(toText.getText()));
            resultext.setText("");
            progressBar.setProgress(0);
            startBtn.setDisable(true);
            suspendBtn.setDisable(false);
            resumeBtn.setDisable(true);
            stopBtn.setDisable(false);
            primeNumbers.start();
        }catch(NumberFormatException ex){
            showError("Incorrect input format!");
        }catch (IllegalArgumentException ex){
            showError("Illegal FROM or TO!");
        }
    }

    @FXML private void suspendClick(ActionEvent actionEvent){
        primeNumbers.suspend();
        startBtn.setDisable(true);
        suspendBtn.setDisable(true);
        resumeBtn.setDisable(false);
        stopBtn.setDisable(false);
    }

    @FXML private void resumeClick(ActionEvent actionEvent){
        primeNumbers.resume();
        startBtn.setDisable(true);
        suspendBtn.setDisable(false);
        resumeBtn.setDisable(true);
        stopBtn.setDisable(false);
    }

    @FXML private void stopClick(ActionEvent actionEvent){ primeNumbers.stop(); }

    private void addToTextArea(){
        String res = primeNumbers.getLastFound().get(0)+": ";
        for(int i = 1;i<primeNumbers.getLastFound().size();i++){
            res+=primeNumbers.getLastFound().get(i)+" ";
        }
        resultext.setText(resultext.getText()+res+"\n");
    }

    private void setProgress(){progressBar.setProgress(primeNumbers.getPercentage());}

    private void finish(){
        startBtn.setDisable(false);
        suspendBtn.setDisable(true);
        resumeBtn.setDisable(true);
        stopBtn.setDisable(true);
    }

    private static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
