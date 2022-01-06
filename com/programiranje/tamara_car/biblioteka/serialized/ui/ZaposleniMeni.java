package programiranje.tamara_car.biblioteka.serialized.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Zaposleni;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class ZaposleniMeni {
	public static Scanner in = new Scanner(System.in);
	
	public static void zaposleniMeni(Biblioteka biblioteka) {
		
		while(true) {
			System.out.println("---Zaposleni meni---");
			System.out.println("1. Ispis svih zaposlenih: ");
			System.out.println("2. Dodaj novog zaposlenog: ");
			System.out.println("3. Izmeni postojeceg zaposlenog: ");
			System.out.println("4. Obrisi zaposlenog: ");
			System.out.println("5. Pretraga zaposlenog po id- u: ");
			System.out.println("6. Pretraga zaposlenog po imenu i prezimenu: ");
			System.out.println(" X - izlaz");
			
		Integer	opcija = Validacije.unosBroja(1, 6);
			if(opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:
				ispisSvihZaposlenih(biblioteka);
				break;
			case 2:
				dodajNovogZaposlenog(biblioteka);
				break;
			case 3:
				izmeniZaposlenog(biblioteka);
				break;
			case 4:
				obrisiZaposlenog(biblioteka);
				break;
			case 5:
				pretragaPoIdu(biblioteka);
				break;
			case 6:
				pretragaPoImenuIprezimenu(biblioteka);
				break;
			}
			
		}
	}
	
	public static void ispisSvihZaposlenih(Biblioteka biblioteka) {
		for(Zaposleni zaposleni : biblioteka.getZaposleni()) {
			System.out.println(zaposleni);
		}
	}
	
	public static void dodajNovogZaposlenog(Biblioteka biblioteka) {
		
		System.out.println("Unesite id zaposlenog: ");
		int idZaposlenog = Integer.parseInt(in.nextLine());
		
		for(Zaposleni zaposleni: biblioteka.getZaposleni()) {
			while(zaposleni.getId()==idZaposlenog) {
				idZaposlenog = Integer.parseInt(in.nextLine());
			}
		}
		
		System.out.println("Unesite ime novog zaposlenog:");
		String ime = in.nextLine();
		
		System.out.println("Unesite prezime novog zaposlenog: ");
		String prezime = in.nextLine();
		
		System.out.println("Unesite datum rodjenja: ");
		String datum = in.nextLine();
		LocalDate parsirani =Validacije.parsiranDatum(datum);
		
		System.out.println("Unesite adresu zaposlenog: ");
		String adresa = in.nextLine();
		
		System.out.println("Unesite broj telefona zaposlenog: ");
		Integer broj = Integer.parseInt(in.nextLine());
		
		System.out.println("Unesite mejl adresu zaposlenog: ");
		String mejl = Validacije.proveraMaila();
		
		System.out.println("Unesite broj zdravstvenog: ");
		String brojZdravstvenog = in.nextLine();
		
		System.out.println("Unesite broj socijalnog: ");
		String brojSocijalnog = in.nextLine();
		
		
		Zaposleni noviZaposleni = new Zaposleni(idZaposlenog, prezime, ime, parsirani, adresa, broj, mejl, brojZdravstvenog, brojSocijalnog);
		
		biblioteka.getZaposleni().add(noviZaposleni);
		System.out.println("Novi zaposleni je uspesno dodat!");
		
		
	}
	
	public static void izmeniZaposlenog(Biblioteka biblioteka) {
		System.out.println("Unesite id zaposlenog: ");
		int idZaposlenog = Integer.parseInt(in.nextLine());
		
		for(Zaposleni zaposleni: biblioteka.getZaposleni()) {
			while(zaposleni.getId()==idZaposlenog) {
				idZaposlenog = Integer.parseInt(in.nextLine());
			}
		}
		
		
		
	}
	
	public static void obrisiZaposlenog(Biblioteka biblioteka) {
		System.out.println("metoda - obrisi zaposlenog");
	}
	public static void pretragaPoIdu(Biblioteka biblioteka) {
		System.out.println("Unesite id zaposlenog: ");
		int idZaposlenog = Integer.parseInt(in.nextLine());
		
		for(Zaposleni zaposleni: biblioteka.getZaposleni()) {
			if(zaposleni.getId()==idZaposlenog) {
				System.out.println(zaposleni);
			}
		}
	}
	
	public static void pretragaPoImenuIprezimenu(Biblioteka biblioteka) {
		System.out.println("Unesite ime novog zaposlenog:");
		String ime = in.nextLine();
		
		System.out.println("Unesite prezime novog zaposlenog: ");
		String prezime = in.nextLine();
		
		for(Zaposleni zaposleni: biblioteka.getZaposleni()) {
			if(zaposleni.getIme().equals(ime) && zaposleni.getPrezime().equals(prezime)) {
				System.out.println(zaposleni);
			}
		}
	}

}
