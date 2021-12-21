package programiranje.tamara_car.biblioteka.serialized.model;

import java.time.LocalDate;

public class Clan extends VaznaOsoba {
	private int clanskiBroj;
	
	
	
	public Clan(int id, String ime, String prezime, LocalDate datumRodjenja, String adresa, int brojTelefona,
			String mail) {
		super(id, ime, prezime, datumRodjenja, adresa, brojTelefona, mail);
		
	}

	public int getClanskiBroj() {
		return clanskiBroj;
	}

	public void setClanskiBroj(int clanskiBroj) {
		this.clanskiBroj = clanskiBroj;
	}

	@Override
	public String toString() {
		return  "Clan [clanskiBroj=" + clanskiBroj+ super.toString();
	}
	
	
	
	
}
