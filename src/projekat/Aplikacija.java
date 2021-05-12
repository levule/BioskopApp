package projekat;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aplikacija {

	private JFrame frmCineBioskop;
	private JTextField txtOnlineRezervacije;
	private JTextField txtBrojUlaznica;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNewButton;
	private JButton btnRezervacije;
	private JSpinner spinner;
	private JToggleButton tglbtnNewToggleButton;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnJamesBondNo;
	private JRadioButton rdbtnTheGentlemen;
	private JTextArea txtrNapomena;
	private Film film;
	private JComboBox<String> comboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplikacija window = new Aplikacija();
					window.frmCineBioskop.setLocationRelativeTo( null );
					window.frmCineBioskop.setVisible(true);
					window.frmCineBioskop.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Aplikacija() {
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		frmCineBioskop = new JFrame();
		frmCineBioskop.getContentPane().setBackground(Color.DARK_GRAY);
		frmCineBioskop.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("*Za rezervacije se mora do\u0107i najkasnije 15min pre projekcije.");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(413, 355, 408, 23);
		frmCineBioskop.getContentPane().add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cena jedne ulaznice je 400din");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(10, 321, 199, 23);
		frmCineBioskop.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4 = new JLabel("150din");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(137, 258, 46, 14);
		frmCineBioskop.getContentPane().add(lblNewLabel_4);
		
		String[] boxOptions = {"PONEDELJAK", "UTORAK", "SREDA", "\u010CETVRTAK", "PETAK", "SUBOTA", "NEDELJA"};
		comboBox = new JComboBox<String>(boxOptions);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setBounds(10, 221, 173, 23);
		frmCineBioskop.getContentPane().add(comboBox);

		tglbtnNewToggleButton = new JToggleButton("VIP");
		tglbtnNewToggleButton.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/slike/sel.png")));
		tglbtnNewToggleButton.setIcon(new ImageIcon(Aplikacija.class.getResource("/slike/notsel.png")));
		tglbtnNewToggleButton.setForeground(new Color(255, 255, 255));
		tglbtnNewToggleButton.setBackground(new Color(0, 0, 0));
		tglbtnNewToggleButton.setBounds(10, 255, 121, 23);
		frmCineBioskop.getContentPane().add(tglbtnNewToggleButton);
		
		btnRezervacije = new JButton("REZERVACIJE");
		btnRezervacije.setForeground(Color.WHITE);
		btnRezervacije.setFont(new Font("Arial", Font.BOLD, 13));
		btnRezervacije.setBackground(Color.BLACK);
		btnRezervacije.setBounds(437, 401, 176, 49);
		frmCineBioskop.getContentPane().add(btnRezervacije);

		spinner = new JSpinner();
		spinner.setForeground(new Color(255, 255, 255));
		spinner.setBackground(new Color(0, 0, 0));
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner.setBounds(146, 290, 55, 20);
		frmCineBioskop.getContentPane().add(spinner);

		txtrNapomena = new JTextArea();
		txtrNapomena.setText("Napomena...");
		txtrNapomena.setBounds(10, 355, 393, 95);
		frmCineBioskop.getContentPane().add(txtrNapomena);

		txtBrojUlaznica = new JTextField();
		txtBrojUlaznica.setText("BROJ ULAZNICA");
		txtBrojUlaznica.setHorizontalAlignment(SwingConstants.CENTER);
		txtBrojUlaznica.setForeground(Color.WHITE);
		txtBrojUlaznica.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtBrojUlaznica.setEditable(false);
		txtBrojUlaznica.setColumns(10);
		txtBrojUlaznica.setBackground(Color.BLACK);
		txtBrojUlaznica.setAlignmentY(0.0f);
		txtBrojUlaznica.setAlignmentX(0.0f);
		txtBrojUlaznica.setBounds(10, 289, 123, 22);
		frmCineBioskop.getContentPane().add(txtBrojUlaznica);

		txtOnlineRezervacije = new JTextField();
		txtOnlineRezervacije.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtOnlineRezervacije.setAlignmentY(Component.TOP_ALIGNMENT);
		txtOnlineRezervacije.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtOnlineRezervacije.setEditable(false);
		txtOnlineRezervacije.setHorizontalAlignment(SwingConstants.CENTER);
		txtOnlineRezervacije.setText("ONLINE REZERVACIJE");
		txtOnlineRezervacije.setForeground(new Color(255, 255, 255));
		txtOnlineRezervacije.setBackground(new Color(0, 0, 0));
		txtOnlineRezervacije.setBounds(10, 188, 173, 22);
		frmCineBioskop.getContentPane().add(txtOnlineRezervacije);
		txtOnlineRezervacije.setColumns(10);

		rdbtnNewRadioButton = new JRadioButton("Fast & Furious 9");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setForeground(new Color(70, 130, 180));
		rdbtnNewRadioButton.setBounds(279, 188, 109, 23);
		frmCineBioskop.getContentPane().add(rdbtnNewRadioButton);

		rdbtnJamesBondNo = new JRadioButton("No time to die");
		buttonGroup.add(rdbtnJamesBondNo);
		rdbtnJamesBondNo.setForeground(new Color(70, 130, 180));
		rdbtnJamesBondNo.setBackground(new Color(0, 0, 0));
		rdbtnJamesBondNo.setBounds(496, 188, 109, 23);
		frmCineBioskop.getContentPane().add(rdbtnJamesBondNo);

		rdbtnTheGentlemen = new JRadioButton("The Gentlemen");
		buttonGroup.add(rdbtnTheGentlemen);
		rdbtnTheGentlemen.setForeground(new Color(70, 130, 180));
		rdbtnTheGentlemen.setBackground(new Color(0, 0, 0));
		rdbtnTheGentlemen.setBounds(715, 188, 109, 23);
		frmCineBioskop.getContentPane().add(rdbtnTheGentlemen);

		btnNewButton = new JButton("REZERVI\u0160I");
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(648, 401, 176, 49);
		frmCineBioskop.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Aplikacija.class.getResource("/slike/bond.png")));
		lblNewLabel_1.setBounds(496, 25, 110, 150);
		frmCineBioskop.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Aplikacija.class.getResource("/slike/ff.png")));
		lblNewLabel_2.setBounds(278, 25, 110, 150);
		frmCineBioskop.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Aplikacija.class.getResource("/slike/tg.png")));
		lblNewLabel_3.setBounds(714, 25, 110, 150);
		frmCineBioskop.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setLabelFor(frmCineBioskop);
		lblNewLabel.setBounds(0, 0, 834, 461);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(Aplikacija.class.getResource("/slike/pozadina.png")));
		frmCineBioskop.getContentPane().add(lblNewLabel);
		frmCineBioskop
				.setIconImage(Toolkit.getDefaultToolkit().getImage(Aplikacija.class.getResource("/slike/favicon.png")));
		frmCineBioskop.setTitle("CINE bioskop");
		frmCineBioskop.setBounds(100, 100, 850, 500);
		frmCineBioskop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int brul = (Integer) spinner.getValue();
				boolean vip = tglbtnNewToggleButton.isSelected();
				if(rdbtnNewRadioButton.isSelected()) film = new Akcija("Fast & Furious 9", "Saga brzih i \u017Eestokih se nastavlja, kao i u svim delovima i u ovom filmu mo\u017Eete o\u010Dekivati mnogo adrenalina, brzine, akcije!", 400);
				else if(rdbtnJamesBondNo.isSelected()) film = new Triler("No time to die", "Agent 007 se vra\u0107a ja\u010Di nego ikad! Ne propustite i ovaj deo sjanog serijala James Bond filmova.", 400);
				else if(rdbtnTheGentlemen.isSelected()) film = new Komedija("The Gentlemen", "Film prati \u017Eivot jednog mutnog biznismena koji se bavi ilegalnim supstancama!", 400);

				Rezervisanje rez = new Rezervisanje(film, brul, vip, comboBox.getSelectedItem().toString());
				rez.setLocationRelativeTo( null );
				rez.setVisible(true);
				rez.setResizable(false);
			}
		});
		btnRezervacije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrikazRezervacija prikazi = new PrikazRezervacija();
				prikazi.setLocationRelativeTo( null );
				prikazi.setVisible(true);
				prikazi.setResizable(false);
			}
		});
		txtrNapomena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sn1 = "Napomena...";
				if(sn1.equals(txtrNapomena.getText())) txtrNapomena.setText("");
			}
		});
	}
}