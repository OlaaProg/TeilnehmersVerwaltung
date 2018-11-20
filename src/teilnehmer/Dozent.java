package teilnehmer;

import java.util.List;

public class Dozent extends Person {
//Attribute
	int id;
	int person_id;
	/**
	 * istMonatlichGehaltRechnung = true, Dozent nehmt sein Geh�lt monatlich.
	 * istMonatlichGehaltRechnung = false, Dozent nehmt sein Geh�lt am ende des Kurs.
	 */
	boolean istMonatlichGehaltRechnung;
	/**
	 * �berweisung: Den Gehalt kann mit Grund nur �berweisen.
	 */
	String ueberweisung;
	/**
	 * ISBN
	 */
	String bankverbindung;
	String description;
	/**
	 * Den Dozent kann viele Kursen Bieten
	 */
	List<Kurs> kursen;
}
