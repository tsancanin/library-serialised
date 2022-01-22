package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;

public class Autor extends Osoba implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5573246014065793183L;

	public Autor(int id, String ime, String prezime) {
		super(id, ime, prezime);
		
	}
	
	@Override
	public String toString() {
		return "Autor:  "+super.toString();
	}
	
	
	
}
