package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reserva extends JFrame {

	private JPanel panel;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva frame = new Reserva();
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
	public Reserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
		
		// Instanciar Componente
		dateChooser = new JDateChooser();
		 
		// Ubicar y agregar al panel
		dateChooser.setBounds(0, 0, 50, 50);
		JDateChooser dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		
		 
		panel.add(dateChooser);
		
		JLabel lblSeleccioneDiaPara = new JLabel("Seleccione dia para reservar mesa");
		lblSeleccioneDiaPara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateChooser.add(lblSeleccioneDiaPara, BorderLayout.NORTH);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = dateChooser.getDate();
				System.out.println(date);
			}
		});
		dateChooser.add(btnReservar, BorderLayout.SOUTH);
	}

}
