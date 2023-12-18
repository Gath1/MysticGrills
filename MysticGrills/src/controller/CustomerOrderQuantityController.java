package controller;

import java.util.ArrayList;
import java.util.Collection;

import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Menu;
import model.Order;
import model.User;
import view.CustomerCartView;
import view.CustomerMenuView;
import view.CustomerQuantityOrderView;
import view.RegisterView;

public class CustomerOrderQuantityController {
	private CustomerQuantityOrderView cqov;
    private ObservableList<Order> orders;
    private static ArrayList<Order> orderList = new ArrayList<>();
    private CustomerCartView ccv;
    
    public CustomerOrderQuantityController(CustomerQuantityOrderView cqov, ObservableList<Order> orders,
			 CustomerCartView ccv, ArrayList<String> cartTemp) {
		super();
		this.cqov 	= cqov;
		this.orders = orders;
		this.ccv 	= ccv; 
		setButtonListener();
	}

	private void handleSave() {
		String orderID 	= "1";
    	String menuName = cqov.getNameTF().getText();
    	int quantity 	= cqov.getQuantityTF().getValue();
    	
    	Order newOrder = new Order(orderID, menuName, quantity);

        orderList.add(newOrder);

    	System.out.println("Order ID	: " + newOrder.getOrderID());
    	System.out.println("Menu Name	: " + newOrder.getMenuName());
    	System.out.println("Quantity	: " + newOrder.getQuantity());
    	
//    	Order.saveToCart(orderID, menuName, quantity);
    	Order.showOrder(orderList);
    	cqov.getScene().getWindow().hide();
    }
    
    private void handleCancel() {
		cqov.getScene().getWindow().hide();
    }
    
    private void setButtonListener() {
    	cqov.getSaveBtn().setOnAction(e -> handleSave());
		cqov.getCancelBtn().setOnAction(e -> handleCancel());
	}
}
