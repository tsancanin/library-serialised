package programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.model.Pozajmica;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validacije;

public class DodavanjePozajmiceMeni {

	public static void kreirajNovoZaduzenje(Biblioteka biblioteka) {
		
		while (true) {
			System.out.println("1. Dodaj knjigu u iznamljene: ");
			System.out.println("2. Obrisi knjigu: ");
			System.out.println("3. Ponisti iznamljivanje: ");
			System.out.println("4. Promeni zaposlenog i clana: ");
			System.out.println("5. Izmeni duzinu trajanja pozajmice: ");
			System.out.println("6. Zakljuci izdavanje: ");
			System.out.println(" x izadji ");

			Integer opcija = Validacije.unosBroja(1, 6);

			if (opcija == null) {
				return;
			}
			switch (opcija) {
			case 1:

				break;

			default:
				break;
			}
		}
	}
	
	private static Pozajmica unosPodataka(Biblioteka biblioteka) {
		
		
		return null;
	}
	
	
	

}
