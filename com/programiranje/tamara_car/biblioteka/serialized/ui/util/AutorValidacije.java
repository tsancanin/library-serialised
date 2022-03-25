package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Author;
import programiranje.tamara_car.biblioteka.serialized.model.Library;

public class AutorValidacije {

	public static Author izborAutora(List<Author> autori) {

		System.out.println("Odaberite redni broj autora: ");
		for (int i = 0; i < autori.size(); i++) {
			System.out.println(i + 1 + ". " + autori.get(i));
		}
		Integer izbor = Validation.numberEntry(1, autori.size());
		return autori.get(izbor - 1);
	}

	public static Author dodajAutora() {

		System.out.println("Unesite id: ");
		int id = Validation.numberEntry(1, null);
		
		System.out.println("Unesite ime autora: ");
		String ime = Validation.textEntry(3, null);

		System.out.println("Unesite prezime autora: ");
		String prezime = Validation.textEntry(3, null);
		Author autor = new Author(id, ime, prezime);
		return autor;
	}

}
