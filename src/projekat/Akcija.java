package projekat;

public class Akcija extends Film {

	private static final long serialVersionUID = 8350412517227826068L;
	private String zanr;
	
	public Akcija(String ime, String opis, int cenaKarte) {
		super(ime, opis, cenaKarte);
		this.zanr = "Akcija";
	}

	public String getZanr() {
		return zanr;
	}
	
	public boolean getZanr(String s) {
		if(s.equalsIgnoreCase(zanr)) return true;
		else return false;
	}
}
