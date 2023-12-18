package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Menu;

public class AdminMenuManagementView {
	
	private TableView<Menu> table;
	
	private TextField name 	= new TextField();
	private TextField price 	= new TextField();
	
	private Button addButton 		= new Button("Add");
	private Button updateButton 	= new Button("Update");
	private Button deleteButton 	= new Button("Delete");
	private Button backButton		= new Button("Back to Menu");
	
	Scene sc;
	public AdminMenuManagementView(Stage stage) {
		VBox root = new VBox();
		
		table = createMenuTable();
		
		GridPane form = createMenuForm(table);
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(table, form);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		sc = new Scene(root, 500, 500);
		stage.setScene(sc);
		stage.setTitle("Mystic Grills");
		stage.setResizable(false);
		stage.show();
	}
	
	private TableView<Menu> createMenuTable(){
		TableView<Menu> table = new TableView<>();

		TableColumn<Menu, String> nameColumn = new TableColumn<>("Menu Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("menuName"));

		TableColumn<Menu, Number> priceColumn = new TableColumn<>("Menu Price");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));
		
		table.getColumns().add(nameColumn);
		table.getColumns().add(priceColumn);
		
		return table;
	}
	
	private GridPane createMenuForm(TableView<Menu> table) {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		form.add(new Label("Name:"), 0, 0);
		form.add(name, 1, 0);
		form.add(new Label("Price:"), 0, 1);
		form.add(price, 1, 1);
		form.add(addButton, 0, 2);
		form.add(updateButton, 1, 2);
		form.add(deleteButton, 2, 2);
		form.add(backButton, 3, 2);
		
		return form;
	}

	

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	public TableView<Menu> getTable() {
		return table;
	}

	public void setTable(TableView<Menu> table) {
		this.table = table;
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public TextField getPrice() {
		return price;
	}

	public void setPrice(TextField price) {
		this.price= price;
	}

	public Button getAddButton() {
		return addButton;
	}

	public void setAddButton(Button addButton) {
		this.addButton = addButton;
	}

	public Button getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(Button updateButton) {
		this.updateButton = updateButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(Button deleteButton) {
		this.deleteButton = deleteButton;
	}
	
	public Scene getScene() {
		return sc;
	}

	public void setScene(Scene scene) {
		this.sc = scene;
	}
}