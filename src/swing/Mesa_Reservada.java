package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mesa_Reservada extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesa_Reservada frame = new Mesa_Reservada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mesa_Reservada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					LoginOpciones menu = new LoginOpciones();
					menu.setVisible(true);
					dispose();
			}
		});
		
		btnNewButton.setBounds(168, 162, 106, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblMesaReservadaCorrectamente = new JLabel("Mesa reservada correctamente.");
		lblMesaReservadaCorrectamente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMesaReservadaCorrectamente.setBounds(92, 24, 278, 22);
		contentPane.add(lblMesaReservadaCorrectamente);
		
		JLabel lblParaVolverAl = new JLabel("Para volver al men\u00FA principal,");
		lblParaVolverAl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblParaVolverAl.setBounds(92, 57, 261, 22);
		contentPane.add(lblParaVolverAl);
		
		JLabel lblPulsaEnEl = new JLabel("pulsa en el bot\u00F3n de volver");
		lblPulsaEnEl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPulsaEnEl.setBounds(92, 90, 229, 22);
		contentPane.add(lblPulsaEnEl);
	}
}
