
package weatherinfoapi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import org.json.JSONObject;

public class FXMLDocumentController implements Initializable {
    
    @FXML private Label cityout;
    @FXML private TextField city;
    @FXML private TextField ccode;
    @FXML private Label tempout;
    @FXML private Label humidityout;
    @FXML private Label mintempout;
    @FXML private Label pressureout;
    @FXML private Label lblsunrise;
    @FXML private Label mintempout1;
    @FXML private Label cloud;
    @FXML private Label wspeed;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
                
        try{
        
        String entered_city = city.getText().toString();
        String entered_ccode = ccode.getText().toString();
        
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+entered_city+","+entered_ccode+"&units=metric&appid=cee8b1b6a77337d75639251f291d7b3c";     
       //cee8b1b6a77337d75639251f291d7b3c   
       //cityout.setText(url);
    
           
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseAPI = con.getResponseCode();
        System.out.println("\nSending 'GET'  request to URL " + url);
        System.out.println("Respons Code "  + responseAPI);
        BufferedReader in = new BufferedReader ( new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null)
        {
        response.append(inputLine);
        }
           
        JSONObject MyRes1 = new JSONObject(response.toString());
        //        System.out.println(MyRes1);
        JSONObject main = new JSONObject(MyRes1.getJSONObject("main").toString());
                
                double temperature = main.getDouble("temp");
                int humidity = main.getInt("humidity");
                double mintemp = main.getDouble("temp_min");
                double maxtemp =main.getDouble("temp_max");
                int pressure = main.getInt("pressure");
               
            tempout.setText(String.valueOf(temperature));
            humidityout.setText(String.valueOf(humidity));
            mintempout.setText(String.valueOf(mintemp));
            mintempout1.setText(String.valueOf(maxtemp));
            pressureout.setText(String.valueOf(pressure));
                //My Response 2        
        JSONObject MyRes2 = new JSONObject(response.toString());
        // System.out.println(MyRes2);
        JSONObject sys = new JSONObject(MyRes2.getJSONObject("sys").toString());
                int sunrise =sys.getInt("sunrise");
                lblsunrise.setText(String.valueOf(sunrise));
                //My Response 3        
        JSONObject MyRes3 = new JSONObject(response.toString());
        //System.out.println(MyRes3);
        JSONObject clouds = new JSONObject(MyRes3.getJSONObject("clouds").toString());
                int all =clouds.getInt("all");
                cloud.setText(String.valueOf(all));

        //My Response 4        
        JSONObject MyRes4 = new JSONObject(response.toString());
        // System.out.println(MyRes4);
        JSONObject wind = new JSONObject(MyRes3.getJSONObject("wind").toString());

                int speed =wind.getInt("speed");
                wspeed.setText(String.valueOf(speed));
         }
        catch (Exception e)
        {
        System.out.println(e);
        }
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
                // TODO
    }    
    
}
