package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import model.User;
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
//		customerView.getMenuButton().setOnAction(e -> movetocustomerMenu());
//		customerView.getCartButton().setOnAction(e -> movetocustomerCart());
		customerView.getCloseButton().setOnAction(e -> movetoLogin());
	}
	
//	void movetocustomerMenu() {
//		Stage stage = new Stage();
//		CustomerViewMenu customerViewMenu = new CustomerViewMenu(stage);
//		CustomerControllerMenu CusCM = new CustomerControllerMenu(customerViewMenu, menus);
//		customerView.getSc().getWindow().hide();
//		stage.show();
//	}
//	
//	void movetocustomerCart() {
//		Stage stage = new Stage();
//		CustomerViewCart customerViewCart = new CustomerViewCart(stage);
//		CustomerControllerCart CusCC = new CustomerControllerCart(customerViewCart, menus);
//		customerView.getSc().getWindow().hide();
//		stage.show();
//	}
	
	void movetoLogin() {
		Stage stage = new Stage();
		LoginView loginView = new LoginView(stage);
		LoginController logC = new LoginController(loginView, users);
		customerView.getSc().getWindow().hide();
		stage.show();
	}
	
	
}
