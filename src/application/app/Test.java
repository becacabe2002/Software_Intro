package application.app;

import application.database.UserSession;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application{

	@Override
	public void start(Stage HomeStage) throws Exception {
		// create new usersession instance
		UserSession usersession = new UserSession();
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/Login.fxml"));
		Scene LoginScene = new Scene(root);
		HomeStage.setScene(LoginScene);
		HomeStage.show();
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}
