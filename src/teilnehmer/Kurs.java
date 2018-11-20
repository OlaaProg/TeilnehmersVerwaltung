package teilnehmer;

import java.time.LocalDate;
import java.util.Date;

public class Kurs {
//Attribute
	private int id;
	/**
	 * Kursnummer soll uniq sein
	 */
	private String kursnummer;	
	private String kursname;
	private LocalDate kursanfangsdatum;
	private LocalDate kursendedatum;
	private String kurszeiten;
	private String description;
	/**
	 * Beziehung: 1 Dozent to many Kures
	 * ein Kurs hat nur einem Dozent 
	 */
	private Dozent dozent;
}
