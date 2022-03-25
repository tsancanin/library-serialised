package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Loan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5243795090118023284L;

	private ArrayList<Book> borrowedBooks;
	private Librarian librarian;
	private Member member;
	private int loanLenght;
	private LocalDate takeLoanDate;
	private LocalDate returnLoanDate;
	private boolean returned;

	public Loan() {
		this.borrowedBooks = new ArrayList<Book>();
		this.loanLenght = 14;
		this.returned = false;
	}

	public Loan(ArrayList<Book> borrowedBooks, Librarian librarian, Member member, int loanLenght,
			LocalDate takeLoanDate) {
		super();
		this.borrowedBooks = borrowedBooks;
		this.librarian = librarian;
		this.member = member;
		this.loanLenght = loanLenght;
		this.takeLoanDate = takeLoanDate;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getLoanLenght() {
		return loanLenght;
	}

	public void setLoanLenght(int loanLenght) {
		this.loanLenght = loanLenght;
	}

	public LocalDate getTakeLoanDate() {
		return takeLoanDate;
	}

	public void setTakeLoanDate(LocalDate takeLoanDate) {
		this.takeLoanDate = takeLoanDate;
	}

	public LocalDate getReturnLoanDate() {
		return returnLoanDate;
	}

	public void setReturnLoanDate(LocalDate returnLoanDate) {
		this.returnLoanDate = returnLoanDate;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("========================");
		sb.append("\n Librarian: \n" + librarian);
		sb.append("\n Member: \n" + member);
		sb.append("\n Loan lenght: " + loanLenght);
		sb.append("\n Take loan Date: " + takeLoanDate);
		sb.append("\n return loan Date: " + returnLoanDate);
		sb.append("\n returned: " + returned);
		sb.append("\n books:");
		for (Book k : this.borrowedBooks) {
			sb.append("\n" + k);
		}
		sb.append("\n========================");
		return sb.toString();
	}

}
