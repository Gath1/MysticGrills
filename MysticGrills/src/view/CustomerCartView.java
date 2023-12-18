package view;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Menu;
import model.Order;
import model.User;

public class CustomerCartView{

	Scene scene;

	private TableView<Order> table;

	private static ObservableList<Order> orders = FXCollections.observableArrayList();
	private static ArrayList<String> cartTemp = new ArrayList<>();
	private static int orderId = 1;

	private BorderPane borderCont		= new BorderPane();
	private HBox buttonBox 				= new HBox(10);
	private Button checkoutBtn			= new Button("Checkout");
	private Button cancelBtn			= new Button("Cancel");

	public static TableView<Order> createMenuOrder() {
		TableView<Order> table = new TableView<>();

		TableColumn<Order, String> nameColumn = new TableColumn<>("Menu Name");
		nameColumn.setCellValueFactory(data ->
		new SimpleStringProperty(data.getValue().getMenuName())
				);

		TableColumn<Order, Number> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		table.getColumns().add(nameColumn);
		table.getColumns().add(quantityColumn);
		
		table.setItems(orders);

		return table;
	}

	public CustomerCartView(Stage stage, ObservableList<Order> orders) {
		VBox root = new VBox();

		table = createMenuOrder();
		buttonBox.getChildren().addAll(checkoutBtn, cancelBtn);
		HBox.setMargin(checkoutBtn, new Insets(50, 50, 50, 50));
		HBox.setMargin(cancelBtn, new Insets(50, 50, 50, 50));
		checkoutBtn.setPrefHeight(100);
		checkoutBtn.setPrefWidth(200);
		cancelBtn.setPrefHeight(100);
		cancelBtn.setPrefWidth(200);

		checkoutBtn.setFont(new Font("Arial", 15));
		cancelBtn.setFont(new Font("Arial", 15));

		root.getChildren().addAll(table, buttonBox);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		buttonBox.setAlignment(Pos.CENTER);

		scene = new Scene(root, 500, 500);

		table.setItems(orders);
		
		stage.setScene(scene);
		stage.setTitle("Mystic Grills - Cart");
		stage.setResizable(false);
		stage.show();
	}

	public TableView<Order> getTable() {
		return table;
	}

	public void setTable(TableView<Order> table) {
		this.table = table;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public static ArrayList<String> getCartTemp() {
		return cartTemp;
	}

	public static void setCartTemp(ArrayList<String> cartTemp) {
		CustomerCartView.cartTemp = cartTemp;
	}

	public BorderPane getBorderCont() {
		return borderCont;
	}

	public void setBorderCont(BorderPane borderCont) {
		this.borderCont = borderCont;
	}

	public Button getCheckoutBtn() {
		return checkoutBtn;
	}

	public void setCheckoutBtn(Button checkoutBtn) {
		this.checkoutBtn = checkoutBtn;
	}

	public Button getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
}
