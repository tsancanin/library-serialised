package programiranje.tamara_car.biblioteka.serialized.model;

import java.time.LocalDate;

public class Zaposleni extends VaznaOsoba {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3725661009685673401L;
	private String brojZdravstvenog;
	private String brojSocijalnog;
	
	public Zaposleni() {
		super();
	}
	
	public Zaposleni(int id, String ime, String prezime, LocalDate datumRodjenja, String adresa, int brojTelefona,
			String mail, String brojZdravstvenog, String brojSocijalnog) {
		super(id, ime, prezime, datumRodjenja, adresa, brojTelefona, mail);
		this.brojZdravstvenog = brojZdravstvenog;
		this.brojSocijalnog = brojSocijalnog;
	}

	public String getBrojZdravstvenog() {
		return brojZdravstvenog;
	}

	public void setBrojZdravstvenog(String brojZdravstvenog) {
		this.brojZdravstvenog = brojZdravstvenog;
	}

	public String getBrojSocijalnog() {
		return brojSocijalnog;
	}

	public void setBrojSocijalnog(String brojSocijalnog) {
		this.brojSocijalnog = brojSocijalnog;
	}

	@Override
	public String toString() {
		return "Zaposleni"+super.toString()+ "brojZdravstvenog=" + brojZdravstvenog + ", brojSocijalnog=" + brojSocijalnog + "]";
	}
	
	
	
	
	
}
