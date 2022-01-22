package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteka implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554186585819634614L;

	private String naziv = "Gradska biblioteka Novi Sad";
	private String adresa = "Dunavska br.1";

	private ArrayList<Autor> autori = new ArrayList<Autor>();
	private ArrayList<Clan> clanovi = new ArrayList<Clan>();
	private ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
	private ArrayList<Pozajmica> evidencijaPozajmica = new ArrayList<Pozajmica>();
	private HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige = 
			new HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>>();

	public Biblioteka() {
	}

	public Biblioteka(String naziv, String adresa) {
		this.naziv = naziv;
		this.adresa = adresa;
	}

	public Biblioteka(ArrayList<Autor> autori, ArrayList<Clan> clanovi, ArrayList<Zaposleni> zaposleni,
			ArrayList<Pozajmica> evidencijaPozajmica, HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige,
			ArrayList<Knjiga> knjige) {
		this.autori = autori;
		this.clanovi = clanovi;
		this.zaposleni = zaposleni;
		this.evidencijaPozajmica = evidencijaPozajmica;
		this.sveKnjige = sveKnjige;
	}

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

	public ArrayList<Autor> getAutori() {
		return autori;
	}

	public void setAutori(ArrayList<Autor> autori) {
		this.autori = autori;
	}

	public ArrayList<Clan> getClanovi() {
		return clanovi;
	}

	public void setClanovi(ArrayList<Clan> clanovi) {
		this.clanovi = clanovi;
	}

	public ArrayList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public ArrayList<Pozajmica> getEvidencijaKnjiga() {
		return evidencijaPozajmica;
	}

	public void setEvidencijaKnjiga(ArrayList<Pozajmica> evidencijaKnjiga) {
		this.evidencijaPozajmica = evidencijaKnjiga;
	}

	public HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> getSveKnjige() {
		return sveKnjige;
	}

	public void setSveKnjige(HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige) {
		this.sveKnjige = sveKnjige;
	}

}
