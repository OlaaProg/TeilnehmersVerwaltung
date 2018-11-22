package datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import teilnehmer.Teilnehmer;

public class Verbindung implements TeilnehmerZugrif {

	private static final String VERBINDUNG = "jdbc:mysql://localhost:3306/friedenshaus_verwaltung?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORT = "";
	private static final String getAllSql = "SELECT * FROM ";
	private static final String TEILNEHMER = "Teilnehmer";
	private static final String PERSON = "Person";
	public Verbindung() throws Exception {
//		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {
//			System.out.println("test die friedenshaus-Verwaltung Verbindung: Erfolgreich");
//		} catch (Exception e) {
//			System.out.println("Zugriff passt nicht: " + e);
//		}
	}

	@Override
	public List<Teilnehmer> getAllTeilnehmer() {
		List<Teilnehmer> alleTeilnehmer = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {
			System.out.println("test die friedenshaus-Verwaltung Verbindung: Erfolgreich");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(getAllSql+TEILNEHMER);
			while (rs.next()) {
				//Teilnehmer Attribute aufrufen
				int teilnehmerId = rs.getInt("id");
				int personId= rs.getInt("person_id");
				LocalDate anmeldung=(rs.getDate("anmeldungsdatum")).toLocalDate();
				System.out.println("Date: " +anmeldung);

				//TODO: Die vererbungs Attribute von Person
				Teilnehmer teilnehmer = new Teilnehmer();
				teilnehmer.setId(teilnehmerId);
				teilnehmer.setPerson_id(personId);				
				teilnehmer.setAnmedungsdatum(anmeldung);
				alleTeilnehmer.add(teilnehmer);
			}
			
		} catch (Exception e) {
			System.out.println("Zugriff passt nicht: " + e);
			e.printStackTrace();
		}
		//test the list
		System.out.println("********Alle teilnehmer*******");
		alleTeilnehmer.forEach(System.out::println);
		return alleTeilnehmer;
	}
	public List<Teilnehmer> getAllTeilnehmerPeron() {
		List<Teilnehmer> alleTeilnehmer = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {
			System.out.println("test die friedenshaus-Verwaltung Verbindung: Erfolgreich");
			Statement stm = con.createStatement();
			String sql ="SELECT Teilnehmer.anmeldungsdatum, Person.vorname FROM Teilnehmer FULL OUTER JOIN Person ON Teilnehmer.id = Person.id" ;
			//ResultSet rs = stm.executeQuery(getAllSql + TEILNEHMER +" FULL OUTER JOIN "+ PERSON+" ON "+TEILNEHMER +".id = "+PERSON +".id");
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				//Teilnehmer Attribute aufrufen
				int teilnehmerId = rs.getInt("id");
				int personId= rs.getInt("person_id");
				//TODO: LocalDate und Date
				Date anmeldung=rs.getDate("anmeldungsdatum");
				System.out.println("Date: " +anmeldung);
				String teilnehmerVorname = rs.getString("vorname");

				//TODO: Die vererbungs Attribute von Person
				Teilnehmer teilnehmer = new Teilnehmer();
				teilnehmer.setId(teilnehmerId);
				teilnehmer.setPerson_id(personId);
				//Person Attribute aufrufen
				
//				String teilnehmerNachname = rs.getString("nachname");
//				String typ=rs.getString("typ");
				//teilnehmer.setAnmedungsdatum(anmeldung.);
				teilnehmer.setVorname(teilnehmerVorname);
//				teilnehmer.setNachname(teilnehmerNachname);
//				teilnehmer.setTyp(typ);
				alleTeilnehmer.add(teilnehmer);
			}
			
		} catch (Exception e) {
			System.out.println("Zugriff passt nicht: " + e);
			e.printStackTrace();
		}
		//test the list
		System.out.println("********Alle teilnehmer*******");
		alleTeilnehmer.forEach(System.out::println);
		return alleTeilnehmer;
	}

	@Override
	public void addTeilnehmer(Teilnehmer teilnehmer) {
		
	}

	@Override
	public void updateTeilnehmer(Teilnehmer teilnehmer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTeilnehmer(Teilnehmer teilnehmer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTeilnehmerById(int id) {
		// TODO Auto-generated method stub

	}

}
