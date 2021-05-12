package projekat;

import java.io.Serializable;

public abstract class Film implements Serializable {

	private static final long serialVersionUID = 2922525582051719484L;
	private String ime;
	private String opis;
	private int cenaKarte;
	
	public Film(String ime, String opis, int cenaKarte) {
		this.ime = ime;
		this.opis = opis;
		this.cenaKarte = cenaKarte;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(int cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	
	public abstract String getZanr();
}
