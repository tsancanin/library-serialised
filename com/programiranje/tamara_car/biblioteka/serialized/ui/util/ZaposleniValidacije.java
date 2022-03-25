package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.time.LocalDate;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Librarian;

public class ZaposleniValidacije {
	

	public static Librarian dodajNovogZaposlenog() {
		return unosPodataka(null);
	}

	public static Librarian izmeniZaposlenog(Librarian zaposleni) {
		return unosPodataka(zaposleni);
	}


	private static Librarian unosPodataka(Librarian zaposleni) {
		Librarian izmenjeniZaposleni = zaposleni;

		// ovo se desava ako smo pozvali kreiranje zaposlenog
		if (izmenjeniZaposleni == null) {
			izmenjeniZaposleni = new Librarian();

			System.out.println("Unesite id zaposlenog: ");
			Integer idZaposlenog = Validation.numberEntry(1, null);
			izmenjeniZaposleni.setId(idZaposlenog);
		}

		System.out.println("Unesite ime novog zaposlenog:");
		String ime = Validation.textEntry(3, null);
		izmenjeniZaposleni.setIme(ime);

		System.out.println("Unesite prezime novog zaposlenog: ");
		String prezime = Validation.textEntry(3, null);
		izmenjeniZaposleni.setPrezime(prezime);

		System.out.println("Unesite datum rodjenja: ");
		LocalDate parsirani = Validation.parsedDate();
		izmenjeniZaposleni.setDatumRodjenja(parsirani);

		System.out.println("Unesite adresu zaposlenog: ");
		String adresa = Validation.textEntry(5, null);
		izmenjeniZaposleni.setAdresa(adresa);

		System.out.println("Unesite broj telefona zaposlenog: ");
		Integer broj = Validation.numberEntry(5, null);
		izmenjeniZaposleni.setBrojTelefona(broj);

		System.out.println("Unesite mejl adresu zaposlenog: ");
		String mejl = Validation.proveraMaila();
		izmenjeniZaposleni.setMail(mejl);

		System.out.println("Unesite broj zdravstvenog: ");
		String brojZdravstvenog = Validation.textEntry(3, null);
		izmenjeniZaposleni.setBrojZdravstvenog(brojZdravstvenog);

		System.out.println("Unesite broj socijalnog: ");
		String brojSocijalnog = Validation.textEntry(3, null);
		izmenjeniZaposleni.setBrojSocijalnog(brojSocijalnog);

		return izmenjeniZaposleni;
	}
}
