package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView{
	
	private TextField userTxt = new TextField();
	private TextField emailTxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	private PasswordField confpassTxt = new PasswordField();
	private Button registerButton = new Button("Register");
	
	
	public RegisterView(Stage primaryStage) {	
		
		VBox root = new VBox();
		
		GridPane form = editComponent();
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(form);
		
		Scene scene = new Scene(root, 500,250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mystic Grills");
		primaryStage.show();
	}
	
	public GridPane editComponent() {	
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		form.add(new Label("Username : "), 0, 0);
		form.add(userTxt, 1, 0);
		form.add(new Label("Email : "), 0, 1);
		form.add(emailTxt, 1, 1);
		form.add(new Label("Password : "), 0, 2);
		form.add(passwordTxt, 1, 2);
		form.add(new Label("ConfirmPassword : "), 0, 3);
		form.add(confpassTxt, 1, 3);	
		form.add(registerButton, 1, 4);
		
		return form;
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
