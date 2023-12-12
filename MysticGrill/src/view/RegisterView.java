package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RegisterView extends VBox {
	
	public RegisterView() {
		
		VBox root = new VBox();
		
		GridPane form = makeForm;
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(form);
		
		Scene scene = new Scene(root, 1000, 600);
		primaryStage.setScene(scene);
		primarystage.show();
		
	}
	
}
