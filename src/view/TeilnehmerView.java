package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import teilnehmer.Person;
import teilnehmer.Teilnehmer;
import teilnehmer.Typ;

public class TeilnehmerView {
	private GridPane personLayout;
	private GridPane subPersonLayout1;
	private GridPane subPersonLayout2;

	private Label idLabel;
	private Label vornameLabel;
	private Label nachnameLabel;
	private Label zustandLabel;
	private Label anmeldungsdatumLabel;
	private Label abmeldungsdatumLabel;
	private Label teilnehmernLabel;

	private TextField idText;
	private TextField vornameText;
	private TextField nachnameText;
	private ComboBox zustandComboBox;
	private DatePicker anmeldungsdatumDatePicker;
	private DatePicker abmeldungsdatumDatePicker;
	private TableView teilnehmernTableView;

	private Button add;
	private Button del;
	private Button upd;
	private Button print;

	private Button first;
	private Button next;
	private Button previous;
	private Button last;

	public GridPane TeilnehmerGridPane() {
		// TODO: Person Style design

		inthaltbauen();
		buttonsbauen();

		subpersonLayoutsbauen();
		personLayoutsbauen();

		return personLayout;
	}

	private void buttonsbauen() {

		add = new Button("Add");
		del = new Button("Delete");
		upd = new Button("Update");

		first = new Button("First");
		next = new Button("Next");
		previous = new Button("Previous");
		last = new Button("Last");

		add.setOnAction(new EventHandler<ActionEvent>() {
			PersonVerbindung pv = new PersonVerbindung();

			@Override
			public void handle(ActionEvent arg0) {
				// Person(String vorname, String nachname, String anschrift, String typ, String
				// email,
				// int telefonnummer, LocalDate anmedungsdatum, LocalDate abmedungsdatum)
				Person p = new Person(vornameText.getText(), nachnameText.getText(), "Anschrifft",
						zustandComboBox.getValue().toString(), "Email", "Telefonnummer",
						anmeldungsdatumDatePicker.getValue(), anmeldungsdatumDatePicker.getValue());
				pv.add(p);
				vornameText.clear();
				// Update the TableView
				int slectedIndex = teilnehmernTableView.getSelectionModel().getSelectedIndex();
				fillTableWithData(teilnehmernTableView);
				//
				teilnehmernTableView.getSelectionModel().selectLast();
			}

		});
		del.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				PersonVerbindung pv = new PersonVerbindung();
				Person p = pv.getById(Integer.parseInt(idText.getText()));
				pv.delete(p);
				int slectedIndex = teilnehmernTableView.getSelectionModel().getSelectedIndex();
				fillTableWithData(teilnehmernTableView);
				// SelectedRow
				teilnehmernTableView.getSelectionModel().select(slectedIndex - 1);
			}

		});
		upd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg) {
				PersonVerbindung pv = new PersonVerbindung();
				Person p = pv.getById(Integer.parseInt(idText.getText()));
				System.out.println("********* vornameText -------------- " + vornameText.getText());
				System.out.println("anmeldungsdatumDatePicke r  " + anmeldungsdatumDatePicker.getValue());
				System.out.println("Person   " + p);
				// TODO:
				p.setVorname(vornameText.getText());
				p.setTyp(zustandComboBox.getValue().toString());
				p.setAnmeldungsdatum(anmeldungsdatumDatePicker.getValue());
				p.setAbmeldungsdatum(abmeldungsdatumDatePicker.getValue());
				System.out.println("Person update   --------------  " + p);

				pv.update(p);

				int slectedIndex = teilnehmernTableView.getSelectionModel().getSelectedIndex();
				fillTableWithData(teilnehmernTableView);
				// SelectedRow
				teilnehmernTableView.getSelectionModel().select(slectedIndex);
			}
		});

		first.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				teilnehmernTableView.getSelectionModel().selectFirst();
			}
		});
		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int index = teilnehmernTableView.getSelectionModel().getSelectedIndex();
				PersonVerbindung pv = new PersonVerbindung();
				if (index < pv.getAll().size()) {
					teilnehmernTableView.getSelectionModel().select(index + 1);
					System.out.println("index +1 : " + index);
				}
			}
		});
		previous.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int index = teilnehmernTableView.getSelectionModel().getSelectedIndex();
				if (index > 1)
					teilnehmernTableView.getSelectionModel().select(index - 1);
			}
		});
		last.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				teilnehmernTableView.getSelectionModel().selectLast();
			}
		});

	}

	private void inthaltbauen() {
		// Inthalt
		// Person
		idLabel = new Label("Identify Nummer");
		idText = new TextField();

		vornameLabel = new Label("Vorname");
		vornameText = new TextField();

		nachnameLabel = new Label("Nachname");
		nachnameText = new TextField();

		zustandLabel = new Label("Zuständigkeit");
		zustandComboBox = new ComboBox();

		zustandComboBox.getItems().addAll(Typ.DOZENT, Typ.KASSENWART, Typ.MITGLIEDER, Typ.SPORTTEILNEHMER,
				Typ.SPRACHTEINEHMER, Typ.VERTRATER, Typ.VORSITZENDER);
		zustandComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				zustandComboBox.setValue(newSelection);
			}
		});
		anmeldungsdatumLabel = new Label("Anmeldungsdatum");
		anmeldungsdatumDatePicker = new DatePicker();

		abmeldungsdatumLabel = new Label("Abmeldungsdatum");
		abmeldungsdatumDatePicker = new DatePicker();

		teilnehmernLabel = new Label("Teilnehmern");
		teilnehmernTableView = new TableView();
		fillTableWithData(teilnehmernTableView);

	}

	private void subpersonLayoutsbauen() {
		subPersonLayout1 = new GridPane();
		subPersonLayout2 = new GridPane();

		subPersonLayout1.setAlignment(Pos.BOTTOM_RIGHT);
		subPersonLayout1.setHgap(10);
		subPersonLayout1.setVgap(10);
		subPersonLayout1.setPadding(new Insets(5, 5, 5, 5));

		subPersonLayout2.setAlignment(Pos.TOP_CENTER);
		subPersonLayout2.setHgap(10);
		subPersonLayout2.setVgap(10);
		subPersonLayout2.setPadding(new Insets(5, 5, 5, 5));

		subPersonLayout2.add(add, 0, 0);
		subPersonLayout2.add(del, 1, 0);
		subPersonLayout2.add(upd, 2, 0);
		// subPersonLayout2.add(print, 3, 0);

		subPersonLayout1.add(new Label(), 1, 0);
		subPersonLayout1.add(first, 1, 1);
		subPersonLayout1.add(next, 1, 2);
		subPersonLayout1.add(previous, 1, 3);
		subPersonLayout1.add(last, 1, 4);

	}

	private void personLayoutsbauen() {
		personLayout = new GridPane();

		personLayout.setAlignment(Pos.TOP_LEFT);
		personLayout.setHgap(10);
		personLayout.setVgap(10);
		personLayout.setPadding(new Insets(20, 20, 20, 20));
		personLayout.add(idLabel, 0, 0);
		personLayout.add(idText, 1, 0);

		personLayout.add(vornameLabel, 0, 1);
		personLayout.add(vornameText, 1, 1);

		personLayout.add(nachnameLabel, 0, 2);
		personLayout.add(nachnameText, 1, 2);

		personLayout.add(zustandLabel, 0, 3);
		personLayout.add(zustandComboBox, 1, 3);

		personLayout.add(anmeldungsdatumLabel, 2, 1);
		personLayout.add(anmeldungsdatumDatePicker, 3, 1);

		personLayout.add(abmeldungsdatumLabel, 2, 2);
		personLayout.add(abmeldungsdatumDatePicker, 3, 2);

		personLayout.add(teilnehmernLabel, 0, 5);
		personLayout.add(teilnehmernTableView, 0, 6, 4, 1);

		personLayout.add(subPersonLayout2, 3, 4);
		personLayout.add(subPersonLayout1, 4, 6);

	}

	private void fillTableWithData(TableView table) {
		// defining Table Data in a List
		TableColumn idCol1 = new TableColumn("Identify Nr.");
		TableColumn vornameCol2 = new TableColumn("Vorname");
		TableColumn nachnameCol3 = new TableColumn("Nachname");
		TableColumn zustandCol4 = new TableColumn("Zuständigkeit");
		TableColumn anmeldungsdatumCol5 = new TableColumn("Anmeldungsdatum");
		TableColumn abmeldungsCol6 = new TableColumn("Abmeldungsdatum");

		table.getColumns().addAll(idCol1, vornameCol2, nachnameCol3, zustandCol4, anmeldungsdatumCol5, abmeldungsCol6);

		PersonVerbindung pv = new PersonVerbindung();
		ObservableList<Person> personenDaten = FXCollections.observableArrayList(pv.getAll());

		// setting Data properties to columns
		idCol1.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
		vornameCol2.setCellValueFactory(new PropertyValueFactory<Person, String>("vorname"));
		nachnameCol3.setCellValueFactory(new PropertyValueFactory<Person, String>("nachname"));
		zustandCol4.setCellValueFactory(new PropertyValueFactory<Person, String>("typ"));
		anmeldungsdatumCol5.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("anmeldungsdatum"));
		abmeldungsCol6.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("abmeldungsdatum"));

		table.setEditable(true);
		table.setItems(personenDaten);

		table.getSelectionModel().selectFirst();
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				Person selectedRowP = (Person) table.getSelectionModel().getSelectedItem();
				System.out.println("Selected row  on selected : " + selectedRowP);
				anzeigGewählteItem(selectedRowP);
			}
		});
		Object obj = table.getSelectionModel().getSelectedItem();

		System.out.println("Selected row at first : " + obj);
		anzeigGewählteItem((Person) obj);
	}

	private void anzeigGewählteItem(Person selectedRowP) {
		// System.out.println("**** Selected row selected : " + selectedRowP);
		// System.out.println("***" +vornameText);
		idText.setText(Integer.toString(selectedRowP.getId()));
		vornameText.setText(selectedRowP.getVorname());
		nachnameText.setText(selectedRowP.getNachname());
		zustandComboBox.setValue(selectedRowP.getTyp());
		anmeldungsdatumDatePicker.setValue(selectedRowP.getAnmeldungsdatum());
		abmeldungsdatumDatePicker.setValue(selectedRowP.getAbmeldungsdatum());
	}

	private void anzeigItem(int index, ObservableList<Person> personenDaten) {

		idText.setText(Integer.toString(personenDaten.get(index).getId()));
		vornameText.setText(personenDaten.get(index).getVorname());

	}

}
