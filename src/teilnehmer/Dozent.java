package teilnehmer;

import java.util.List;

public class Dozent extends Person {
//Attribute
	int id;
	int person_id;
	/**
	 * istMonatlichGehaltRechnung = true, Dozent nehmt sein Gehält monatlich.
	 * istMonatlichGehaltRechnung = false, Dozent nehmt sein Gehält am ende des Kurs.
	 */
	boolean istMonatlichGehaltRechnung;
	/**
	 * Überweisung: Den Gehalt kann mit Grund nur überweisen.
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
