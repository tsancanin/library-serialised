package programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Member;
import programiranje.tamara_car.biblioteka.serialized.model.Book;
import programiranje.tamara_car.biblioteka.serialized.model.Loan;
import programiranje.tamara_car.biblioteka.serialized.model.Librarian;
import programiranje.tamara_car.biblioteka.serialized.ui.ClanMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.ZaposleniMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class PozajmiceMeni {

	public static void pozajmiceMeni(Library biblioteka) {
		while (true) {
			System.out.println("----Upravljanje pozajmicama----");
			System.out.println("1.Listaj sve pozajmice ");
			System.out.println("2.Listaj pozajmice po clanu ");
			System.out.println("3.Kreiraj novu pozajmicu ");
			System.out.println("4.Razduzi pozajmicu ");
			System.out.println(" x izlaz ");

			Integer opcija = Validation.numberEntry(1, 4);
			if (opcija == null) {
				return;
			}
			switch (opcija) {
			case 1: {
				List<Loan> trazene = biblioteka.getEvidencijaKnjiga();
				if (trazene.isEmpty()) {
					System.out.println("Trenutno nema pozajmica.");
				} else {
					for (Loan pozajmica : trazene) {
						System.out.println(pozajmica);
					}
				}
				break;
			}
			case 2: {
				Loan trazena = nadjiPoClanu(biblioteka);
				if (trazena != null) {
					System.out.println(trazena);
				} else {
					System.out.println("Pozajmica nije nadjena");
				}
				break;
			}
			case 3: {
				kreirajPozajmicu(biblioteka);
				break;
			}

			}
		}
	}

	public static void kreirajPozajmicu(Library biblioteka) {
		System.out.println("Odaberite zaposlenog: ");
		Librarian odabraniZaposleni = ZaposleniMeni.odabirZaposlenog(biblioteka.getZaposleni());
		if (odabraniZaposleni == null) {
			System.out.println("Prekida se kreiranje pozajmice");
			return;
		}
		
		System.out.println("Odaberite clana: ");
		Member odabraniClan = ClanMeni.odabirClana(biblioteka.getClanovi());
		if (odabraniClan == null) {
			System.out.println("Prekida se kreiranje pozajmice");
			return;
		}
		
		System.out.println("Unesite datum pozajmice: ");
		LocalDate datum = Validation.parsedDate();
		System.out.println("Unesite duzinu pozajmice: ");
		Integer duzinaPozajmice = Validation.numberEntry(1, null);

		Loan novaPozajmica = new Loan(odabraniZaposleni, odabraniClan, duzinaPozajmice, datum,
				new ArrayList<Book>());

		Loan zavrsena = DodavanjePozajmiceMeni.kreirajNovuPozajmicu(novaPozajmica, biblioteka);
		if (zavrsena == null) {
			System.out.println("Prekida se kreiranje pozajmice");
			return;
		} else {
			biblioteka.getEvidencijaKnjiga().add(zavrsena);
			System.out.println("Pozajmica je zavedena.");
		}

	}

	public static Loan nadjiPoClanu(Library biblioteka) {
		Member odabir = ClanMeni.odabirClana(biblioteka.getClanovi());
		if (odabir == null) {
			return null;
		}
		for (Loan trenutna : biblioteka.getEvidencijaKnjiga()) {
			if (odabir.getId() == trenutna.getPozajmio().getId()) {
				return trenutna;
			}
		}
		return null;
	}

}
