package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import model.User;
import view.AdminView;
import view.LoginView;
import view.AdminMenuManagementView;
import view.AdminUserManagementView;

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
		adminView.getMenuButton().setOnAction(e -> handleMenu());
		adminView.getUserButton().setOnAction(e -> handleUser());
	}
	
	void handleUser() {
		Stage stage = new Stage();
		AdminUserManagementView adminUserMgmt 		= new AdminUserManagementView(stage);
		AdminUserManagementController adminUserMgmtCont = new AdminUserManagementController(adminUserMgmt, users);
		
		adminView.getScene().getWindow().hide();
		stage.show();
	}
	
	void handleMenu() {
		Stage stage = new Stage();
		AdminMenuManagementView AdminMenuMgmtView 		= new AdminMenuManagementView(stage);
		AdminMenuManagementController AdminMenuMgmtCont = new AdminMenuManagementController(AdminMenuMgmtView, menus);
		
		adminView.getScene().getWindow().hide();
		stage.show();
	}
	
	void movetoLogin() {
		Stage stage = new Stage();
		LoginView loginView = new LoginView(stage);
		LoginController logC = new LoginController(loginView, users);
		adminView.getSc().getWindow().hide();
		stage.show();
	}
	
}