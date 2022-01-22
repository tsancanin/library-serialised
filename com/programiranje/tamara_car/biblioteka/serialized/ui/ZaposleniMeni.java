package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Zaposleni;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.ZaposleniValidacije;

public class ZaposleniMeni {

	public static void zaposleniMeni(Biblioteka biblioteka) {

		while (true) {
			System.out.println("---Zaposleni meni---");
			System.out.println("1. Ispis svih zaposlenih: ");
			System.out.println("2. Dodaj novog zaposlenog: ");
			System.out.println("3. Izmeni postojeceg zaposlenog: ");
			System.out.println("4. Obrisi zaposlenog: ");
			System.out.println("5. Pretraga zaposlenog po id- u: ");
			System.out.println("6. Pretraga zaposlenih po imenu i prezimenu: ");
			System.out.println(" X - izlaz");

			Integer opcija = Validacije.unosBroja(1, 6);
			if (opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:
				ispisSvihZaposlenih(biblioteka.getZaposleni());
				break;
			case 2:
				dodajNovogZaposlenog(biblioteka);
				break;
			case 3: {
				Zaposleni zaposleni = pretragaPoIdu(biblioteka.getZaposleni());
				if (zaposleni != null) {
					ZaposleniValidacije.izmeniZaposlenog(zaposleni);
				} else {
					System.out.println("Trazeni zaposleni ne postoji.");
				}
				break;
			}
			case 4:
				obrisiZaposlenog(biblioteka);
				break;
			case 5: {
				Zaposleni trazeni = pretragaPoIdu(biblioteka.getZaposleni());
				if (trazeni != null) {
					System.out.println(trazeni);
				} else {
					System.out.println("Trazeni zaposleni ne postoji.");
				}
				break;
			}
			case 6: {
				List<Zaposleni> nadjeni = pretragaPoImenuIprezimenu(biblioteka.getZaposleni());
				if (nadjeni.isEmpty()) {
					System.out.println("Trazeni zaposleni ne postoji.");
				} else {
					for (Zaposleni zaposleni : nadjeni) {
						System.out.println(zaposleni);
					}
				}
				break;
			}
			}
		}
	}

	public static void ispisSvihZaposlenih(List<Zaposleni> zaposleni) {
		for (Zaposleni zaposleniNadjeni : zaposleni) {
			System.out.println(zaposleniNadjeni);
		}
	}

	public static void dodajNovogZaposlenog(Biblioteka biblioteka) {

		Zaposleni zaposleni = ZaposleniValidacije.dodajNovogZaposlenog();
		do {
			boolean nadjen = false;
			for (Zaposleni trenutni : biblioteka.getZaposleni()) {
				nadjen = trenutni.getId() == zaposleni.getId();
				if (nadjen)
					break;
			}
			if (nadjen) {
				System.out.println("ID je zauzet. Unesite novi ID: ");
				Integer noviId = Validacije.unosBroja(1, null);
				zaposleni.setId(noviId);
			} else {
				break;
			}
		} while (true);
		biblioteka.getZaposleni().add(zaposleni);
		System.out.println("Novi zaposleni je uspesno dodat!");

	}

	public static Zaposleni pretragaPoIdu(List<Zaposleni> zaposleni) {
		System.out.println("Unesite id zaposlenog: ");
		Integer idZaposlenog = Validacije.unosBroja(1, null);

		for (Zaposleni zaposleniNadjeni : zaposleni) {
			if (zaposleniNadjeni.getId() == idZaposlenog) {
				System.out.println(zaposleniNadjeni);
			}
		}
		return null;
	}

	public static List<Zaposleni> pretragaPoImenuIprezimenu(List<Zaposleni> zaposleni) {

		System.out.println("Unesite tekst za pretragu: ");
		String tekst = Validacije.unosTeksta(3, null);

		List<Zaposleni> nadjeni = new ArrayList<Zaposleni>();

		for (Zaposleni zaposleniNadjeni : zaposleni) {
			if (zaposleniNadjeni.getIme().toLowerCase().contains(tekst.toLowerCase())
					|| zaposleniNadjeni.getPrezime().toLowerCase().contains(tekst.toLowerCase())) {
				nadjeni.add(zaposleniNadjeni);
			}
		}
		return nadjeni;

	}

	public static Zaposleni odabirZaposlenog(List<Zaposleni> zaposleni) {

		System.out.println("1. Pretraga zaposlenog po ID u: ");
		System.out.println("2. Pretraga zaposlenog po imenu i prezimenu: ");

		Integer opcija = Validacije.unosBroja(1, 2);
		if (opcija == 1) {
			return pretragaPoIdu(zaposleni);
		} else {
			return odabirZaposlenogPoImenuIprezimenu(zaposleni);
		}

	}

	public static Zaposleni odabirZaposlenogPoImenuIprezimenu(List<Zaposleni> zaposleni) {

		List<Zaposleni> nadjeni = pretragaPoImenuIprezimenu(zaposleni);

		for (int i = 0; i < nadjeni.size(); i++) {
			System.out.println(i + 1 + ". " + nadjeni.get(i));
		}

		System.out.println(" Odaberite zaposlenog(unesite broj): ");
		Integer odabir = Validacije.unosBroja(1, nadjeni.size());

		return nadjeni.get(odabir - 1);
	}

	public static void obrisiZaposlenog(Biblioteka biblioteka) {
		Zaposleni nadjen = odabirZaposlenog(biblioteka.getZaposleni());

		if (nadjen == null) {
			System.out.println("Zaposleni nije pronadjen.");
		} else {
			biblioteka.getZaposleni().remove(nadjen);
		}
	}

}
