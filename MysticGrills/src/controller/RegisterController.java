package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
import view.LoginView;
import view.RegisterView;
import database.Connect;

public class RegisterController {
	private RegisterView registerView;
	private Connect connect = Connect.getConnection();
	private String UserID;
	
//	public class User (String userID, String username, String email, String password){
//		UserID = userID;
//		Username = username;
//		Email = email;
//		Password = password;
//	}
//	
	public RegisterController(RegisterView registerView){
		this.registerView = registerView;
		setButtonHandlers();
	}
		
	public boolean validateRegisterForm() {

	    if (registerView.getUserTxt().getText().isEmpty() || registerView.getEmailTxt().getText().isEmpty() || 
	    		registerView.getPasswordTxt().getText().isEmpty() || registerView.getConfpassTxt().getText().isEmpty()) {
	    	return false;
	    }
	    if (registerView.getPasswordTxt().getText().length() < 6) {
	    	System.out.println("Password must be greater or equals 6");
	    	return false;
	    }
	    if (!registerView.getPasswordTxt().getText().equals(registerView.getConfpassTxt().getText())) {
	    	System.out.println("Password not the same");
	    	return false;
	    }
	    
	    IDgenerator();
	    return true;
	}
	
	private void setButtonHandlers() {
        registerView.getRegisterButton().setOnAction(event -> {
        	System.out.println("Register Clicked");
        	handleRegister();
        });
    }
	
	private void handleRegister() {
//		String userID = registerView.getUserID();
        if (validateRegisterForm()) {
            System.out.println("Register successful!");
//            addData(UserID, username, email, password);
//            register(username, email, password);
            // Add logic to navigate to the next scene or perform other actions
            
        } else {
            System.out.println("Register failed. Please check your credentials.");
        }
        
        String Username = registerView.getUserTxt().getText();
    	String Email = registerView.getEmailTxt().getText();
    	String Password = registerView.getPasswordTxt().getText();
    	String ConfPass = registerView.getConfpassTxt().getText();
	    System.out.println("ID: " + UserID);
	    System.out.println("Username: " + Username);
        System.out.println("Email: " + Email);
        System.out.println("Pass: " + Password);
        System.out.println("Confirm Pass: " + ConfPass);
        
	}
	
	private String IDgenerator() {
		int idCounter = 0;
//		UserID = idCounter + 1;
		UserID = String.format("ID_%03d", idCounter+1);
		
		return UserID;
	}
	
	private void addData(String userID, String username, String email, String password) {
		
		String query = "INSERT INTO user VALUES(UserID, Username, Email, Password)";
		
		PreparedStatement stmt = connect.prepareStatement(query);
		try {
			stmt.setString(1, UserID);
			stmt.setString(2, username);
			stmt.setString(3, email);
			stmt.setString(4, password);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private void switchToLoginScene() {
//        // You can put the logic for switching to the login scene here
//        // For example:
//        VBox root = new VBox();
//        GridPane loginForm = new GridPane();  // Create your login form
//        root.getChildren().add(loginForm);
//
//        Scene loginScene = new Scene(root, 800, 600);
//
//        Main.getPrimaryStage().setScene(loginScene);
//        Main.getPrimaryStage().setTitle("Login");
//    }
//	
//	public boolean register(String username, String email, String password) {
//      // Add your database interaction logic here
//      // For simplicity, we'll assume a hardcoded password for the email "test@example.com"
//		return true;
//	}
}
	
	
	
	
	
	
	