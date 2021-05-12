package projekat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Provera extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel dialogTekst;

	public Provera() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Provera.class.getResource("/slike/favicon.png")));
		setTitle("CINE gre\u0161ka");
		setBounds(100, 100, 450, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("Zatvori");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			dialogTekst = new JLabel("Uneti podaci nisu ispravni.");
			dialogTekst.setFont(new Font("Tahoma", Font.PLAIN, 13));
			dialogTekst.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(dialogTekst, BorderLayout.CENTER);
		}
	}
	
	public JLabel getDialogTekst() {
		return dialogTekst;
	}

	public void setDialogTekst(String st) {
		this.dialogTekst.setText(st);
	}

}