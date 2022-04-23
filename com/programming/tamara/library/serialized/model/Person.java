package programming.tamara.library.serialized.model;

import java.io.Serializable;

public abstract class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7112126032955868254L;
	private int id;
	private String name;
	private String surname;

	public Person() {
	}

	public Person(int id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n ID: "+id);
		sb.append("\n Name: "+ name);
		sb.append("\n Surname: "+ surname);
		return sb.toString();
	}

}
