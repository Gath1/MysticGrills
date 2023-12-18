package view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.CustomerController;

public class CustomerView {
	
	private Button menuButton = new Button("View Menu");	
	private Button cartButton = new Button("View Cart");	
	private Button logoutButton = new Button("LogOut");
	private VBox actionBox = new VBox(20);
	private BorderPane borderCnt = new BorderPane();
	Scene sc;
	
	private void editComponent() {
		borderCnt.setCenter(actionBox);
		borderCnt.setBottom(logoutButton);
		
		actionBox.getChildren().addAll(menuButton, cartButton);
		
		BorderPane.setAlignment(logoutButton, Pos.CENTER);
		BorderPane.setMargin(actionBox, new Insets(10));
		
		actionBox.setAlignment(Pos.CENTER);
		sc = new Scene(borderCnt, 400, 200);
		
	}
	
	public CustomerView(Stage stage) {
		editComponent();
		
		stage.setScene(sc);
		stage.setTitle("Customer");
		stage.setResizable(false);
		stage.show();
	}

	public Button getMenuButton() {
		return menuButton;
	}

	public void setMenuButton(Button menuButton) {
		this.menuButton = menuButton;
	}

	public Button getCartButton() {
		return cartButton;
	}

	public void setCartButton(Button cartButton) {
		this.cartButton = cartButton;
	}

	public Button getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(Button logoutButton) {
		this.logoutButton = logoutButton;
	}

	public VBox getActionBox() {
		return actionBox;
	}

	public void setActionBox(VBox actionBox) {
		this.actionBox = actionBox;
	}

	public BorderPane getBorderCnt() {
		return borderCnt;
	}

	public void setBorderCnt(BorderPane borderCnt) {
		this.borderCnt = borderCnt;
	}

	public Scene getSc() {
		return sc;
	}

	public void setSc(Scene sc) {
		this.sc = sc;
	}
	
}