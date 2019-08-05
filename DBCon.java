
package studentrecords;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;


public class DBCon {
    
    public String MakeDbConnection()
    {
                
   try  {
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root", "2017@nsr");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "2017@nsr");
        }
    
   catch(Exception exc)
        {
        return "invalid";
        } 
    
    return "valid";
    
    } 
public String InsertData(String stno, String stname, String stcourse, String stage ) 
{
    
try { 
  
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "2017@nsr");
    Statement query = con.createStatement();
    query.executeUpdate("INSERT INTO `studentdata` (std_id,std_name,std_course,std_age) VALUE ('"+stno+"','"+stname+"','"+stcourse+"','"+stage+"')");
    con.close();
    
    }
 
catch(Exception exc)
    {
    return "invalid";
    } 
    
    return "valid";
    }

public ArrayList<String> ViewStudent()

{
    ArrayList<String> std = new ArrayList<String>();       

try { 

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "2017@nsr");
    Statement query = con.createStatement();
    ResultSet result = query.executeQuery("SELECT std_id,std_name,std_course,std_age FROM studentdata");
    //emp_no,emp_name,dep_id,emp_type
  while(result.next())
    {
std.add(result.getString("std_id"));
std.add(result.getString("std_name"));
std.add(result.getString("std_course"));
std.add(result.getString("std_age"));
    }

}
 catch(Exception exc)
    {
    return std;
    } 
    return std;
}
}