package programiranje.tamara_car.biblioteka.serialized.model;

public class Knjiga {

	private int idKnjige;
	private String naziv;
	private Autor autor;
	private int brojKnjiga;
	private int duzinaPozajmice = 14;

	public Knjiga(int idKnjige, String naziv, Autor autor, int brojKnjiga, int duzinaPozajmice) {
		this.idKnjige = idKnjige;
		this.naziv = naziv;
		this.autor = autor;
		this.brojKnjiga = brojKnjiga;
		this.duzinaPozajmice = duzinaPozajmice;
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

	public int getBrojKnjiga() {
		return brojKnjiga;
	}

	public void setBrojKnjiga(int brojKnjiga) {
		this.brojKnjiga = brojKnjiga;
	}

	public int getDuzinaPozajmice() {
		return duzinaPozajmice;
	}

	public void setDuzinaPozajmice(int duzinaPozajmice) {
		this.duzinaPozajmice = duzinaPozajmice;
	}

	@Override
	public String toString() {
		return "Knjiga [idKnjige=" + idKnjige + ", naziv=" + naziv + ", autor=" + autor + ", brojKnjiga=" + brojKnjiga
				+ ", duzinaPozajmice=" + duzinaPozajmice + "]";
	}

}
