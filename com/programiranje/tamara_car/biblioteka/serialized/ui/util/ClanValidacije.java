package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.time.LocalDate;

import programiranje.tamara_car.biblioteka.serialized.model.Clan;

public class ClanValidacije {

	public static Clan unosPodataka(Clan clan) {
		Clan izmenjeniClan = clan;

		if (izmenjeniClan == null) {
			izmenjeniClan = new Clan();
			System.out.println("Unesite ID clana: ");
			Integer idClana = Validacije.unosBroja(1, null);
			izmenjeniClan.setId(idClana);
		}
		System.out.println("Unesite clanski broj: ");
		int clanskiBroj = Validacije.unosBroja(1, null);
		izmenjeniClan.setClanskiBroj(clanskiBroj);
		System.out.println("Unesite ime clana: ");
		String ime = Validacije.unosTeksta(3, null);
		izmenjeniClan.setIme(ime);
		System.out.println("Unesite prezime clana: ");
		String prezime = Validacije.unosTeksta(3, null);
		izmenjeniClan.setPrezime(prezime);
		System.out.println("Unesite datum rodjenja clana: ");
		LocalDate parsirani = Validacije.parsiranDatum();
		izmenjeniClan.setDatumRodjenja(parsirani);
		System.out.println("Unesite adresu clana: ");
		String adresa = Validacije.unosTeksta(3, null);
		izmenjeniClan.setAdresa(adresa);
		System.out.println("Unesite clanov broj telefona: ");
		int brojtelefona = Validacije.unosBroja(3, null);
		izmenjeniClan.setBrojTelefona(brojtelefona);
		System.out.println("Unesite mail adresu clana: ");
		String mail = Validacije.proveraMaila();
		izmenjeniClan.setMail(mail);

		return izmenjeniClan;
	}

	public static Clan izmenaClana(Clan clan) {
		return unosPodataka(clan);
	}

	public static Clan dodajClana() {
		return unosPodataka(null);
	}

}
