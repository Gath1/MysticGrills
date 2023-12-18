package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import model.User;
import view.CustomerCartView;
import view.CustomerMenuView;
import view.CustomerView;
import view.LoginView;

public class CustomerController {

	private CustomerView customerView;
	private ObservableList<User> users = FXCollections.observableArrayList();
	private ObservableList<Menu> menus = FXCollections.observableArrayList();

	public CustomerController(CustomerView customerController) {
		this.customerView = customerController;
		setButtonHandlers();
	}
	
	private void setButtonHandlers() {
		customerView.getMenuButton().setOnAction(e -> movetocustomerMenu());
		customerView.getCartButton().setOnAction(e -> movetocustomerCart());
		customerView.getLogoutButton().setOnAction(e -> movetoLogin());
	}
	
	void movetocustomerMenu() {
		System.out.println("menu button clicked");
		Stage stage = new Stage();
		CustomerMenuView customerMenuView = new CustomerMenuView(stage);
		CustomerMenuController CusCM = new CustomerMenuController(customerMenuView, menus);
		customerView.getSc().getWindow().hide();
		stage.show();
	}
	
	void movetocustomerCart() {
		System.out.println(" cart button clicked");
		Stage stage = new Stage();
		CustomerCartView customerCartView = new CustomerCartView(stage, null);
		CustomerCartController CusCC = new CustomerCartController(customerCartView, null);
		customerView.getSc().getWindow().hide();
		stage.show();
	}
	
	void movetoLogin() {
		System.out.println("Login button clicked");
		Stage stage = new Stage();
		LoginView loginView = new LoginView(stage);
		LoginController logC = new LoginController(loginView, users);
		customerView.getSc().getWindow().hide();
		stage.show();
	}
	
	
}