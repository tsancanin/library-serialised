package programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Clan;
import programiranje.tamara_car.biblioteka.serialized.model.Knjiga;
import programiranje.tamara_car.biblioteka.serialized.model.Pozajmica;
import programiranje.tamara_car.biblioteka.serialized.model.Zaposleni;
import programiranje.tamara_car.biblioteka.serialized.ui.ClanMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.ZaposleniMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class PozajmiceMeni {

	public static void pozajmiceMeni(Biblioteka biblioteka) {
		while (true) {
			System.out.println("----Upravljanje pozajmicama----");
			System.out.println("1.Listaj sve pozajmice ");
			System.out.println("2.Listaj pozajmice po clanu ");
			System.out.println("3.Kreiraj novu pozajmicu ");
			System.out.println("4.Razduzi pozajmicu ");
			System.out.println(" x izlaz ");

			Integer opcija = Validacije.unosBroja(1, 4);
			if (opcija == null) {
				return;
			}
			switch (opcija) {
			case 1: {
				List<Pozajmica> trazene = biblioteka.getEvidencijaKnjiga();
				if (trazene.isEmpty()) {
					System.out.println("Trenutno nema pozajmica.");
				} else {
					for (Pozajmica pozajmica : trazene) {
						System.out.println(pozajmica);
					}
				}
				break;
			}
			case 2: {
				Pozajmica trazena = nadjiPoClanu(biblioteka);
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

	public static void kreirajPozajmicu(Biblioteka biblioteka) {
		System.out.println("Odaberite zaposlenog: ");
		Zaposleni odabraniZaposleni = ZaposleniMeni.odabirZaposlenog(biblioteka.getZaposleni());
		if (odabraniZaposleni == null) {
			System.out.println("Prekida se kreiranje pozajmice");
			return;
		}
		
		System.out.println("Odaberite clana: ");
		Clan odabraniClan = ClanMeni.odabirClana(biblioteka.getClanovi());
		if (odabraniClan == null) {
			System.out.println("Prekida se kreiranje pozajmice");
			return;
		}
		
		System.out.println("Unesite datum pozajmice: ");
		LocalDate datum = Validacije.parsiranDatum();
		System.out.println("Unesite duzinu pozajmice: ");
		Integer duzinaPozajmice = Validacije.unosBroja(1, null);

		Pozajmica novaPozajmica = new Pozajmica(odabraniZaposleni, odabraniClan, duzinaPozajmice, datum,
				new ArrayList<Knjiga>());

		Pozajmica zavrsena = DodavanjePozajmiceMeni.kreirajNovuPozajmicu(novaPozajmica, biblioteka);
		if (zavrsena == null) {
			System.out.println("Prekida se kreiranje pozajmice");
			return;
		} else {
			biblioteka.getEvidencijaKnjiga().add(zavrsena);
			System.out.println("Pozajmica je zavedena.");
		}

	}

	public static Pozajmica nadjiPoClanu(Biblioteka biblioteka) {
		Clan odabir = ClanMeni.odabirClana(biblioteka.getClanovi());
		if (odabir == null) {
			return null;
		}
		for (Pozajmica trenutna : biblioteka.getEvidencijaKnjiga()) {
			if (odabir.getId() == trenutna.getPozajmio().getId()) {
				return trenutna;
			}
		}
		return null;
	}

}
