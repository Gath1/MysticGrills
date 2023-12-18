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
	private TextField username = new TextField();
	private TextField email = new TextField();
	private PasswordField password = new PasswordField();
	private PasswordField confPass = new PasswordField();
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
		gridCnt.add(username, 1, 0);
		gridCnt.add(new Label("Email : "), 0, 1);
		gridCnt.add(email, 1, 1);
		gridCnt.add(new Label("Password : "), 0, 2);
		gridCnt.add(password, 1, 2);
		gridCnt.add(new Label("ConfirmPassword : "), 0, 3);
		gridCnt.add(confPass, 1, 3);	
		
		sc = new Scene(borderCnt, 500, 500);
	}
	
	private void setComponent() {
		BorderPane.setAlignment(gridCnt, Pos.CENTER);
		
		BorderPane.setMargin(actionBox, new Insets(10));
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

	public TextField getusername() {
		return username;
	}

	public void setusername(TextField username) {
		this.username = username;
	}

	public TextField getemail() {
		return email;
	}

	public void setemail(TextField email) {
		this.email = email;
	}

	public PasswordField getpassword() {
		return password;
	}

	public void setpassword(PasswordField password) {
		this.password = password;
	}

	public PasswordField getconfPass() {
		return confPass;
	}

	public void setconfPass(PasswordField confPass) {
		this.confPass = confPass;
	}

	public Button getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(Button registerButton) {
		this.registerButton = registerButton;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
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
	
}