package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import programiranje.tamara_car.biblioteka.serialized.model.Autor;
import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Pozajmica;
import programiranje.tamara_car.biblioteka.serialized.model.Knjiga;
import programiranje.tamara_car.biblioteka.serialized.model.Zanrovi;
import programiranje.tamara_car.biblioteka.serialized.ui.util.ZanroviValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.AutorValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.KnjigaValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

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

			Integer opcija = Validacije.unosBroja(1, 8);

			if (opcija == null) {
				return;
			}

			switch (opcija) {
			case 1:
				ispisiSveKnjige(biblioteka);
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
			case 8:
				pretragaPoIdu(biblioteka);
				break;
			case 9:
				pretragaPoNazivu(biblioteka);
				break;
			case 10:
				pretragaPoZanru(biblioteka);
				break;
			case 11:
				pretragaPoAutoru(biblioteka);
				break;
			}

		}

	}

	public static void ispisiSveKnjige(Biblioteka biblioteka) {
		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanr : biblioteka.getSveKnjige().entrySet()) {
			System.out.println("\t" + zanr.getKey());

			for (Map.Entry<Autor, ArrayList<Knjiga>> autorIzZanra : zanr.getValue().entrySet()) {
				System.out.println("\t" + autorIzZanra.getKey());
				for (Knjiga knjiga : autorIzZanra.getValue()) {
					System.out.println("\t" + knjiga);
				}
			}
		}

	}

	public static void dodajKnjigu(Biblioteka biblioteka) {

		Knjiga knjiga = KnjigaValidacije.unosKnjige(null, biblioteka.getAutori());// ui
		HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige = biblioteka.getSveKnjige();
		// ako nepostoji taj zanr napravi ga
		if (!sveKnjige.containsKey(knjiga.getZanr())) {
			HashMap<Autor, ArrayList<Knjiga>> noviAutori = new HashMap<Autor, ArrayList<Knjiga>>();
			sveKnjige.put(knjiga.getZanr(), noviAutori);
		}
		HashMap<Autor, ArrayList<Knjiga>> autoriIzZanra = sveKnjige.get(knjiga.getZanr());

		if (!autoriIzZanra.containsKey(knjiga.getAutor())) {
			autoriIzZanra.put(knjiga.getAutor(), new ArrayList<Knjiga>());
		}

		ArrayList<Knjiga> knjigeTogAutora = autoriIzZanra.get(knjiga.getAutor());
		knjigeTogAutora.add(knjiga);
		System.out.println("Knjiga je uspesno dodata.");// ui

	}

	public static void obrisiKnjigu(Biblioteka biblioteka) {
		System.out.println("Unesite naziv knjige: ");
		String nazivKnjige = Validacije.unosTeksta(3, null);

		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanr : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autor : zanr.getValue().entrySet()) {
				for (Knjiga knjiga: autor.getValue()) {
						if(knjiga.getNaziv().contains(nazivKnjige)) {
							
						}
						autor.getValue().remove(knjiga);
						//ne znam kako ovo da uradim
						
						System.out.println("Knjiga je obrisana.");
						
					}
				}
			}
		}
	

	public static void izmeniNazivKnjige(Biblioteka biblioteka) {
		System.out.println("Unesite naziv knjige: ");
		String naziKnjige = Validacije.unosTeksta(3, null);
		String noviNaziv = null;

		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanrovi : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autori : zanrovi.getValue().entrySet()) {
				for (int i = 0; i < autori.getValue().size(); i++) {
					if (autori.getValue().get(i).getNaziv().equals(naziKnjige)) {
						System.out.println("Unesite novi naziv knjige: ");
						noviNaziv = Validacije.unosTeksta(3, null);
					}
					autori.getValue().get(i).setNaziv(noviNaziv);
					System.out.println("Naziv je uspesno promenjen");
				}
			}
		}

	}

	public static void izmeniBrojKopija(Biblioteka biblioteka) {
		System.out.println("Unesite naziv knjige: ");
		String naziKnjige = Validacije.unosTeksta(3, null);
		Integer noviBrojKopija = null;

		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanrovi : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autori : zanrovi.getValue().entrySet()) {
				for (int i = 0; i < autori.getValue().size(); i++) {
					if (autori.getValue().get(i).getNaziv().equals(naziKnjige)) {
						System.out.println("Trenutno broj kopija: " + autori.getValue().get(i).getBrojKnjiga());
						System.out.println("Unesite novi broj kopija: ");
						noviBrojKopija = Validacije.unosBroja(1, null);
					}
					autori.getValue().get(i).setBrojKnjiga(noviBrojKopija);
					System.out.println("Naziv je uspesno promenjen");
				}
			}
		}
	}

	public static void izmeniZanr(Biblioteka biblioteka) {
		System.out.println("Unesite naziv knjige: ");
		String nazivKnjige = Validacije.unosTeksta(3, null);
		Zanrovi noviZanr = null;

		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanrovi : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autori : zanrovi.getValue().entrySet()) {
				for (Knjiga knjiga : autori.getValue()) {
					if (knjiga.getNaziv().equals(nazivKnjige)) {
						System.out.println("Trenutni zanr je: " + zanrovi.getKey());
						System.out.println("Odaberite novi zanr: ");
						noviZanr = ZanroviValidacije.odabirZanra();
						knjiga.setZanr(noviZanr);
						System.out.println("Zanr knjige je uspesno promenjen");
					}
				}
			}
		}
	}

	public static void izmeniAutora(Biblioteka biblioteka) {
		System.out.println("Unesite naziv knjige: ");
		String naziKnjige = Validacije.unosTeksta(3, null);
		String ime = null;
		String prezime = null;
		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanr : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autor : zanr.getValue().entrySet()) {
				for (Knjiga knjiga : autor.getValue()) {
					if (knjiga.getNaziv().equals(naziKnjige)) {
						System.out.println(knjiga);
						System.out.println("Unesite novo ime autora: ");
						ime = Validacije.unosTeksta(3, null);
						System.out.println("Unesite novo prezime autora: ");
						prezime = Validacije.unosTeksta(3, null);
						knjiga.getAutor().setIme(ime);
						knjiga.getAutor().setPrezime(prezime);
						System.out.println("Autor je uspesno promenjen.");
					}
				}
			}
		}
	}

	public static void pretragaPoIdu(Biblioteka biblioteka) {
		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanr : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autor : zanr.getValue().entrySet()) {
				System.out.println("Unesite ID knjige:");
				Integer id = Validacije.unosBroja(1, null);
				for (Knjiga knjiga : autor.getValue()) {
					if (knjiga.getIdKnjige() == id) {
						System.out.println(knjiga);
					}
				}
			}
		}
	}

	public static void pretragaPoNazivu(Biblioteka biblioteka) {
		System.out.println("Unesite naziv knjige: ");
		String naziv = Validacije.unosTeksta(3, null);

		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanrovi : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autor : zanrovi.getValue().entrySet()) {
				for (Knjiga knjiga : autor.getValue()) {
					if (knjiga.getNaziv().equals(naziv)) {
						System.out.println(knjiga);
					}
				}
			}
		}
	}

	public static void pretragaPoZanru(Biblioteka biblioteka) {
		Zanrovi odabrani = ZanroviValidacije.odabirZanra();// ui

		// servisni sloj
		ArrayList<Knjiga> trazeneKnjige = new ArrayList<Knjiga>();
		if (biblioteka.getSveKnjige().containsKey(odabrani)) {
			HashMap<Autor, ArrayList<Knjiga>> autoriIzZanra = biblioteka.getSveKnjige().get(odabrani);
			for (ArrayList<Knjiga> knjigeAutora : autoriIzZanra.values()) {
				trazeneKnjige.addAll(knjigeAutora);
			}
		}

		// ui
		if (trazeneKnjige.size() < 1) {
			System.out.println("Nema knjiga trazenog zanra");
			return;
		}

		for (Knjiga knjiga : trazeneKnjige) {
			System.out.println(knjiga);
		}

	}

	public static void pretragaPoAutoru(Biblioteka biblioteka) {
		Autor odabraniAutor = AutorValidacije.izborAutora(biblioteka.getAutori());

		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanr : biblioteka.getSveKnjige().entrySet()) {
			for (Map.Entry<Autor, ArrayList<Knjiga>> autori : zanr.getValue().entrySet()) {
				if (autori.getKey().equals(odabraniAutor)) {
					for (Knjiga knjiga : autori.getValue()) {
						System.out.println(knjiga);
					}
				}
			}
		}

	}
	
	public static void odabirPretrageKnjige(Biblioteka biblioteka) {
		while (true) {
			System.out.println("1. Pretraga knjige po ID u: ");
			System.out.println("2. Pretraga knjige po zanru: ");
			System.out.println("3. Pretraga knjige po nazivu: ");
			System.out.println(" unesite broj za pretragu: ");

			Integer opcija = Validacije.unosBroja(1, 3);
			if (opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:
				KnjigaMeni.pretragaPoIdu(biblioteka);
				break;
			case 2:
				KnjigaMeni.pretragaPoZanru(biblioteka);
				break;
			case 3:
				KnjigaMeni.pretragaPoNazivu(biblioteka);
			default:
				break;
			}
		}
	}

}
