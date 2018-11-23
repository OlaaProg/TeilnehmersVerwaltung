package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datenbank.PersonVerbindung;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import teilnehmer.Person;
import teilnehmer.Teilnehmer;

public class TeilnehmerView {
	
	private TextField idText;
	private TextField vornameText;
	private TextField nachnameText;
	private ComboBox zustandComboBox;
	private TextField anmeldungsdatumText;
	private TextField abmeldungsdatumText ;
	private TableView teilnehmernTableView;

	private Button add;
	private Button del;
	private Button upd;

	private Button first;
	private Button next ;
	private Button previous;
	private Button last;

	
	public GridPane TeilnehmerGridPane() {
		// TODO: gitter Style design
		GridPane gitter = new GridPane();
		GridPane subgitter1 = new GridPane();
		GridPane subgitter2 = new GridPane();
		gitter.setAlignment(Pos.TOP_LEFT);
		gitter.setHgap(10);
		gitter.setVgap(10);
		gitter.setPadding(new Insets(20, 20, 20, 20));

		subgitter1.setAlignment(Pos.BOTTOM_RIGHT);
		subgitter1.setHgap(10);
		subgitter1.setVgap(10);
		subgitter1.setPadding(new Insets(5, 5, 5, 5));

		subgitter2.setAlignment(Pos.TOP_CENTER);
		subgitter2.setHgap(10);
		subgitter2.setVgap(10);
		subgitter2.setPadding(new Insets(5, 5, 5, 5));

		// Inthalt
		// Gitter
		Label idLabel = new Label("Identify Nummer");
		TextField idText = new TextField();

		Label vornameLabel = new Label("Vorname");
		TextField vornameText = new TextField();

		Label nachnameLabel = new Label("Nachname");
		TextField nachnameText = new TextField();

		Label zustandLabel = new Label("Zuständigkeit");
		ComboBox zustandComboBox = new ComboBox();

		Label anmeldungsdatumLabel = new Label("Anmeldungsdatum");
		TextField anmeldungsdatumText = new TextField();

		Label abmeldungsdatumLabel = new Label("Abmeldungsdatum");
		TextField abmeldungsdatumText = new TextField();

		Label teilnehmernLabel = new Label("Teilnehmern");
		TableView teilnehmernTableView = new TableView();
		fillTableWithData(teilnehmernTableView);
		
		Button add = new Button("Add");
		Button del = new Button("Delete");
		Button upd = new Button("Update");

		Button first = new Button("First");
		Button next = new Button("Next");
		Button previous = new Button("Previous");
		Button last = new Button("Last");

		gitter.add(idLabel, 0, 0);
		gitter.add(idText, 1, 0); 
		
		gitter.add(vornameLabel, 0, 1);
		gitter.add(vornameText, 1, 1);

		gitter.add(nachnameLabel, 0, 2);
		gitter.add(nachnameText, 1, 2);

		gitter.add(zustandLabel, 0, 3);
		gitter.add(zustandComboBox, 1, 3);

		gitter.add(anmeldungsdatumLabel, 2, 1);
		gitter.add(anmeldungsdatumText, 3, 1);

		gitter.add(abmeldungsdatumLabel, 2, 2);
		gitter.add(abmeldungsdatumText, 3, 2);
		subgitter2.add(add, 0, 0);
		subgitter2.add(del, 1, 0);
		subgitter2.add(upd, 2, 0);
		gitter.add(subgitter2, 3, 4);

		gitter.add(teilnehmernLabel, 0, 5);
		gitter.add(teilnehmernTableView, 0, 6, 4, 1);

		subgitter1.add(new Label(), 1, 0);
		subgitter1.add(first, 1, 1);
		subgitter1.add(next, 1, 2);
		subgitter1.add(previous, 1, 3);
		subgitter1.add(last, 1, 4);
		gitter.add(subgitter1, 4, 6);

		add.setOnAction(new EventHandler<ActionEvent>() {
			PersonVerbindung pv = new PersonVerbindung();

			@Override
			public void handle(ActionEvent arg0) {
				Person p = new Person(vornameText.getText(), "Tester add");
				pv.add(p);
				vornameText.clear();
				//TODO: Update the TableView
				fillTableWithData(teilnehmernTableView);
			}

		});
		
		del.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				PersonVerbindung pv = new PersonVerbindung();
				Person p = pv.getById(Integer.parseInt(idText.getText()));				
				pv.delete(p);
				fillTableWithData(teilnehmernTableView);
	
			}
			
		});
		upd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg) {
				PersonVerbindung pv = new PersonVerbindung();
				Person p = pv.getById(Integer.parseInt(idText.getText()));
				p.setVorname(vornameText.getText());
				p.setTyp(p.getTyp()+"Geändert"+LocalDate.now());
				pv.update(p);
				fillTableWithData(teilnehmernTableView);

			}
		});

		return gitter;
	}

	private void fillTableWithData(TableView table) {
		// defining Table Data in a List
		TableColumn idCol1 = new TableColumn("Identify Nr.");
		TableColumn vornameCol2 = new TableColumn("Vorname");
		TableColumn nachnameCol3 = new TableColumn("Nachname");
		TableColumn zustandCol4 = new TableColumn("Zuständigkeit");
//		TableColumn anmeldungsdatumCol5 = new TableColumn("Anmeldungsdatum");
//		TableColumn abmeldungsCol6 = new TableColumn("Abmeldungsdatum");

		table.getColumns().addAll(idCol1, vornameCol2, nachnameCol3, zustandCol4);

		PersonVerbindung pv = new PersonVerbindung();
		ObservableList<Person> personenDaten = FXCollections.observableArrayList(pv.getAll());

		// setting Data properties to columns
		idCol1.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
		vornameCol2.setCellValueFactory(new PropertyValueFactory<Person, String>("vorname"));
		nachnameCol3.setCellValueFactory(new PropertyValueFactory<Person, String>("nachname"));
		zustandCol4.setCellValueFactory(new PropertyValueFactory<Person, String>("typ"));
		table.setEditable(true);
		table.setItems(personenDaten);
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("Mouse Event" +arg0.getPickResult().getIntersectedNode().getClass());
				
			}
		});
}
		
	private void anzeigItem(int index,ObservableList<Person> personenDaten) {
		
		idText.setText(Integer.toString(personenDaten.get(index).getId()));
		vornameText.setText(personenDaten.get(index).getVorname());
		
	}
}
