package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import programiranje.tamara_car.biblioteka.serialized.model.Autor;
import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.ui.util.AutorValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class AutorMeni {
	public static Scanner in = new Scanner(System.in);

	public static void autorMeni(Biblioteka biblioteka) {

		while (true) {
			System.out.println("-----Autor meni------");
			System.out.println("1.Ispis svih autora: ");
			System.out.println("2.Dodaj novog autora: ");
			System.out.println("3.Obrisi autora: ");
			System.out.println("4.Pretraga autora po imenu i prezimenu: "); 
			System.out.println("5.Pretraga autora po ID u: ");
			System.out.println(" X - izlaz ");

			Integer opcija = Validacije.unosBroja(1, 5);

			if (opcija == null) {
				return;
			}

			switch (opcija) {
			case 1:
				ispisSvihAutora(biblioteka);
				break;
			case 2:
				dodajAutora(biblioteka);
				break;
			case 3:
				obrisiAutora(biblioteka);
				break;
			case 4: {
				List<Autor> trazeni = pretragaPoImenuIprezimenu(biblioteka.getAutori());
				if (trazeni.size() > 0) {
					for (Autor autor : trazeni) {
						System.out.println(autor);
					}
				} else {
					System.out.println("Ne postoji autor sa unetim tekstom.");
				}
				break;
			}
			case 5: {
				Autor trazeni = pretragaPoIDu(biblioteka.getAutori());
				if (trazeni != null) {
					System.out.println(trazeni);
				} else {
					System.out.println("Ne postoji autor sa trazenim ID-em.");
				}
				break;
			}
		  }
	   }
	}

	public static void ispisSvihAutora(Biblioteka biblioteka) {
		System.out.println("Spisak autora: ");
		for (Autor autor : biblioteka.getAutori()) {
			System.out.println(autor);
		}
	}

	public static void dodajAutora(Biblioteka biblioteka) {
		// ucitaj sve o autoru sa tastature
		Autor autor = AutorValidacije.dodajAutora();
		do {
			// pretpostavi da je trenutni id ok
			boolean nadjen = false;

			// prodji kroz sve autore
			for (Autor trenutni : biblioteka.getAutori()) {
				// ako je id zapravo zauzet, zapamti to u "nadjen"
				nadjen = trenutni.getId() == autor.getId();
				if (nadjen)
					break;
			}

			if (nadjen) {
				// ako je id nadjen (zauzet), unesi novi id, i setuj ga autoru koga je korisnik
				// vec uneo
				// ovo izbegava scenario da mora ponovo da unosi celog autora
				System.out.println("Id je zauzet. Unesite novi id");
				Integer noviId = Validacije.unosBroja(1, null);

				autor.setId(noviId);
				// u if grani nema break, sto znaci da ces se wratiti u do-while
			} else {
				// ako id nije nadjen (slobodan je) izadji iz celog ovog do-while-a
				break;
			}
		} while (true);// radi dokle god id nije tacan

		// ovde sigurno imas valjanog autora sa dobrim id-em, pa mozes bezbedno da ga
		// dodas
		biblioteka.getAutori().add(autor);
		System.out.println("Autor je uspesno dodat!");

	}

	public static void obrisiAutora(Biblioteka biblioteka) {
		System.out.println("Unesite id autora:");
		int id = Validacije.unosBroja(1, null);

		boolean nadjen = false;
		for (Autor zaBrisanje : biblioteka.getAutori()) {
			if (zaBrisanje.getId() == id) {
				biblioteka.getAutori().remove(zaBrisanje);
				System.out.println("autor je obrisan.");
				return;
			}
			
		}
		if (!nadjen) {
			System.out.println("Autor nije pronadjen");
		}
	}

	public static List<Autor> pretragaPoImenuIprezimenu(List<Autor> autori) {
		System.out.println("Unesite tekst za pretragu: ");
		String unos = Validacije.unosTeksta(3, null);

		List<Autor> nova = new ArrayList<Autor>();
		for (Autor autor : autori) {
			if (autor.getIme().contains(unos) || autor.getPrezime().contains(unos)) {
				nova.add(autor);
			}
		}
		return nova;

	}

	public static Autor pretragaPoIDu(List<Autor> autori) {
		System.out.println("Unesite id: ");
		int id = Validacije.unosBroja(1, null);

		for (Autor autor : autori) {
			if (autor.getId() == id) {
				return autor;
			}
		}

		return null;

	}

}
