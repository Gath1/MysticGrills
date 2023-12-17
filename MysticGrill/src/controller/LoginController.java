package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import view.AdminView;
import view.CustomerView;
import view.LoginView;
import view.RegisterView;

public class LoginController {
	
	private ObservableList<User> users = FXCollections.observableArrayList();
	private static LoginView loginView;
	
	public LoginController(LoginView view, ObservableList<User> users) {
		this.loginView = view;
		setButtonHandlers();
	}
	
	private void setButtonHandlers() {
        loginView.getLoginButton().setOnAction(event -> handleLogin());
        loginView.getRegisterButton().setOnAction(event -> movetoRegister());
    }
	
	private void handleLogin() {
		String email = loginView.getEmailTF().getText();
	    String password = loginView.getPasswordTF().getText();
        User.Userlogin(email, password);
	}
	
	private void movetoRegister() {
		Stage primaryStage = new Stage();
		RegisterView registerView = new RegisterView(primaryStage);
		RegisterController regC = new RegisterController(registerView, users);
		loginView.getSc().getWindow().hide();
		primaryStage.show();
	}
	
	private static void movetoCustomer() {
		Stage primaryStage = new Stage();
		CustomerView customerView = new CustomerView(primaryStage);
		CustomerController CusC = new CustomerController(customerView);
		loginView.getSc().getWindow().hide();
		primaryStage.show();
	}
	
	private static void movetoAdmin() {
		Stage primaryStage = new Stage();
		AdminView adminView = new AdminView(primaryStage);
		AdminController AdmC = new AdminController(adminView);
		loginView.getSc().getWindow().hide();
		primaryStage.show();
	}
	
	public static void showUserRole(String userRole) {
		switch (userRole) {
		case "Admin":
			movetoAdmin();
			break;
		case "Chef":
			break;
		case "Waiter":
			break;
		case "Cashier":
			break;
		case "Customer":
			movetoCustomer();
			break;
		default:
			break;
		}
	}
	
}
