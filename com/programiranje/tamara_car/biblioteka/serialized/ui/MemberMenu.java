package programiranje.tamara_car.biblioteka.serialized.ui;

import java.util.ArrayList;
import java.util.List;

import programiranje.tamara_car.biblioteka.serialized.model.Library;
import programiranje.tamara_car.biblioteka.serialized.model.Member;
import programiranje.tamara_car.biblioteka.serialized.ui.util.MemberValidation;
import programiranje.tamara_car.biblioteka.serialized.ui.util.Validation;

public class MemberMenu {

	public static void memberMenu(Library library) {

		while (true) {
			System.out.println("---Member menu---");
			System.out.println("1. List all members: ");
			System.out.println("2. Add new member: ");
			System.out.println("3. Change an existing member: ");
			System.out.println("4. Delete member: ");
			System.out.println("5. Search by member's ID: ");
			System.out.println("6. Search by name and surname: ");
			System.out.println(" X - exit");

			Integer option = Validation.numberEntry(1, 6);

			if (option == null) {
				return;
			}
			switch (option) {
			case 1:
				listAllMembers(library);
				break;
			case 2:
				addNewMember(library);
				break;
			case 3: {
				Member searchMember = selectMember(library.getMembers());
				if (searchMember != null) {
					MemberValidation.changeMember(searchMember);
					System.out.println("Member is changed.");
				} else {
					System.out.println("Member do not exist.");
				}
				break;
			}
			case 4: {
				Member searchMember = selectMember(library.getMembers());
				if (searchMember == null) {
					System.out.println("Member do not exist.");
				} else {
					library.getMembers().remove(searchMember);
					System.out.println("Member is removed.");
				}
				break;
			}
			case 5: {
				Member searchMember = searchByMemberId(library.getMembers());
				if (searchMember != null) {
					System.out.println(searchMember);
				} else {
					System.out.println("Member do not exist.");
				}
				break;
			}
			case 6:
			{	 
				List<Member> founded =searchByNameAndSurname(library.getMembers());
				if(founded.isEmpty()) {
					System.out.println("Trazeni clan ne postoji.");
				}else {
					System.out.println(founded);
				}
				break;
			}
			}

		}

	}

	public static void listAllMembers(Library library) {
		for (Member member : library.getMembers()) {
			System.out.println(member);
		}
	}

	public static void addNewMember(Library library) {
		Member newMember = MemberValidation.addMember();

		do {
			boolean found = false;
			for (Member searchedMember : library.getMembers()) {
				found = searchedMember.getId() == newMember.getId();
				if (found)
					break;
			}
			if (found) {
				System.out.println("Id is taken, enter the new id: ");
				Integer noviId = Validation.numberEntry(1, null);
				newMember.setId(noviId);
			} else {
				break;
			}

		} while (true);

		library.getMembers().add(newMember);
		System.out.println("Member is added.");
	}

	public static Member searchByMemberId(List<Member> members) {
		System.out.println("Enter the member's ID: ");
		int id = Validation.numberEntry(1, null);

		for (Member searchedMember : members) {
			if (searchedMember.getMemberId() == id) {
				return searchedMember;
			}
		}
		return null;
	}

	public static List<Member> searchByNameAndSurname(List<Member> members) {
		
		System.out.println("Enter text for search: ");
		String text = Validation.textEntry(3, null);
		List<Member> filtered = new ArrayList<Member>();
		for (Member member : members) {
			if (
					member.getName().toLowerCase().contains(text.toLowerCase()) 
					|| member.getSurname().toLowerCase().contains(text.toLowerCase())
				) {
				filtered.add(member);
			}
		}
		
		return filtered;
	}

	public static Member selectMember(List<Member> members) {

		System.out.println("1. Search by ID: ");
		System.out.println("2. Search by name and surname: ");

		Integer option = Validation.numberEntry(1, 2);
		if (option == 1) {
			return searchByMemberId(members);

		} else {
			return selectMemberByNameAndSurname(members);
		}

	}

	public static Member selectMemberByNameAndSurname(List<Member> members) {

		List<Member> founded = searchByNameAndSurname(members);

		for (int i = 0; i < founded.size(); i++) {
			System.out.println(i + 1 + ". " + founded.get(i));
		}

		System.out.println("Select member(pick a number): ");
		Integer selection = Validation.numberEntry(1, founded.size());

		return founded.get(selection - 1);
	}

}
