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
import java.awt.Color;

public class Reserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel, panel_hora;
	private JDateChooser dateChooser;
	public static JComboBox<String> comboBox = new JComboBox<String>();
	private JComboBox<String> comboBoxHora;

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
		setContentPane(panel);

		// Instanciar Componente
		dateChooser = new JDateChooser();

		// Ubicar y agregar al panel
		dateChooser.setBounds(0, 0, 50, 50);
		panel.setLayout(null);

		JDateChooser dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dateChooser.setBounds(5, 0, 274, 55);

		panel.add(dateChooser);

		JLabel lblSeleccioneDiaPara = new JLabel("Seleccione dia para reservar mesa");
		lblSeleccioneDiaPara.setBackground(new Color(0, 191, 255));
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
				
				JPanel panel_reservar = new JPanel();
				panel_reservar.setBackground(new Color(0, 191, 255));
				panel_reservar.setBounds(5, 101, 274, 99);
				panel.add(panel_reservar);
						panel_reservar.setLayout(null);
				
						JButton btnReservar = new JButton("Reservar");
						btnReservar.setBounds(46, 25, 180, 40);
						panel_reservar.add(btnReservar);
						
						panel_hora = new JPanel();
						panel_hora.setBackground(new Color(0, 191, 255));
						panel_hora.setBounds(5, 60, 274, 41);
						panel.add(panel_hora);
						
						JLabel lbl_hora = new JLabel("Hora: ");
						lbl_hora.setFont(new Font("Tahoma", Font.PLAIN, 14));
						panel_hora.add(lbl_hora);
						
						comboBoxHora = new JComboBox<String>();
						comboBoxHora.addItem("12:00");
						comboBoxHora.addItem("13:00");
						comboBoxHora.addItem("14:00");
						comboBoxHora.addItem("15:00");
						panel_hora.add(comboBoxHora);
				btnReservar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Date date = dateChooser.getDate();
						Date fechaparsed = new java.sql.Date(date.getTime());
						// hay que parsear el date a sql date
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad", "root", "");
							PreparedStatement pst = conexion
									.prepareStatement("INSERT INTO reservas (id_usuario, fecha, hora, mesa) values (?,?,?,?)");

							Mesa mesa = new Mesa();

							mesa.setId_usuario(Login.username);
							mesa.setFecha((java.sql.Date) fechaparsed);
							String m = (String) comboBox.getSelectedItem();
							String hora = (String) comboBoxHora.getSelectedItem();
							mesa.setNombre(m);
							mesa.setHora(hora);

							pst.setString(1, mesa.getId_usuario());
							pst.setDate(2, new java.sql.Date(mesa.getFecha().getTime()));
							pst.setString(3, mesa.getHora());
							pst.setString(4, mesa.getNombre());
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
		
	}
}
