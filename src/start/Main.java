package start;

import java.time.LocalDate;

import datenbank.KursVerbindung;
import datenbank.PersonVerbindung;
import datenbank.Verbindung;
import teilnehmer.Kurs;
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
			//PersonVerbindung pv=new PersonVerbindung();
			//pv.getAll();
			//pv.add(p1);
			//pv.delete(p1);
			//pv.update(p1);
			//Person pById= pv.getById(5);
			//System.out.println("********* "+ pById);
			//pById.setVorname("Nina");
			//pById.setTyp(pById.getTyp()+LocalDate.now());
			//pv.update(pById);
			//System.out.println("********* "+ pv.getById(5).toString());
			
			KursVerbindung kv=new KursVerbindung();
			//kv.getAll();
			//System.out.println("********* get all kurses ist erfolgrich");
			//kv.getAllDozenten();
			//System.out.println("********* get all Dozenten ist erfolgrich");

			//Kurs k=new Kurs(1,"ws 18/7","Sprache",LocalDate.now(),LocalDate.now(),"","");
			//kv.add(k);
			//System.out.println("********* add einen neuen kurs");

			Kurs kUpdate=kv.getById(4);
			System.out.println("********* get by id einen neuen kurs\n " +kUpdate);
			kUpdate.setPerson_id(10);
			kUpdate.setKursname("Sprache");
			kv.update(kUpdate);
			System.out.println("********* Update by id einen neuen kurs\n " +kUpdate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
