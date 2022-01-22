package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Autor;
import programiranje.tamara_car.biblioteka.serialized.model.Knjiga;
import programiranje.tamara_car.biblioteka.serialized.model.Zanrovi;

public class KnjigaValidacije {
	public static Knjiga unosKnjige(Integer id,List<Autor>autori) {
		Integer idKnjige = id;
		if(idKnjige==null) {
			System.out.println("Unesite ID knjige: ");
			 idKnjige = Validacije.unosBroja(1,null);
		}
		System.out.println("Unesite naziv knjige: ");
		String nazivKnjige = Validacije.unosTeksta(1, 250);
		
		Autor autor = AutorValidacije.izborAutora(autori);
		
		Zanrovi zanr = ZanroviValidacije.odabirZanra();
		
		System.out.println("Broj knjiga u biblioteci: ");
		Integer brKnjiga = Validacije.unosBroja(1, null);
		
		return new Knjiga(idKnjige, nazivKnjige, autor, zanr, brKnjiga);
	}
	
	
	
}
