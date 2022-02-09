package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7112126032955868254L;
	private int id;
	private String ime;
	private String prezime;
	
	public Osoba() {}
	
	public Osoba(int id, String ime, String prezime) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return (
			"========================="
			+ "\n| id: " + id 
			+ ",\n| ime: " + ime 
			+ ",\n| prezime: " + prezime
		);
	}
	
	

}
