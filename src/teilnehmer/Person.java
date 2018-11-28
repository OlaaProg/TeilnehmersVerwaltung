package teilnehmer;

import java.time.LocalDate;

public class Person {
//Attribute
	// TODO: protected
	protected int id;
	protected String vorname;
	protected String nachname;
	protected String anschrift;
	protected String typ;
	protected String email;
	protected String telefonnummer;
	private LocalDate anmeldungsdatum;
	private LocalDate abmeldungsdatum;

	public Person() {
		super();

	}

	public Person(String vorname, String typ) {
		super();
		this.vorname = vorname;
		this.typ = typ;
	}

	public Person(String vorname, String nachname, String anschrift, String typ, String email, String telefonnummer) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.anschrift = anschrift;
		this.typ = typ;
		this.email = email;
		this.telefonnummer = telefonnummer;
	}

	public Person(String vorname, String nachname, String anschrift, String typ, String email, String telefonnummer,
			LocalDate anmedungsdatum, LocalDate abmedungsdatum) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.anschrift = anschrift;
		this.typ = typ;
		this.email = email;
		this.telefonnummer = telefonnummer;
		this.anmeldungsdatum = anmedungsdatum;
		this.abmeldungsdatum = abmedungsdatum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getAnschrift() {
		return anschrift;
	}

	public void setAnschrift(String anschrift) {
		this.anschrift = anschrift;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public LocalDate getAnmeldungsdatum() {
		return anmeldungsdatum;
	}

	public void setAnmeldungsdatum(LocalDate anmeldungsdatum) {
		this.anmeldungsdatum = anmeldungsdatum;
	}

	public LocalDate getAbmeldungsdatum() {
		return abmeldungsdatum;
	}

	public void setAbmeldungsdatum(LocalDate abmeldungsdatum) {
		this.abmeldungsdatum = abmeldungsdatum;
	}

	@Override
	public String toString() {
		return "Id: "+ id +" "+ vorname+ " " +nachname;
//		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", anschrift=" + anschrift
//				+ ", typ=" + typ + ", email=" + email + ", telefonnummer=" + telefonnummer + ", anmedungsdatum="
//				+ anmeldungsdatum + ", abmedungsdatum=" + abmeldungsdatum + "]";
	}

}
