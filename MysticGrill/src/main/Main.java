package main;

import controller.LoginController;
import controller.RegisterController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.LoginView;
import view.RegisterView;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginView loginView = new LoginView(primaryStage);
    	LoginController logC = new LoginController(loginView, null);
		
//		RegisterView registerView = new RegisterView(primaryStage);
//		RegisterController registerController = new RegisterController(registerView);
//		loginView = new LoginView(primaryStage);
//		primaryStage.show();
//					
	}

}