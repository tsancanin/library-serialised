package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Clan extends VaznaOsoba implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2412713962555379125L;
	private int clanskiBroj;
	
	
	
	public Clan(int id, String ime, String prezime, LocalDate datumRodjenja, String adresa, int brojTelefona,
			String mail) {
		super(id, ime, prezime, datumRodjenja, adresa, brojTelefona, mail);
		
	}

	public Clan() {}
	
	public int getClanskiBroj() {
		return clanskiBroj;
	}

	public void setClanskiBroj(int clanskiBroj) {
		this.clanskiBroj = clanskiBroj;
	}

	@Override
	public String toString() {
		return (super.toString() + ",\n| clanskiBroj: " + clanskiBroj);
	}
	
	
	
	
}
