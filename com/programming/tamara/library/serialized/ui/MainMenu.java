package programming.tamara.library.serialized.ui;

import programming.tamara.library.serialized.model.Library;
import programming.tamara.library.serialized.ui.recordsLoanBooks.LoanMenu;
import programming.tamara.library.serialized.ui.util.Validation;

public class MainMenu {

	public static void libraryName(Library library) {
		System.out.println("---------------------------");
		System.out.println(library.getName() + "\n"+library.getAddress());
		System.out.println("---------------------------");
	}
	
	public static void mainMenu(Library library) {

		while(true) {
			libraryName(library);
			System.out.println("1. Book menu ");
			System.out.println("2. Loan menu ");
			System.out.println("3. Author menu ");
			System.out.println("4. Librarian menu ");
			System.out.println("5. Member menu ");
			System.out.println(" X - exit ");
 
			Integer option = Validation.numberEntry(1, 6);
			if(option == null) {
				return;
			}
			switch (option) {
			case 1:
				BookMenu.bookMenu(library);
				break;
			case 2:
				LoanMenu.loanMenu(library);
				break;
			case 3:
				AuthorMenu.autorMeni(library);
				break;
			case 4:
				LibrarianMenu.librarianMenu(library);
				break;
			case 5:
				MemberMenu.memberMenu(library);
				break;
			}
		} 
	}

}
