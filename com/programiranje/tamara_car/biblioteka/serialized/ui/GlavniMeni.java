package programiranje.tamara_car.biblioteka.serialized.ui;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class GlavniMeni {

	public static void ispisBiblioteke(Biblioteka biblioteka) {
		System.out.println("---------------------------");
		System.out.println(biblioteka.getNaziv() + "\n"+biblioteka.getAdresa());
		System.out.println("---------------------------");
	}
	
	public static void glavniMeni(Biblioteka biblioteka) {

		while(true) {
			ispisBiblioteke(biblioteka);
			System.out.println("1. Knjiga meni: ");
			System.out.println("2. Zaposleni meni: ");
			System.out.println("3. Clanovi meni: ");
			System.out.println(" X - izlaz ");

			Integer opcija = Validacije.unosBroja(1, 3);
			if(opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:
				KnjigaMeni.knjigeMeni(biblioteka);
				break;
			case 2:
				ZaposleniMeni.zaposleniMeni(biblioteka);
				break;
			case 3:
				ClanMeni.clanMeni();
				break;

			}
		} 
	}

}
