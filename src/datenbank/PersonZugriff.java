package datenbank;

import java.util.List;

import teilnehmer.Person;


public interface PersonZugriff {
	List<Person> getAll();
	void add(Person p);
	void update(Person p);
	void delete(Person p);
	Person getById(int id);
}
