package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.time.LocalDate;

import programiranje.tamara_car.biblioteka.serialized.model.Member;

public class ClanValidacije {

	public static Member unosPodataka(Member clan) {
		Member izmenjeniClan = clan;

		if (izmenjeniClan == null) {
			izmenjeniClan = new Member();
			System.out.println("Unesite ID clana: ");
			Integer idClana = Validation.numberEntry(1, null);
			izmenjeniClan.setId(idClana);
		}
		System.out.println("Unesite clanski broj: ");
		int clanskiBroj = Validation.numberEntry(1, null);
		izmenjeniClan.setClanskiBroj(clanskiBroj);
		System.out.println("Unesite ime clana: ");
		String ime = Validation.textEntry(3, null);
		izmenjeniClan.setIme(ime);
		System.out.println("Unesite prezime clana: ");
		String prezime = Validation.textEntry(3, null);
		izmenjeniClan.setPrezime(prezime);
		System.out.println("Unesite datum rodjenja clana: ");
		LocalDate parsirani = Validation.parsedDate();
		izmenjeniClan.setDatumRodjenja(parsirani);
		System.out.println("Unesite adresu clana: ");
		String adresa = Validation.textEntry(3, null);
		izmenjeniClan.setAdresa(adresa);
		System.out.println("Unesite clanov broj telefona: ");
		int brojtelefona = Validation.numberEntry(3, null);
		izmenjeniClan.setBrojTelefona(brojtelefona);
		System.out.println("Unesite mail adresu clana: ");
		String mail = Validation.proveraMaila();
		izmenjeniClan.setMail(mail);

		return izmenjeniClan;
	}

	public static Member izmenaClana(Member clan) {
		return unosPodataka(clan);
	}

	public static Member dodajClana() {
		return unosPodataka(null);
	}

}
