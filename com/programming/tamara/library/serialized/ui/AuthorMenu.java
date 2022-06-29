package programming.tamara.library.serialized.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import programming.tamara.library.serialized.model.Author;
import programming.tamara.library.serialized.model.Library;
import programming.tamara.library.serialized.service.AuthorService;
import programming.tamara.library.serialized.ui.util.AuthorValidation;
import programming.tamara.library.serialized.ui.util.Validation;

public class AuthorMenu {
	public static Scanner in = new Scanner(System.in);

	public static void autorMeni(Library library) {

		while (true) {
			System.out.println("-----Author menu------");
			System.out.println("1.List all authors: ");
			System.out.println("2.Add new author: ");
			System.out.println("3.Delete author: ");
			System.out.println("4.Search by name and surname: ");
			System.out.println("5.Search by ID: ");
			System.out.println(" X - exit ");

			Integer option = Validation.numberEntry(1, 5);

			if (option == null) {
				return;
			}

			switch (option) {
			case 1:
				listAllAuthor(library);
				break;
			case 2:
				addAuthor(library);
				break;
			case 3:
				deleteAuthor(library);
				break;
			case 4: {
				List<Author> searchedAuthor = searchByNameAndSurname(library.getAuthors());
				if (searchedAuthor.size() > 0) {
					for (Author author : searchedAuthor) {
						System.out.println(author);
					}
				} else {
					System.out.println("The author was not found.");
				}
				break;
			}
			case 5: {
				Author searchedAuthor = searchById(library.getAuthors());
				if (searchedAuthor != null) {
					System.out.println(searchedAuthor);
				} else {
					System.out.println("Author does not exist whith this ID.");
				}
				break;
			}
			}
		}
	}

	public static void listAllAuthor(Library library) {
		System.out.println("List of Autors: ");
		try {
			for (Author author : AuthorService.findAll()) {
				System.out.println(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while listing authors.");
		}
	}

	public static void addAuthor(Library library) {
		// ucitaj sve o autoru sa tastature
		Author author = AuthorValidation.addAuthor();
		do {
			// pretpostavi da je trenutni id ok
			boolean found = false;

			// prodji kroz sve autore
			for (Author current : library.getAuthors()) {
				// ako je id zapravo zauzet, zapamti to u "nadjen"
				found = current.getId() == author.getId();
				if (found)
					break;
			}

			if (found) {
				// ako je id nadjen (zauzet), unesi novi id, i setuj ga autoru koga je korisnik
				// vec uneo
				// ovo izbegava scenario da mora ponovo da unosi celog autora
				System.out.println("Id is taken. Enter new id");
				Integer newId = Validation.numberEntry(1, null);

				author.setId(newId);
				// u if grani nema break, sto znaci da ces se wratiti u do-while
			} else {
				// ako id nije nadjen (slobodan je) izadji iz celog ovog do-while-a
				break;
			}
		} while (true);// radi dokle god id nije tacan

		// ovde sigurno imas valjanog autora sa dobrim id-em, pa mozes bezbedno da ga
		// dodas
		library.getAuthors().add(author);
		System.out.println("Author is added.");

	}

	public static void deleteAuthor(Library library) {
		System.out.println("Enter author's ID:");
		int id = Validation.numberEntry(1, null);

		boolean found = false;
		for (Author forDelete : library.getAuthors()) {
			if (forDelete.getId() == id) {
				library.getAuthors().remove(forDelete);
				System.out.println("Author is deleted.");
				return;
			}

		}
		if (!found) {
			System.out.println("The author was not found.");
		}
	}

	public static List<Author> searchByNameAndSurname(List<Author> authors) {
		System.out.println("Enter the search text: ");
		String entry = Validation.textEntry(3, null);

		List<Author> newList = new ArrayList<Author>();
		for (Author author : authors) {
			if (author.getName().toLowerCase().contains(entry) || author.getSurname().toLowerCase().contains(entry)) {
				newList.add(author);
			}
		}
		return newList;

	}

	public static Author searchById(List<Author> authors) {
		System.out.println("Enter ID: ");
		int id = Validation.numberEntry(1, null);

		for (Author author : authors) {
			if (author.getId() == id) {
				return author;
			}
		}

		return null;

	}

}
