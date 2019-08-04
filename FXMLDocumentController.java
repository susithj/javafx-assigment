package validateinputs;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label;
    @FXML private TextField Txtstid;
    @FXML private TextField Txtmcode;
    @FXML private TextField Txtclassroom;
    @FXML private TextField Txtemial;
    @FXML private TextField Txtpostcode;
    
    @FXML private Label Stidout;
    @FXML private Label Mcodeout;
    @FXML private Label MClassOut;
    @FXML private Label Emailout;
    @FXML private Label Pcodeout;
    
    public void ClearLabels(){  
      
      Stidout.setText("");
      Mcodeout.setText("");
      MClassOut.setText("");
      Emailout.setText("");
      Pcodeout.setText("");
      }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
        ClearLabels();
    
            String StNo = Txtstid.getText().toString();
            String MoCode = Txtmcode.getText().toString();
            String RomNo = Txtclassroom.getText().toString(); 
            String Eml=Txtemial.getText().toString();
            String PCode=Txtpostcode.getText().toString();

       
        Student std = new Student();
    
String status =   std.Validate(StNo, MoCode, RomNo, Eml, PCode);

if(status == "valid")
{ 
        ArrayList<String> StdDetails = std.GetStdDetails (StNo, MoCode, RomNo, Eml, PCode);  
     
      Stidout.setText((StdDetails.get(0)));
      Mcodeout.setText((StdDetails.get(1)));
      MClassOut.setText((StdDetails.get(2)));
      Emailout.setText((StdDetails.get(3)));
      Pcodeout.setText((StdDetails.get(4)));
           
} 

else {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Validation Errors Detected");
        alert.setContentText("Please fix Validation Errors before continuing");
        alert.showAndWait();
}    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
