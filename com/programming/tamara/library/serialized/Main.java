package programming.tamara.library.serialized;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import programming.tamara.library.serialized.model.Library;
import programming.tamara.library.serialized.ui.MainMenu;
import programming.tamara.library.serialized.util.DataBaseConnection;

public class Main {

	private static final String FILE_NAME = "library.ser";

	public static void main(String[] args) {
		
		DataBaseConnection.connectingWithBase();
		
		Library library = loadingLibrary();
		MainMenu.mainMenu(library);
		saveLibrary(library);
	}

	private static Library loadingLibrary() {
		Library library = new Library();

		try (FileInputStream fis = new FileInputStream(FILE_NAME);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			library = (Library) ois.readObject();
		} catch (IOException ioe) {
			System.out.println("File " + FILE_NAME + " not found");
			System.out.println("A new library is initialized");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading library");
			System.out.println("A new library is initialized");
		}
		return library;
	}
	
	private static void saveLibrary(Library library) {
		try (
			FileOutputStream fos = new FileOutputStream(FILE_NAME); 
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
	      oos.writeObject(library);
	    } catch (IOException ioe) {
	      System.out.println("Error loading library.");
	      ioe.printStackTrace();
	    }
	}

}
