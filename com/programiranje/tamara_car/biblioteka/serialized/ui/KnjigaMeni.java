package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import programiranje.tamara_car.biblioteka.serialized.model.Author;
import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Book;
import programiranje.tamara_car.biblioteka.serialized.model.Genres;
import programiranje.tamara_car.biblioteka.serialized.ui.util.AutorValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.KnjigaValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;
import programiranje.tamara_car.biblioteka.serialized.ui.util.ZanroviValidacije;

public class KnjigaMeni {

	public static Scanner in = new Scanner(System.in);

	public static void knjigeMeni(Library biblioteka) {

		while (true) {

			System.out.println("---Knjige meni---");
			System.out.println("1.Ispisi sve knjige: ");
			System.out.println("2.Dodaj knjigu: ");
			System.out.println("3.Obrisi knjigu: ");
			System.out.println("4.Izmeni naziv knjige: ");
			System.out.println("5.Izmeni broj kopija: ");
			System.out.println("6.Izmeni zanr: ");
			System.out.println("7.Izmeni autora: ");
			System.out.println("8.Pretraga knjige po id-u: ");
			System.out.println("9.Knjige po nazivu: ");
			System.out.println("10.Knjige po zanru: ");
			System.out.println("11.Knjige po autoru: ");
			System.out.println(" X izlaz ");

			Integer opcija = Validation.numberEntry(1, 11);

			if (opcija == null) {
				return;
			}

			switch (opcija) {
			case 1:
				ispisiSveKnjige(biblioteka.getListOfBooks());
				break;
			case 2:
				dodajKnjigu(biblioteka);
				break;
			case 3:
				obrisiKnjigu(biblioteka);
				break;
			case 4:
				izmeniNazivKnjige(biblioteka);
				break;
			case 5:
				izmeniBrojKopija(biblioteka);
				break;
			case 6:
				izmeniZanr(biblioteka);
				break;
			case 7:
				izmeniAutora(biblioteka);
				break;
			case 8: {

				Book knjiga = pretragaPoIdu(biblioteka.getListOfBooks());
				if (knjiga == null) {
					System.out.println("Trazena knjiga ne postoji.");
				} else {
					System.out.println(knjiga);
				}
				break;
			}
			case 9: {
				List<Book> trazeneKnjige = pretragaPoNazivu(biblioteka.getListOfBooks());
				if (trazeneKnjige.isEmpty()) {
					System.out.println("Trazene knjige ne postoje.");
				} else {
					System.out.println(trazeneKnjige);
				}
				break;
			}
			case 10: {
				List<Book> trazeneKnjige = pretragaPoZanru(biblioteka.getListOfBooks());
				if (trazeneKnjige.isEmpty()) {
					System.out.println("Trazene knjige ne postoje.");
				} else {
					System.out.println(trazeneKnjige);
				}
				break;
			}
			case 11: {
				List<Book> trazeneKnjige = pretragaPoAutoru(biblioteka.getListOfBooks(), biblioteka.getAutori());
				if (trazeneKnjige.isEmpty()) {
					System.out.println("Trazene knjige ne postoje.");
				} else {
					System.out.println(trazeneKnjige);
				}
				break;
			}
			}

		}

	}

	public static void ispisiSveKnjige(List<Book> knjige) {
		for (int i = 0; i < knjige.size(); i++) {
			System.out.println(i + 1 + ". " + knjige.get(i));
		}
	}

	public static void dodajKnjigu(Library biblioteka) {

		Book knjiga = KnjigaValidacije.unosKnjige(null, biblioteka.getAutori());// ui
		dodavanjeKnjige(biblioteka.getSveKnjige(), knjiga);
		System.out.println("Knjiga je uspesno dodata.");// ui

	}

	public static void obrisiKnjigu(Library biblioteka) {
		Book odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListOfBooks(),biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		uklanjanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		
		System.out.println("Knjiga je uspesno obrisana.");
	}
	
	public static void uklanjanjeKnjige(HashMap<Genres, HashMap<Author, ArrayList<Book>>> sveKnjige, Book odabranaKnjiga) {
		
		HashMap<Author, ArrayList<Book>> autoriUzanru = sveKnjige.get(odabranaKnjiga.getZanr());
		ArrayList<Book> knjigeAutora = autoriUzanru.get(odabranaKnjiga.getAutor());
			
		knjigeAutora.remove(odabranaKnjiga);
			
		if (knjigeAutora.isEmpty()) {
			autoriUzanru.remove(odabranaKnjiga.getAutor());
		}
		if (autoriUzanru.isEmpty()) {
			sveKnjige.remove(odabranaKnjiga.getZanr());
		}
	}
	
	public static void dodavanjeKnjige(HashMap<Genres, HashMap<Author, ArrayList<Book>>> sveKnjige, Book odabranaKnjiga) {
		
		if (!sveKnjige.containsKey(odabranaKnjiga.getZanr())) {
			HashMap<Author, ArrayList<Book>> noviAutori = new HashMap<Author, ArrayList<Book>>();
			sveKnjige.put(odabranaKnjiga.getZanr(), noviAutori);
		}
		
		HashMap<Author, ArrayList<Book>> autoriIzZanra = sveKnjige.get(odabranaKnjiga.getZanr());
		
		if (!autoriIzZanra.containsKey(odabranaKnjiga.getAutor())) {
			autoriIzZanra.put(odabranaKnjiga.getAutor(), new ArrayList<Book>());
		}
		
		ArrayList<Book> knjigeTogAutora = autoriIzZanra.get(odabranaKnjiga.getAutor());
		knjigeTogAutora.add(odabranaKnjiga);

	}

	public static void izmeniNazivKnjige(Library biblioteka) {
		Book odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListOfBooks(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}

		System.out.println("Unesite novi naziv knjige: ");
		String noviNaziv = Validation.textEntry(3, null);
		odabranaKnjiga.setNaziv(noviNaziv);
		System.out.println("Naziv je uspesno izmenjen.");
	}

	public static void izmeniBrojKopija(Library biblioteka) {
		Book odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListOfBooks(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		System.out.println("Unesite novi broj kopija knjige: ");
		Integer brojKnjiga = Validation.numberEntry(1, null);
		odabranaKnjiga.setBrojKnjiga(brojKnjiga);
		System.out.println("Broj kopija je uspesno izmenjen.");

		
	}

	public static void izmeniZanr(Library biblioteka) {
		Book odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListOfBooks(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		Genres noviZanr = ZanroviValidacije.odabirZanra();
		uklanjanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		odabranaKnjiga.setZanr(noviZanr);
		dodavanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		
	}

	public static void izmeniAutora(Library biblioteka) {
		Book odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListOfBooks(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		Author noviAutor = AutorValidacije.izborAutora(biblioteka.getAutori());
		uklanjanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		odabranaKnjiga.setAutor(noviAutor);
		dodavanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);

		
	}

	public static Book pretragaPoIdu(List<Book> knjige) {
		System.out.println("Unesite ID knjige:");
		Integer id = Validation.numberEntry(1, null);
		for (Book knjiga : knjige) {
			if (knjiga.getIdKnjige() == id) {
				return knjiga;
			}
		}

		return null;
	}

	public static List<Book> pretragaPoNazivu(List<Book> knjige) {
		System.out.println("Unesite naziv knjige: ");
		String naziv = Validation.textEntry(3, null);

		ArrayList<Book> trazeneKnjige = new ArrayList<Book>();
		for (Book knjiga : knjige) {
			if (knjiga.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
				trazeneKnjige.add(knjiga);

			}

		}
		return trazeneKnjige;
	}

	public static List<Book> pretragaPoZanru(List<Book> knjige) {
		Genres odabrani = ZanroviValidacije.odabirZanra();// ui

		// servisni sloj
		ArrayList<Book> trazeneKnjige = new ArrayList<Book>();
		for (Book knjiga : knjige) {
			if (knjiga.getZanr().equals(odabrani)) {
				trazeneKnjige.add(knjiga);
			}
		}

		return trazeneKnjige;

//		// ui
//		if (trazeneKnjige.size() < 1) {
//			System.out.println("Nema knjiga trazenog zanra");
//			return null;
//		}

	}

	public static List<Book> pretragaPoAutoru(List<Book> knjige, List<Author> autori) {
		Author odabraniAutor = AutorValidacije.izborAutora(autori);

		ArrayList<Book> trazeneKnjige = new ArrayList<Book>();

		for (Book knjiga : knjige) {
			if (knjiga.getAutor().getId() == odabraniAutor.getId()) {
				trazeneKnjige.add(knjiga);
			}
		}
		return trazeneKnjige;

	}

	public static Book odabirPretrageKnjige(List<Book> knjige, List<Author> autori) {
		while (true) {
			System.out.println("1. Pretraga knjige po ID u: ");
			System.out.println("2. Pretraga knjige po zanru: ");
			System.out.println("3. Pretraga knjige po nazivu: ");
			System.out.println("4. Pretraga knjige po autoru:");
			System.out.println("   Unesite broj za pretragu: ");
			System.out.println(" x izlaz");

			Integer opcija = Validation.numberEntry(1, 4);
			if (opcija == null) {
				return null;
			}
			switch (opcija) {
			case 1: {
				Book trazenaKnjiga = pretragaPoIdu(knjige);
				return trazenaKnjiga;
			}
			case 2: {
				List<Book> trezeneKnjige = pretragaPoZanru(knjige);
				Book nadjena = odabirKnjige(trezeneKnjige);
				return nadjena;
			}
			case 3: {
				List<Book> trazeneKnjige = pretragaPoNazivu(knjige);
				Book nadjena = odabirKnjige(trazeneKnjige);
				return nadjena;
			}
			case 4: {
				List<Book> trazeneKnjige = pretragaPoAutoru(knjige, autori);
				Book nadjena = odabirKnjige(trazeneKnjige);
				return nadjena;
			}
			}
		}
	}

	public static Book odabirKnjige(List<Book> knjige) {
		ispisiSveKnjige(knjige);
		System.out.println("Odaberite broj knjige: ");
		Integer izbor = Validation.numberEntry(1, knjige.size());
		return knjige.get(izbor - 1);
	}

}
