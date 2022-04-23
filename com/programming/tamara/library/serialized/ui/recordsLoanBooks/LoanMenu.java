package programming.tamara.library.serialized.ui.recordsLoanBooks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import programming.tamara.library.serialized.model.Book;
import programming.tamara.library.serialized.model.Librarian;
import programming.tamara.library.serialized.model.Library;
import programming.tamara.library.serialized.model.Loan;
import programming.tamara.library.serialized.model.Member;
import programming.tamara.library.serialized.ui.LibrarianMenu;
import programming.tamara.library.serialized.ui.MemberMenu;
import programming.tamara.library.serialized.ui.util.Validation;

public class LoanMenu {

	public static void loanMenu(Library library) {
		while (true) {
			System.out.println("----Loan controle----");
			System.out.println("1.List all loan ");
			System.out.println("2.List loan by member ");
			System.out.println("3.Create new loan ");
			System.out.println("4.Return the book in library ");
			System.out.println(" x exit ");

			Integer option = Validation.numberEntry(1, 4);
			if (option == null) {
				return;
			}
			switch (option) {
			case 1: {
				List<Loan> searchFor = library.getLoan();
				if (searchFor.isEmpty()) {
					System.out.println("There are no loans.");
				} else {
					for (Loan loan : searchFor) {
						System.out.println(loan);
					}
				}
				break;
			}
			case 2: {
				List<Loan> searchFor = findLoanByMember(library.getLoan(), library.getMembers());
				if (searchFor.isEmpty()) {
					System.out.println("Loan not found.");
				} else {
					for (Loan loan : searchFor) {
						System.out.println(loan);
					}
				}
				break;
			}
			case 3: {
				createLoan(library);
				break;
			}
			case 4:
				returnBook( library.getLoan(), library.getMembers());
				break;

			}
		}
	}

	public static void createLoan(Library library) {
		System.out.println("Pick librarian: ");
		Librarian pickedLibrarian = LibrarianMenu.pickLibrarian(library.getLibrarians());
		System.out.println(pickedLibrarian);
		if (pickedLibrarian == null) {
			System.out.println("Librarian does not exist.");
			return;
		}

		System.out.println("Pick a member: ");
		Member pickedMember = MemberMenu.selectMember(library.getMembers());
		System.out.println(pickedMember);
		if (pickedMember == null) {
			System.out.println("Member does not exist.");
			return;
		}

		System.out.println("Enter date of loan: ");
		LocalDate date = Validation.parsedDate();
		System.out.println("Enter lenght of loan: ");
		Integer lenghtOfLoan = Validation.numberEntry(1, null);

		Loan newLoan = new Loan(new ArrayList<Book>(), pickedLibrarian, pickedMember, lenghtOfLoan, date);

		Loan endLoan = AddLoanMenu.createNewLoan(newLoan, library);

		if (endLoan == null) {
			System.out.println("The creation of the loan is stop");
			return;
		} else {
			library.getLoan().add(endLoan);
			System.out.println("The loan was recorded.");
		}

	}

	public static List<Loan> findLoanByMember(List<Loan> loans, List<Member> members) {

		Member pickingMember = MemberMenu.selectMember(members);
		List<Loan> filtered = new ArrayList<Loan>();

		for (Loan current : loans) {
			if (current.getMember().getMemberId() == pickingMember.getMemberId()) {
				filtered.add(current);
			}
		}
		return filtered;
	}

	public static void returnBook(List<Loan> loans, List<Member> members) {
		System.out.println("Pick loan by member: ");
		List<Loan> search = findLoanByMember(loans, members);

		for (int i = 0; i < search.size(); i++) {
			System.out.println(i + 1 + ". " + search.get(i));
		}
		System.out.println("Pick loan for delete: ");
		Integer selection = Validation.numberEntry(1, search.size());
		loans.remove(selection - 1);
		System.out.println("Loan is deleted.");

	}
}
 
