package datenbank;

import java.util.List;

import teilnehmer.Kurs;


public interface kursZugriff {
	List<Kurs> getAll();
	void add(Kurs k);
	void update(Kurs k);
	void delete(Kurs k);
	Kurs getById(int id);
}
