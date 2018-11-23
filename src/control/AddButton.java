package control;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import teilnehmer.Person;

public class AddButton extends Button {

	public AddButton(List<Person> data, Person person) {
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Person p = new Person();
				data.add(person);

			}

		});
	}
}
