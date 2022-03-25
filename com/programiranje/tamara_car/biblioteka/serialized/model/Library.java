package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554186585819634614L;

	private String name = "Gradska biblioteka Novi Sad";
	private String address = "Dunavska br.1";

	private ArrayList<Author> authors = new ArrayList<Author>();
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<Librarian> librarians = new ArrayList<Librarian>();
	private ArrayList<Loan> loanRecords = new ArrayList<Loan>();
	private HashMap<Genres, HashMap<Author, ArrayList<Book>>> allBooks = new HashMap<Genres, HashMap<Author, ArrayList<Book>>>();

	public Library() {
	}

	public Library(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getNaziv() {
		return name;
	}

	public void setNaziv(String name) {
		this.name = name;
	}

	public String getAdresa() {
		return address;
	}

	public void setAdresa(String address) {
		this.address = address;
	}

	public ArrayList<Author> getAuthor() {
		return authors;
	}

	public void setAuthor(ArrayList<Author> authors) {
		this.authors = authors;
	}

	public ArrayList<Member> getMember() {
		return members;
	}

	public void setMember(ArrayList<Member> members) {
		this.members = members;
	}

	public ArrayList<Librarian> getZaposleni() {
		return librarians;
	}

	public void setZaposleni(ArrayList<Librarian> librarians) {
		this.librarians = librarians;
	}

	public ArrayList<Loan> getLoan() {
		return loanRecords;
	}

	public void setLoan(ArrayList<Loan> loan) {
		this.loanRecords = loan;
	}

	public HashMap<Genres, HashMap<Author, ArrayList<Book>>> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(HashMap<Genres, HashMap<Author, ArrayList<Book>>> allBooks) {
		this.allBooks = allBooks;
	}

	public List<Book> getListOfBooks() {
		ArrayList<Book> requiredBooks = new ArrayList<Book>();
		for (Map.Entry<Genres, HashMap<Author, ArrayList<Book>>> genres : allBooks.entrySet()) {
			for (Map.Entry<Author, ArrayList<Book>> author : genres.getValue().entrySet()) {
				requiredBooks.addAll(author.getValue());
			}
		}
		return requiredBooks;
	}
}
