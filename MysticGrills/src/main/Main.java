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
import view.LoginView;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import controller.LoginController;

public class Main extends Application {

	Scene scene;
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	primaryStage.show();
    	LoginView loginView = new LoginView(primaryStage);
    	LoginController loginController = new LoginController(loginView);
    }
}








