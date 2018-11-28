package view;

import java.awt.Color;

import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import teilnehmer.Teilnehmer;

public class Layouts extends TabPane{

	private Tab personLayout = new Tab("Teilnehmer",new TeilnehmerView().TeilnehmerGridPane());
	private Tab kursLayout = new Tab("Kurs",new KursView().kursGridPane());

	public Layouts() {
		zusammenstellen();
	}

	private void zusammenstellen() {

		this.getTabs().add(personLayout);
		this.getTabs().add(kursLayout);

	}
}
