package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Autor;
import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;

public class AutorValidacije {

	public static Autor izborAutora(List<Autor> autori) {

		System.out.println("Odaberite redni broj autora: ");
		for (int i = 0; i < autori.size(); i++) {
			System.out.println(i + 1 + ". " + autori.get(i));
		}
		Integer izbor = Validacije.unosBroja(1, autori.size());
		return autori.get(izbor - 1);
	}

	public static Autor dodajAutora() {

		System.out.println("Unesite id: ");
		int id = Validacije.unosBroja(1, null);
		
		System.out.println("Unesite ime autora: ");
		String ime = Validacije.unosTeksta(3, null);

		System.out.println("Unesite prezime autora: ");
		String prezime = Validacije.unosTeksta(3, null);
		Autor autor = new Autor(id, ime, prezime);
		return autor;
	}

}
