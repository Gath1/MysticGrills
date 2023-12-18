package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import model.Order;
import view.CustomerCartView;
import view.CustomerMenuView;
import view.CustomerQuantityOrderView;

public class CustomerCartController {
	private CustomerCartView ccov;
	private static CustomerMenuView cmv;
	
	private ObservableList<Order> orders = FXCollections.observableArrayList();
	private ArrayList<String> cartTemp 		= new ArrayList<>();
	
	String menuName = "di controller";
	int quantity = 3;
	
	public CustomerCartController(CustomerCartView ccov, ArrayList<String> cartTemp) {
		super();
		this.ccov 		= ccov;
		this.cartTemp 	= cartTemp;
		
		loadTableData();
		setButtonListener();
	}
	
	void loadTableData() {
		orders.clear();
//		orders.addAll(Order.showOrder(orderList));
		ccov.getTable().setItems(orders);
	}

	void handleSave(){
		System.out.println("ini save");
	}

	void handleCancel(){
		Stage stage 				= new Stage();
		CustomerMenuView cmv		= new CustomerMenuView(stage);
		CustomerMenuController cc	= new CustomerMenuController(cmv, null);
		
		ccov.getScene().getWindow().hide();
		stage.show();
	}
	
	void handleOrder(Menu rowData) {
		cmv.getAddBtn().setOnAction(e -> handleOrder(rowData));
        cmv.getScene().getWindow();
        Menu selectedMenu 						= cmv.getTable().getSelectionModel().getSelectedItem();
	    Stage stage 							= new Stage();
        CustomerQuantityOrderView vcoq 			= new CustomerQuantityOrderView(stage, rowData);
        CustomerOrderQuantityController coqc 	= new CustomerOrderQuantityController(vcoq, orders, null, null);
        stage.show();
	}
	
	void setButtonListener() {
		ccov.getCheckoutBtn().setOnAction(e -> handleSave());
		ccov.getCancelBtn().setOnAction(e -> handleCancel());
	}

}
