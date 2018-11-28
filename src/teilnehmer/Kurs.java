package teilnehmer;

import java.time.LocalDate;
import java.util.Date;

public class Kurs {
//Attribute
	private int id;
	private int person_id;
	/**
	 * Kursnummer soll uniq sein
	 */
	private String kursnummer;
	private String kursname;
	private LocalDate kursanfangsdatum;
	private LocalDate kursendedatum;
	private String kurszeiten;
	private String description;
	private String dozentname;
	/**
	 * Beziehung: 1 Dozent to many Kures ein Kurs hat nur einem Dozent
	 */
	private Person dozent;

	public Kurs() {

	}
	public Kurs( int person_id, String kursnummer, String kursname, LocalDate kursanfangsdatum,
			LocalDate kursendedatum, String kurszeiten, String description) {
		super();
		this.person_id = person_id;
		this.kursnummer = kursnummer;
		this.kursname = kursname;
		this.kursanfangsdatum = kursanfangsdatum;
		this.kursendedatum = kursendedatum;
		this.kurszeiten = kurszeiten;
		this.description = description;
	}

	public Kurs(int id, int person_id, String kursnummer, String kursname, LocalDate kursanfangsdatum,
			LocalDate kursendedatum, String kurszeiten, String description, Person dozent) {
		super();
		this.id = id;
		this.person_id = person_id;
		this.kursnummer = kursnummer;
		this.kursname = kursname;
		this.kursanfangsdatum = kursanfangsdatum;
		this.kursendedatum = kursendedatum;
		this.kurszeiten = kurszeiten;
		this.description = description;
		this.dozent = dozent;
	}

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

	public String getKursnummer() {
		return kursnummer;
	}

	public void setKursnummer(String kursnummer) {
		this.kursnummer = kursnummer;
	}

	public String getKursname() {
		return kursname;
	}

	public void setKursname(String kursname) {
		this.kursname = kursname;
	}

	public LocalDate getKursanfangsdatum() {
		return kursanfangsdatum;
	}

	public void setKursanfangsdatum(LocalDate kursanfangsdatum) {
		this.kursanfangsdatum = kursanfangsdatum;
	}

	public LocalDate getKursendedatum() {
		return kursendedatum;
	}

	public void setKursendedatum(LocalDate kursendedatum) {
		this.kursendedatum = kursendedatum;
	}

	public String getKurszeiten() {
		return kurszeiten;
	}

	public void setKurszeiten(String kurszeiten) {
		this.kurszeiten = kurszeiten;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Person getDozent() {
		return dozent;
	}

	public void setDozent(Person dozent) {
		this.dozent = dozent;
	}

	public String getDozentname() {
		return getDozent().getVorname();
	}
	public void setDozentname(String dozentname) {
		this.dozentname = dozentname;
	}
	@Override
	public String toString() {

		return "Kurs [id=" + id + ", kursnummer=" + kursnummer + ", kursname=" + kursname + ", kursanfangsdatum="
				+ kursanfangsdatum + ", kursendedatum=" + kursendedatum + ", kurszeiten=" + kurszeiten
				+ ", description=" + description + ", dozent=" + dozent + "]";
	}
}
