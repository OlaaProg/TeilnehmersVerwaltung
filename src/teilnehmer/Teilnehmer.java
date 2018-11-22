package teilnehmer;

import java.time.LocalDate;

public class Teilnehmer extends Person {
//Attribute
	// TODO private
	// TODO LocalDate
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public LocalDate getAnmedungsdatum() {
		return anmedungsdatum;
	}

	public void setAnmedungsdatum(LocalDate anmedungsdatum) {
		this.anmedungsdatum = anmedungsdatum;
	}

	public LocalDate getAbmedungsdatum() {
		return abmedungsdatum;
	}

	public void setAbmedungsdatum(LocalDate abmedungsdatum) {
		this.abmedungsdatum = abmedungsdatum;
	}

	public LocalDate getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(LocalDate geburtstag) {
		this.geburtstag = geburtstag;
	}

	public String getBetreuer_Vorname() {
		return betreuer_Vorname;
	}

	public void setBetreuer_Vorname(String betreuer_Vorname) {
		this.betreuer_Vorname = betreuer_Vorname;
	}

	public String getBetreuer_Nachname() {
		return betreuer_Nachname;
	}

	public void setBetreuer_Nachname(String betreuer_Nachname) {
		this.betreuer_Nachname = betreuer_Nachname;
	}

	public String getMonatenbesuchen() {
		return monatenbesuchen;
	}

	public void setMonatenbesuchen(String monatenbesuchen) {
		this.monatenbesuchen = monatenbesuchen;
	}

	public String getMonatlichbezahlung() {
		return Monatlichbezahlung;
	}

	public void setMonatlichbezahlung(String monatlichbezahlung) {
		Monatlichbezahlung = monatlichbezahlung;
	}

	public Boolean getIstUeberweisung() {
		return istUeberweisung;
	}

	public void setIstUeberweisung(Boolean istUeberweisung) {
		this.istUeberweisung = istUeberweisung;
	}

	@Override
	public String toString() {
		return "Teilnehmer [id=" + id + ", person_id=" + person_id + ", anmedungsdatum=" + anmedungsdatum
				+ ", abmedungsdatum=" + abmedungsdatum + "]";
	}
}
