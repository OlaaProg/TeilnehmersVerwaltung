package teilnehmer;

import java.util.Date;

public class Teinehmer extends Person {
//Attribute
	int id; // did i need it in java?
	int person_id; // did i need it in java?
	Date anmedungsdatum;
	Date abmedungsdatum;
	/**
	 * Geburtstag ist gebrauchen falls den Teilnehmer kind ist
	 */
	Date geburtstag;
	/**
	 * betreuer_Vorname ist gebrauchen falls den Teilnehmer kind ist
	 */
	String betreuer_Vorname;
	/**
	 * betreuer_Nachname ist gebrauchen falls den Teilnehmer kind ist
	 */
	String betreuer_Nachname;
	/**
	 * monatenbesuchen, Teilnehmer kann den kurs am Anfang des Monat anmelden und am
	 * Ende des monate abmelden Der Teilnehmer kann die Monaten, die er will
	 * besuchen, wählen.
	 */
	String monatenbesuchen;
	String Monatlichbezahlung;
	/**
	 * istUeberweisung = true, Teilnehmer soll den kursgebuhr überweisen.
	 * istUeberweisung = false, Teilnehmer soll den kursgebuhr bargeld bezahlen.
	 */
	Boolean istUeberweisung;
}
