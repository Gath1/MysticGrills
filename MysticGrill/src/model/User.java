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
	
	private String UserID;
	private String Username;
	private String Email;
	private String Password;
	private String ConfirmPassword;
	
	public User(String userID, String username, String email, String password, String confirmPassword) {
		super();
		UserID = userID;
		Username = username;
		Email = email;
		Password = password;
		ConfirmPassword = confirmPassword;
	}
	
	public static ArrayList<User> getAllUser(){
		ArrayList<User> users = new ArrayList<>();
		String query = "Select * FROM users";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		
		try {
			while(rs.next()) {
				String userID = rs.getString(1);
				String userRole = rs.getString(2);
				String username = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				
				users.add(new User(userID, userRole, username, email, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public static void UserRegister(String username, String email, String password, String confirmPassword) {
		if(username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || confirmPassword.trim().isEmpty()) {
			showAlert("Every feilds must be filled!!!");
			return;
		}
		if(!password.equals(confirmPassword)) {
			showAlert("Confirm Password did not match");
			return;
		}
		if(password.length() < 6) {
			showAlert("Password must be filled at least 6 character!!!");
			return;
		}
		String query = String.format("INSERT INTO users, userID, username, email, password, confirmPassword) VALUES (NULL, 'Customer', '%s', '%s', '%s')", username, email, password, confirmPassword);
		Connect.getConnection().executeUpdate(query);
		showAlert("Your data have been registered");
		RegisterController.movetoLogin();
		
	}
	
	public static void Userlogin(String email, String password) {
		try {
			String query ="SELECT * FROM users WHERE emailTF = ? AND passwordTF = ?";
			PreparedStatement ps = Connect.getConnection().prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String userRole = rs.getString("userRole");
				LoginController.showUserRole(userRole);
			}
			else {
				showAlert("Your role cant be found");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void Userinsert(String userRole, String username, String email) {
		String query = "INSERT INTO users (userRole, username, email) VALUES (?, ?, ?)";
		try(PreparedStatement ps = Connect.getConnection().prepareStatement(query)){
			ps.setString(1, userRole);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.executeUpdate();
			showAlert("You data have been inserted.");
		}catch (SQLException e) {
			e.printStackTrace();
			showAlert("Your data failed to be inserted");
		}
	}
	
	public static void Userupdate(String userRole, String username, String email) {
		String query ="UPDATE users SET userRole = ?, email = ? WHERE username = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
			
			ps.setString(1, userRole);
			ps.setString(2, email);
			ps.setString(3, username);
			ps.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(String username) {
		String query ="DELETE FROM users WHERE username = ?";
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
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	
}