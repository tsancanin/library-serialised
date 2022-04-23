package programming.tamara.library.serialized.model;

import java.io.Serializable;

public class Author extends Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5573246014065793183L;

	public Author(int id, String name, String surname) {
		super(id, name, surname);
		
	}
	
	@Override
	public String toString() {
		return "---Author---  "+ super.toString();
	}
	
	
	
}
