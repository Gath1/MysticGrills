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
import view.RegisterView;

public class RegisterController {
	
	private RegisterView RegisterView;

	public RegisterController(RegisterView View){
		this.RegisterView = View;
		validateRegisterForm();
//		RegisterHandlerBtn();

	}
		
	public boolean validateRegisterForm() {
		
		
		System.out.println("Username: " + RegisterView.getUserTxt());
		System.out.println("Email: " + RegisterView.getEmailTxt());
	    System.out.println("Password: " + RegisterView.getPasswordTxt());
	    System.out.println("ConfirmPassword: " + RegisterView.getConfpassTxt());

	    if (RegisterView.getUserTxt().getText().isEmpty() || RegisterView.getEmailTxt().getText().isEmpty() || 
	    	RegisterView.getPasswordTxt().getText().isEmpty() || RegisterView.getConfpassTxt().getText().isEmpty()) {
	    	 return false;
	    }
	    return true;
	}
	

	
//	private void RegisterHandlerBtn() {
//		RegisterView.getRegisterButton().setOnMouseClicked(e->{
//			System.out.println("You Have Register Your Account");
//			
//			
//		});
//	}
	
	
	
}
	
	
	
	
	
	
	
