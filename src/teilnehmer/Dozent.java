package teilnehmer;

import java.util.List;

public class Dozent extends Person {
//Attribute
	private int id;
	private int person_id;
	/**
	 * istMonatlichGehaltRechnung = true, Dozent nehmt sein Gehält monatlich.
	 * istMonatlichGehaltRechnung = false, Dozent nehmt sein Gehält am ende des Kurs.
	 */
	private boolean istMonatlichGehaltRechnung;
	/**
	 * Überweisung: Den Gehalt kann mit Grund nur überweisen.
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
