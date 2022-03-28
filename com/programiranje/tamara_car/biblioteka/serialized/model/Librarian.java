package programiranje.tamara_car.biblioteka.serialized.model;

import java.time.LocalDate;

public class Librarian extends ImportantPerson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3725661009685673401L;
	private String healthNumber;
	private String socialSecurityNumber;

	public Librarian() {
		super();
	}

	public Librarian(int id, String name, String surname, LocalDate birthday, String address, int phoneNumber,
			String mail, String healthNumber, String socialSecurityNumber) {
		super(id, name, surname, birthday, address, phoneNumber, mail);
		this.healthNumber = healthNumber;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getHealthNumber() {
		return healthNumber;
	}

	public void setHealthNumber(String healthNumber) {
		this.healthNumber = healthNumber;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
