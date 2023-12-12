package main;

import controller.LoginController;
import controller.RegisterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoginView;
import view.RegisterView;

public class Main extends Application {
	
	Scene scene;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
		
		LoginView loginView = new LoginView(primaryStage);
    	LoginController loginController = new LoginController(loginView);
		
//		RegisterView registerView = new RegisterView(primaryStage);
//		RegisterController registerController = new RegisterController(registerView);
				
	}

}
