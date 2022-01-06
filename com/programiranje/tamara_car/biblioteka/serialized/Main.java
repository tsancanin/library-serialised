package programiranje.tamara_car.biblioteka.serialized;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.ui.GlavniMeni;

public class Main {

	public static void main(String[] args) {
		 Biblioteka biblioteka = new Biblioteka(); 
		 GlavniMeni.glavniMeni(biblioteka);

	}

}
