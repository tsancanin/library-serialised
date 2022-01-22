package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;

public class Knjiga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 520243975431957223L;
	private int idKnjige;
	private String naziv;
	private Autor autor;
	private Zanrovi zanr;
	private int brojKnjiga;
	

	public Knjiga(int idKnjige, String naziv, Autor autor,Zanrovi zanr ,int brojKnjiga) {
		this.idKnjige = idKnjige;
		this.naziv = naziv;
		this.autor = autor;
		this.zanr = zanr;
		this.brojKnjiga = brojKnjiga;
	}

	public int getIdKnjige() {
		return idKnjige;
	}

	public void setIdKnjige(int idKnjige) {
		this.idKnjige = idKnjige;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Zanrovi getZanr() {
		return zanr;
	}

	public void setZanr(Zanrovi zanr) {
		this.zanr = zanr;
	}

	public int getBrojKnjiga() {
		return brojKnjiga;
	}

	public void setBrojKnjiga(int brojKnjiga) {
		this.brojKnjiga = brojKnjiga;
	}

	
	@Override
	public String toString() {
		return "Knjiga [idKnjige=" + idKnjige + ", naziv=" + naziv + ", autor=" + autor + ", zanr=" + zanr
				+ ", brojKnjiga=" + brojKnjiga + "]";
	}
	

}
