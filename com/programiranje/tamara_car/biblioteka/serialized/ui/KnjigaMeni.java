package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import programiranje.tamara_car.biblioteka.serialized.model.Autor;
import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.EvidencijaKnjiga;
import programiranje.tamara_car.biblioteka.serialized.model.Knjiga;
import programiranje.tamara_car.biblioteka.serialized.model.Zanrovi;
import programiranje.tamara_car.biblioteka.serialized.ui.util.OdabirZanra;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class KnjigaMeni {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void knjigeMeni(Biblioteka biblioteka) {
		
		while(true) {
			
			System.out.println("---Knjige meni---");
			System.out.println("1.Ispisi sve knjige: ");
			System.out.println("2.Dodaj knjigu: ");
			System.out.println("3.Obrisi knjigu: ");
			System.out.println("4.Izmeni knjigu: ");
			System.out.println("5.Pretraga knjige po id-u: ");
			System.out.println("6.Pretraga knjige po nazivu: ");
			System.out.println("7.Pretraga knjige po zanru: ");
			System.out.println("8.Pretraga knjige po autoru: ");
			System.out.println(" X izlaz ");
			
		Integer	opcija = Validacije.unosBroja(1, 8);
			
			if(opcija == null) {
				return;
			}
			
			switch (opcija) {
			case 1:
				ispisiSveKnjige(biblioteka);
				break;
			case 2:
				dodajKnjigu(biblioteka);
				break;
			case 3:
				obrisiKnjigu();
				break;
			case 4:
				izmeniKnjigu();
				break;
			case 5:
				pretragaPoIdu(biblioteka);
				break;
			case 6:
				pretragaNazivu(biblioteka);
				break;
			case 7:
				pretragaPoZanru();
				break;
			case 8:
				pretragaPoAutoru(biblioteka);
				break;
			}
			
		} 
		
	}
	
	public static void ispisiSveKnjige(Biblioteka biblioteka) {
		for (Map.Entry<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> zanr : biblioteka.getSveKnjige().entrySet()) {
		    Zanrovi zanrovi = zanr.getKey();
		    System.out.println("t"+zanrovi);
		    HashMap<Autor, ArrayList<Knjiga>> autor = zanr.getValue();
		    System.out.println("t"+autor);
			for (ArrayList<Knjiga> knjige : autor.values()) {
				for (Knjiga knjiga : knjige) {
					System.out.println("t"+knjiga);
				}
			}
		}
	}
	
	public static void dodajKnjigu(Biblioteka biblioteka) {
		
		
		
		
		
	}
	
	public static void obrisiKnjigu() {
		System.out.println(" metoda - obrisi knjigu");
	}
	
	public static void izmeniKnjigu() {
		System.out.println(" metoda - izmeni knjigu");
	}
	
	public static void pretragaPoIdu(Biblioteka biblioteka) {
		
	}
	
	public static void pretragaNazivu(Biblioteka biblioteka) {
		
	}
	
	public static void pretragaPoZanru() {
		OdabirZanra.odabirZanra();
	}
	
	public static void pretragaPoAutoru(Biblioteka biblioteka) {
		System.out.println("Unesite ime i prezime autora: ");
		String ime = in.nextLine();
		String prezime = in.nextLine();
		for (Autor autor : biblioteka.getAutori()) {
			if(autor.getIme().equals(ime) && autor.getPrezime().equals(prezime)) {
				System.out.println(autor);
			}else {
				System.out.println("Autor ne postoji");
			}
		}
	}
	
}
