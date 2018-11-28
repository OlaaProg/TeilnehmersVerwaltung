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

import teilnehmer.Person;

public class PersonVerbindung implements PersonZugriff {
	//private static final String VERBINDUNG = "jdbc:mysql://localhost:3306/friedenshaus_verwaltung?serverTimezone=UTC";
	private static final String VERBINDUNG = "jdbc:mysql://192.168.2.116:3306/friedenshaus_verwaltung?serverTimezone=UTC";

	private static final String USER = "Olaa";
	private static final String PASSWORT = "olaa";
	private static final String getAllSql = "SELECT * FROM ";
	private static final String PERSON = "Person";

	@Override
	public List<Person> getAll() {
		List<Person> allePersonen = new ArrayList();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			// System.out.println("test die friedenshaus-Verwaltung person Verbindung:
			// Erfolgreich");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(getAllSql + PERSON);
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setTyp(rs.getString("typ"));
				p.setAnmeldungsdatum(rs.getDate("anmeldungsdatum").toLocalDate());
				p.setAbmeldungsdatum(rs.getDate("abmeldungsdatum").toLocalDate());

				allePersonen.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Zugriff passt nicht: " + e);
			e.printStackTrace();
		}
		//allePersonen.forEach(System.out::println);
		return allePersonen;
	}

	@Override
	public void add(Person p) {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			System.out.println("test die friedenshaus-Verwaltung person Verbindung: Erfolgreich");

			PreparedStatement ps = con.prepareStatement("INSERT INTO " + PERSON
					+ " (vorname,nachname, typ,anmeldungsdatum,abmeldungsdatum) VALUES (?,?,?,?,?)");
			ps.setString(1, p.getVorname());
			ps.setString(2, p.getNachname());
			ps.setString(3, p.getTyp());
			// TODO: Set Date
			System.out.println("P: " + p.getAnmeldungsdatum());
			ps.setDate(4, Date.valueOf(p.getAnmeldungsdatum()));
			ps.setDate(5, Date.valueOf(p.getAbmeldungsdatum()));

			ps.executeUpdate();

			System.out.println("Insert a Person ist Ok ");
		} catch (SQLException e) {
			System.out.println("Insert ist nicht Ok: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void update(Person p) {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			// System.out.println("test die friedenshaus-Verwaltung person Verbindung:
			// Erfolgreich");

			PreparedStatement ps = con.prepareStatement(
					"UPDATE " + PERSON + " SET vorname=?, typ=?, anmeldungsdatum=?, abmeldungsdatum=?  WHERE id = ?");
			ps.setString(1, p.getVorname());
			ps.setString(2, p.getTyp());
			ps.setDate(3, Date.valueOf(p.getAnmeldungsdatum()));
			ps.setDate(4, Date.valueOf(p.getAbmeldungsdatum()));
			ps.setInt(5, p.getId());

			System.out.println("test Person update  databank ----------------- " + ps);

			ps.executeUpdate();
			System.out.println("Update a Person ist Ok ");
		} catch (SQLException e) {
			System.out.println("Update ist nicht Ok: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			System.out.println("test die friedenshaus-Verwaltung person Verbindung: Erfolgreich");

			PreparedStatement ps = con.prepareStatement("DELETE FROM " + PERSON + " WHERE id = ?");
			ps.setInt(1, p.getId());
			ps.executeUpdate();

			System.out.println("Delete a Person ist Ok ");
		} catch (SQLException e) {
			System.out.println("Detete ist nicht Ok: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public Person getById(int id) {
		Person p = new Person();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			// System.out.println("test die friedenshaus-Verwaltung Get By Id Verbindung:
			// Erfolgreich");
			PreparedStatement ps = con.prepareStatement(getAllSql + PERSON + " WHERE id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs != null) {
				p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("Nachname"));
				p.setTyp(rs.getString("typ"));
				p.setAnmeldungsdatum(rs.getDate("anmeldungsdatum").toLocalDate());
				p.setAbmeldungsdatum(rs.getDate("abmeldungsdatum").toLocalDate());
			}
			// System.out.println("get by Id a Person ist Ok " + p);
			// System.out.println(" Person by Id ist: " + p);
		} catch (SQLException e) {
			System.out.println("get by Id ist nicht Ok: " + e);
			e.printStackTrace();
		}
		return p;
	}

	

}
