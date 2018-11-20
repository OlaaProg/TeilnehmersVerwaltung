package datenbank;

import java.sql.Connection;
import java.sql.DriverManager;

public class Verbindung {

	public Verbindung() throws Exception {
		String verbindung = "jdbc:mysql://localhost:3306/friedenshaus_verwaltung";
		Connection con = DriverManager.getConnection(verbindung, "root", "");
	}

}
