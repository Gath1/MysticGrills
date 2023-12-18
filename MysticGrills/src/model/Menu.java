package model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Menu {
	private String menuID;
	private String menuName;
	private  BigDecimal menuPrice;
	
	public Menu(String menuID, String menuName, BigDecimal menuPrice) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}
	
	public static ArrayList<Menu> getAllMenu(){
		ArrayList<Menu> menus = new ArrayList<>();
		String query ="SELECT * FROM menu";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				BigDecimal price = rs.getBigDecimal(3);
				
				menus.add(new Menu(id, name, price));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}
	
	public static void menuInsert(String menuName, BigDecimal menuPrice) {
		
		if (menuName.trim().isEmpty() || menuPrice.compareTo(BigDecimal.ZERO) <= 0) {
	        showAlert("All fields must be filled in!");
	        return;
	}
		if(menuName.isEmpty()) {
			showAlert("Menu Name must be filled.");
			return;
		}

	    if (menuPrice.compareTo(new BigDecimal("2.5")) < 0) {
	    	showAlert("Menu Price must greater than 2.5 or equals");
	        return;
	    }
	    
	    String query ="INSERT INTO menu (menuName, menuPrice) VALUES (?, ?)";
	    try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
	        ps.setString(1, menuName);
	        ps.setBigDecimal(2, menuPrice);

	        ps.executeUpdate();
	        showAlert("Menu data have been inserted.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        showAlert("Failed to insert menu data.");
	    }    
	}
	
	public static void menuUpdate(String menuName, BigDecimal menuPrice) {
		String query = "UPDATE menu SET menuPrice = ? WHERE menuName = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
	        ps.setBigDecimal(1, menuPrice);
	        ps.setString(2, menuName);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void menuDelete(String menuName) {
		String query = "DELETE FROM menu WHERE menuName = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
			ps.setString(1, menuName);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	private static void showAlert(String notif) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText(null);
		alert.setContentText(notif);
		alert.showAndWait();
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public BigDecimal getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(BigDecimal menuPrice) {
		this.menuPrice = menuPrice;
	}
		
}