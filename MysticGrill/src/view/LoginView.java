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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.RegisterView;
import controller.LoginController;

public class LoginView {
	
	private TextField emailTF = new TextField();
	private PasswordField passwordTF = new PasswordField();	
	private Button loginButton = new Button("Login");
	private Button registerButton = new Button("Register");
	private VBox actionBox = new VBox(20);
	
	private BorderPane borderCnt;
	private GridPane gridCnt;
	private FlowPane flowCnt;
	
	Scene sc;
	
	private void createLoginForm() {
		borderCnt.setCenter(gridCnt);
		borderCnt.setBottom(actionBox);
		
		actionBox.getChildren().addAll(loginButton, registerButton);
		
		gridCnt.add(new Label("Email : "), 0, 0);
		gridCnt.add(emailTF, 1, 0);
		gridCnt.add(new Label("Password : "), 0, 1);
		gridCnt.add(passwordTF, 1, 1);
		gridCnt.add(loginButton, 0, 2);
		gridCnt.add(registerButton, 1, 2);
		
		sc = new Scene(borderCnt, 500, 500);
	}
	
	private void setComponent() {
		borderCnt.setAlignment(gridCnt, Pos.CENTER);
		borderCnt.setMargin(actionBox, new Insets(10));
		
		actionBox.setAlignment(Pos.CENTER);
		gridCnt.setAlignment(Pos.CENTER);
		gridCnt.setVgap(20);
	}
	
	public LoginView(Stage stage){
		createLoginForm();
		setComponent();
		
		stage.setTitle("Mystic Grills");
		stage.setScene(sc);
		stage.setResizable(false);
		stage.show();
		
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

	public Scene getSc() {
		return sc;
	}

	public void setSc(Scene sc) {
		this.sc = sc;
	}

	
	
}


