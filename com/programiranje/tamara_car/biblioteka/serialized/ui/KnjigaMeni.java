package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.Scanner;



public class KnjigaMeni {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void knjigeMeni() {
		
		String opcija = null;
		do {
			
			System.out.println("---Knjige meni---");
			System.out.println("1.Ispisi sve knjige: ");
			System.out.println("2.Dodaj knjigu: ");
			System.out.println("3.Obrisi knjigu: ");
			System.out.println("4.Izmeni knjigu: ");
			System.out.println("5.Pretraga knjige po id-u: ");
			System.out.println("6.Pretraga knjige po nazivu: ");
			System.out.println("7. Pretraga knjige po zanru: ");
			System.out.println("8.Pretraga knjige po autoru: ");
			System.out.println(" X izlaz ");
			
			opcija = in.nextLine();
			
			switch (opcija) {
			case "1":
				ispisiSveKnjige();
				break;
			case "2":
				dodajKnjigu();
				break;
			case "3":
				obrisiKnjigu();
				break;
			case "4":
				izmeniKnjigu();
				break;
			case "5":
				pretragaPoIdu();
				break;
			case "6":
				pretragaNazivu();
				break;
			case "7":
				pretragaPoZanru();
				break;
			case "8":
				pretragaPoAutoru();
				break;
			default:
				break;
			}
			
		} while (!opcija.equals("x"));
		
	}
	
	public static void ispisiSveKnjige() {
		System.out.println("metoda -ispisi sve knjige");
	}
	
	public static void dodajKnjigu() {
		System.out.println("metoda - dodaj knjigu");
	}
	
	public static void obrisiKnjigu() {
		System.out.println(" metoda - obrisi knjigu");
	}
	
	public static void izmeniKnjigu() {
		System.out.println(" metoda - izmeni knjigu");
	}
	
	public static void pretragaPoIdu() {
		System.out.println("metoda - pretraga po id u");
	}
	
	public static void pretragaNazivu() {
		System.out.println("metoda - pretraga po nazivu");
	}
	
	public static void pretragaPoZanru() {
		System.out.println("metoda - pretraga po zanru");
	}
	
	public static void pretragaPoAutoru() {
		System.out.println("metoda - pretraga po autoru");
	}
	
}
