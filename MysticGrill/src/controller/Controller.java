package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class Controller {

//    private final Map<String, String> userDatabase = new HashMap<>();
//    private final ObservableList<Controller.MenuItem> menuItems = FXCollections.observableArrayList();
//    private final TableView<Controller.OrderItem> orderTable = new TableView<>();

    private TextField usernameField;
    private TextField emailField;
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;

//    public Controller() {
//        // Simulated initialization, you might load data from a database in a real scenario
//        menuItems.add(new Controller.MenuItem("Burger", 5.99));
//        menuItems.add(new Controller.MenuItem("Pizza", 8.99));
//        menuItems.add(new Controller.MenuItem("Salad", 4.99));
//    }

    public GridPane createLoginForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        
        // Implement the logic to create login form components
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        // Add components to the grid
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        
//        grid.setAlignment(Pos.CENTER);

        return grid;
    }

    public GridPane createRegistrationForm() {
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(20));
        
        // Implement the logic to create registration form components
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordField = new PasswordField();

        // Add components to the grid
        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(confirmPasswordLabel, 0, 3);
        grid.add(confirmPasswordField, 1, 3);
        
//        grid.setAlignment(Pos.CENTER);
        
        return grid;
    }

    public boolean validateRegistrationForm() {
        // Implement the logic to validate registration form
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return false;
        }

        if (password.length() < 6 || !password.equals(confirmPassword)) {
            return false;
        }

//        // Simulated database check
//        if (userDatabase.containsKey(email)) {
//            // Email already exists
//            return false;
//        }
//
//        Simulated registration (add user to the database)
//        userDatabase.put(email, password);
        return true;
    }

    public boolean validateLoginForm() {
        // Implement the logic to validate login form
        String email = emailField.getText();
        String password = passwordField.getText();
        
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }
        	
//        // Simulated database check
//        if (!userDatabase.containsKey(email) || !userDatabase.get(email).equals(password)) {
//            // Invalid email or password
//            return false;
//        }

        return true;
    }
}
