package teilnehmer;

import java.time.LocalDate;

public class Teinehmer extends Person {
//Attribute
	//TODO private
	//TODO LocalDate
	private int id; 
	private int person_id; 
	private LocalDate anmedungsdatum;
	private LocalDate abmedungsdatum;
	/**
	 * Geburtstag ist gebrauchen falls den Teilnehmer kind ist
	 */
	private LocalDate geburtstag;
	/**
	 * betreuer_Vorname ist gebrauchen falls den Teilnehmer kind ist
	 */
	private String betreuer_Vorname;
	/**
	 * betreuer_Nachname ist gebrauchen falls den Teilnehmer kind ist
	 */
	private String betreuer_Nachname;
	/**
	 * monatenbesuchen, Teilnehmer kann den kurs am Anfang des Monat anmelden und am
	 * Ende des monate abmelden Der Teilnehmer kann die Monaten, die er will
	 * besuchen, wählen.
	 */
	private String monatenbesuchen;
	private String Monatlichbezahlung;
	/**
	 * istUeberweisung = true, Teilnehmer soll den kursgebuhr überweisen.
	 * istUeberweisung = false, Teilnehmer soll den kursgebuhr bargeld bezahlen.
	 */
	private Boolean istUeberweisung;
}
