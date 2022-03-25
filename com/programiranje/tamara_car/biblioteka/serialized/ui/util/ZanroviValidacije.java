package programiranje.tamara_car.biblioteka.serialized.ui.util;

import programiranje.tamara_car.biblioteka.serialized.model.Genres;

public class ZanroviValidacije {
	
	public static Genres odabirZanra() {
		
		Genres [] zanrovi = Genres.values();
		
		System.out.println("Odaberite redni broj zanra: ");
		for (int i = 0; i < zanrovi.length; i++) {
			System.out.println(i+1+". "+zanrovi[i]);
		}
		Integer izbor = Validation.numberEntry(1,zanrovi.length);
		return zanrovi[izbor-1];
	}
	
}
