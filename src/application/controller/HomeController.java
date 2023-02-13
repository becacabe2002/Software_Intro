package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.database.UserSession;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class HomeController implements Initializable{

    @FXML
    private BorderPane HomePane;
	
    @FXML
    private ImageView LogoutBtn;

    @FXML
    private Button UC1Btn;

    @FXML
    private Button UC2Btn;

    @FXML
    private Label UsernameField;
    
    @FXML
    void switchUCMain(ActionEvent event) {
    	FXMLLoader ld = new FXMLLoader();
    	Pane npane = null;
    	if(event.getSource() == UC1Btn) {
    		try {
    		ld.setLocation(getClass().getResource("/application/view/MainUC1.fxml"));
    		npane= ld.load();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    		HomePane.setCenter(npane);
    	}else {
    		try {
        		ld.setLocation(getClass().getResource("/application/view/MainUC2.fxml"));
        		npane= ld.load();
        		}catch(IOException e) {
        			e.printStackTrace();
        		}
        		HomePane.setCenter(npane);
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UsernameField.setText(UserSession.getInstance().getAdmin_name());
		
	}

}
