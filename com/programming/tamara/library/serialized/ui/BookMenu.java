package programming.tamara.library.serialized.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import programming.tamara.library.serialized.model.Author;
import programming.tamara.library.serialized.model.Book;
import programming.tamara.library.serialized.model.Genres;
import programming.tamara.library.serialized.model.Library;
import programming.tamara.library.serialized.ui.util.AuthorValidation;
import programming.tamara.library.serialized.ui.util.BookValidation;
import programming.tamara.library.serialized.ui.util.GenresValidation;
import programming.tamara.library.serialized.ui.util.Validation;

public class BookMenu {

	public static Scanner in = new Scanner(System.in);

	public static void bookMenu(Library library) {

		while (true) {

			System.out.println("---BOOK MENU---");
			System.out.println("1.List all books: ");
			System.out.println("2.Add new book: ");
			System.out.println("3.Delete book: ");
			System.out.println("4.Change the title: ");
			System.out.println("5.Change the number of copies: ");
			System.out.println("6.Change genre: ");
			System.out.println("7.Change author: ");
			System.out.println("8.Search by ID: ");
			System.out.println("9.Search by title: ");
			System.out.println("10.Search by genre: ");
			System.out.println("11.Search by author: ");
			System.out.println(" X exit ");

			Integer option = Validation.numberEntry(1, 11);

			if (option == null) {
				return;
			}

			switch (option) {
			case 1:
				listAllBooks(library.getListOfBooks());
				break;
			case 2:
				addBook(library);
				break;
			case 3:
				deleteBook(library);
				break;
			case 4:
				changeTitle(library);
				break;
			case 5:
				changeNumberOfCopies(library);
				break;
			case 6:
				changeGenre(library);
				break;
			case 7:
				changeAuthor(library);
				break;
			case 8: {

				Book book = searchById(library.getListOfBooks());
				if (book == null) {
					System.out.println("Book's not exist.");
				} else {
					System.out.println(book);
				}
				break;
			}
			case 9: {
				List<Book> searchBook = searchByTitle(library.getListOfBooks());
				if (searchBook.isEmpty()) {
					System.out.println("Book's not exist.");
				} else {
					System.out.println(searchBook);
				}
				break;
			}
			case 10: {
				List<Book> searchBooks = searchByGenre(library.getListOfBooks());
				if (searchBooks.isEmpty()) {
					System.out.println("Book's not exist.");
				} else {
					System.out.println(searchBooks);
				}
				break;
			}
			case 11: {
				List<Book> searchBooks = searchByAuthor(library.getListOfBooks(), library.getAuthors());
				if (searchBooks.isEmpty()) {
					System.out.println("Book's not exist.");
				} else {
					System.out.println(searchBooks);
				}
				break;
			}
			}

		}

	}

	public static void listAllBooks(List<Book> books) {
		for (int i = 0; i < books.size(); i++) {
			System.out.println(i + 1 + ". " + books.get(i));
		}
	}

	public static void addBook(Library library) {

		Book book = BookValidation.addBook(null, library.getAuthors());// ui
		do {
			boolean found = false;
			for(Book curent: library.getListOfBooks()) {
				found = curent.getIdBook() == book.getIdBook();
				if(found)
					break;
			}
			if(found) {
				System.out.println("Id is taken. Enter new id");
				Integer newId = Validation.numberEntry(1, null);
				book.setIdBook(newId);
			}else
				break;
		} while (true);
		
		addingAbook(library.getAllBooks(), book);
		System.out.println("Book is added.");// ui

	}

	public static void deleteBook(Library biblioteka) {
		Book selectedBook = bookSelectionSearch(biblioteka.getListOfBooks(),biblioteka.getAuthors());
		if (selectedBook == null) {
			System.out.println("Book is not found.");
			return;
		}
		removingBook(biblioteka.getAllBooks(), selectedBook);
		
		System.out.println("Book is deleted.");
	}
	
	public static void removingBook(HashMap<Genres, HashMap<Author, ArrayList<Book>>> allBook, Book selectedBook) {
		
		HashMap<Author, ArrayList<Book>> authorFromeGenre = allBook.get(selectedBook.getGenre());
		ArrayList<Book> booksByAuthor = authorFromeGenre.get(selectedBook.getAuthor());
			
		booksByAuthor.remove(selectedBook);
			
		if (booksByAuthor.isEmpty()) {
			authorFromeGenre.remove(selectedBook.getAuthor());
		}
		if (authorFromeGenre.isEmpty()) {
			allBook.remove(selectedBook.getGenre());
		}
	}
	
	public static void addingAbook(HashMap<Genres, HashMap<Author, ArrayList<Book>>> allBooks, Book selectedBook) {
		
		if (!allBooks.containsKey(selectedBook.getGenre())) {
			HashMap<Author, ArrayList<Book>> newAuthor = new HashMap<Author, ArrayList<Book>>();
			allBooks.put(selectedBook.getGenre(), newAuthor);
		}
		
		HashMap<Author, ArrayList<Book>> authorFromeGenre = allBooks.get(selectedBook.getGenre());
		
		if (!authorFromeGenre.containsKey(selectedBook.getAuthor())) {
			authorFromeGenre.put(selectedBook.getAuthor(), new ArrayList<Book>());
		}
		
		ArrayList<Book> booksByAuthor = authorFromeGenre.get(selectedBook.getAuthor());
		booksByAuthor.add(selectedBook);

	}

	public static void changeTitle(Library library) {
		Book selectedBook = bookSelectionSearch(library.getListOfBooks(), library.getAuthors());
		if (selectedBook == null) {
			System.out.println("Book's not found.");
			return;
		}

		System.out.println("Enter new title: ");
		String newTitle = Validation.textEntry(3, null);
		selectedBook.setTitle(newTitle);
		System.out.println("Title's changed.");
	}

	public static void changeNumberOfCopies(Library library) {
		Book selectedBook = bookSelectionSearch(library.getListOfBooks(), library.getAuthors());
		if (selectedBook == null) {
			System.out.println("Book's not found.");
			return;
		}
		System.out.println("Enter new number of copies: ");
		Integer nombersOfCopies = Validation.numberEntry(1, null);
		selectedBook.setNumberOfBooks(nombersOfCopies);
		System.out.println("Number of copies is changed.");

		
	}

	public static void changeGenre(Library library) {
		Book selectedBook = bookSelectionSearch(library.getListOfBooks(), library.getAuthors());
		if (selectedBook == null) {
			System.out.println("Book's not found.");
			return;
		}
		Genres newGenre = GenresValidation.selectGenre();
		removingBook(library.getAllBooks(), selectedBook);
		selectedBook.setGenre(newGenre);
		addingAbook(library.getAllBooks(), selectedBook);
		System.out.println("Genre is changed.");
		
	}

	public static void changeAuthor(Library library) {
		Book selectedBook = bookSelectionSearch(library.getListOfBooks(), library.getAuthors());
		if (selectedBook == null) {
			System.out.println("Book's not found.");
			return;
		}
		Author newAuthor = AuthorValidation.selectAuthor(library.getAuthors());
		removingBook(library.getAllBooks(), selectedBook);
		selectedBook.setAuthor(newAuthor);
		addingAbook(library.getAllBooks(), selectedBook);
		System.out.println("Author is changed.");

		
	}

	public static Book searchById(List<Book> books) {
		System.out.println("Enter book ID:");
		Integer id = Validation.numberEntry(1, null);
		for (Book book : books) {
			if (book.getIdBook() == id) {
				return book;
			}
		}

		return null;
	}

	public static List<Book> searchByTitle(List<Book> books) {
		System.out.println("Enter book title: ");
		String bookTitle = Validation.textEntry(3, null);

		ArrayList<Book> searchedBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(bookTitle.toLowerCase())) {
				searchedBooks.add(book);

			}

		}
		return searchedBooks;
	}

	public static List<Book> searchByGenre(List<Book> books) {
		Genres selected = GenresValidation.selectGenre();// ui

		// servisni sloj
		ArrayList<Book> searchedBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getGenre().equals(selected)) {
				searchedBooks.add(book);
			}
		}

		return searchedBooks;

//		// ui
//		if (trazeneKnjige.size() < 1) {
//			System.out.println("Nema knjiga trazenog zanra");
//			return null;
//		}

	}

	public static List<Book> searchByAuthor(List<Book> books, List<Author> authors) {
		Author selectedAuthor = AuthorValidation.selectAuthor(authors);

		ArrayList<Book> searchedBooks = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getAuthor().getId() == selectedAuthor.getId()) {
				searchedBooks.add(book);
			}
		}
		return searchedBooks;

	}

	public static Book bookSelectionSearch(List<Book> books, List<Author> authors) {
		while (true) {
			System.out.println("1. Search book by ID: ");
			System.out.println("2. Search book by genre: ");
			System.out.println("3. Search book by title: ");
			System.out.println("4. Search book by author:");
			System.out.println("   Enter search number: ");
			System.out.println(" x exit");

			Integer option = Validation.numberEntry(1, 4);
			if (option == null) {
				return null;
			}
			switch (option) {
			case 1: {
				Book searchBook = searchById(books);
				return searchBook;
			}
			case 2: {
				List<Book> searchBooks = searchByGenre(books);
				Book foundBook = selectBook(searchBooks);
				return foundBook;
			}
			case 3: {
				List<Book> searchBooks = searchByTitle(books);
				Book foundBook = selectBook(searchBooks);
				return foundBook;
			}
			case 4: {
				List<Book> searchBooks = searchByAuthor(books, authors);
				Book foundBook = selectBook(searchBooks);
				return foundBook;
			}
			}
		}
	}

	public static Book selectBook(List<Book> books) {
		listAllBooks(books);
		System.out.println("Enter search number: ");
		Integer choice = Validation.numberEntry(1, books.size());
		return books.get(choice - 1);
	}

}
