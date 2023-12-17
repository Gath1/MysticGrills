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
	private String menuDescription;
	private  BigDecimal menuPrice;
	
	public Menu(String menuID, String menuName, String menuDescription, BigDecimal price) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
		this.menuDescription = menuDescription;
		this.menuPrice = price;
	}
	
	public static ArrayList<Menu> getAllMenu(){
		ArrayList<Menu> menus = new ArrayList<>();
		String query ="SELECT * FROM menus";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				BigDecimal price = rs.getBigDecimal(4);
				
				menus.add(new Menu(id, name, description, price));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}
	
	public static void menuInsert(String menuName, String menuDescription, BigDecimal menuPrice) {
		
		if (menuName.trim().isEmpty() || menuDescription.trim().isEmpty() || menuPrice.compareTo(BigDecimal.ZERO) <= 0) {
	        showAlert("All fields must be filled in!");
	        return;
	}
		if(menuName.isEmpty()) {
			showAlert("Menu Name must be filled.");
			return;
		}
		
		if (menuDescription.length() <= 10) {
	    	showAlert("Menu Description must be filled at least more than 10 characters.");
	        return;
	    }

	    if (menuPrice.compareTo(new BigDecimal("2.5")) < 0) {
	    	showAlert("Menu Price must greater than 2.5 or equals");
	        return;
	    }
	    
	    String query ="INSERT INTO menus (menuName, menuDescription, menuPrice) VALUES (?, ?, ?)";
	    try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
	        ps.setString(1, menuName);
	        ps.setString(2, menuDescription);
	        ps.setBigDecimal(3, menuPrice);

	        ps.executeUpdate();
	        showAlert("Menu data have been inserted.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        showAlert("Failed to insert menu data.");
	    }    
	}
	
	public static void menuUpdate(String menuName, String menuDescription, BigDecimal menuPrice) {
		String query = "UPDATE menus SET menuDescription = ?, menuPrice = ? WHERE menuName = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
			ps.setString(1, menuDescription);
	        ps.setBigDecimal(2, menuPrice);
	        ps.setString(3, menuName);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void menuDelete(String menuName) {
		String query = "DELETE FROM menus WHERE menuName = ?";
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

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public BigDecimal getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(BigDecimal menuPrice) {
		this.menuPrice = menuPrice;
	}
		
}
