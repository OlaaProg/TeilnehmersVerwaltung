package datenbank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import teilnehmer.Dozent;
import teilnehmer.Kurs;
import teilnehmer.Person;
import teilnehmer.Typ;

public class KursVerbindung implements kursZugriff {
	private static final String VERBINDUNG = "jdbc:mysql://localhost:3306/friedenshaus_verwaltung?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORT = "";
	private static final String getAllSql = "SELECT * FROM ";
	private static final String KURS = "Kurs";

	@Override
	public List<Kurs> getAll() {
		List<Kurs> alleKursen = new ArrayList();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			//System.out.println("test die friedenshaus-Verwaltung Kurs Verbindung Erfolgreich");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(getAllSql + KURS);
			while (rs.next()) {
				Kurs k = new Kurs();
				k.setId(rs.getInt("id"));
				k.setPerson_id(rs.getInt("person_id"));
				k.setKursname(rs.getString("kursname"));
				k.setKursnummer(rs.getString("kursnummer"));
				/// TODO: Dozent_Id
				if (k.getPerson_id() != 0) {
					Person dozent = new PersonVerbindung().getById(k.getPerson_id());
					k.setDozent(dozent);
				}
				k.setKursanfangsdatum(rs.getDate("kursanfangsdatum").toLocalDate());
				k.setKursendedatum(rs.getDate("kursendedatum").toLocalDate());

				alleKursen.add(k);
			}
		} catch (SQLException e) {
			System.out.println("Zugriff passt nicht: " + e);
			e.printStackTrace();
		}
		// alleKursen.forEach(System.out::println);
		return alleKursen;
	}

	public void add(Kurs k) {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			System.out.println("test die friedenshaus-Verwaltung Kurs Verbindung: Erfolgreich");

			PreparedStatement ps = con.prepareStatement("INSERT INTO " + KURS
					+ " (kursname,kursnummer, person_id,kursanfangsdatum,kursendedatum) VALUES (?,?,?,?,?)");
			ps.setString(1, k.getKursname());
			ps.setString(2, k.getKursnummer());
			ps.setInt(3, k.getPerson_id());
			// TODO: Set Date
			ps.setDate(4, Date.valueOf(k.getKursanfangsdatum()));
			ps.setDate(5, Date.valueOf(k.getKursendedatum()));

			ps.executeUpdate();

			System.out.println("Insert a Kurs ist Ok ");
		} catch (SQLException e) {
			System.out.println("Insert ist nicht Ok: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void update(Kurs k) {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			System.out.println("test die friedenshaus-Verwaltung Kurs Verbindung: Erfolgreich");

			PreparedStatement ps = con.prepareStatement("UPDATE " + KURS
					+ " SET kursname=?,kursnummer=?, person_id=?, kursanfangsdatum=?, kursendedatum=?  WHERE id = ?");
			ps.setString(1, k.getKursname());
			ps.setString(2, k.getKursnummer());
			ps.setInt(3, k.getPerson_id());
			ps.setDate(4, Date.valueOf(k.getKursanfangsdatum()));
			ps.setDate(5, Date.valueOf(k.getKursendedatum()));
			ps.setInt(6, k.getId());

			System.out.println("test Kurs update  databank ----------------- " + ps);

			ps.executeUpdate();
			System.out.println("Update a Kurs ist Ok ");
		} catch (SQLException e) {
			System.out.println("Update ist nicht Ok: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Kurs k) {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			//System.out.println("test die friedenshaus-Verwaltung Kurs Verbindung: Erfolgreich");

			PreparedStatement ps = con.prepareStatement("DELETE FROM " + KURS + " WHERE id = ?");
			ps.setInt(1, k.getId());
			ps.executeUpdate();

			// System.out.println("Delete a Kurs ist Ok ");
		} catch (SQLException e) {
			System.out.println("Detete ist nicht Ok: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public Kurs getById(int id) {
		Kurs k = new Kurs();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			// System.out.println("test die friedenshaus-Verwaltung Get By Id Verbindung:
			// Erfolgreich");
			PreparedStatement ps = con.prepareStatement(getAllSql + KURS + " WHERE id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs != null) {
				k.setId(rs.getInt("id"));
				k.setPerson_id(rs.getInt("person_id"));
				k.setKursname(rs.getString("kursname"));
				k.setKursnummer(rs.getString("kursnummer"));
				// TODO: Dozent_Id
				if (k.getPerson_id() != 0) {
					Person dozent = new PersonVerbindung().getById(k.getPerson_id());
					k.setDozent(dozent);
				}
				k.setKursanfangsdatum(rs.getDate("kursanfangsdatum").toLocalDate());
				k.setKursendedatum(rs.getDate("kursendedatum").toLocalDate());
			}
			// System.out.println("get by Id a Kurs ist Ok " + k);
		} catch (SQLException e) {
			System.out.println("get by Id ist nicht Ok: " + e);
			e.printStackTrace();
		}
		return k;
	}

	public List<Person> getAllDozenten() {
		List<Person> alleDozente = new ArrayList();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			// System.out.println("test die friedenshaus-Verwaltung person Verbindung:
			// Erfolgreich");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(getAllSql + " person" + " WHERE typ = 'DOZENT'");
			// PreparedStatement ps = con.prepareStatement(getAllSql + KURS + " WHERE typ
			// =?");
			// Typ enumTyp;//TODO: use it toget the DOZENT
			// ps.setString(1, "DOZENT");
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setTyp(rs.getString("typ"));
				p.setAnmeldungsdatum(rs.getDate("anmeldungsdatum").toLocalDate());
				p.setAbmeldungsdatum(rs.getDate("abmeldungsdatum").toLocalDate());

				alleDozente.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Zugriff passt nicht: " + e);
			e.printStackTrace();
		}
		// alleDozente.forEach(System.out::println);
		return alleDozente;
	}

}
