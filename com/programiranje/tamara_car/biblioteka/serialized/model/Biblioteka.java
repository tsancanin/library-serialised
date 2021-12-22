package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteka implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554186585819634614L;
	
	private String naziv;
	private String adresa;
	
	private ArrayList<Autor> autori = new ArrayList<Autor>();
	private ArrayList<Clan> clanovi = new ArrayList<Clan>();
	private ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
	private ArrayList<EvidencijaKnjiga> evidencijaKnjiga = new ArrayList<EvidencijaKnjiga>();
	private HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige = 
			new HashMap<Zanrovi, HashMap<Autor,ArrayList<Knjiga>>>();
	
	
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

	public ArrayList<EvidencijaKnjiga> getEvidencijaKnjiga() {
		return evidencijaKnjiga;
	}

	public void setEvidencijaKnjiga(ArrayList<EvidencijaKnjiga> evidencijaKnjiga) {
		this.evidencijaKnjiga = evidencijaKnjiga;
	}

	public HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> getSveKnjige() {
		return sveKnjige;
	}

	public void setSveKnjige(HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige) {
		this.sveKnjige = sveKnjige;
	}

	public Biblioteka(ArrayList<Autor> autori, ArrayList<Clan> clanovi, ArrayList<EvidencijaKnjiga> evidencijaKnjiga,
			HashMap<Zanrovi, HashMap<Autor, ArrayList<Knjiga>>> sveKnjige, ArrayList<Knjiga> knjige) {
		this.autori = autori;
		this.clanovi = clanovi;
		this.evidencijaKnjiga = evidencijaKnjiga;
		this.sveKnjige = sveKnjige;
		this.knjige = knjige;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}

}
