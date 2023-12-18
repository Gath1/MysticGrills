package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminView {
	private Button menuButton = new Button("Manage Menu");
	private Button userButton = new Button("Manage User");
	private Button closeButton = new Button("Close");
	private VBox actionBox = new VBox(20);
	private BorderPane borderCnt = new BorderPane();
	
	Scene sc;
	
	private void editComponent() {
		borderCnt.setCenter(actionBox);
		borderCnt.setBottom(closeButton);
		actionBox.getChildren().addAll(menuButton, userButton);
		
		BorderPane.setAlignment(closeButton, Pos.CENTER);
		BorderPane.setMargin(actionBox, new Insets(10));
		actionBox.setAlignment(Pos.CENTER);
		sc = new Scene(borderCnt, 400, 200);
		
	}
	
	public AdminView(Stage stage) {
		editComponent();
		
		stage.setScene(sc);
		stage.setTitle("Admin");
		stage.setResizable(false);
		stage.show();
	}

	public Scene getScene() {
		return sc;
	}

	public void setScene(Scene scene) {
		this.sc = scene;
	}
	public Button getMenuButton() {
		return menuButton;
	}

	public void setMenuButton(Button menuButton) {
		this.menuButton = menuButton;
	}

	public Button getUserButton() {
		return userButton;
	}

	public void setUserButton(Button userButton) {
		this.userButton = userButton;
	}

	public Button getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(Button closeButton) {
		this.closeButton = closeButton;
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