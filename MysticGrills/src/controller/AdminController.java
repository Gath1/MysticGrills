package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import model.User;
import view.AdminView;
import view.LoginView;

public class AdminController {
	private AdminView adminView;
	private ObservableList<User> users = FXCollections.observableArrayList();
	private ObservableList<Menu> menus = FXCollections.observableArrayList();
	
	public AdminController(AdminView adminView) {
		this.adminView = adminView;
		setButtonHandlers();
	}
	
	private void setButtonHandlers() {
		adminView.getCloseButton().setOnAction(e -> movetoLogin());
	}
	
	void movetoLogin() {
		Stage stage = new Stage();
		LoginView loginView = new LoginView(stage);
		LoginController logC = new LoginController(loginView, users);
		adminView.getSc().getWindow().hide();
		stage.show();
	}
	
}