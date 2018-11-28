package view;

import java.awt.Color;
import java.time.LocalDate;
import java.util.List;

import datenbank.KursVerbindung;
import datenbank.PersonVerbindung;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import teilnehmer.Kurs;
import teilnehmer.Person;
import teilnehmer.Typ;

public class KursView  {
	private GridPane kursLayout;
	private GridPane subKursLayout1;
	private GridPane subKursLayout2;

	private Label idLabel;
	private Label kursnameLabel;
	private Label kursnummerLabel;
	private Label dozentLabel;
	private Label kursanfangsdatumLabel;
	private Label kursendedatumLabel;
	private Label kursTableLabel;

	private TextField idText;
	private TextField kursnameText;
	private TextField kursnummerText;
	private ComboBox dozentComboBox;
	private DatePicker kursanfangsdatumDatePicker;
	private DatePicker kursendedatumDatePicker;
	private TableView kursTableView;

	private Button add;
	private Button del;
	private Button upd;

	private Button first;
	private Button next;
	private Button previous;
	private Button last;

	public GridPane kursGridPane() {
		inthaltbauen();
		buttonsbauen();
		subKursLayoutsbauen();
		kursLayoutsbauen();

		return kursLayout;
	}

	private void inthaltbauen() {
		idLabel = new Label("Identify Nummer");
		System.out.print("*********************-------------- " +idLabel.getText());
		idText = new TextField();

		kursnameLabel = new Label("Kursname");
		kursnameText = new TextField();

		kursnummerLabel = new Label("Kursnummer");
		kursnummerText = new TextField();

		dozentLabel = new Label("Dozent");
		dozentComboBox = new ComboBox();
		//TODO: ruf die DOzent nur einmal auf,Verbesserung später: weniger Datenbank aufrufen
		List<Person> dozenten=new KursVerbindung().getAllDozenten();
		dozentComboBox.getItems().addAll(dozenten);
		
		dozentComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				System.out.println("Dozent New selection "+newSelection);
				//dozentComboBox.setValue(((Person)newSelection).getVorname());
				dozentComboBox.setValue(newSelection);

			}
		});
		kursanfangsdatumLabel = new Label("Kursanfagsdatum");
		kursanfangsdatumDatePicker = new DatePicker();

		kursendedatumLabel = new Label("Kursendesdatum");
		kursendedatumDatePicker = new DatePicker();

		kursTableLabel = new Label("Kursen");
		kursTableView = new TableView();
		fillTableWithData(kursTableView);


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
			KursVerbindung pv = new KursVerbindung();

			@Override
			public void handle(ActionEvent arg0) {
				// Kurs(String vorname, String nachname, String anschrift, String typ, String
				// email,
				// int telefonnummer, LocalDate anmedungsdatum, LocalDate abmedungsdatum)
				Kurs k = new Kurs(1, "ws 18/7", "Sprache", LocalDate.now(), LocalDate.now(), "", "");
				int person_id = ((Person) dozentComboBox.getValue()).getId();
				Kurs p = new Kurs(person_id, kursnummerText.getText(), kursnameText.getText(),
						kursanfangsdatumDatePicker.getValue(), kursendedatumDatePicker.getValue(), "", "");
				pv.add(p);
				// Update the TableView
				int slectedIndex = kursTableView.getSelectionModel().getSelectedIndex();
				fillTableWithData(kursTableView);
				//
				kursTableView.getSelectionModel().selectLast();
			}

		});
		del.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				KursVerbindung pv = new KursVerbindung();
				Kurs p = pv.getById(Integer.parseInt(idText.getText()));
				pv.delete(p);
				int slectedIndex = kursTableView.getSelectionModel().getSelectedIndex();
				fillTableWithData(kursTableView);
				// SelectedRow
				kursTableView.getSelectionModel().select(slectedIndex - 1);
			}

		});
		upd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg) {
				KursVerbindung pv = new KursVerbindung();
				Kurs k = pv.getById(Integer.parseInt(idText.getText()));
				//System.out.println("*********  kursnameText -------------- " + kursnameText.getText());
				//System.out.println("kursanfangsdatumDatePicker  " + kursanfangsdatumDatePicker.getValue());
				//System.out.println("Kurs   " + k);
				// TODO:
				int person_id = ((Person) dozentComboBox.getValue()).getId();

				k.setPerson_id(person_id);
				k.setKursname(kursnameText.getText());
				k.setKursnummer(kursnummerText.getText());
				k.setDozent((Person)dozentComboBox.getValue());
				k.setKursanfangsdatum(kursanfangsdatumDatePicker.getValue());
				k.setKursendedatum(kursendedatumDatePicker.getValue());
				//System.out.println("Kurs update   --------------  " + k);

				pv.update(k);

				int slectedIndex = kursTableView.getSelectionModel().getSelectedIndex();
				fillTableWithData(kursTableView);
				// SelectedRow
				kursTableView.getSelectionModel().select(slectedIndex);
			}
		});

		first.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				kursTableView.getSelectionModel().selectFirst();
			}
		});
		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int index = kursTableView.getSelectionModel().getSelectedIndex();
				KursVerbindung pv = new KursVerbindung();
				if (index < pv.getAll().size()) {
					kursTableView.getSelectionModel().select(index + 1);
					System.out.println("index +1 : " + index);
				}
			}
		});
		previous.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int index = kursTableView.getSelectionModel().getSelectedIndex();
				if (index > 1)
					kursTableView.getSelectionModel().select(index - 1);
			}
		});
		last.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				kursTableView.getSelectionModel().selectLast();
			}
		});

	}

	private void subKursLayoutsbauen() {
		subKursLayout1 = new GridPane();
		subKursLayout2 = new GridPane();

		subKursLayout1.setAlignment(Pos.BOTTOM_RIGHT);
		subKursLayout1.setHgap(10);
		subKursLayout1.setVgap(10);
		subKursLayout1.setPadding(new Insets(5, 5, 5, 5));

		subKursLayout2.setAlignment(Pos.TOP_CENTER);
		subKursLayout2.setHgap(10);
		subKursLayout2.setVgap(10);
		subKursLayout2.setPadding(new Insets(5, 5, 5, 5));

		subKursLayout2.add(add, 0, 0);
		subKursLayout2.add(del, 1, 0);
		subKursLayout2.add(upd, 2, 0);

		subKursLayout1.add(new Label(), 1, 0);
		subKursLayout1.add(first, 1, 1);
		subKursLayout1.add(next, 1, 2);
		subKursLayout1.add(previous, 1, 3);
		subKursLayout1.add(last, 1, 4);


	}

	private void kursLayoutsbauen() {
		kursLayout = new GridPane();

		kursLayout.setAlignment(Pos.TOP_LEFT);
		kursLayout.setHgap(10);
		kursLayout.setVgap(10);
		kursLayout.setPadding(new Insets(20, 20, 20, 20));
		kursLayout.add(idLabel, 0, 0);
		kursLayout.add(idText, 1, 0);

		kursLayout.add(kursnameLabel, 0, 1);
		kursLayout.add(kursnameText, 1, 1);

		kursLayout.add(kursnummerLabel, 0, 2);
		kursLayout.add(kursnummerText, 1, 2);

		kursLayout.add(dozentLabel, 0, 3);
		kursLayout.add(dozentComboBox, 1, 3);

		kursLayout.add(kursanfangsdatumLabel, 2, 1);
		kursLayout.add(kursanfangsdatumDatePicker, 3, 1);

		kursLayout.add(kursendedatumLabel, 2, 2);
		kursLayout.add(kursendedatumDatePicker, 3, 2);

		kursLayout.add(kursTableLabel, 0, 5);
		kursLayout.add(kursTableView, 0, 6, 4, 1);

		kursLayout.add(subKursLayout2, 3, 4);
		kursLayout.add(subKursLayout1, 4, 6);

	}

	private void fillTableWithData(TableView table) {
		// defining Table Data in a List
		TableColumn idCol1 = new TableColumn("Identify Nr.");
		TableColumn vornameCol2 = new TableColumn("Kursname");
		TableColumn nachnameCol3 = new TableColumn("Kursnummer");
		TableColumn zustandCol4 = new TableColumn("Dozent");
		TableColumn anmeldungsdatumCol5 = new TableColumn("Kuranfangsdatum");
		TableColumn abmeldungsCol6 = new TableColumn("Kursendedatum");

		table.getColumns().addAll(idCol1, vornameCol2, nachnameCol3, zustandCol4, anmeldungsdatumCol5, abmeldungsCol6);

		KursVerbindung pv = new KursVerbindung();
		ObservableList<Kurs> kursenDaten = FXCollections.observableArrayList(pv.getAll());

		// setting Data properties to columns
		idCol1.setCellValueFactory(new PropertyValueFactory<Kurs, String>("id"));
		vornameCol2.setCellValueFactory(new PropertyValueFactory<Kurs, String>("kursname"));
		nachnameCol3.setCellValueFactory(new PropertyValueFactory<Kurs, String>("kursnummer"));
		zustandCol4.setCellValueFactory(new PropertyValueFactory<Kurs, String>("dozentname"));
		anmeldungsdatumCol5.setCellValueFactory(new PropertyValueFactory<Kurs, LocalDate>("kursanfangsdatum"));
		abmeldungsCol6.setCellValueFactory(new PropertyValueFactory<Kurs, LocalDate>("kursendedatum"));

		table.setEditable(true);
		table.setItems(kursenDaten);

		table.getSelectionModel().selectFirst();
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				Kurs selectedRowP = (Kurs) table.getSelectionModel().getSelectedItem();
				//System.out.println("Selected row  on selected : " + selectedRowP);
				anzeigGewählteItem(selectedRowP);
			}
		});
		Object obj = table.getSelectionModel().getSelectedItem();

		//System.out.println("Selected row at first : " + obj);
		anzeigGewählteItem((Kurs) obj);
	}

	private void anzeigGewählteItem(Kurs selectedRowP) {
		//System.out.println("**** Selected row selected : " + selectedRowP);

		idText.setText(Integer.toString(selectedRowP.getId()));
		kursnameText.setText(selectedRowP.getKursname());
		kursnummerText.setText(selectedRowP.getKursnummer());
		dozentComboBox.setValue(selectedRowP.getDozent());
		kursanfangsdatumDatePicker.setValue(selectedRowP.getKursanfangsdatum());
		kursendedatumDatePicker.setValue(selectedRowP.getKursendedatum());
	}

}
