package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Librarian;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;
import programiranje.tamara_car.biblioteka.serialized.ui.util.librarianValidation;

public class LibrarianMenu {

	public static void librarianMenu(Library library) {

		while (true) {
			System.out.println("---Librarian menu---");
			System.out.println("1. List all librarian: ");
			System.out.println("2. Add new librarian: ");
			System.out.println("3. Change librarian: ");
			System.out.println("4. Delete librarian: ");
			System.out.println("5. Search librarian by ID: ");
			System.out.println("6. Search librarian by name and surname: ");
			System.out.println(" X - exit");

			Integer option = Validation.numberEntry(1, 6);
			if (option == null) {
				return;
			}
			switch (option) {
			case 1:
				listAllLibrarian(library.getLibrarians());
				break;
			case 2:
				addNewLibrarian(library);
				break;
			case 3: {
				Librarian librarian = searchById(library.getLibrarians());
				if (librarian != null) {
					librarianValidation.changeLibrarian(librarian);
				} else {
					System.out.println("Librarian do not exist.");
				}
				break;
			}
			case 4:
				deleteLibrarian(library);
				break;
			case 5: {
				Librarian searchLibrarian = searchById(library.getLibrarians());
				if (searchLibrarian != null) {
					System.out.println(searchLibrarian);
				} else {
					System.out.println("Librarian do not exist.");
				}
				break;
			}
			case 6: {
				List<Librarian> found = searchByNameAndSurname(library.getLibrarians());
				if (found.isEmpty()) {
					System.out.println("Librarian do not exist.");
				} else {
					for (Librarian librarian : found) {
						System.out.println(librarian);
					}
				}
				break;
			}
			}
		}
	}

	public static void listAllLibrarian(List<Librarian> librarian) {
		for (Librarian foundLibrarian : librarian) {
			System.out.println(foundLibrarian);
		}
	}

	public static void addNewLibrarian(Library library) {

		Librarian librarian = librarianValidation.addNewLibrarian();
		do {
			boolean found = false;
			for (Librarian current : library.getLibrarians()) {
				found = current.getId() == librarian.getId();
				if (found)
					break;
			}
			if (found) {
				System.out.println("ID is taken.Enter new ID: ");
				Integer newId = Validation.numberEntry(1, null);
				librarian.setId(newId);
			} else {
				break;
			}
		} while (true);
		library.getLibrarians().add(librarian);
		System.out.println("Librarian is added!");

	}

	public static Librarian searchById(List<Librarian> librarian) {
		System.out.println("Enter librarian ID: ");
		Integer idLibrarian = Validation.numberEntry(1, null);

		for (Librarian foundLibrarian : librarian) {
			if (foundLibrarian.getId() == idLibrarian) {
				return foundLibrarian;
			}
		}
		return null;
	}

	public static List<Librarian> searchByNameAndSurname(List<Librarian> librarian) {

		System.out.println("Enter the search text: ");
		String text = Validation.textEntry(3, null);

		List<Librarian> found = new ArrayList<Librarian>();

		for (Librarian foundLibrarian : librarian) {
			if (foundLibrarian.getName().toLowerCase().contains(text.toLowerCase())
					|| foundLibrarian.getSurname().toLowerCase().contains(text.toLowerCase())) {
				found.add(foundLibrarian);
			}
		}
		return found;

	}

	public static Librarian pickLibrarian(List<Librarian> librarian) {

		System.out.println("1. Search librarian by ID: ");
		System.out.println("2. Search librarian by name and surname: ");

		Integer option = Validation.numberEntry(1, 2);
		if (option == 1) {
			return searchById(librarian);
		} else {
			return pickLibrarianByNameAndSurname(librarian);
		}

	}

	public static Librarian pickLibrarianByNameAndSurname(List<Librarian> librarian) {

		List<Librarian> found = searchByNameAndSurname(librarian);

		for (int i = 0; i < found.size(); i++) {
			System.out.println(i + 1 + ". " + found.get(i));
		}

		System.out.println(" Pick librarian (enter the number): ");
		Integer selection = Validation.numberEntry(1, found.size());

		return found.get(selection - 1);
	}

	public static void deleteLibrarian(Library library) {
		Librarian found = pickLibrarian(library.getLibrarians());

		if (found == null) {
			System.out.println("Librarian not found.");
		} else {
			library.getLibrarians().remove(found);
		}
	}

}
