package programming.tamara.library.serialized.ui.util;

import java.util.List;

import programming.tamara.library.serialized.model.Author;
import programming.tamara.library.serialized.model.Library;

public class AuthorValidation {

	public static Author selectAuthor(List<Author> authors) {

		System.out.println("Select the ordinal number of the Author: ");
		for (int i = 0; i < authors.size(); i++) {
			System.out.println(i + 1 + ". " + authors.get(i));
		}
		Integer choice = Validation.numberEntry(1, authors.size());
		return authors.get(choice - 1);
	}

	public static Author addAuthor() {

		System.out.println("Enter id: ");
		int id = Validation.numberEntry(1, null);
		
		System.out.println("Enter the author's name: ");
		String name = Validation.textEntry(3, null);

		System.out.println("Enter the author's surname: ");
		String surname = Validation.textEntry(3, null);
		Author author = new Author(id, name, surname);
		return author;
	}

}
