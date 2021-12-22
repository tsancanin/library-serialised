package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.Scanner;

public class ClanMeni {

	public static Scanner in = new Scanner(System.in);

	public static void clanMeni() {
		String opcija = null;
		do {
			System.out.println("---Clan meni---");
			System.out.println("1. Ispis svih clanova: ");
			System.out.println("2. Dodaj novog clana: ");
			System.out.println("3. Izmeni postojeceg clana: ");
			System.out.println("4. Obrisi clana: ");
			System.out.println("5. Pretraga clanova po clanskom broju: ");
			System.out.println("6. Pretraga clanova po imenu i prezimenu: ");
			System.out.println(" X - izlaz");

			opcija = in.nextLine();

			switch (opcija) {
			case "1":
				ispisSvihClanova();
				break;
			case "2":
				dodajNovogClana();
				break;
			case "3":
				izmeniPostojecegClana();
				break;
			case "4":
				obrisiClana();
				break;
			case "5":
				pretragaPoClanskomBroju();
				break;
			case "6":
				pretragaPoImenuIprezimenu();
				break;

			default:
				break;
			}

		} while (!opcija.equals("x"));

	}
	
	public static void ispisSvihClanova() {
		System.out.println(" metoda - ispis svih clanova");
	}
	
	public static void dodajNovogClana() {
		System.out.println(" metoda - dodaj novog clana");
	}
	
	public static void izmeniPostojecegClana() {
		System.out.println(" metoda - izmeni postojeceg clana");
	}
	
	public static void obrisiClana() {
		System.out.println(" metoda - obrisi clana ");
	}
	
	public static void pretragaPoClanskomBroju() {
		System.out.println(" metoda - pretraga po clanskom broju");
	}
	
	public static void pretragaPoImenuIprezimenu() {
		System.out.println(" metoda - pretraga po imenu i prezimenu");
	}

}
