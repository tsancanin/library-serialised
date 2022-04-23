package programming.tamara.library.serialized.model;

import java.io.Serializable;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 520243975431957223L;
	private int idBook;
	private String title;
	private Author author;
	private Genres genre;
	private int numberOfBooks;

	public Book(int idBook, String title, Author author, Genres genre, int numberOfBooks) {
		this.idBook = idBook;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.numberOfBooks = numberOfBooks;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Genres getGenre() {
		return genre;
	}

	public void setGenre(Genres genre) {
		this.genre = genre;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n**************************");
		sb.append("\n Book ID:" + idBook);
		sb.append("\n Title: "+ title);
		sb.append("\n "+ author);
		sb.append("\n Genre: "+ genre);
		sb.append("\n Number of books: "+numberOfBooks);
		sb.append("\n **************************");
		
		return sb.toString();
	}

}
