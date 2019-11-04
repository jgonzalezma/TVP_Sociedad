package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ticket extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
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
	public Ticket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuieresImprimirUn = new JLabel("\u00BFQuieres imprimir un ticket?");
		lblQuieresImprimirUn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuieresImprimirUn.setBounds(115, 26, 206, 20);
		contentPane.add(lblQuieresImprimirUn);
		
		JButton btnSi = new JButton("SI");
		btnSi.setBackground(new Color(0, 255, 0));
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSi.setBounds(54, 121, 113, 41);
		contentPane.add(btnSi);
		
		JButton btnNo = new JButton("NO");
		btnNo.setBackground(new Color(255, 0, 0));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNo.setBounds(268, 121, 113, 41);
		contentPane.add(btnNo);
	}
}
