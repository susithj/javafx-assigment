
package mymediaplayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLDocumentController implements Initializable {
    @FXML Slider VolBar;
    @FXML  private MediaView MDv;
    private MediaPlayer MP1;
    private Media Mda;
    @FXML private Button Search;
    @FXML private Button Load;
    @FXML private ListView ListBox;
    
    @FXML
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //String path = new File("src/Media/CT001.mp4").getAbsolutePath(); 
       String path = new File("d:\\Video\\CT002.mp4").getAbsolutePath();
       //String path = new File("src/Media/ & ListBox. ).getAbsolutePath(); 
       Mda=new Media(new File(path).toURI().toString());
       MP1=new MediaPlayer(Mda);
       //MDv.setFitHeight(1200);
       //MDv.setFitWidth(600);
       MDv.setMediaPlayer(MP1);
       //MP1.setAutoPlay(true); 
       DoubleProperty width= MDv.fitWidthProperty();
       DoubleProperty height= MDv.fitHeightProperty();
       width.bind(Bindings.selectDouble(MDv.sceneProperty(),"widht"));
       height.bind(Bindings.selectDouble(MDv.sceneProperty(),"height"));
       VolBar.setValue(MP1.getVolume()*100);
       VolBar.valueProperty().addListener(new InvalidationListner(){

            @Override
            public void invalidated(Observable observable) {
            MP1.setVolume(VolBar.getValue() /100);
       }
           
       });     
               
    }    
    
    public void play(ActionEvent event) {
        MP1.play();
    }
    public void pause(ActionEvent event) {
        MP1.pause();
    }
    public void Fast(ActionEvent event) {
        MP1.setRate(4);
    }
    public void Slow(ActionEvent event) {
        MP1.setRate(.5);
    }
    public void Reload(ActionEvent event) {
        MP1.seek(MP1.getStartTime());
        MP1.play();
    }
    public void Start(ActionEvent event) {
        MP1.seek(MP1.getStartTime());
        MP1.stop();
    }
    public void Last(ActionEvent event) {
        MP1.seek(MP1.getTotalDuration());
        MP1.stop();
    }
    public void Search(ActionEvent event) {
        FileChooser FC1 = new FileChooser();
        //File selectedFile= FC1.showOpenDialog(null);
        FC1.setInitialDirectory(new File ("D:\\Video"));
        File selectedFile= FC1.showOpenDialog(null);
        FC1.getExtensionFilters().addAll(
                new ExtensionFilter("MP4 Files", "*.mp4"));
        
        if (selectedFile != null){
           ListBox.getItems().add(selectedFile.getName());
        }else{
            System.out.println("Invalied File");
    } 
    }
    public void Load(ActionEvent event) {
    FileChooser FC1 = new FileChooser();
    FC1.setInitialDirectory(new File ("D:\\Video"));
    FC1.getExtensionFilters().addAll(
            new ExtensionFilter("Video Files", "*.mp4"));
    File selectedFile = FC1.showOpenDialog(null);
            if(selectedFile != null) {
                MP1.play();
                }

    else {
        System.out.println("file is not valid");
    }

}
}
