package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Member extends ImportantPerson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2412713962555379125L;
	private int memberId;
	
	
	
	public Member(int id, String name, String surname, LocalDate birthday, String address, int phoneNumber,
			String mail) {
		super(id, name, surname, birthday, address, phoneNumber, mail);
		
	}

	public Member() {}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return (super.toString() + ",\n| member ID: " + memberId);
	}
	
	
	
	
}
