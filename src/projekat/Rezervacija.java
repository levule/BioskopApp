package projekat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Rezervacija implements Serializable, Fajl {

	private static final long serialVersionUID = 1L;
	private static int rezID = 0;
	private String imePrezime;
	private String dan;
	private int brojLicne;
	private int brojUlaznica = 0;
	private boolean vip;
	private Film film;
	private static ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
	
	public Rezervacija(String imePrezime, int brojLicne, int brojUlaznica, boolean vip, Film film, String dan) {
		rezID ++;
		this.imePrezime = imePrezime;
		this.brojLicne = brojLicne;
		this.brojUlaznica = brojUlaznica;
		this.vip = vip;
		this.film = film;
		this.dan = dan;
		uFajl();
	}

	public String getDan() {
		return dan;
	}

	public void setDan(String dan) {
		this.dan = dan;
	}

	public static int getRezID() {
		return rezID;
	}

	public static void setRezID(int rezID) {
		Rezervacija.rezID = rezID;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public int getBrojLicne() {
		return brojLicne;
	}

	public void setBrojLicne(int brojLicne) {
		this.brojLicne = brojLicne;
	}

	public int getBrojUlaznica() {
		return brojUlaznica;
	}

	public void setBrojUlaznica(int brojUlaznica) {
		this.brojUlaznica = brojUlaznica;
	}

	public String isVip() {
		if(vip) return "Da";
		else return "Ne";
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	public void uFajl() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("rezervacije.csv"));
			Rezervacija.rezervacije.add(this);
			os.writeObject(Rezervacija.rezervacije);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Greska prilikom cuvanja datoteke rezervacije! Proverite da li datoteka postoji i da li imate pristup.");
		}
	}

	@SuppressWarnings("unchecked")
	public static void izFajla() {
		try {
			ObjectInputStream os = new ObjectInputStream(new FileInputStream("rezervacije.csv"));
			try {
				Rezervacija.rezervacije = (ArrayList<Rezervacija>) os.readObject();
				os.close();
			} catch (ClassNotFoundException e) {
			}
		} catch (IOException e) {
			if (rezervacije.size() != 0)
				System.out.println("Greska prilikom ucitavanja datoteke rezervacije! Proverite da li datoteka postoji i da li imate pristup.");
		}
	}
	
	public static ArrayList<Rezervacija> getRezervacije() {
		izFajla();
		return rezervacije;
	}
}
