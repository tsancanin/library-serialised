package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.Scanner;

public class GlavniMeni {

	public static Scanner in = new Scanner(System.in);

	public static void glavniMeni() {
		String opcija = null;

		do {
			System.out.println("*******BIBLIOTEKA*******");
			System.out.println("1. Knjiga meni: ");
			System.out.println("2. Zaposleni meni: ");
			System.out.println("3. Clanovi meni: ");
			System.out.println(" X - izlaz ");

			opcija = in.nextLine();

			switch (opcija) {
			case "1":
				KnjigaMeni.knjigeMeni();
				break;
			case "2":
				ZaposleniMeni.zaposleniMeni();
				break;
			case "3":
				ClanMeni.clanMeni();
				break;

			}
		} while (!opcija.equals("x"));
	}

}
