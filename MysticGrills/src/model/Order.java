package model;

import java.util.ArrayList;

import database.Connect;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Order {
	private String orderID;
	private String menuName;
	private int quantity;

	private static ArrayList<String> cartTab = new ArrayList<>();
	private static ArrayList<Order> orders = new ArrayList<>();

	public Order(String orderID, String menuName, int quantity) {
		super();
		this.orderID 		= orderID;
		this.menuName 		= menuName;
		this.quantity 		= quantity;
	}

	public static ArrayList<Order> showOrder(ArrayList<Order> orderList) {
		ArrayList<Order> orders = new ArrayList<>();
//		System.out.println("===== BATAS AWAL getOrder =====");
//		for (Order order : orderList) {
//		    System.out.println("Menu Name: " + order.getmenuName());
//		    System.out.println("Quantity : " + order.getQuantity());
//	        orders.add(order);
//		}
//		System.out.println("===== BATAS AKHIR getOrder =====");
		return orderList;
	}

	public static void cartTemp(String menuName, int quantity) {
		String orderInfo = "Menu : " + menuName + ", Quantity: " + quantity;
		cartTab.add(orderInfo);
		System.out.println(cartTab);
		showAlert("Your Order Have Been Added To Cart!");
	}

	public static void saveToCart(String orderID, String menuName, int quantity) {
		String query = String.format("INSERT INTO order (orderID, menuName, quantity) VALUES (NULL, '%s', %d)", menuName, quantity);
		Connect.getConnection().executeUpdate(query);
		showAlert("Order Succesfull!");

		cartTab.add(menuName);
		System.out.println(menuName);
	}

	private static void showAlert(String notif) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText(null);
		alert.setContentText(notif);
		alert.showAndWait();
	}
	
	public static ArrayList<Order> getOrders() {
		return orders;
	}

	public static void setOrders(ArrayList<Order> orders) {
		Order.orders = orders;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static ArrayList<String> getCartTab() {
		return cartTab;
	}

	public static void setCartTab(ArrayList<String> cartTab) {
		Order.cartTab = cartTab;
	}

	
}
