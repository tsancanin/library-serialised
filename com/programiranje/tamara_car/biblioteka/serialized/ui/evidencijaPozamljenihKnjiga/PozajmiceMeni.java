package programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class PozajmiceMeni {

	public static void pozajmiceMeni(Biblioteka biblioteka) {
		while (true) {
			System.out.println("----Upravljanje pozajmicama----");
			System.out.println("1.Listaj sve pozajmice ");
			System.out.println("2.Listaj pozajmice po clanu ");
			System.out.println("3.Kreiraj novu pozajmicu ");
			System.out.println("4.Razduzi pozajmicu ");
			System.out.println(" x izlaz ");

			Integer opcija = Validacije.unosBroja(1, 4);
			if (opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:

				break;
			case 2:
			
			default:
				break;
			}

		}
	}
	
	
	
	
	
	
	
}
