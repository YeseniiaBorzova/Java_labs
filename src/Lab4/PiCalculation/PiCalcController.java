package Lab4.PiCalculation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PiCalcController {
     public  TextField numOfElm;
     public  TextField numEps;
     public  Button startBtn;
     public  Button suspendtBtn;
     public  Button resumeBtn;
     public  Button stopBtn;
     public TextField calcElem;
     public   TextArea resultText;
     public ProgressBar progressBar;

    public PiCalcThread primeNumbers = new PiCalcThread(this::addTextToArea, this::setProgress, this::finish);

   @FXML public void startClick(ActionEvent actionEvent){
         try{
             primeNumbers.setNum(Integer.parseInt((numOfElm.getText())));
             primeNumbers.setEps(Double.parseDouble(numEps.getText()));
             resultText.setText("");
             progressBar.setProgress(0);
             startBtn.setDisable(true);
             suspendtBtn.setDisable(false);
             resumeBtn.setDisable(true);
             stopBtn.setDisable(false);
             primeNumbers.start();
         }catch(NumberFormatException ex){
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Error");
             alert.setHeaderText("Invalid input");
             alert.showAndWait();
         }
     }
    public void suspendClick(ActionEvent actionEvent){
         primeNumbers.suspend();;
         startBtn.setDisable(true);
         suspendtBtn.setDisable(true);
         resumeBtn.setDisable(false);
         stopBtn.setDisable(false);
     }

    public void resumeClick(ActionEvent actionEvent){
         primeNumbers.resume();
         startBtn.setDisable(true);
         suspendtBtn.setDisable(false);
         resumeBtn.setDisable(true);
         stopBtn.setDisable(false);
     }

    public void stopClick(ActionEvent actionEvent){primeNumbers.stop();}
    public void updateClick(ActionEvent actionEvent){calcElem.setText(""+primeNumbers.getCount());}
    public void addTextToArea(){
         resultText.setText(resultText.getText()+primeNumbers.getLastFound()+" | ");
     }
    public void setProgress(){progressBar.setProgress(primeNumbers.getPercentage());}

    public void finish(){
         startBtn.setDisable(false);
         suspendtBtn.setDisable(true);
         resumeBtn.setDisable(true);
         stopBtn.setDisable(true);
     }

}
