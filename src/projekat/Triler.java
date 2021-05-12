package projekat;

public class Triler extends Film {

	private static final long serialVersionUID = 7036002044386440308L;
	private String zanr;
	
	public Triler(String ime, String opis, int cenaKarte) {
		super(ime, opis, cenaKarte);
		this.zanr = "Triler";
	}
	
	public String getZanr() {
		return zanr;
	}
	
	public boolean getZanr(String s) {
		if(s.equalsIgnoreCase(zanr)) return true;
		else return false;
	}
}
