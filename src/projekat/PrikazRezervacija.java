package projekat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class PrikazRezervacija extends JFrame {

	private static final long serialVersionUID = 2413142264471870761L;
	private JPanel contentPane;
	private JTable tabela;
	private JTextField txtRezervacije;
	private ArrayList<Rezervacija> zaTabelu = new ArrayList<Rezervacija>();
	
	public PrikazRezervacija() {
		setTitle("REZERVACIJE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrikazRezervacija.class.getResource("/slike/favicon.png")));
		setBounds(100, 100, 724, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRezervacije = new JTextField();
		txtRezervacije.setEditable(false);
		txtRezervacije.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtRezervacije.setHorizontalAlignment(SwingConstants.CENTER);
		txtRezervacije.setText("REZERVACIJE");
		txtRezervacije.setForeground(Color.WHITE);
		txtRezervacije.setBackground(Color.BLACK);
		txtRezervacije.setBounds(10, 377, 170, 22);
		contentPane.add(txtRezervacije);
		txtRezervacije.setColumns(10);
		
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("ID");
        model.addColumn("Ime i prezime");
        model.addColumn("Broj LK");
        model.addColumn("Broj ulaznica");
        model.addColumn("VIP");
        model.addColumn("Film");
        model.addColumn("Zanr");
        model.addColumn("Dan");
        model.addRow(new Object[]{"ID", "Ime i prezime", "Broj LK","Broj ulaznica", "VIP","Film","Žanr","Dan"});
        tabela = new JTable(model);
        tabela.setEnabled(false);
		tabela.setBounds(10, 11, 688, 355);
		contentPane.add(tabela);
		
		JLabel pozadina = new JLabel("");
		pozadina.setIcon(new ImageIcon(PrikazRezervacija.class.getResource("/slike/pozadina.png")));
		pozadina.setBounds(0, 0, 708, 410);
		contentPane.add(pozadina);
		
		zaTabelu = Rezervacija.getRezervacije();
		
		for (int i = 0; i < zaTabelu.size(); i++) {
			String [] objekat = 
			{
					String.valueOf(i+1), 
					zaTabelu.get(i).getImePrezime(), 
					String.valueOf(zaTabelu.get(i).getBrojLicne()), 
					String.valueOf(zaTabelu.get(i).getBrojUlaznica()), 
					String.valueOf(zaTabelu.get(i).isVip()), 
					String.valueOf(zaTabelu.get(i).getFilm().getIme()),
					String.valueOf(zaTabelu.get(i).getFilm().getZanr()),
					String.valueOf(zaTabelu.get(i).getDan())
			};
			model.addRow(objekat);
		}
	}
}
