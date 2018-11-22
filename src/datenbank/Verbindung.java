package datenbank;

import java.sql.Connection;
import java.sql.DriverManager;

public class Verbindung {

	private static final String VERBINDUNG = "jdbc:mysql://localhost:3306/friedenshaus_verwaltung?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORT = "";
	
	public Verbindung() throws Exception {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {			
			System.out.println("test die friedenshaus-Verwaltung Verbindung: Erfolgreich");
		} catch (Exception e) {
			System.out.println("Zugriff passt nicht: " +e);
			e.printStackTrace();
		}
	}

}
