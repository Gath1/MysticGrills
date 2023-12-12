package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LoginView {
	
	private TextField emailTF = new TextField();
	private PasswordField passwordTF = new PasswordField();	
	private Button loginButton = new Button("Login");
	private Button registerButton = new Button("Register");
	
	public LoginView(Stage stage){
		
		VBox root = new VBox();
				
		GridPane form = createLoginForm();
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(form);
		
		Scene scene = new Scene(root, 500, 250);
		stage.setScene(scene);
		stage.setTitle("Mystic Grills");
		stage.show();
	}
	
	private GridPane createLoginForm() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		form.add(new Label("Email : "), 0, 0);
		form.add(emailTF, 1, 0);
		form.add(new Label("Password : "), 0, 1);
		form.add(passwordTF, 1, 1);
		form.add(loginButton, 0, 2);
		form.add(registerButton, 1, 2);
	
		
		return form;
	}

	public TextField getEmailTF() {
		return emailTF;
	}

	public void setEmailTF(TextField emailTF) {
		this.emailTF = emailTF;
	}

	public PasswordField getPasswordTF() {
		return passwordTF;
	}

	public void setPasswordTF(PasswordField passwordTF) {
		this.passwordTF = passwordTF;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}

	public Button getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(Button registerButton) {
		this.registerButton = registerButton;
	}
	
}


