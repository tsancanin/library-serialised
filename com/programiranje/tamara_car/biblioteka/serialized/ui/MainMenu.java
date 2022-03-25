package programiranje.tamara_car.biblioteka.serialized.ui;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga.PozajmiceMeni;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class MainMenu {

	public static void ispisBiblioteke(Library biblioteka) {
		System.out.println("---------------------------");
		System.out.println(biblioteka.getNaziv() + "\n"+biblioteka.getAdresa());
		System.out.println("---------------------------");
	}
	
	public static void mainMenu(Library biblioteka) {

		while(true) {
			ispisBiblioteke(biblioteka);
			System.out.println("1. Knjiga meni: ");
			System.out.println("2. Evidencija knjiga: ");
			System.out.println("3. Autor meni: ");
			System.out.println("4. Zaposleni meni: ");
			System.out.println("5. Clanovi meni: ");
			System.out.println(" X - izlaz ");
 
			Integer opcija = Validation.numberEntry(1, 6);
			if(opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:
				KnjigaMeni.knjigeMeni(biblioteka);
				break;
			case 2:
				PozajmiceMeni.pozajmiceMeni(biblioteka);
				break;
			case 3:
				AuthorMenu.autorMeni(biblioteka);
				break;
			case 4:
				ZaposleniMeni.zaposleniMeni(biblioteka);
				break;
			case 5:
				ClanMeni.clanMeni(biblioteka);
				break;
			}
		} 
	}

}
