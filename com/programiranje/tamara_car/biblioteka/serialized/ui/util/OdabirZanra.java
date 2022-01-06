package programiranje.tamara_car.biblioteka.serialized.ui.util;

import programiranje.tamara_car.biblioteka.serialized.model.Zanrovi;

public class OdabirZanra {
	
	public static void odabirZanra() {
		
		for(Zanrovi zanr: Zanrovi.values()) {
			System.out.println(zanr);
		}
		
	}
	
}
