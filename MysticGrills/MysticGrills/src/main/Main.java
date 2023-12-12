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

import java.util.HashMap;
import java.util.Map;

import controller.Controller;

public class Main extends Application {

	private final Controller controller = new Controller();
    private Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login and Registration Example");

        TabPane tabPane = new TabPane();

        // Login Tab
        Tab loginTab = new Tab("Login");
        loginTab.setContent(controller.createLoginForm());

        // Registration Tab
        Tab registrationTab = new Tab("Register");
        registrationTab.setContent(controller.createRegistrationForm());

        // Add tabs to the TabPane
        tabPane.getTabs().addAll(loginTab, registrationTab);

        // Set the login tab as the initial tab to show
        tabPane.getSelectionModel().select(loginTab);

        // Create a Register button to switch to the Registration tab
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            if (controller.validateRegistrationForm()) {
                Platform.runLater(() -> tabPane.getSelectionModel().select(registrationTab));
                System.out.println("Register Success");
            } else {
                // Show an error message or handle validation failure
                System.out.println("Registration validation failed.");
            }
        });

        // Create a Login button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            if (controller.validateLoginForm()) {
            	System.out.println("Login Success");
                loginButtonClicked();
            } else {
                // Show an error message or handle validation failure
                System.out.println("Login validation failed.");
            }
        });

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

    private void loginButtonClicked() {
        // Implement your login logic here
        System.out.println("Login button clicked");
    }
}








