package programiranje.tamara_car.biblioteka.serialized;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import programiranje.tamara_car.biblioteka.serialized.model.Biblioteka;
import programiranje.tamara_car.biblioteka.serialized.ui.GlavniMeni;

public class Main {

	private static final String IME_FAJLA = "biblioteka.ser";

	public static void main(String[] args) {
		Biblioteka biblioteka = ucitavanjeBiblioteke();
		GlavniMeni.glavniMeni(biblioteka);
		cuvanjeBiblioteke(biblioteka);
	}

	private static Biblioteka ucitavanjeBiblioteke() {
		Biblioteka biblioteka = new Biblioteka();

		try (FileInputStream fis = new FileInputStream(IME_FAJLA);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			biblioteka = (Biblioteka) ois.readObject();
		} catch (IOException ioe) {
			System.out.println("Fajl " + IME_FAJLA + " nije pronadjen");
			System.out.println("Inicijalizuje se nova biblioteka");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Greska u ucitavanju biblioteke");
			System.out.println("Inicijalizuje se nova biblioteka");
		}
		return biblioteka;
	}
	
	private static void cuvanjeBiblioteke(Biblioteka biblioteka) {
		try (
			FileOutputStream fos = new FileOutputStream(IME_FAJLA); 
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
	      oos.writeObject(biblioteka);
	    } catch (IOException ioe) {
	      System.out.println("Problem u cuvanju biblioteke");
	      ioe.printStackTrace();
	    }
	}

}
