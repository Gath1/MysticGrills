package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login and Registration Example");

        TabPane tabPane = new TabPane();

        // Login Tab
        Tab loginTab = new Tab("Login");
        GridPane loginGrid = createLoginForm();
        loginTab.setContent(loginGrid);

        // Registration Tab
        Tab registrationTab = new Tab("Register");
        GridPane registrationGrid = createRegistrationForm();
        registrationTab.setContent(registrationGrid);

        // Add tabs to the TabPane
        tabPane.getTabs().addAll(loginTab, registrationTab);

        // Set the login tab as the initial tab to show
        tabPane.getSelectionModel().select(loginTab);

        // Create a Register button to switch to the Registration tab
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> Platform.runLater(() -> tabPane.getSelectionModel().select(registrationTab)));

        // Create a Login button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> loginButtonClicked());

        // Arrange buttons horizontally
        HBox buttonBox = new HBox(10, loginButton, registerButton);
        buttonBox.setPadding(new Insets(10));

        // Create the main scene
        VBox mainLayout = new VBox(tabPane, buttonBox);
        Scene scene = new Scene(mainLayout, 400, 300);

        // Set the stage's scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createLoginForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Add UI components for login
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        // Add components to the grid
        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);

        return grid;
    }

    private GridPane createRegistrationForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Add UI components for registration
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label confirmPasswordLabel = new Label("Confirm Password:");
        PasswordField confirmPasswordField = new PasswordField();

        // Add components to the grid
        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(confirmPasswordLabel, 0, 3);
        grid.add(confirmPasswordField, 1, 3);

        return grid;
    }

    private void loginButtonClicked() {
        // Implement your login logic here
        System.out.println("Login button clicked");
    }
}



