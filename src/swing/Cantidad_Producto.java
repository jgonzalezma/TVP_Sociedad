package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import swing.Sociedad;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cantidad_Producto extends JFrame {

	private JPanel contentPane;
	public JTextField txtfield_cantidad;
	public JTextField txtfield_cantidadDisponible;
	public JTextField txtfield_precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cantidad_Producto frame = new Cantidad_Producto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Cantidad_Producto() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 410);
		
		Sociedad sociedad = new Sociedad();
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Conexion a base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = null;
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT * from productos");
		
		txtfield_cantidad = new JTextField();
		txtfield_cantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					while(rs.next()) {
					try {
						String precio = rs.getString("precio");
						int cantidadDisponible = rs.getInt("cantidad_disponible");
						String cantidad = txtfield_cantidad.getText();
						int c = Integer.parseInt(cantidad);
						double p = Double.parseDouble(precio);
						double res = (double) (p * c);
						txtfield_precio.setText(Double.toString(res) + "€");
						txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		txtfield_cantidad.setBackground(new Color(0, 255, 204));
		txtfield_cantidad.setText("1");
		txtfield_cantidad.setBounds(136, 46, 140, 36);
		contentPane.add(txtfield_cantidad);
		txtfield_cantidad.setColumns(10);
		
		JLabel lblCanti = new JLabel("Cantidad");
		lblCanti.setBounds(182, 21, 62, 14);
		contentPane.add(lblCanti);
		
		// Aparecera aqui la cantidad del producto
		txtfield_cantidadDisponible = new JTextField();
		txtfield_cantidadDisponible.setEditable(false);
		txtfield_cantidadDisponible.setBounds(10, 46, 116, 34);
		contentPane.add(txtfield_cantidadDisponible);
		txtfield_cantidadDisponible.setColumns(10);
		
		JLabel lblCantidadDisponible = new JLabel("Cantidad disponible");
		lblCantidadDisponible.setBounds(10, 21, 126, 14);
		contentPane.add(lblCantidadDisponible);
		
		txtfield_precio = new JTextField();
		txtfield_precio.setEditable(false);
		txtfield_precio.setColumns(10);
		txtfield_precio.setBounds(286, 46, 116, 34);
		contentPane.add(txtfield_precio);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(321, 23, 46, 14);
		contentPane.add(lblPrecio);
		
		JButton button = new JButton("<---");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int length = txtfield_cantidad.getText().length();
				int number = txtfield_cantidad.getText().length() -1;
				String store;
				
				if(length > 0) {
					StringBuilder back = new StringBuilder(txtfield_cantidad.getText());
					back.deleteCharAt(number);
					store = back.toString();
					txtfield_cantidad.setText(store);
				}
			}
		});
		button.setBounds(80, 290, 110, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(0);
			}
		});
		button_1.setBounds(20, 290, 50, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(1);
			}
		});
		button_2.setBounds(20, 223, 50, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(2);
			}
		});
		button_3.setBounds(80, 223, 50, 50);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("3");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(3);
			}
		});
		button_4.setBounds(142, 223, 50, 50);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(6);
			}
		});
		button_5.setBounds(142, 162, 50, 50);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("9");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(9);
			}
		});
		button_6.setBounds(140, 100, 50, 50);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("5");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(5);
			}
		});
		button_7.setBounds(80, 162, 50, 50);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("4");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(4);
			}
		});
		button_8.setBounds(20, 162, 50, 50);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("7");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(7);
			}
		});
		button_9.setBounds(20, 100, 50, 50);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("8");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(8);
			}
		});
		button_10.setBounds(80, 100, 50, 50);
		contentPane.add(button_10);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket ticket = new Ticket();
				ticket.setVisible(true);
			}
		});
		btnPagar.setBounds(260, 124, 126, 50);
		contentPane.add(btnPagar);
		
		JButton btnSalir = new JButton("Cerrar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(260, 205, 126, 50);
		contentPane.add(btnSalir);
		
	}
	public void anadirNumero(int num) {
		txtfield_cantidad.setText(txtfield_cantidad.getText() + num);		
	}
}
