package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.User;
import view.AdminView;
import view.AdminUserManagementView;

public class AdminUserManagementController {
	private AdminUserManagementView AdminUserMgmtView;
	
	private ObservableList<User> users = FXCollections.observableArrayList();
	
	public AdminUserManagementController(AdminUserManagementView view, ObservableList<User> users) {
		this.AdminUserMgmtView = view;
		loadMenuData();
		setButtonListener();
		setupTableSelectionListener();
	}
	
	private void setupTableSelectionListener() {
		AdminUserMgmtView.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				AdminUserMgmtView.getRole().setValue(newSelection.getRole());
				AdminUserMgmtView.getName().setText(newSelection.getUsername());
				AdminUserMgmtView.getEmail().setText(newSelection.getEmail());
			}
		});
	}
	
	void loadMenuData() {
		users.clear();
		users.addAll(User.getAllUser());
		AdminUserMgmtView.getTable().setItems(users);
	}
	
	void handleInsert() {
		String role		= AdminUserMgmtView.getRole().getValue();
		String username 	= AdminUserMgmtView.getName().getText();
		String email 	= AdminUserMgmtView.getEmail().getText();
		for (User user : users) {
			if (username.equals(user.getUsername())) {
				System.out.println("Name is not unique");
				return;
			}
		}
		User.Userinsert(role, username, email);
		loadMenuData();
	}
	
	void handleDelete() {
		String userName = AdminUserMgmtView.getName().getText();
		User.deleteUser(userName);
		loadMenuData();
	}

	void handleUpdate() {
		String role		= AdminUserMgmtView.getRole().getValue();
		String username 	= AdminUserMgmtView.getName().getText();
		String email 	= AdminUserMgmtView.getEmail().getText();
		User.Userupdate(role, username, email);
		loadMenuData();
	}
	
	void handleBack() {
		Stage stage 					= new Stage();
		AdminView adminView 			= new AdminView(stage);
		AdminController adminCont 		= new AdminController(adminView);
		
		AdminUserMgmtView.getScene().getWindow().hide();
		stage.show();
	}
	
	private void setButtonListener() {
		AdminUserMgmtView.getAddButton().setOnAction(e -> handleInsert());
		AdminUserMgmtView.getDeleteButton().setOnAction(e -> handleDelete());
		AdminUserMgmtView.getUpdateButton().setOnAction(e -> handleUpdate());
		AdminUserMgmtView.getBackButton().setOnAction(e -> handleBack());
	}
}
