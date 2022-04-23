package programming.tamara.library.serialized.model;

import java.time.LocalDate;

public abstract class ImportantPerson extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2352707807405598460L;
	private LocalDate birthday;
	private String address;
	private int phoneNumber;
	private String mail;

	public ImportantPerson() {
		super();
	}

	public ImportantPerson(int id, String name, String surname, LocalDate birthday, String address, int phoneNumber,
			String mail) {
		super(id, name, surname);
		this.birthday = birthday;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mail = mail;

	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------------");
		sb.append("\n"+ super.toString());
		sb.append("\n Birthday: "+birthday);
		sb.append("\n Address: "+address);
		sb.append("\n Phone number :"+phoneNumber);
		sb.append("\n Mail: "+mail);
		return sb.toString();
	}

}
