package datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import teilnehmer.Person;

public class PersonVerbindung implements PersonZugriff {
	private static final String VERBINDUNG = "jdbc:mysql://localhost:3306/friedenshaus_verwaltung?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORT = "";
	private static final String getAllSql = "SELECT * FROM ";
	private static final String PERSON = "Person";

	@Override
	public List<Person> getAll() {
		List<Person> allePersonen=new ArrayList();
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			System.out.println("test die friedenshaus-Verwaltung person Verbindung: Erfolgreich");
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery(getAllSql+PERSON);
			while(rs.next()) {
				Person p=new Person();
				p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setTyp(rs.getString("typ"));
				allePersonen.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Zugriff passt nicht: " + e);
			e.printStackTrace();
		}
		allePersonen.forEach(System.out::println);
		return allePersonen;
	}

	@Override
	public void add(Person p) {
		try (Connection con = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);) {
			System.out.println("test die friedenshaus-Verwaltung person Verbindung: Erfolgreich");

			PreparedStatement ps = con.prepareStatement("INSERT INTO " + PERSON + " (vorname, typ) VALUES (?,?)");
			ps.setString(1, p.getVorname());
			ps.setString(2, p.getTyp());

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
			System.out.println("test die friedenshaus-Verwaltung person Verbindung: Erfolgreich");

			PreparedStatement ps = con.prepareStatement("UPDATE " + PERSON + " SET vorname=?, typ=?  WHERE id = ?");
			ps.setString(1, p.getVorname());
			ps.setString(2, p.getTyp());
			ps.setInt(3, p.getId());
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
			System.out.println("test die friedenshaus-Verwaltung Get By Id Verbindung: Erfolgreich");
			PreparedStatement ps = con.prepareStatement(getAllSql + PERSON + " WHERE id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs != null) {
				p.setVorname(rs.getString("vorname"));
				p.setTyp(rs.getString("typ"));
			}
			System.out.println("get by Id a Person ist Ok " + p);
			System.out.println(" Person by Id ist: " + p);
		} catch (SQLException e) {
			System.out.println("get by Id ist nicht Ok: " + e);
			e.printStackTrace();
		}
		return p;
	}

}
