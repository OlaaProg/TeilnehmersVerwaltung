package start;

import java.time.LocalDate;

import datenbank.PersonVerbindung;
import datenbank.Verbindung;
import teilnehmer.Person;
import teilnehmer.Typ;

public class Main {

	public static void main(String[] args) {
		
		try {
			// Test die Person Verbindung
			//Verbindung verbindung = new Verbindung();
			//verbindung.getAllTeilnehmer();
			//test Person:
//			Person p1=new Person();
			//p1.setId(5);
//			p1.setVorname("mika");
//			p1.setTyp(Typ.VORSITZENDER.toString());
			PersonVerbindung pv=new PersonVerbindung();
			//pv.getAll();
			//pv.add(p1);
			//pv.delete(p1);
			//pv.update(p1);
			Person pById= pv.getById(5);
			System.out.println("********* "+ pById);
			pById.setVorname("Nina");
			pById.setTyp(pById.getTyp()+LocalDate.now());
			pv.update(pById);
			System.out.println("********* "+ pv.getById(5).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
