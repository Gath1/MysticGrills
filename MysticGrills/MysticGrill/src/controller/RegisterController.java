package controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RegisterController {
	
	public static StackPane root;
	
	Label usernameLbl, emailLbl, passwordLbl,confpassLbl;
	TextField userTxt, emailTxt; 
	PasswordField passwordTxt, confpassTxt;
	VBox form, usernamePane, emailPane, passwordPane, confpassPane;
	
	void makeForm() {
		usernameLbl = new Label("Name");
		userTxt = new TextField();
		
		emailLbl = new Label("Email");
		emailTxt = new TextField();
		
		passwordLbl = new Label("Password");
		passwordTxt = new PasswordField();
		
		confpassLbl = new Label("ConfirmPassword");
		confpassTxt = new PasswordField(); 
		
		usernamePane = new VBox();
		usernamePane.getChildren().addAll(usernameLbl, userTxt);
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
