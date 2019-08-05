
package studentrecords;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

public class Student {
    private String StdNo;
    private String StdName;
    private String StdCos;
    private String StdAge;
    
    public String getStNo() {
        return StdNo;
    }
        public String getStName() {
        return StdName;
    }
    public String getStCos() {
        return StdCos;
    }

    public String getStAge() {
        return StdAge;
    }

    public Student(){}
    
    public Student( String StdNo, String StdName, String StdCos, String StdAge) {
    
        this.StdNo =  StdNo;
        this.StdName = StdName;
        this.StdCos = StdCos;
        this.StdAge = StdAge;
    }
    
    public String Validate(String StdNo, String StdName) 
    
    {

    if (!Pattern.matches("ST[0-9]{3}?", StdNo))

      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Student Number");
        alert.setContentText("STUDENT NUMBER should be ST followed by 3 digits");
        alert.showAndWait();
        return "invalid";
      }

    else if (!Pattern.matches("^[a-zA-Z0-9]+$", StdName))

      {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Informarion Dialog");
        alert.setHeaderText("Invalid Student Name");
        alert.setContentText("Please Enter a Valid First Name");
        alert.showAndWait();
        return "invalid";
      }

    else
      {
        return "valid";        
      }
     
    }
            
}
