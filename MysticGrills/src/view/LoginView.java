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
	
	private TextField email = new TextField();
	private PasswordField password = new PasswordField();	
	private Button loginButton = new Button("Login");
	private Button registerButton = new Button("Register");
	private VBox actionBox = new VBox(20);
	
	private BorderPane borderCnt = new BorderPane();
	private GridPane gridCnt = new GridPane();
	private FlowPane flowCnt = new FlowPane();
	
	Scene sc;
	
	private void createLoginForm() {
		borderCnt.setCenter(gridCnt);
		borderCnt.setBottom(actionBox);
		
		actionBox.getChildren().addAll(loginButton, registerButton);
		
		gridCnt.add(new Label("Email : "), 0, 0);
		gridCnt.add(email, 1, 0);
		gridCnt.add(new Label("Password : "), 0, 1);
		gridCnt.add(password, 1, 1);
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
	

	public TextField getEmail() {
		return email;
	}

	public void setEmail(TextField email) {
		this.email = email;
	}

	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
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

	public VBox getActionBox() {
		return actionBox;
	}

	public void setActionBox(VBox actionBox) {
		this.actionBox = actionBox;
	}

	public BorderPane getBorderCnt() {
		return borderCnt;
	}

	public void setBorderCnt(BorderPane borderCnt) {
		this.borderCnt = borderCnt;
	}

	public GridPane getGridCnt() {
		return gridCnt;
	}

	public void setGridCnt(GridPane gridCnt) {
		this.gridCnt = gridCnt;
	}

	public FlowPane getFlowCnt() {
		return flowCnt;
	}

	public void setFlowCnt(FlowPane flowCnt) {
		this.flowCnt = flowCnt;
	}

	public Scene getSc() {
		return sc;
	}

	public void setSc(Scene sc) {
		this.sc = sc;
	}

	
	
}

