package start;

import datenbank.Verbindung;

public class Main {

	public static void main(String[] args) {
		// Test die Verbindung
		try {
			Verbindung verbindung = new Verbindung();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
