package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.time.LocalDate;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Librarian;

public class librarianValidation {
	

	public static Librarian addNewLibrarian() {
		return dataEntry(null);
	}

	public static Librarian changeLibrarian(Librarian librarian) {
		return dataEntry(librarian);
	}


	private static Librarian dataEntry(Librarian librarian) {
		Librarian changedLibrarian = librarian;

		// ovo se desava ako smo pozvali kreiranje zaposlenog
		if (changedLibrarian == null) {
			changedLibrarian = new Librarian();

			System.out.println("Enter librarian ID: ");
			Integer idLibrarian = Validation.numberEntry(1, null);
			changedLibrarian.setId(idLibrarian);
		}

		System.out.println("Enter name:");
		String name = Validation.textEntry(3, null);
		changedLibrarian.setName(name);

		System.out.println("Enter surname: ");
		String surname = Validation.textEntry(3, null);
		changedLibrarian.setSurname(surname);

		System.out.println("Enter birthday: ");
		LocalDate parsed = Validation.parsedDate();
		changedLibrarian.setBirthday(parsed);

		System.out.println("Enter the address: ");
		String address = Validation.textEntry(5, null);
		changedLibrarian.setAddress(address);

		System.out.println("Enter the phone number: ");
		Integer phoneNumber = Validation.numberEntry(5, null);
		changedLibrarian.setPhoneNumber(phoneNumber);

		System.out.println("Enter the librarian mail address : ");
		String mejl = Validation.checkMail();
		changedLibrarian.setMail(mejl);

		System.out.println("Enter health number: ");
		String healthNumber = Validation.textEntry(3, null);
		changedLibrarian.setHealthNumber(healthNumber);

		System.out.println("Enter social security number: ");
		String socialNumber = Validation.textEntry(3, null);
		changedLibrarian.setSocialSecurityNumber(socialNumber);

		return changedLibrarian;
	}
}
