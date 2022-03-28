package programiranje.tamara_car.biblioteka.serialized.ui.evidencijaPozamljenihKnjiga;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Member;
import programiranje.tamara_car.biblioteka.serialized.model.Book;
import programiranje.tamara_car.biblioteka.serialized.model.Loan;
import programiranje.tamara_car.biblioteka.serialized.model.Librarian;
import programiranje.tamara_car.biblioteka.serialized.ui.MemberMenu;
import programiranje.tamara_car.biblioteka.serialized.ui.LibrarianMenu;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class LoanMenu {

	public static void loanMenu(Library library) {
		while (true) {
			System.out.println("----Loan controle----");
			System.out.println("1.List all loan ");
			System.out.println("2.List loan by member ");
			System.out.println("3.Create new loan ");
			System.out.println("4.Give back the book ");//razduziti??
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
				Loan searchFor = loanByMember(library);
				if (searchFor != null) {
					System.out.println(searchFor);
				} else {
					System.out.println("Loan not found.");
				}
				break;
			}
			case 3: {
				createLoan(library);
				break;
			}

			}
		}
	}

	public static void createLoan(Library library) {
		System.out.println("Pick librarian: ");
		Librarian pickedLibrarian = LibrarianMenu.pickLibrarian(library.getLibrarians());
		if (pickedLibrarian == null) {
			System.out.println("The creation of the loan is stop.");
			return;
		}
		
		System.out.println("Pick a member: ");
		Member pickedMember = MemberMenu.selectMember(library.getMembers());
		if (pickedMember == null) {
			System.out.println("The creation of the loan is stop.");
			return;
		}
		
		System.out.println("Enter date of loan: ");
		LocalDate date = Validation.parsedDate();
		System.out.println("Enter lenght of loan: ");
		Integer lenghtOfLoan = Validation.numberEntry(1, null);

		Loan newLoan = new Loan(pickedLibrarian, pickedMember, lenghtOfLoan, date,
				new ArrayList<Book>());

		Loan endLoan = AddLoanMenu.createNewLoan(newLoan, library);
		if (endLoan == null) {
			System.out.println("The creation of the loan is stop");
			return;
		} else {
			library.getLoan().add(endLoan);
			System.out.println("The loan was recorded.");
		}

	}

	public static Loan loanByMember(Library library) {
		Member pickingMember = MemberMenu.selectMember(library.getMembers());
		if (pickingMember == null) {
			return null;
		}
		for (Loan current : library.getLoan()) {
			if (pickingMember.getId() == current.getMember().getId()) {
				return current;
			}
		}
		return null;
	}

}
