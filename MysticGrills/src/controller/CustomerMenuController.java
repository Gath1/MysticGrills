package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import model.Order;
import view.CustomerView;
import view.CustomerCartView;
import view.CustomerMenuView;
import view.CustomerQuantityOrderView;

public class CustomerMenuController {
	private static CustomerMenuView cmv;
	
	private static ObservableList<Menu> menus 		= FXCollections.observableArrayList();
	private static ObservableList<Order> orders 	= FXCollections.observableArrayList();
	
	public CustomerMenuController (CustomerMenuView view, ObservableList<Menu> menus) {
	    this.cmv 	= view;
	    loadMenuData();
	    setButtonListener();
	}

	void loadMenuData() {
		menus.clear();
		menus.addAll(Menu.getAllMenu());
		cmv.getTable().setItems(menus);
	}
	
	void setButtonListener() {
		cmv.getBackBtn().setOnAction(e -> handleBack());
		cmv.getViewBtn().setOnAction(e -> handleCart());
	}
	
	void handleBack() {
		Stage stage 			= new Stage();
		CustomerView vc			= new CustomerView(stage);
		CustomerController cc 	= new CustomerController(vc);
		
		cmv.getScene().getWindow().hide();
		stage.show();
	}			
	
	void handleCart() {
		Stage stage 				= new Stage();
		CustomerCartView ccv		= new CustomerCartView(stage, null);
		CustomerCartController ccc 	= new CustomerCartController(ccv, null);
		
		cmv.getScene().getWindow().hide();
		stage.show();
	}
	
	public static void handleCart(Menu rowData) {
        cmv.getAddBtn().setOnAction(e -> handleCart(rowData));
        cmv.getScene().getWindow();
        System.out.println("cart added");
        Menu selectedMenu 						= cmv.getTable().getSelectionModel().getSelectedItem();
	    Stage stage 							= new Stage();
        CustomerQuantityOrderView cqov 			= new CustomerQuantityOrderView(stage, rowData);
        CustomerOrderQuantityController coqc 	= new CustomerOrderQuantityController(cqov, orders, null, null);
        stage.show();
	}
}
