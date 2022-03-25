package programiranje.tamara_car.biblioteka.serialized.model;

import java.time.LocalDate;

public abstract class ImportantPerson extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2352707807405598460L;
	private LocalDate datumRodjenja;
	private String adresa;
	private int brojTelefona;
	private String mail;
	
	public ImportantPerson() {
		super();
	}
	
	public ImportantPerson(int id, String ime, String prezime, LocalDate datumRodjenja, String adresa,int brojTelefona, String mail) {
		super(id, ime, prezime);
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.mail = mail;
		
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(int brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return (
			super.toString()
			+ "\n| datumRodjenja=" + datumRodjenja 
			+ ",\n| adresa=" + adresa 
			+ ",\n| brojTelefona=" + brojTelefona
			+ ",\n| mail=" + mail
		);
	}
	
	
	
	
}
