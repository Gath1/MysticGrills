package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.LoginView;
import view.RegisterView;

public class LoginController {
	
	private ObservableList<String> registeredEmails = FXCollections.observableArrayList();
	private Stage stage;
	private LoginView loginView;
	
	public LoginController(LoginView view) {
		this.loginView = view;
		setButtonHandlers();
	}
	
	public boolean validateLoginForm() {

	    if (loginView.getEmailTF().getText().isEmpty() || loginView.getPasswordTF().getText().isEmpty()) {
	    	 System.out.println("fail");
	    	 return false;
	    }
	        	
//	       // Simulated database check
//	       if (!userDatabase.containsKey(email) || !userDatabase.get(email).equals(password)) {
//	           // Invalid email or password
//	           return false;
//	       }
	    
	    System.out.println("Success");
	    return true;
	    
	 }
	
	private void setButtonHandlers() {
        loginView.getLoginButton().setOnAction(event -> handleLogin());
        loginView.getRegisterButton().setOnAction(event -> handleRegister());
    }
	
	private void handleLogin() {
		String email = loginView.getEmailTF().getText();
	    String password = loginView.getPasswordTF().getText();
        System.out.println("Email: " + email);
        System.out.println("Pass: " + password);

        if (validateLoginForm()) {
            System.out.println("Login successful!");
            login(email, password);
            // Add logic to navigate to the next scene or perform other actions
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
	}
	
	private void handleRegister() {
		
	}
	
	public boolean login(String email, String password) {
//         Add your database interaction logic here
		return true;
    }
}
