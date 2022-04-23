package programming.tamara.library.serialized.ui.util;

import programming.tamara.library.serialized.model.Genres;

public class GenresValidation {
	
	public static Genres selectGenre() {
		
		Genres [] genres = Genres.values();
		
		System.out.println("Pick the number of genres: ");
		for (int i = 0; i < genres.length; i++) {
			System.out.println(i+1+". "+genres[i]);
		}
		Integer choice = Validation.numberEntry(1,genres.length);
		return genres[choice-1];
	}
	
}
