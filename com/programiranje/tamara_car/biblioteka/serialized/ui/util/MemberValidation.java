package programiranje.tamara_car.biblioteka.serialized.ui.util;

import java.time.LocalDate;

import programiranje.tamara_car.biblioteka.serialized.model.Member;

public class MemberValidation {

	public static Member dataEntry(Member member) {
		Member changedMember = member;

		if (changedMember == null) {
			changedMember = new Member();
			System.out.println("Enter the personal ID: ");
			Integer personalId = Validation.numberEntry(1, null);
			changedMember.setId(personalId);
		}
		System.out.println("Enter the membership ID: ");
		int membershipId = Validation.numberEntry(1, null);
		changedMember.setMemberId(membershipId);
		System.out.println("Enter the member name: ");
		String name = Validation.textEntry(3, null);
		changedMember.setName(name);
		System.out.println("Enter the member surname: ");
		String surname = Validation.textEntry(3, null);
		changedMember.setSurname(surname);
		System.out.println("Enter the member's birthday : ");
		LocalDate parsed = Validation.parsedDate();
		changedMember.setBirthday(parsed);
		System.out.println("Enter the member's address : ");
		String address = Validation.textEntry(3, null);
		changedMember.setAddress(address);
		System.out.println("Enter the member's phone number : ");
		int phoneNumber = Validation.numberEntry(3, null);
		changedMember.setPhoneNumber(phoneNumber);
		System.out.println("Enter the member's mail address : ");
		String mail = Validation.checkMail();
		changedMember.setMail(mail);

		return changedMember;
	}

	public static Member changeMember(Member member) {
		return dataEntry(member);
	}

	public static Member addMember() {
		return dataEntry(null);
	}

}
