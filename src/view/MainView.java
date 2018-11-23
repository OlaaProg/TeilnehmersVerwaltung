package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Teilnehmer");
				
		GridPane gitter = new TeilnehmerView().TeilnehmerGridPane();
		
		Scene scene = new Scene(gitter, 800, 600);
		scene.getStylesheets().add("style/gitter.css");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) throws Exception {
		launch(args);
	}
}
