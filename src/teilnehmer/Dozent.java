package teilnehmer;

import java.util.List;

public class Dozent extends Person {
//Attribute
	private int id;
	private int person_id;
	/**
	 * istMonatlichGehaltRechnung = true, Dozent nehmt sein Geh�lt monatlich.
	 * istMonatlichGehaltRechnung = false, Dozent nehmt sein Geh�lt am ende des Kurs.
	 */
	private boolean istMonatlichGehaltRechnung;
	/**
	 * �berweisung: Den Gehalt kann mit Grund nur �berweisen.
	 */
	private String ueberweisung;
	/**
	 * ISBN
	 */
	private String bankverbindung;
	private String description;
	/**
	 *  Beziehung: 1 Dozent to many Kures
	 * Den Dozent kann viele Kursen Bieten
	 */
	private List<Kurs> kursen;
}
