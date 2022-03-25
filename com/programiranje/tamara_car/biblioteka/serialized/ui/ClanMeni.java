package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Member;
import programiranje.tamara_car.biblioteka.serialized.ui.util.ClanValidacije;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class ClanMeni {

	public static void clanMeni(Library biblioteka) {

		while (true) {
			System.out.println("---Clan meni---");
			System.out.println("1. Ispis svih clanova: ");
			System.out.println("2. Dodaj novog clana: ");
			System.out.println("3. Izmeni postojeceg clana: ");
			System.out.println("4. Obrisi clana: ");
			System.out.println("5. Pretraga clanova po clanskom broju: ");
			System.out.println("6. Pretraga clanova po imenu i prezimenu: ");
			System.out.println(" X - izlaz");

			Integer opcija = Validation.numberEntry(1, 6);

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
				Member trazeni = odabirClana(biblioteka.getClanovi());
				if (trazeni != null) {
					ClanValidacije.izmenaClana(trazeni);
					System.out.println("Clan uspesno izmenjen");
				} else {
					System.out.println("Trazeni clan ne postoji.");
				}
				break;
			}
			case 4: {
				Member trazeni = odabirClana(biblioteka.getClanovi());
				if (trazeni == null) {
					System.out.println("Trazeni clan ne postoji.");
				} else {
					biblioteka.getClanovi().remove(trazeni);
					System.out.println("Clan uspesno uklonjen");
				}
				break;
			}
			case 5: {
				Member trazeni = pretragaPoClanskomBroju(biblioteka.getClanovi());
				if (trazeni != null) {
					System.out.println(trazeni);
				} else {
					System.out.println("Trazeni clan ne postoji.");
				}
				break;
			}
			case 6:
			{	 
				List<Member> nadjeni =pretragaPoImenuIprezimenu(biblioteka.getClanovi());
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

	public static void ispisSvihClanova(Library biblioteka) {
		for (Member clan : biblioteka.getClanovi()) {
			System.out.println(clan);
		}
	}

	public static void dodajNovogClana(Library biblioteka) {
		Member noviClan = ClanValidacije.dodajClana();

		do {
			boolean nadjen = false;
			for (Member trazeni : biblioteka.getClanovi()) {
				nadjen = trazeni.getId() == noviClan.getId();
				if (nadjen)
					break;
			}
			if (nadjen) {
				System.out.println("ID je zauzet. Unesite novi ID: ");
				Integer noviId = Validation.numberEntry(1, null);
				noviClan.setId(noviId);
			} else {
				break;
			}

		} while (true);

		biblioteka.getClanovi().add(noviClan);
		System.out.println("Novi clan je uspesno dodat!");
	}

	public static Member pretragaPoClanskomBroju(List<Member> clanovi) {
		System.out.println("Unesite broj clanske kartice: ");
		int id = Validation.numberEntry(1, null);

		for (Member trazeniClan : clanovi) {
			if (trazeniClan.getClanskiBroj() == id) {
				return trazeniClan;
			}
		}
		return null;
	}

	public static List<Member> pretragaPoImenuIprezimenu(List<Member> clanovi) {
		
		System.out.println("Unesite tekst za pretragu: ");
		String tekst = Validation.textEntry(3, null);
		List<Member> filtrirani = new ArrayList<Member>();
		for (Member clan : clanovi) {
			if (
					clan.getIme().toLowerCase().contains(tekst.toLowerCase()) 
					|| clan.getPrezime().toLowerCase().contains(tekst.toLowerCase())
				) {
				filtrirani.add(clan);
			}
		}
		
		return filtrirani;
	}

	public static Member odabirClana(List<Member> clanovi) {

		System.out.println("1. Pretraga clana po ID u: ");
		System.out.println("2. Pretraga clana po imenu i prezimenu: ");

		Integer opcija = Validation.numberEntry(1, 2);
		if (opcija == 1) {
			return pretragaPoClanskomBroju(clanovi);

		} else {
			return odabirClanaPoImenuIprezimenu(clanovi);
		}

	}

	public static Member odabirClanaPoImenuIprezimenu(List<Member> clanovi) {

		List<Member> nadjeni = pretragaPoImenuIprezimenu(clanovi);

		for (int i = 0; i < nadjeni.size(); i++) {
			System.out.println(i + 1 + ". " + nadjeni.get(i));
		}

		System.out.println("Odaberite clana(unesite broj): ");
		Integer odabir = Validation.numberEntry(1, nadjeni.size());

		return nadjeni.get(odabir - 1);
	}

}
