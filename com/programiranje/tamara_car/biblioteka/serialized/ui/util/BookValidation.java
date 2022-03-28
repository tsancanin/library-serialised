package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Author;
import programiranje.tamara_car.biblioteka.serialized.model.Book;
import programiranje.tamara_car.biblioteka.serialized.model.Genres;

public class BookValidation {
	public static Book addBook(Integer id,List<Author>authors) {
		Integer bookId = id;
		if(bookId==null) {
			System.out.println("Enter book ID: ");
			 bookId = Validation.numberEntry(1,null);
		}
		System.out.println("Enter book title: ");
		String bookTitle = Validation.textEntry(1, 250);
		
		Author author = AuthorValidation.selectAuthor(authors);
		
		Genres genre = GenresValidation.selectGenre();
		
		System.out.println("Number of copy in library: ");
		Integer bumberOfbooks = Validation.numberEntry(1, null);
		
		return new Book(bookId, bookTitle, author, genre, bumberOfbooks);
	}
	
	
	
}
