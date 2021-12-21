package programiranje.tamara_car.biblioteka.serialized.model;

import java.time.LocalDate;

public class Clan extends Osoba {
	private int clanskiBroj;
	private LocalDate datumRodjenja;
	
	public Clan(int id, String ime, String prezime) {
		super(id, ime, prezime);
	}

	public Clan(int id, String ime, String prezime, int clanskiBroj, LocalDate datumRodjenja) {
		super(id, ime, prezime);
		this.clanskiBroj = clanskiBroj;
		this.datumRodjenja = datumRodjenja;
	}

	public int getClanskiBroj() {
		return clanskiBroj;
	}

	public void setClanskiBroj(int clanskiBroj) {
		this.clanskiBroj = clanskiBroj;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	@Override
	public String toString() {
		return  "Clan [clanskiBroj=" + clanskiBroj+ super.toString() + 
				", datumRodjenja=" + datumRodjenja + "]";
	}
	
	
	
	
}
