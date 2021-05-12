package projekat;

public class Komedija extends Film {

	private static final long serialVersionUID = 4523760937013257137L;
	private String zanr;
	
	public Komedija(String ime, String opis, int cenaKarte) {
		super(ime, opis, cenaKarte);
		this.zanr = "Komedija";
	}
	
	public String getZanr() {
		return zanr;
	}
	
	public boolean getZanr(String s) {
		if(s.equalsIgnoreCase(zanr)) return true;
		else return false;
	}
}
