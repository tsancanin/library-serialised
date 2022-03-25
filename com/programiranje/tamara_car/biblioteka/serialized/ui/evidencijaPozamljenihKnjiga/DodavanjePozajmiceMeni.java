package programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Author;
import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Member;
import programiranje.tamara_car.biblioteka.serialized.model.Book;
import programiranje.tamara_car.biblioteka.serialized.model.Loan;
import programiranje.tamara_car.biblioteka.serialized.model.Librarian;
import programiranje.tamara_car.biblioteka.serialized.ui.ClanMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.KnjigaMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.ZaposleniMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class DodavanjePozajmiceMeni {

	public static Loan kreirajNovuPozajmicu(Loan zaKreiranje, Library biblioteka) {

		while (true) {
			System.out.println("=========================================");
			System.out.println("Kreira se:");
			System.out.println(zaKreiranje);
			System.out.println("=========================================");
			System.out.println("1. Dodaj knjigu u iznamljene: ");
			System.out.println("2. Obrisi knjigu ");
			System.out.println("3. Promeni bibliotekara ");
			System.out.println("4. Promeni clana ");
			System.out.println("5. Izmeni duzinu trajanja pozajmice ");
			System.out.println("6. Promeni datum iznamljivanja ");
			System.out.println("7. Zakljuci izdavanje ");
			System.out.println("  Ponisti iznamljivanje X  ");

			Integer opcija = Validation.numberEntry(1, 7);

			if (opcija == null) {
				return null;
			}
			switch (opcija) {
			case 1: {
				dodajKnjiguUIznajmljene(zaKreiranje, biblioteka);
				break;
			}

			case 2: {
				obrisiKnjiguIzPozajmice(zaKreiranje);
				break;
			}
			case 3:
				promeniBibliotekara(zaKreiranje, biblioteka);
				break;
			case 4:
				promeniClana(zaKreiranje, biblioteka);
				break;
			case 5:
				promeniDuzinuTrajanjaPozajmice(zaKreiranje);
				break;
			case 6:
				promeniDatumIznamljivanja(zaKreiranje);
				break;
			case 7:
				System.out.println("Zavrseno kreiranje pozajmice");
				return zaKreiranje;
			}
		}
	}

	public static void dodajKnjiguUIznajmljene(Loan zaKreiranje, Library biblioteka) {
		Book odabrana = KnjigaMeni.odabirPretrageKnjige(biblioteka.getListOfBooks(), biblioteka.getAutori());
		if (odabrana != null) {
			zaKreiranje.getPozajmljeneKnjige().add(odabrana);
			System.out.println("Dodata: " + odabrana.getNaziv());
		}

	}

	public static void obrisiKnjiguIzPozajmice(Loan zaKreiranje) {
		List<Book> trenutnoDodate = zaKreiranje.getPozajmljeneKnjige();
		if (trenutnoDodate.isEmpty()) {
			System.out.println("Pozajmica nema dodatih knjiga");
			return;
		}

		List<Author> samoAktivniAutori = new ArrayList<Author>();
		for (Book knjiga : trenutnoDodate) {
			samoAktivniAutori.add(knjiga.getAutor());
		}

		Book odabrana = KnjigaMeni.odabirPretrageKnjige(trenutnoDodate, samoAktivniAutori);
		if (odabrana == null) {
			System.out.println("Uklanjanje ponisteno");
			return;
		}

		System.out.println("Uklonjena: " + odabrana.getNaziv());
		trenutnoDodate.remove(odabrana);

	}

	public static void promeniBibliotekara(Loan zaKreiranje, Library biblioteka) {
		Librarian nadjeni = ZaposleniMeni.odabirZaposlenog(biblioteka.getZaposleni());
		if (nadjeni == null) {
			System.out.println("Ponisteno menjanje bibliotekara");
			return;
		}
		zaKreiranje.setIzdao(nadjeni);
		System.out.println("Bibliotekar promenjen");
	}

	public static void promeniClana(Loan zaKreiranje, Library biblioteka) {
		Member odabrani = ClanMeni.odabirClana(biblioteka.getClanovi());
		if (odabrani == null) {
			System.out.println("Ponisteno menjanje clana");
			return;
		}
		zaKreiranje.setPozajmio(odabrani);
		System.out.println("Clan promenjen");
	}

	public static void promeniDuzinuTrajanjaPozajmice(Loan zaKreiranje) {
		System.out.println("Unesi novo trajanje pozajmice");
		Integer duzina = Validation.numberEntry(1, null);
		if (duzina == null) {
			System.out.println("Ponisteno menjanje trajanja");
			return;
		}
		zaKreiranje.setDuzinaPozajmice(duzina);
		System.out.println("Duzina pozajmice je uspesno promenjena.");
	}

	public static void promeniDatumIznamljivanja(Loan zaKreiranje) {
		System.out.println("Unesi novi datum pozajmljivanja");
		LocalDate datum = Validation.parsedDate();
		if (datum == null) {
			System.out.println("Ponistena izmena datuma");
			return;
		}
		zaKreiranje.setDatumIznajmljivanja(datum);
		System.out.println("Datum uspesno promenjen");
	}

}
