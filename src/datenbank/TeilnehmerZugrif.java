package datenbank;

import java.util.List;

import teilnehmer.Teilnehmer;

public interface TeilnehmerZugrif {
	//TODO Teilnehmerzugriffen testen
	List<Teilnehmer> getAllTeilnehmer();
	void addTeilnehmer(Teilnehmer teilnehmer);
	void updateTeilnehmer(Teilnehmer teilnehmer);
	void deleteTeilnehmer(Teilnehmer teilnehmer);
	void getTeilnehmerById(int id);
}
