package start;

import datenbank.PersonVerbindung;
import datenbank.Verbindung;
import teilnehmer.Person;

public class Main {

	public static void main(String[] args) {
		// Test die Verbindung
		try {
			//Verbindung verbindung = new Verbindung();
			//verbindung.getAllTeilnehmer();
			//test Person:
			Person p1=new Person();
			p1.setId(5);
			p1.setVorname("mika");
			p1.setTyp("Katze");
			PersonVerbindung pv=new PersonVerbindung();
			pv.getAll();
			//pv.add(p1);
			//pv.delete(p1);
			//pv.update(p1);
			Person pById= pv.getById(4);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
