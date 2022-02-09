package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import programiranje.tamara_car.biblioteka.serialized.model.Autor;
import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Knjiga;
import programiranje.tamara_car.biblioteka.serialized.model.Zanrovi;
import programiranje.tamara_car.biblioteka.serialized.ui.util.AutorValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.KnjigaValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.ZanroviValidacije;

public class KnjigaMeni {

	public static Scanner in = new Scanner(System.in);

	public static void knjigeMeni(Biblioteka biblioteka) {

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

			Integer opcija = Validacije.unosBroja(1, 11);

			if (opcija == null) {
				return;
			}

			switch (opcija) {
			case 1:
				ispisiSveKnjige(biblioteka.getListaKnjiga());
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

				Knjiga knjiga = pretragaPoIdu(biblioteka.getListaKnjiga());
				if (knjiga == null) {
					System.out.println("Trazena knjiga ne postoji.");
				} else {
					System.out.println(knjiga);
				}
				break;
			}
			case 9: {
				List<Knjiga> trazeneKnjige = pretragaPoNazivu(biblioteka.getListaKnjiga());
				if (trazeneKnjige.isEmpty()) {
					System.out.println("Trazene knjige ne postoje.");
				} else {
					System.out.println(trazeneKnjige);
				}
				break;
			}
			case 10: {
				List<Knjiga> trazeneKnjige = pretragaPoZanru(biblioteka.getListaKnjiga());
				if (trazeneKnjige.isEmpty()) {
					System.out.println("Trazene knjige ne postoje.");
				} else {
					System.out.println(trazeneKnjige);
				}
				break;
			}
			case 11: {
				List<Knjiga> trazeneKnjige = pretragaPoAutoru(biblioteka.getListaKnjiga(), biblioteka.getAutori());
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

	public static void ispisiSveKnjige(List<Knjiga> knjige) {
		for (int i = 0; i < knjige.size(); i++) {
			System.out.println(i + 1 + ". " + knjige.get(i));
		}
	}

	public static void dodajKnjigu(Biblioteka biblioteka) {

		Knjiga knjiga = KnjigaValidacije.unosKnjige(null, biblioteka.getAutori());// ui
		dodavanjeKnjige(biblioteka.getSveKnjige(), knjiga);
		System.out.println("Knjiga je uspesno dodata.");// ui

	}

	public static void obrisiKnjigu(Biblioteka biblioteka) {
		Knjiga odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListaKnjiga(),biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		uklanjanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		
		System.out.println("Knjiga je uspesno obrisana.");
	}
	
	public static void uklanjanjeKnjige(HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige, Knjiga odabranaKnjiga) {
		
		HashMap<Autor, ArrayList<Knjiga>> autoriUzanru = sveKnjige.get(odabranaKnjiga.getZanr());
		ArrayList<Knjiga> knjigeAutora = autoriUzanru.get(odabranaKnjiga.getAutor());
			
		knjigeAutora.remove(odabranaKnjiga);
			
		if (knjigeAutora.isEmpty()) {
			autoriUzanru.remove(odabranaKnjiga.getAutor());
		}
		if (autoriUzanru.isEmpty()) {
			sveKnjige.remove(odabranaKnjiga.getZanr());
		}
	}
	
	public static void dodavanjeKnjige(HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige, Knjiga odabranaKnjiga) {
		
		if (!sveKnjige.containsKey(odabranaKnjiga.getZanr())) {
			HashMap<Autor, ArrayList<Knjiga>> noviAutori = new HashMap<Autor, ArrayList<Knjiga>>();
			sveKnjige.put(odabranaKnjiga.getZanr(), noviAutori);
		}
		
		HashMap<Autor, ArrayList<Knjiga>> autoriIzZanra = sveKnjige.get(odabranaKnjiga.getZanr());
		
		if (!autoriIzZanra.containsKey(odabranaKnjiga.getAutor())) {
			autoriIzZanra.put(odabranaKnjiga.getAutor(), new ArrayList<Knjiga>());
		}
		
		ArrayList<Knjiga> knjigeTogAutora = autoriIzZanra.get(odabranaKnjiga.getAutor());
		knjigeTogAutora.add(odabranaKnjiga);

	}

	public static void izmeniNazivKnjige(Biblioteka biblioteka) {
		Knjiga odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListaKnjiga(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}

		System.out.println("Unesite novi naziv knjige: ");
		String noviNaziv = Validacije.unosTeksta(3, null);
		odabranaKnjiga.setNaziv(noviNaziv);
		System.out.println("Naziv je uspesno izmenjen.");
	}

	public static void izmeniBrojKopija(Biblioteka biblioteka) {
		Knjiga odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListaKnjiga(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		System.out.println("Unesite novi broj kopija knjige: ");
		Integer brojKnjiga = Validacije.unosBroja(1, null);
		odabranaKnjiga.setBrojKnjiga(brojKnjiga);
		System.out.println("Broj kopija je uspesno izmenjen.");

		
	}

	public static void izmeniZanr(Biblioteka biblioteka) {
		Knjiga odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListaKnjiga(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		Zanrovi noviZanr = ZanroviValidacije.odabirZanra();
		uklanjanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		odabranaKnjiga.setZanr(noviZanr);
		dodavanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		
	}

	public static void izmeniAutora(Biblioteka biblioteka) {
		Knjiga odabranaKnjiga = odabirPretrageKnjige(biblioteka.getListaKnjiga(), biblioteka.getAutori());
		if (odabranaKnjiga == null) {
			System.out.println("Knjiga nije pronadjena.");
			return;
		}
		Autor noviAutor = AutorValidacije.izborAutora(biblioteka.getAutori());
		uklanjanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);
		odabranaKnjiga.setAutor(noviAutor);
		dodavanjeKnjige(biblioteka.getSveKnjige(), odabranaKnjiga);

		
	}

	public static Knjiga pretragaPoIdu(List<Knjiga> knjige) {
		System.out.println("Unesite ID knjige:");
		Integer id = Validacije.unosBroja(1, null);
		for (Knjiga knjiga : knjige) {
			if (knjiga.getIdKnjige() == id) {
				return knjiga;
			}
		}

		return null;
	}

	public static List<Knjiga> pretragaPoNazivu(List<Knjiga> knjige) {
		System.out.println("Unesite naziv knjige: ");
		String naziv = Validacije.unosTeksta(3, null);

		ArrayList<Knjiga> trazeneKnjige = new ArrayList<Knjiga>();
		for (Knjiga knjiga : knjige) {
			if (knjiga.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
				trazeneKnjige.add(knjiga);

			}

		}
		return trazeneKnjige;
	}

	public static List<Knjiga> pretragaPoZanru(List<Knjiga> knjige) {
		Zanrovi odabrani = ZanroviValidacije.odabirZanra();// ui

		// servisni sloj
		ArrayList<Knjiga> trazeneKnjige = new ArrayList<Knjiga>();
		for (Knjiga knjiga : knjige) {
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

	public static List<Knjiga> pretragaPoAutoru(List<Knjiga> knjige, List<Autor> autori) {
		Autor odabraniAutor = AutorValidacije.izborAutora(autori);

		ArrayList<Knjiga> trazeneKnjige = new ArrayList<Knjiga>();

		for (Knjiga knjiga : knjige) {
			if (knjiga.getAutor().getId() == odabraniAutor.getId()) {
				trazeneKnjige.add(knjiga);
			}
		}
		return trazeneKnjige;

	}

	public static Knjiga odabirPretrageKnjige(List<Knjiga> knjige, List<Autor> autori) {
		while (true) {
			System.out.println("1. Pretraga knjige po ID u: ");
			System.out.println("2. Pretraga knjige po zanru: ");
			System.out.println("3. Pretraga knjige po nazivu: ");
			System.out.println("4. Pretraga knjige po autoru:");
			System.out.println("   Unesite broj za pretragu: ");
			System.out.println(" x izlaz");

			Integer opcija = Validacije.unosBroja(1, 4);
			if (opcija == null) {
				return null;
			}
			switch (opcija) {
			case 1: {
				Knjiga trazenaKnjiga = pretragaPoIdu(knjige);
				return trazenaKnjiga;
			}
			case 2: {
				List<Knjiga> trezeneKnjige = pretragaPoZanru(knjige);
				Knjiga nadjena = odabirKnjige(trezeneKnjige);
				return nadjena;
			}
			case 3: {
				List<Knjiga> trazeneKnjige = pretragaPoNazivu(knjige);
				Knjiga nadjena = odabirKnjige(trazeneKnjige);
				return nadjena;
			}
			case 4: {
				List<Knjiga> trazeneKnjige = pretragaPoAutoru(knjige, autori);
				Knjiga nadjena = odabirKnjige(trazeneKnjige);
				return nadjena;
			}
			}
		}
	}

	public static Knjiga odabirKnjige(List<Knjiga> knjige) {
		ispisiSveKnjige(knjige);
		System.out.println("Odaberite broj knjige: ");
		Integer izbor = Validacije.unosBroja(1, knjige.size());
		return knjige.get(izbor - 1);
	}

}
