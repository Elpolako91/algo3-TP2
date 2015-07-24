package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import javax.swing.JTextPane;

public class VistaGanador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VistaGanador(String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 572, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Sonido triunfo = new Sonido("aplausos_de_ganadores.au");
		triunfo.reproducir();
		
		JTextPane txtGanador = new JTextPane();
		txtGanador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		txtGanador.setText("GANADOR: " + nombre + "!!");
		txtGanador.setBounds(10, 77, 536, 92);
		contentPane.add(txtGanador);
			
	}
}
