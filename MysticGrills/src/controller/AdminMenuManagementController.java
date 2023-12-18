package controller;

import java.math.BigDecimal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import view.AdminView;
import view.AdminMenuManagementView;

public class AdminMenuManagementController {
	private AdminMenuManagementView AdminMenuMgmtView;
	
	private ObservableList<Menu> menus = FXCollections.observableArrayList();
	
	public AdminMenuManagementController (AdminMenuManagementView view, ObservableList<Menu> menus2) {
		this.AdminMenuMgmtView = view;
		loadMenuData();
		setButtonListener();
		setupTableSelectionListener();
	}
	
	private void setupTableSelectionListener() {
		AdminMenuMgmtView.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				AdminMenuMgmtView.getName().setText(newSelection.getMenuName());
				AdminMenuMgmtView.getPrice().setText(String.valueOf(newSelection.getMenuPrice()));
			}
		});
	}
	
	void loadMenuData() {
		menus.clear();
		menus.addAll(Menu.getAllMenu());
		AdminMenuMgmtView.getTable().setItems(menus);
	}
	
	void handleInsert() {
		String menuName 		= AdminMenuMgmtView.getName().getText();
		BigDecimal menuPrice 	= new BigDecimal(AdminMenuMgmtView.getPrice().getText());
		for (Menu menu : menus) {
			if (menuName.equals(menu.getMenuName())) {
				System.out.println("Name is not unique");
				return;
			}
		}
		Menu.menuInsert(menuName, menuPrice);
		loadMenuData();
	}
	
	void handleDelete() {
		String menuName = AdminMenuMgmtView.getName().getText();
		Menu.menuDelete(menuName);
		loadMenuData();
	}

	void handleUpdate() {
		String menuName 		= AdminMenuMgmtView.getName().getText();
		BigDecimal menuPrice 	= new BigDecimal(AdminMenuMgmtView.getPrice().getText());
		Menu.menuUpdate(menuName, menuPrice);
		loadMenuData();
	}
	
	void handleBack() {
		Stage stage 						= new Stage();
		AdminView adminView 				= new AdminView(stage);
		AdminController adminCont 			= new AdminController(adminView);
		
		AdminMenuMgmtView.getScene().getWindow().hide();
		stage.show();
	}
	
	private void setButtonListener() {
		AdminMenuMgmtView.getAddButton().setOnAction(e -> handleInsert());
		AdminMenuMgmtView.getDeleteButton().setOnAction(e -> handleDelete());
		AdminMenuMgmtView.getUpdateButton().setOnAction(e -> handleUpdate());
		AdminMenuMgmtView.getBackButton().setOnAction(e -> handleBack());
	}
}
