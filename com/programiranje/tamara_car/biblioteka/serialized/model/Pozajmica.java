package programiranje.tamara_car.biblioteka.serialized.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pozajmica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5243795090118023284L;

	private ArrayList<Knjiga> pozajmljeneKnjige;
	private Zaposleni izdao;
	private Clan pozajmio;
	private int duzinaPozajmice;
	private LocalDate datumIznajmljivanja;
	private LocalDate datumVracanja;
	private boolean vraceno;

	public Pozajmica() {
		this.pozajmljeneKnjige = new ArrayList<Knjiga>();
		this.duzinaPozajmice = 14;
		this.vraceno = false;
	}

	public Pozajmica(Zaposleni izdao, Clan pozajmio, Integer duzinaPozajmice, LocalDate datumIznajmljivanja,
			ArrayList<Knjiga> pozajmljeneKnjige) {
		this.izdao = izdao;
		this.pozajmio = pozajmio;
		this.duzinaPozajmice = duzinaPozajmice;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.pozajmljeneKnjige = pozajmljeneKnjige;
	}

	public ArrayList<Knjiga> getPozajmljeneKnjige() {
		return pozajmljeneKnjige;
	}

	public void setPozajmljeneKnjige(ArrayList<Knjiga> pozajmljeneKnjige) {
		this.pozajmljeneKnjige = pozajmljeneKnjige;
	}

	public Zaposleni getIzdao() {
		return izdao;
	}

	public void setIzdao(Zaposleni izdao) {
		this.izdao = izdao;
	}

	public Clan getPozajmio() {
		return pozajmio;
	}

	public void setPozajmio(Clan pozajmio) {
		this.pozajmio = pozajmio;
	}

	public int getDuzinaPozajmice() {
		return duzinaPozajmice;
	}

	public void setDuzinaPozajmice(int duzinaPozajmice) {
		this.duzinaPozajmice = duzinaPozajmice;
	}

	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}

	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}

	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public boolean isVraceno() {
		return vraceno;
	}

	public void setVraceno(boolean vraceno) {
		this.vraceno = vraceno;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("========================");
		sb.append("\n izdao: \n" + izdao);
		sb.append("\n pozajmio: \n" + pozajmio);
		sb.append("\n duzinaPozajmice: " + duzinaPozajmice);
		sb.append("\n datum izdavanja: " + datumIznajmljivanja);
		sb.append("\n datum vracanja: " + datumVracanja);
		sb.append("\n vraceno: " + vraceno);
		sb.append("\n knjige:");
		for(Knjiga k: this.pozajmljeneKnjige) {
			sb.append("\n" + k);
		}
		sb.append("\n========================");
		return sb.toString();
	}

}
