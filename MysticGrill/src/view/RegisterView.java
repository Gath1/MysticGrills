package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;

public class RegisterView{
	
	Scene sc;
	private TextField userTxt = new TextField();
	private TextField emailTxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	private PasswordField confpassTxt = new PasswordField();
	private Button registerButton = new Button("Register");
	private Button loginButton = new Button("Login");
	private VBox actionBox = new VBox(20);
	
	private BorderPane borderCnt = new BorderPane();
	private GridPane gridCnt = new GridPane();
	private FlowPane flowCnt = new FlowPane();
	
	
	private void editComponent() {	
		actionBox.getChildren().addAll(registerButton, loginButton);
		borderCnt.setCenter(gridCnt);
		borderCnt.setBottom(actionBox);
		
		gridCnt.add(new Label("Username : "), 0, 0);
		gridCnt.add(userTxt, 1, 0);
		gridCnt.add(new Label("Email : "), 0, 1);
		gridCnt.add(emailTxt, 1, 1);
		gridCnt.add(new Label("Password : "), 0, 2);
		gridCnt.add(passwordTxt, 1, 2);
		gridCnt.add(new Label("ConfirmPassword : "), 0, 3);
		gridCnt.add(confpassTxt, 1, 3);	
		gridCnt.add(registerButton, 1, 4);
		
		sc = new Scene(borderCnt, 500, 500);
	}
	
	private void setComponent() {
		borderCnt.setAlignment(gridCnt, Pos.CENTER);
		
		borderCnt.setMargin(actionBox, new Insets(10));
		actionBox.setAlignment(Pos.CENTER);
		
		gridCnt.setAlignment(Pos.CENTER);
		gridCnt.setVgap(10);
		
	}
	

	public RegisterView(Stage stage) {	
		editComponent();
		setComponent();
		
		stage.setScene(sc);
		stage.setResizable(false);
		stage.show();
	}
	
	public Scene getSc() {
		return sc;
	}

	public void setSc(Scene sc) {
		this.sc = sc;
	}

	public TextField getUserTxt() {
		return userTxt;
	}

	public void setUserTxt(TextField userTxt) {
		this.userTxt = userTxt;
	}

	public TextField getEmailTxt() {
		return emailTxt;
	}

	public void setEmailTxt(TextField emailTxt) {
		this.emailTxt = emailTxt;
	}

	public PasswordField getPasswordTxt() {
		return passwordTxt;
	}

	public void setPasswordTxt(PasswordField passwordTxt) {
		this.passwordTxt = passwordTxt;
	}

	public PasswordField getConfpassTxt() {
		return confpassTxt;
	}

	public void setConfpassTxt(PasswordField confpassTxt) {
		this.confpassTxt = confpassTxt;
	}

	public Button getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(Button registerButton) {
		this.registerButton = registerButton;
	}

	
}