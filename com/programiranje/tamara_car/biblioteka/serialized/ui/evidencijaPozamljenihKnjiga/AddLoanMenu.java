package programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Author;
import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Member;
import programiranje.tamara_car.biblioteka.serialized.model.Book;
import programiranje.tamara_car.biblioteka.serialized.model.Loan;
import programiranje.tamara_car.biblioteka.serialized.model.Librarian;
import programiranje.tamara_car.biblioteka.serialized.ui.MemberMenu;
import programiranje.tamara_car.biblioteka.serialized.ui.BookMenu;
import programiranje.tamara_car.biblioteka.serialized.ui.LibrarianMenu;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class AddLoanMenu {

	public static Loan createNewLoan(Loan forCreate, Library library) {

		while (true) {
			System.out.println("=========================================");
			System.out.println("Is being created:");
			System.out.println(forCreate);
			System.out.println("=========================================");
			System.out.println("1. Add book in loan: ");
			System.out.println("2. Delete book ");
			System.out.println("3. Change librarian ");
			System.out.println("4. Change member ");
			System.out.println("5. Change lenght of loan ");
			System.out.println("6. Change the date of borrow book ");
			System.out.println("7. Finish loan ");
			System.out.println("  cancel loan X  ");

			Integer option = Validation.numberEntry(1, 7);

			if (option == null) {
				return null;
			}
			switch (option) {
			case 1: {
				addBookInLoan(forCreate, library);
				break;
			}

			case 2: {
				deleteBookFromeLoan(forCreate);
				break;
			}
			case 3:
				changeLibrarian(forCreate, library);
				break;
			case 4:
				changeMember(forCreate, library);
				break;
			case 5:
				changeLenghtOfLoan(forCreate);
				break;
			case 6:
				changeDateOfBorrowBook(forCreate);
				break;
			case 7:
				System.out.println("Zavrseno kreiranje pozajmice");
				return forCreate;
			}
		}
	}

	public static void addBookInLoan(Loan forCreate, Library library) {
		Book chosenBook = BookMenu.bookSelectionSearch(library.getListOfBooks(), library.getAuthors());
		if (chosenBook != null) {
			forCreate.getBorrowedBooks().add(chosenBook);
			System.out.println("Dodata: " + chosenBook.getTitle());
		}

	}

	public static void deleteBookFromeLoan(Loan forCreate) {
		List<Book> temporaryAdded = forCreate.getBorrowedBooks();
		if (temporaryAdded.isEmpty()) {
			System.out.println("Loan is empty");
			return;
		}

		List<Author> activeAuthors = new ArrayList<Author>();
		for (Book book : temporaryAdded) {
			activeAuthors.add(book.getAuthor());
		}

		Book chosenBook = BookMenu.bookSelectionSearch(temporaryAdded, activeAuthors);
		if (chosenBook == null) {
			System.out.println("Delete is canceled");
			return;
		}

		System.out.println("Deleted book: " + chosenBook.getTitle());
		temporaryAdded.remove(chosenBook);

	}

	public static void changeLibrarian(Loan forCreate, Library library) {
		Librarian found = LibrarianMenu.pickLibrarian(library.getLibrarians());
		if (found == null) {
			System.out.println("The change of librarian is canceled.");
			return;
		}
		forCreate.setLibrarian(found);
		System.out.println("Librarian is changed.");
	}

	public static void changeMember(Loan forCreate, Library library) {
		Member chosenMember = MemberMenu.selectMember(library.getMembers());
		if (chosenMember == null) {
			System.out.println("The change of member is canceled.");
			return;
		}
		forCreate.setMember(chosenMember);
		System.out.println("Member is changed.");
	}

	public static void changeLenghtOfLoan(Loan forCreate) {
		System.out.println("Enter new lenght of loan:");
		Integer lenght = Validation.numberEntry(1, null);
		if (lenght == null) {
			System.out.println("The change of lenght is canceled");
			return;
		}
		forCreate.setLoanLenght(lenght);
		System.out.println("Lenght of loan is change.");
	}

	public static void changeDateOfBorrowBook(Loan forCreate) {
		System.out.println("Enter new borrow date: ");
		LocalDate date = Validation.parsedDate();
		if (date == null) {
			System.out.println("The change of date is canceled");
			return;
		}
		forCreate.setTakeLoanDate(date);
		System.out.println("Date of borrow book is change");
	}

}
