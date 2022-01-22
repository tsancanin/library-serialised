package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Clan;
import programiranje.tamara_car.biblioteka.serialized.ui.util.ClanValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class ClanMeni {

	public static void clanMeni(Biblioteka biblioteka) {

		while (true) {
			System.out.println("---Clan meni---");
			System.out.println("1. Ispis svih clanova: ");
			System.out.println("2. Dodaj novog clana: ");
			System.out.println("3. Izmeni postojeceg clana: ");
			System.out.println("4. Obrisi clana: ");
			System.out.println("5. Pretraga clanova po clanskom broju: ");
			System.out.println("6. Pretraga clanova po imenu i prezimenu: ");
			System.out.println(" X - izlaz");

			Integer opcija = Validacije.unosBroja(1, 6);

			if (opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:
				ispisSvihClanova(biblioteka);
				break;
			case 2:
				dodajNovogClana(biblioteka);
				break;
			case 3: {
				Clan trazeni = odabirClana(biblioteka.getClanovi());
				if (trazeni != null) {
					ClanValidacije.izmenaClana(trazeni);
					System.out.println("Clan uspesno izmenjen");
				} else {
					System.out.println("Trazeni clan ne postoji.");
				}
				break;
			}
			case 4: {
				Clan trazeni = odabirClana(biblioteka.getClanovi());
				if (trazeni == null) {
					System.out.println("Trazeni clan ne postoji.");
				} else {
					biblioteka.getClanovi().remove(trazeni);
					System.out.println("Clan uspesno uklonjen");
				}
				break;
			}
			case 5: {
				Clan trazeni = pretragaPoClanskomBroju(biblioteka.getClanovi());
				if (trazeni != null) {
					System.out.println(trazeni);
				} else {
					System.out.println("Trazeni clan ne postoji.");
				}
				break;
			}
			case 6:
			{	 
				List<Clan> nadjeni =pretragaPoImenuIprezimenu(biblioteka.getClanovi());
				if(nadjeni.isEmpty()) {
					System.out.println("Trazeni clan ne postoji.");
				}else {
					System.out.println(nadjeni);
				}
				break;
			}
			}

		}

	}

	public static void ispisSvihClanova(Biblioteka biblioteka) {
		for (Clan clan : biblioteka.getClanovi()) {
			System.out.println(clan);
		}
	}

	public static void dodajNovogClana(Biblioteka biblioteka) {
		Clan noviClan = ClanValidacije.dodajClana();

		do {
			boolean nadjen = false;
			for (Clan trazeni : biblioteka.getClanovi()) {
				nadjen = trazeni.getId() == noviClan.getId();
				if (nadjen)
					break;
			}
			if (nadjen) {
				System.out.println("ID je zauzet. Unesite novi ID: ");
				Integer noviId = Validacije.unosBroja(1, null);
				noviClan.setId(noviId);
			} else {
				break;
			}

		} while (true);

		biblioteka.getClanovi().add(noviClan);
		System.out.println("Novi clan je uspesno dodat!");
	}

	public static Clan pretragaPoClanskomBroju(List<Clan> clanovi) {
		System.out.println("Unesite broj clanske kartice: ");
		int id = Validacije.unosBroja(1, null);

		for (Clan trazeniClan : clanovi) {
			if (trazeniClan.getClanskiBroj() == id) {
				return trazeniClan;
			}
		}
		return null;
	}

	public static List<Clan> pretragaPoImenuIprezimenu(List<Clan> clanovi) {
		
		System.out.println("Unesite tekst za pretragu: ");
		String tekst = Validacije.unosTeksta(3, null);
		List<Clan> filtrirani = new ArrayList<Clan>();
		for (Clan clan : clanovi) {
			if (
					clan.getIme().toLowerCase().contains(tekst.toLowerCase()) 
					|| clan.getPrezime().toLowerCase().contains(tekst.toLowerCase())
				) {
				filtrirani.add(clan);
			}
		}
		
		return filtrirani;
	}

	public static Clan odabirClana(List<Clan> clanovi) {

		System.out.println("1. Pretraga clana po ID u: ");
		System.out.println("2. Pretraga clana po imenu i prezimenu: ");

		Integer opcija = Validacije.unosBroja(1, 2);
		if (opcija == 1) {
			return pretragaPoClanskomBroju(clanovi);

		} else {
			return odabirClanaPoImenuIprezimenu(clanovi);
		}

	}

	public static Clan odabirClanaPoImenuIprezimenu(List<Clan> clanovi) {

		List<Clan> nadjeni = pretragaPoImenuIprezimenu(clanovi);

		for (int i = 0; i < nadjeni.size(); i++) {
			System.out.println(i + 1 + ". " + nadjeni.get(i));
		}

		System.out.println("Odaberite clana(unesite broj): ");
		Integer odabir = Validacije.unosBroja(1, nadjeni.size());

		return nadjeni.get(odabir - 1);
	}

}
