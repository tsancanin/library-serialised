package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import programiranje.tamara_car.biblioteka.serialized.model.Author;
import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.ui.util.AutorValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class AuthorMenu {
	public static Scanner in = new Scanner(System.in);

	public static void autorMeni(Library library) {

		while (true) {
			System.out.println("-----Author menu------");
			System.out.println("1.List all authors: ");
			System.out.println("2.Add new author: ");
			System.out.println("3.Obrisi autora: ");
			System.out.println("4.Search by name and surname: "); 
			System.out.println("5.Search by ID: ");
			System.out.println(" X - exit ");

			Integer option = Validation.numberEntry(1, 5);

			if (option == null) {
				return;
			}

			switch (option) {
			case 1:
				listAllAuthor(library);
				break;
			case 2:
				dodajAutora(library);
				break;
			case 3:
				obrisiAutora(library);
				break;
			case 4: {
				List<Author> trazeni = pretragaPoImenuIprezimenu(library.getAuthor());
				if (trazeni.size() > 0) {
					for (Author autor : trazeni) {
						System.out.println(autor);
					}
				} else {
					System.out.println("Ne postoji autor sa unetim tekstom.");
				}
				break;
			}
			case 5: {
				Author trazeni = pretragaPoIDu(library.getAuthor());
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

	public static void listAllAuthor(Library library) {
		System.out.println("List of Autors: ");
		for (Author author : library.getAuthor()) {
			System.out.println(author);
		}
	}

	public static void dodajAutora(Library biblioteka) {
		// ucitaj sve o autoru sa tastature
		Author autor = AutorValidacije.dodajAutora();
		do {
			// pretpostavi da je trenutni id ok
			boolean nadjen = false;

			// prodji kroz sve autore
			for (Author trenutni : biblioteka.getAuthor()) {
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
				Integer noviId = Validation.numberEntry(1, null);

				autor.setId(noviId);
				// u if grani nema break, sto znaci da ces se wratiti u do-while
			} else {
				// ako id nije nadjen (slobodan je) izadji iz celog ovog do-while-a
				break;
			}
		} while (true);// radi dokle god id nije tacan

		// ovde sigurno imas valjanog autora sa dobrim id-em, pa mozes bezbedno da ga
		// dodas
		biblioteka.getAuthor().add(autor);
		System.out.println("Autor je uspesno dodat!");

	}

	public static void obrisiAutora(Library biblioteka) {
		System.out.println("Unesite id autora:");
		int id = Validation.numberEntry(1, null);

		boolean nadjen = false;
		for (Author zaBrisanje : biblioteka.getAuthor()) {
			if (zaBrisanje.getId() == id) {
				biblioteka.getAuthor().remove(zaBrisanje);
				System.out.println("autor je obrisan.");
				return;
			}
			
		}
		if (!nadjen) {
			System.out.println("Autor nije pronadjen");
		}
	}

	public static List<Author> pretragaPoImenuIprezimenu(List<Author> autori) {
		System.out.println("Unesite tekst za pretragu: ");
		String unos = Validation.textEntry(3, null);

		List<Author> nova = new ArrayList<Author>();
		for (Author autor : autori) {
			if (autor.getName().contains(unos) || autor.getSurname().contains(unos)) {
				nova.add(autor);
			}
		}
		return nova;

	}

	public static Author pretragaPoIDu(List<Author> autori) {
		System.out.println("Unesite id: ");
		int id = Validation.numberEntry(1, null);

		for (Author autor : autori) {
			if (autor.getId() == id) {
				return autor;
			}
		}

		return null;

	}

}
