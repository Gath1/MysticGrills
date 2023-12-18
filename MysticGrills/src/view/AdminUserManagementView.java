package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

public class AdminUserManagementView {
	
	private TableView<User> table;

	private ComboBox<String> role = new ComboBox<>();
	
	private TextField name 		= new TextField();
	private TextField email 	= new TextField();

	private Button addButton 		= new Button("Add");
	private Button deleteButton 	= new Button("Delete");
	private Button updateButton		= new Button("Update");
	private Button backButton		= new Button("Menu");
	
	Scene sc;
	public AdminUserManagementView(Stage stage) {
		VBox root = new VBox();

		table = createMenuUser();

		GridPane form = createUserForm(table);
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(table, form);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		sc = new Scene(root, 500, 500);
		stage.setScene(sc);
		stage.setTitle("Mystic Grills");
		stage.setResizable(false);
		stage.show();
	}

	private TableView<User> createMenuUser(){
		TableView<User> table = new TableView<>();

		TableColumn<User, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

		TableColumn<User, String> emailColumn = new TableColumn<>("Email");
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		TableColumn<User, String> roleColumn = new TableColumn<>("Role");
		roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

		table.getColumns().add(nameColumn);
		table.getColumns().add(emailColumn);
		table.getColumns().add(roleColumn);

		return table;
	}

	private GridPane createUserForm(TableView<User> table) {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		role.getItems().addAll("Admin", "Customer");
		form.add(new Label("Role:"), 0, 0);
		form.add(role, 1, 0);
		form.add(new Label("Name:"), 0, 1);
		form.add(name, 1, 1);
		form.add(new Label("Email:"), 0, 2);
		form.add(email, 1, 2);
		form.add(addButton, 0, 3);
		form.add(updateButton, 1, 3);
		form.add(deleteButton, 2, 3);
		form.add(backButton, 3, 3);

		return form;
	}

	public Scene getScene() {
		return sc;
	}

	public void setScene(Scene scene) {
		this.sc = scene;
	}

	public TableView<User> getTable() {
		return table;
	}

	public void setTable(TableView<User> table) {
		this.table = table;
	}

	public ComboBox<String> getRole() {
	    return role;
	}

	public void setRole(ComboBox<String> role) {
	    this.role = role;
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public TextField getEmail() {
		return email;
	}

	public void setEmail(TextField email) {
		this.email = email;
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

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}
}