package teilnehmer;

public class Person {
//Attribute
	// TODO: protected
	protected int id;
	protected String vorname;
	protected String nachname;
	protected String anschrift;
	protected String typ;
	protected String email;
	protected int telefonnummer;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String vorname, String typ) {
		super();
		this.vorname = vorname;
		this.typ = typ;
	}

	public Person(String vorname, String  nachname, String anschrift, String typ, String email, int telefonnummer) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.anschrift = anschrift;
		this.typ = typ;
		this.email = email;
		this.telefonnummer = telefonnummer;
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

	public int getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", anschrift=" + anschrift
				+ ", typ=" + typ + ", email=" + email + ", telefonnummer=" + telefonnummer + "]";
	}

}
