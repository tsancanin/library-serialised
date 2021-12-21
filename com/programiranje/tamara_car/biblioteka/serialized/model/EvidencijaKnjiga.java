package programiranje.tamara_car.biblioteka.serialized.model;

public class EvidencijaKnjiga {
	
	private Knjiga knjiga;
	private Zaposleni zaposleni;
	private Clan clan;
	
	public EvidencijaKnjiga(Knjiga knjiga, Zaposleni zaposleni, Clan clan) {
		this.knjiga = knjiga;
		this.zaposleni = zaposleni;
		this.clan = clan;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	@Override
	public String toString() {
		return "EvidencijaKnjiga [knjiga=" + knjiga + ", zaposleni=" + zaposleni + ", clan=" + clan + "]";
	}
	
	
	
	
}
