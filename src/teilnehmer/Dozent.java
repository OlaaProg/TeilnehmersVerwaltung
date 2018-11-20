package teilnehmer;

import java.util.List;

public class Dozent extends Person {
//Attribute
	int id;
	int person_id;
	boolean istMonatlichGehaltRechnung;
	String ueberweisung;
	String bankverbindung;
	String description;
	List<Kurs> kursen;
}
