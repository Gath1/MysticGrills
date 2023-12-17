package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;
import view.LoginView;
import view.RegisterView;
import database.Connect;

public class RegisterController {
	private static RegisterView registerView;
	private static ObservableList<User> users = FXCollections.observableArrayList();
	
	
	public RegisterController(RegisterView registerView, ObservableList<User> users){
		this.registerView = registerView;
		setButtonHandlers();
	}
		
	private void setButtonHandlers() {
		registerView.getRegisterButton().setOnAction(e -> insertHandler());
		registerView.getLoginButton().setOnAction(e -> movetoLogin());
	}

	public static void movetoLogin() {
		Stage primaryStage = new Stage();
		LoginView loginView = new LoginView(primaryStage);
		LoginController logC = new LoginController(loginView, users);
		registerView.getSc().getWindow().hide();
		primaryStage.show();
	}
	
	private void insertHandler() {
		String username = registerView.getUserTxt().getText();
		String email = registerView.getEmailTxt().getText();
		String password = registerView.getPasswordTxt().getText();
		String confirmPassword = registerView.getConfpassTxt().getText();
		for(User users : users) {
		if(username.equals(users.getUsername())) {
			System.out.println("Please fill with unique name");
			return;
		}
		User.UserRegister(username, email, password, confirmPassword);
		}
	}
	
	
}
	
	
	
	
	
	
	