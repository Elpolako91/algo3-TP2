package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaMenuPrincipal extends JFrame {
	
	final VistaMenuJugador vista2 = new VistaMenuJugador();

	/**
	 * Create the frame.
	 */
	public VistaMenuPrincipal() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar Partida");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				vista2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(233, 183, 180, 57);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(233, 274, 180, 50);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblMenuPrincipal = new JLabel("Bienvenido a AlgoCraft");
		lblMenuPrincipal.setForeground(new Color(72, 61, 139));
		lblMenuPrincipal.setFont(new Font("Vani", Font.BOLD | Font.ITALIC, 40));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setBounds(41, 11, 556, 84);
		getContentPane().add(lblMenuPrincipal);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Familia\\Desktop\\wall2-1920x1200.jpg"));
		lblNewLabel.setBounds(0, 0, 631, 606);
		getContentPane().add(lblNewLabel);
		
	}
}