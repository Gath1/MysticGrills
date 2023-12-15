package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;


public class User {
	
	private String UserID;
	private String Username;
	private String Email;
	private String Password;
	private String ConfirmPassword;
	
	public User(String userID, String username, String email, String password, String confirmPassword) {
		UserID = userID;
		Username = username;
		Email = email;
		Password = password;
		ConfirmPassword = confirmPassword;
	}
	
	public static ArrayList<User> getAllUser(){
		ArrayList<User> users = new ArrayList<>();
//		Connect con = Connect.getInstance();
		String query = "Select * FROM users";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		
		try {
			while(rs.next()) {
				String userID = rs.getString("userid");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String confirmPassword = rs.getString("confirmpassword");	
				
				users.add(new User(userID, username, email, password, confirmPassword));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
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