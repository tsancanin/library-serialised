package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;

public class Biblioteka implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554186585819634614L;
	
	private String naziv;
	private String adresa;
	
	private Biblioteka() {}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

}
