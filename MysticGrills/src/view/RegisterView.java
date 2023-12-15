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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;

public class RegisterView{
	
	
	private TextField userTxt = new TextField();
	private TextField emailTxt = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	private PasswordField confpassTxt = new PasswordField();
	private static Button registerButton = new Button("Register");
	private static VBox vbox, LoginLayout;
	static StackPane root;
	
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
		
//		getRegisterButton().setOnMouseClicked(e->{
//			System.out.println("You Have Register Your Account");
//			root.getChildren().clear();
//			root.getChildren().add(moveToLogin());
//		});
//		
		return form;
	}
	
//	static VBox moveToLogin() {
//		LoginLayout = new VBox();
//		Label LoginLbl = new Label("Login");
//		LoginLayout.getChildren().add(LoginLbl);
//		
//		return LoginLayout;
//	}
	

	public RegisterView(Stage stage) {	
		
		vbox = new VBox();
		
		GridPane form = editComponent();
		VBox.setMargin(form, new Insets(20));
		vbox.getChildren().addAll(form);
		
		root = new StackPane();
		root.getChildren().add(vbox);
		
		Scene scene = new Scene(root, 500,250);
		stage.setScene(scene);
		stage.setTitle("Mystic Grills");
		stage.show();
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