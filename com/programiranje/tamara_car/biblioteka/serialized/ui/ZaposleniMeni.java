package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.Scanner;

public class ZaposleniMeni {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void zaposleniMeni() {
		String opcija = null;
		
		do {
			System.out.println("---Zaposleni meni---");
			System.out.println("1. Ispis svih zaposlenih: ");
			System.out.println("2. Dodaj novog zaposlenog: ");
			System.out.println("3. Izmeni postojeceg zaposlenog: ");
			System.out.println("4. Obrisi zaposlenog: ");
			System.out.println("5. Pretraga zaposlenog po id- u: ");
			System.out.println("6. Pretraga zaposlenog po imenu i prezimenu: ");
			System.out.println(" X - izlaz");
			
			opcija = in.nextLine();
			
			switch (opcija) {
			case "1":
				ispisSvihZaposlenih();
				break;
			case "2":
				dodajNovogZaposlenog();
				break;
			case "3":
				izmeniZaposlenog();
				break;
			case "4":
				obrisiZaposlenog();
				break;
			case "5":
				pretragaPoIdu();
				break;
			case "6":
				pretragaPoImenuIprezimenu();
				break;
			default:
				break;
			}
			
		} while (!opcija.equals("x"));
	}
	
	public static void ispisSvihZaposlenih() {
		System.out.println("metoda - ispis svih zaposlenih");
	}
	
	public static void dodajNovogZaposlenog() {
		System.out.println("metoda - dodaj novog zaposlenog");
	}
	
	public static void izmeniZaposlenog() {
		System.out.println("metoda - izmeni zaposlenog");
	}
	
	public static void obrisiZaposlenog() {
		System.out.println("metoda - obrisi zaposlenog");
	}
	public static void pretragaPoIdu() {
		System.out.println("metoda - pretraga po id u");
	}
	
	public static void pretragaPoImenuIprezimenu() {
		System.out.println("metoda - pretragaPoImenuIprezimenu");
	}

}
