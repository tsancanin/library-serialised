package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Author;
import programiranje.tamara_car.biblioteka.serialized.model.Book;
import programiranje.tamara_car.biblioteka.serialized.model.Genres;

public class KnjigaValidacije {
	public static Book unosKnjige(Integer id,List<Author>autori) {
		Integer idKnjige = id;
		if(idKnjige==null) {
			System.out.println("Unesite ID knjige: ");
			 idKnjige = Validation.numberEntry(1,null);
		}
		System.out.println("Unesite naziv knjige: ");
		String nazivKnjige = Validation.textEntry(1, 250);
		
		Author autor = AutorValidacije.izborAutora(autori);
		
		Genres zanr = ZanroviValidacije.odabirZanra();
		
		System.out.println("Broj knjiga u biblioteci: ");
		Integer brKnjiga = Validation.numberEntry(1, null);
		
		return new Book(idKnjige, nazivKnjige, autor, zanr, brKnjiga);
	}
	
	
	
}
