package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.time.LocalDate;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Zaposleni;

public class ZaposleniValidacije {
	

	public static Zaposleni dodajNovogZaposlenog() {
		return unosPodataka(null);
	}

	public static Zaposleni izmeniZaposlenog(Zaposleni zaposleni) {
		return unosPodataka(zaposleni);
	}


	private static Zaposleni unosPodataka(Zaposleni zaposleni) {
		Zaposleni izmenjeniZaposleni = zaposleni;

		// ovo se desava ako smo pozvali kreiranje zaposlenog
		if (izmenjeniZaposleni == null) {
			izmenjeniZaposleni = new Zaposleni();

			System.out.println("Unesite id zaposlenog: ");
			Integer idZaposlenog = Validacije.unosBroja(1, null);
			izmenjeniZaposleni.setId(idZaposlenog);
		}

		System.out.println("Unesite ime novog zaposlenog:");
		String ime = Validacije.unosTeksta(3, null);
		izmenjeniZaposleni.setIme(ime);

		System.out.println("Unesite prezime novog zaposlenog: ");
		String prezime = Validacije.unosTeksta(3, null);
		izmenjeniZaposleni.setPrezime(prezime);

		System.out.println("Unesite datum rodjenja: ");
		LocalDate parsirani = Validacije.parsiranDatum();
		izmenjeniZaposleni.setDatumRodjenja(parsirani);

		System.out.println("Unesite adresu zaposlenog: ");
		String adresa = Validacije.unosTeksta(5, null);
		izmenjeniZaposleni.setAdresa(adresa);

		System.out.println("Unesite broj telefona zaposlenog: ");
		Integer broj = Validacije.unosBroja(5, null);
		izmenjeniZaposleni.setBrojTelefona(broj);

		System.out.println("Unesite mejl adresu zaposlenog: ");
		String mejl = Validacije.proveraMaila();
		izmenjeniZaposleni.setMail(mejl);

		System.out.println("Unesite broj zdravstvenog: ");
		String brojZdravstvenog = Validacije.unosTeksta(3, null);
		izmenjeniZaposleni.setBrojZdravstvenog(brojZdravstvenog);

		System.out.println("Unesite broj socijalnog: ");
		String brojSocijalnog = Validacije.unosTeksta(3, null);
		izmenjeniZaposleni.setBrojSocijalnog(brojSocijalnog);

		return izmenjeniZaposleni;
	}
}
