package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginOpciones extends JFrame {

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
					LoginOpciones frame = new LoginOpciones();
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
	public LoginOpciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReservarMesa = new JButton("Reservar mesa");
		btnReservarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reserva reserva = new Reserva();
				reserva.setVisible(true);
				dispose();
			}
		});
		btnReservarMesa.setBounds(233, 108, 149, 48);
		contentPane.add(btnReservarMesa);
		
		JButton btnComprarProductos = new JButton("Comprar productos");
		btnComprarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Sociedad sociedad = new Sociedad();
					sociedad.setVisible(true);
					dispose();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnComprarProductos.setBounds(47, 108, 149, 48);
		contentPane.add(btnComprarProductos);
		
		JLabel lblaQuePantalla = new JLabel("\u00BFA que pantalla desea ir?");
		lblaQuePantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaQuePantalla.setBounds(100, 46, 254, 25);
		contentPane.add(lblaQuePantalla);
		
		JButton btnVerGastos = new JButton("Ver gastos");
		btnVerGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gastos gastos = new Gastos();
				gastos.setVisible(true);
				dispose();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
					String sql = "SELECT SUM(gasto) FROM gastos;";
					PreparedStatement pst = conexion.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					rs.next();
					Double gasto = rs.getDouble(1);
					Double roundGasto = Math.round(gasto * 100.0) / 100.0;
					gastos.textField_gastos.setText(roundGasto+"�");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnVerGastos.setBounds(136, 180, 149, 48);
		contentPane.add(btnVerGastos);
	}
}
