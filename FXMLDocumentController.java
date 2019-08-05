package studentrecords;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    
    @FXML private TextField Stnumber;
    @FXML private TextField Stname;
    @FXML private TextField stcouse;
    @FXML private TextField stage;
    
    @FXML private TableView<Student> tableView;
    @FXML private TableColumn<Student, String> TStdNo;
    @FXML private TableColumn<Student, String> TStdName;
    @FXML private TableColumn<Student, String> TStdCos;
    @FXML private TableColumn<Student, String> TStdage;
    
    ObservableList<Student> std = FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      //  System.out.println("You clicked me!");
      //  label.setText("Hello World!");
        String S2= Stname.getText().toString();
        String S1=Stnumber.getText().toString();
        String S3 =stcouse.getText().toString();
        String S4 =stage.getText().toString();
        
        Student std = new Student();
        
        String status =   std.Validate(S1, S2);
        String dbstatus;
        DBCon db = new DBCon();
        dbstatus = db.MakeDbConnection();
    String test;
    
        if(status == "valid" && dbstatus == "valid")
{ 
             
      Student stdcon =   new Student(S1,S2, S3,S4);
      
      String Studentno = stdcon.getStNo();
      String Studentname = stdcon.getStName();
      String Studentcos = stdcon.getStCos();
      String Studentage = stdcon.getStAge();

      test =    db.InsertData(Studentno, Studentname, Studentcos,Studentage);

  if ( test == "valid")
  {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Success");
        alert.setContentText("Data Entered Success");
        alert.showAndWait();
        
        ClearTableView(); 
  }
  
  else {
  
  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText(" Database Errors Detected");
        alert.setContentText("You Entered existing Student Number");
        alert.showAndWait();
  }
      
}   
  else {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText(" Errors Detected");
        alert.setContentText("Please fix Validation or Database Errors before continuing");
        alert.showAndWait();
}
    
    }
     @FXML
    private void ClearTableView() 
        {
            
        std.removeAll(std);

        }
    
    
    @FXML
    private void ListStudent(ActionEvent event) 
        {
            ArrayList <String> tr = new ArrayList<String>();
            DBCon df = new DBCon();
            tr =   df.ViewStudent();
            tableView.setItems(getStudent(tr));
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
  
    TStdNo.setCellValueFactory(new PropertyValueFactory<Student,String>("StdNo"));
    TStdName.setCellValueFactory(new PropertyValueFactory<Student, String>("StdName"));
    TStdCos.setCellValueFactory(new PropertyValueFactory<Student, String>("StdCos"));
    TStdage.setCellValueFactory(new PropertyValueFactory<Student, String>("StdAge"));
    
    }    
    
    public ObservableList<Student> getStudent(ArrayList <String> dbdata)
    {

       std = FXCollections.observableArrayList(); 
       int RowCount = dbdata.size()/4;
        
       
           for(int j = 0; j < dbdata.size(); j = j + 4)
           {
               int a, b, c, d;
               a = j;
               b = j+1;
               c = j+2;
               d = j+3;
               
              //  std.add(new Student(dbdata.get(a)));
               std.add(new Student(dbdata.get(a),dbdata.get(b),dbdata.get(c),dbdata.get(d)));
               
           } 
   
        return std;
    }
}
