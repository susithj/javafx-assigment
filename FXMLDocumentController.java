package extaxgui;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import javafx.scene.control.Label;
import com.restfb.types.Post;
import com.restfb.types.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONException;
import org.json.JSONObject;
import com.restfb.*;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML private Label TUser;
    @FXML private Label TSex;
    @FXML private Label TDob;
    @FXML private Label THometown;
    @FXML private TableView<Messages> resulttable;
    @FXML private TableColumn<Messages, String> message;
    @FXML private TableColumn<Messages, String> posttime;
    
        ObservableList<Messages> msg = FXCollections.observableArrayList();

    
    @FXML
    private void handleButtonAction(ActionEvent event)  {

 // String Token2 = "EAAFktlFY5f0BACzU1RzdZCWTRbXrRq0z1BmzOVFKbg170KDfvUQwKTWSuVkrcS8DgjulMrbOZAqpPUEtds9kWZAX4LKwIhZChx01cCscSRlZAm3zxC4sCvfYBAF5AQAqPZAAS1KT4lLtOHw4iZBtbWU7mZBAAHwp4ZC2ogtS4NhPLpAZDZD";   // page access token      
  String Token  ="EAAFktlFY5f0BAM2TK4OgZBJMPlgi58ygJ91H3c8ZBSKLB4RBVVKJHpi3S7g8sVMlPZCYfLJPsZCEj2rsoVfyzhdjLY4bxrv4jFaLvDtfU4y165DylIvSLTVb6V4JfTcg3PuhEmvbwagNtHeO6b82maRlhRrdwKT35AF6ajk6AHGFChG9FgZC6nOFBBoWlZATlfJaecAjOheQZDZD"; // USer access token

  FacebookClient fb = new com.restfb.DefaultFacebookClient(Token);

  //FacebookClient fbp = new com.restfb.DefaultFacebookClient(Token2);


//FacebookType response = fbp.publish("102822324406123/feed", FacebookType.class, Parameter.with("message","susith send this"));
      
        Connection<Post> result = fb.fetchConnection("me/feed", Post.class);
        ArrayList<String> repos = new ArrayList(); 
        repos.add("Data will go from this point");
        
        String time;
        String mes;
        
        for (List<Post> page : result)
        {
        for (Post aPost : page){
        mes = aPost.getMessage();
        time = aPost.getCreatedTime().toString();
         if (mes == null)
            {
            mes = "EMPTY";
            
            }
        repos.add(mes);
        repos.add(time);
        }
        }
        for (int i = 1;  i < repos.size(); i = i + 2)
        {
            int a, b;
            
            a = i;
            b = i+1;
      System.out.println(repos.get(a) + "  " + repos.get(b));
        }
        resulttable.setItems(getMessages(repos));
    }
    
    public ObservableList<Messages> getMessages(ArrayList <String> prdata)
    {

       msg = FXCollections.observableArrayList(); 
        
           for(int j = 1; j < prdata.size(); j = j + 2)
           {
               int a, b;
               a = j;
               b = j+1;
               
               System.out.println(prdata.get(a) + "  " + prdata.get(b));
               msg.add(new Messages(prdata.get(a), prdata.get(b)));
               
           } 
    
        return msg;
    
}
    
    @FXML
    private void Btn(ActionEvent event)  {
    
        //String Token2 = "EAAFktlFY5f0BACzU1RzdZCWTRbXrRq0z1BmzOVFKbg170KDfvUQwKTWSuVkrcS8DgjulMrbOZAqpPUEtds9kWZAX4LKwIhZChx01cCscSRlZAm3zxC4sCvfYBAF5AQAqPZAAS1KT4lLtOHw4iZBtbWU7mZBAAHwp4ZC2ogtS4NhPLpAZDZD";   // page access token      
            //String Token  ="EAAFktlFY5f0BAM2TK4OgZBJMPlgi58ygJ91H3c8ZBSKLB4RBVVKJHpi3S7g8sVMlPZCYfLJPsZCEj2rsoVfyzhdjLY4bxrv4jFaLvDtfU4y165DylIvSLTVb6V4JfTcg3PuhEmvbwagNtHeO6b82maRlhRrdwKT35AF6ajk6AHGFChG9FgZC6nOFBBoWlZATlfJaecAjOheQZDZD"; // USer access token

            //FacebookClient fb = new com.restfb.DefaultFacebookClient(Token);


        //FacebookType response = fb.publish("102822324406123/feed", FacebookType.class, Parameter.with("message","susith send this"));

        String TK1  ="EAAFktlFY5f0BAFsKmRmoWFdTuyoPJkWVVp7JkytA5liE3xBq4zcfMwUOoPZB26zfDTe8LScBVgco7qc6vngCUZAFZALWyZB3MdedKnga5nOsbkpulb9KR1lISOvoWZCkyovihLMUrptLfDtLVBQhlcbqZC2tTErwYrepbq56FBYwZDZD";
        FacebookClient MyFB = new com.restfb.DefaultFacebookClient(TK1);

         
        User me = MyFB.fetchObject("me", User.class, Parameter.with("fields", "name,email,gender,birthday,hometown")); 


                TUser.setText(me.getName());
                TSex.setText(me.getGender());
                TDob.setText(me.getBirthday());
                THometown.setText(me.getHometownName());
        //System.out.println("........");
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    message.setCellValueFactory(new PropertyValueFactory<Messages, String>("message"));
    posttime.setCellValueFactory(new PropertyValueFactory<Messages, String>("ttime"));
    }    
    
}
