package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import view.LoginView;

public class LoginController {
	
	private ObservableList<String> registeredEmails = FXCollections.observableArrayList();
	 
	private LoginView loginView;
	
	public LoginController(LoginView view) {
		this.loginView = view;
		validateLoginForm();
	}
	
	public boolean validateLoginForm() {
	        
	    System.out.println("Email: " + loginView.getEmailTF());
	    System.out.println("Password: " + loginView.getPasswordTF());

	    if (loginView.getEmailTF().getText().isEmpty() || loginView.getPasswordTF().getText().isEmpty()) {
	    	 return false;
	    }
	        	
//	       // Simulated database check
//	       if (!userDatabase.containsKey(email) || !userDatabase.get(email).equals(password)) {
//	           // Invalid email or password
//	           return false;
//	       }

	    return true;
	 }
	
	private void setButtonHandlers() {
        loginView.getLoginButton().setOnAction(event -> handleLogin());
//        loginView.getRegisterButton().setOnAction(event -> handleRegister());
    }
	
	private void handleLogin() {
        String email = loginView.getEmailTF().getText();
        String password = loginView.getPasswordTF().getText();

        // Call the login method in the controller
        boolean loginSuccessful = login(email, password);

        if (loginSuccessful) {
            System.out.println("Login successful!");
            // Add logic to navigate to the next scene or perform other actions
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }
	
	public boolean login(String email, String password) {
        // Add your database interaction logic here
        // For simplicity, we'll assume a hardcoded password for the email "test@example.com"
        if ("test@example.com".equals(email) && "password".equals(password)) {
            return true;
        }
        
        return false;
    }
}
