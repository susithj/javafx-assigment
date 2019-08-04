
package validateinputs;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;


public class Student {
    
   private String StdNum; 
   private String ModCode;
   private String RoomNo;
   private String Email;
   private String PostCode;
    
    public String Validate(String StNo, String MCode, String RomNo, String Eml, String PCode) 
    
    {

    if (!Pattern.matches("STD[0-9]{5}?", StNo))

      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Student ID");
        alert.setContentText("Student ID should be STD followed by 5 digits");
        alert.showAndWait();
        return "invalid";
      }

    else if (!Pattern.matches("^[a-zA-Z0-9]+$", MCode))

      {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Module Code");
        alert.setContentText("Please Enter a Valid Module Code (Numbers and Letters Only)");
        alert.showAndWait();
        return "invalid";
      }

    else if (!Pattern.matches("R[0-9]{3}", RomNo))

      {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Class Room No");
        alert.setContentText("Class Room No Must Start with R then followed by 3 Numbers");
        alert.showAndWait();
        return "invalid";
      }

    else if (!Pattern.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+", Eml))

      {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Email Address");
        alert.setContentText("Please Enter a Valid Email Address");
        alert.showAndWait();
        return "invalid";
      }

    else if (!Pattern.matches("^[a-zA-Z]{1,2}[0-9][0-9A-Za-z]{0,1} {0,1}[0-9][A-Za-z]{2}$", PCode))

      {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Postal Code");
        alert.setContentText("Please Enter a Valid UK Poastal Code");
        alert.showAndWait();
        return "invalid";
      }
    else
      {
        return "valid";        
      }
     
    }
   
public  String GetStdCode(String StNo)
    {
    this.StdNum =  StNo;  
    return (StdNum);
    }   

public  String GetModule(String MCode)
    {
    this.ModCode =  MCode;  
    return (ModCode);
    }

public  String GetRoom(String RomNo)
    {
   this.RoomNo =  RomNo;  
    return (RomNo);
    }

public  String GetEml(String Eml)
    {
   this.Email =  Eml;  
    return (Eml);
    }

public  String GetPCode(String PCode)
    {
   this.PostCode =  PCode;  
    return (PCode);
    }

public ArrayList<String> GetStdDetails( String StNo, String MCode, String RomNo, String Eml, String PCode)
{    
   
    this.StdNum = StNo;
    this.ModCode =  MCode;
    this.RoomNo=RomNo;
    this.Email=Eml;
    this.PostCode=PCode;
    
   
    ArrayList<String> StdDetails = new ArrayList<String>();       

    StdDetails.add(this.StdNum);
    StdDetails.add(ModCode);
    StdDetails.add(RoomNo);    
    StdDetails.add(Email);
    StdDetails.add(PostCode);


return (StdDetails);

}

}
