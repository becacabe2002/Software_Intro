// @author becacabe2002

package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.database.UserSession;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import application.model.*;

public class HomeController implements Initializable{
	
    @FXML
    private BorderPane HomePane;
	
    @FXML
    private Button UC1Btn;

    @FXML
    private Button UC2Btn;

    @FXML
    private Button HomeLogoutBtn;
    
    @FXML
    private Label UsernameField;
    
    
    @FXML
    void switchUCMain(ActionEvent event) {
    	FXMLLoader ld = new FXMLLoader();
    	Pane npane1 = null;
    	Pane npane2 = null;
    	if(event.getSource() == UC1Btn) {
    		try {
    		ld.setLocation(getClass().getResource("/application/view/MainUC1.fxml"));
    		npane1= ld.load();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    		HomePane.setCenter(npane1);
    	}else {
    		try {
        		ld.setLocation(getClass().getResource("/application/view/MainUC2.fxml"));
        		npane2= ld.load();
        		}catch(IOException e) {
        			e.printStackTrace();
        		}
        		HomePane.setCenter(npane2);
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		UsernameField.setText(UserSession.getInstance().getAdmin_name());
	}
	
	
	
	
	@FXML
	public void logout(ActionEvent e) {
		Node tempNode = (Node) e.getSource();
		Stage tempStage = (Stage) tempNode.getScene().getWindow();
		Alert logoutAlert = new Alert(AlertType.CONFIRMATION);
		logoutAlert.setTitle("Logout");
		logoutAlert.setHeaderText("Logout khỏi tài khoản ?");
		Optional<ButtonType> res = logoutAlert.showAndWait();
		if(res.isPresent() && res.get() == ButtonType.OK) {
			Parent login = null;
			try {
			login = FXMLLoader.load(getClass().getResource("/application/view/Login.fxml"));
			} catch(IOException exc) {
				exc.printStackTrace();
			}
			
			Scene LoginScene = new Scene(login);
			tempStage.setScene(LoginScene);
			tempStage.show();
		}
		else {
			logoutAlert.close();
		}
	}

}
