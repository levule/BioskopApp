package projekat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rezervisanje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtImeIPrezime;
	private JTextField txtBrojLineKarte;
	private JTextField txtTheGentlemen;
	private JTextField txtAkcija;
	private JTextField txtDin;
	private JButton btnNewButton;

	public Rezervisanje(Film filmID, int brul, boolean vip, String dan) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Rezervisanje.class.getResource("/slike/favicon.png")));
		setTitle("CINE rezervacija");
		setBounds(100, 100, 390, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrTheGentlemanJe = new JTextArea();
		txtrTheGentlemanJe.setText("");
		txtrTheGentlemanJe.setRows(15);
		txtrTheGentlemanJe.setForeground(new Color(255, 255, 255));
		txtrTheGentlemanJe.setBackground(new Color(0, 0, 0));
		txtrTheGentlemanJe.setLineWrap(true);
		txtrTheGentlemanJe.setText(filmID.getOpis());
		txtrTheGentlemanJe.setBounds(36, 142, 303, 223);
		contentPane.add(txtrTheGentlemanJe);
		
		txtDin = new JTextField();
		int cena = brul*filmID.getCenaKarte();
		if(vip) cena += 150*brul;
		txtDin.setText(cena+"din");
		txtDin.setForeground(Color.WHITE);
		txtDin.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDin.setEditable(false);
		txtDin.setColumns(10);
		txtDin.setBackground(Color.BLACK);
		txtDin.setBounds(100, 90, 216, 16);
		contentPane.add(txtDin);
		
		txtTheGentlemen = new JTextField();
		txtTheGentlemen.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTheGentlemen.setText(filmID.getIme());
		txtTheGentlemen.setEditable(false);
		txtTheGentlemen.setForeground(Color.WHITE);
		txtTheGentlemen.setBackground(Color.BLACK);
		txtTheGentlemen.setBounds(100, 48, 216, 16);
		contentPane.add(txtTheGentlemen);
		txtTheGentlemen.setColumns(10);
		
		txtAkcija = new JTextField();
		
		txtAkcija.setText(filmID.getZanr());
		txtAkcija.setForeground(Color.WHITE);
		txtAkcija.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAkcija.setEditable(false);
		txtAkcija.setColumns(10);
		txtAkcija.setBackground(Color.BLACK);
		txtAkcija.setBounds(100, 69, 216, 16);
		contentPane.add(txtAkcija);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Rezervisanje.class.getResource("/slike/test.png")));
		lblNewLabel_1.setBounds(10, 11, 354, 431);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("POTVRDI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//potvrdio
				int filmBrojac = 0, br1 = 0;
				if( !validnoIme(txtImeIPrezime.getText()) ) filmBrojac++;
				if( !validnaLicna(txtBrojLineKarte.getText()) ) br1++;
				
				Provera pro = new Provera();
				if( filmBrojac != 0 && br1 != 0 ) pro.setDialogTekst("Ime Prezime i broj li\u010Dne karte nisu dobro uneti!");
				else if( filmBrojac == 0 && br1 != 0 ) pro.setDialogTekst("Broj li\u010Dne karte nije dobro unet!");
				else if( filmBrojac != 0 && br1 == 0 ) pro.setDialogTekst("Ime i Prezime nije uneto validno!");
				else if( filmBrojac == 0 && br1 == 0 ) {
					setTitle("CINE rezervacija");
					pro.setDialogTekst("Uspesno ste izvršili rezervaciju!");
					Rezervacija novaRez = new Rezervacija(txtImeIPrezime.getText(), Integer.valueOf(txtBrojLineKarte.getText()), brul, vip, filmID, dan);
					System.out.println("Rezervacija korisnika sa brojem LK: " + novaRez.getBrojLicne() + " je dodata.");
					dispose();
				}
				pro.setLocationRelativeTo( null );
				pro.setVisible(true);
				pro.setResizable(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Rezervisanje.class.getResource("/slike/sel.png")));
		btnNewButton.setForeground(new Color(46, 139, 87));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(121, 547, 132, 23);
		contentPane.add(btnNewButton);
		
		txtBrojLineKarte = new JTextField();
		txtBrojLineKarte.setText("Broj li\u010Dne karte");
		txtBrojLineKarte.setHorizontalAlignment(SwingConstants.CENTER);
		txtBrojLineKarte.setForeground(Color.WHITE);
		txtBrojLineKarte.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBrojLineKarte.setColumns(10);
		txtBrojLineKarte.setBackground(Color.BLACK);
		txtBrojLineKarte.setBounds(58, 500, 258, 36);
		contentPane.add(txtBrojLineKarte);
		txtBrojLineKarte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//licna
				String brl = "Broj li\u010Dne karte";
				if(brl.equals(txtBrojLineKarte.getText())) txtBrojLineKarte.setText("");
			}
		});
		
		txtImeIPrezime = new JTextField();
		txtImeIPrezime.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtImeIPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		txtImeIPrezime.setText("Ime i prezime");
		txtImeIPrezime.setForeground(new Color(255, 255, 255));
		txtImeIPrezime.setBackground(new Color(0, 0, 0));
		txtImeIPrezime.setBounds(58, 453, 258, 36);
		contentPane.add(txtImeIPrezime);
		txtImeIPrezime.setColumns(10);
		txtImeIPrezime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//ime
				String ip = "Ime i prezime";
				if(ip.equals(txtImeIPrezime.getText())) txtImeIPrezime.setText("");
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Rezervisanje.class.getResource("/slike/pozadina.png")));
		lblNewLabel.setBounds(0, 0, 374, 581);
		contentPane.add(lblNewLabel);
	}
	
	public boolean validnoIme(String str) {
	    String expression = "^[a-zA-Z ]+$";
	    String ip = "Ime i prezime";
	    if( ip.equals(txtImeIPrezime.getText()) || prazanStr(str) || str.length()<5 || !str.contains(" ") || !dvaVelika(str) ) return false;
	    return str.matches(expression);
	}
	
	public boolean prazanStr(String str) {
	    return (str == null || str.equals("") || str.equals("null") || str.trim().equals(""));
	}
	
	public boolean dvaVelika(String str) {
		int brojV = 0;
		for (char c : str.toCharArray()) {
		    if (Character.isUpperCase(c)) {
		    	brojV++;
		    }
		}
		if(brojV == 2) return true;
		else return false;
	}
	
	public boolean validnaLicna(String str) {
	    boolean ret = false;
	    if (!prazanStr(str) && str.length()==9 ) {
	        ret = str.matches("^[0-9]+$");
	    }
	    return ret;
	}
}