package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import bean.Mesa;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Reserva extends JFrame {

	private JPanel panel;
	private JDateChooser dateChooser;
	public static JComboBox<String> comboBox = new JComboBox<String>();

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

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion;
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad", "root", "");
				Statement st = conexion.createStatement();
				String sql = "SELECT * FROM mesa";
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					comboBox.addItem(nombre);
					panel.add(comboBox, BorderLayout.SOUTH);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = dateChooser.getDate();
				Date fechaparsed = new java.sql.Date(date.getTime());
				// hay que parsear el date a sql date
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad", "root", "");
					PreparedStatement pst = conexion
							.prepareStatement("INSERT INTO reservas (id_usuario, fecha, mesa) values (?,?,?)");

					Mesa mesa = new Mesa();

					mesa.setId_usuario(Login.username);
					mesa.setFecha((java.sql.Date) fechaparsed);
					String m = (String) comboBox.getSelectedItem();
					mesa.setNombre(m);

					pst.setString(1, mesa.getId_usuario());
					pst.setDate(2, new java.sql.Date(mesa.getFecha().getTime()));
					pst.setString(3, mesa.getNombre());
					pst.execute();

					Mesa_Reservada mesareservada = new Mesa_Reservada();
					mesareservada.setVisible(true);
					dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		dateChooser.add(btnReservar, BorderLayout.SOUTH);
	}

}
