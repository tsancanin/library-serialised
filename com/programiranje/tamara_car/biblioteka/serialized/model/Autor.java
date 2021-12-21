package programiranje.tamara_car.biblioteka.serialized.model;

public class Autor extends Osoba {
	
	public Autor(int id, String ime, String prezime) {
		super(id, ime, prezime);
		
	}
	
	@Override
	public String toString() {
		return "Autor:  "+super.toString();
	}
	
	
	
}
