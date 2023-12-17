package view;
//package view;
//
//import controller.LoginController;
//import controller.RegisterController;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import main.Main;
//
//public class ViewManager {
//	private StackPane stackPane;
//    private Main mainApp;
//    
//    private LoginView loginView;
//    private RegisterView registerView;
//
//    public ViewManager(StackPane stackPane, Main mainApp) {
//        this.stackPane = stackPane;
//        this.mainApp = mainApp;
//        loginView = new LoginView(mainApp);
//        registerView = new RegisterView(mainApp);
//        switchToLoginScene();
//    }
//
//    public void switchToLoginScene() {
//        stackPane.getChildren().clear();
//        LoginController loginController = new LoginController(loginView);
//        stackPane.getChildren().add(new LoginView(loginView).getView());
//    }
//
//    public void switchToRegisterScene() {
//        stackPane.getChildren().clear();
//        stackPane.getChildren().add(new RegisterView(mainApp).getView());
//        RegisterController registerController = new RegisterController(registerView);
//    }
//}
