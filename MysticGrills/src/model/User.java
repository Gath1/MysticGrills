package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.LoginController;
import controller.RegisterController;
import database.Connect;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class User {
	
	private String userID;
	private String role;
	private String username;
	private String email;
	private String password;
	
	public User(String userID, String role, String username, String email, String password) {
		super();
		this.userID = userID;
		this.role = role;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public static ArrayList<User> getAllUser(){
		ArrayList<User> user = new ArrayList<>();
		String query = "Select * FROM user";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		
		try {
			while(rs.next()) {
				String userID 	= rs.getString(1);
				String role 	= rs.getString(2);
				String username = rs.getString(3);
				String email	= rs.getString(4);
				String password = rs.getString(5);
				
				user.add(new User(userID, role, username, email, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static void UserRegister(String username, String email, String password, String confirmPassword) {
		if(username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || confirmPassword.trim().isEmpty()) {
			showAlert("Every fields must be filled!!!");
			return;
		}
		if(password.length() < 6) {
			showAlert("Password must be filled at least 6 character!!!");
			return;
		}
		if(!password.equals(confirmPassword)) {
			showAlert("Confirm Password did not match");
			return;
		}
		
		String query = String.format("INSERT INTO user (userID, role, username, email, password) VALUES (NULL, 'Customer', '%s', '%s', '%s')", username, email, password, confirmPassword);
		Connect.getConnection().executeUpdate(query);
		showAlert("Your data have been registered");
		RegisterController.movetoLogin();
		
	}
	
	public static void Userlogin(String email, String password) {
		try {
			String query ="SELECT * FROM user WHERE email = ? AND password = ?";
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(email.isEmpty() || password.isEmpty()) {
				showAlert("Email or Password must be filled!");
			}
			else if(rs.next()) {
				String role = rs.getString("role");
				LoginController.showUserRole(role);
			}
			else {
				showAlert("Invalid Email or Password");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void Userinsert(String role, String username, String email) {
		String query = "INSERT INTO user (role, username, email) VALUES (?, ?, ?)";
		try(PreparedStatement ps = Connect.getConnection().prepareStatement(query)){
			ps.setString(1, role);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.executeUpdate();
			showAlert("You data have been inserted.");
		}catch (SQLException e) {
			e.printStackTrace();
			showAlert("Your data failed to be inserted");
		}
	}
	
	public static void Userupdate(String role, String username, String email) {
		String query ="UPDATE user SET role = ?, email = ? WHERE username = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
			
			ps.setString(1, role);
			ps.setString(2, email);
			ps.setString(3, username);
			ps.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(String username) {
		String query ="DELETE FROM user WHERE username = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
			ps.setString(1, username);
			ps.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void showAlert(String notif) {
		Alert warn = new Alert(AlertType.INFORMATION);
		warn.setTitle("Notification");
		warn.setHeaderText(null);
		warn.setContentText(notif);
		warn.showAndWait();
		
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}