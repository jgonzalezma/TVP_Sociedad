package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;


public class Sociedad extends JFrame {

	private JPanel contentPane;
	static String tipo, nombre, precio;
	static int cantidadDisponible, id;
	private JTextField txtfield_cantidadDisponible;
	private JTextField txtfield_cantidad;
	private JTextField txtfield_precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Sociedad frame;
				try {
					frame = new Sociedad();
					frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
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
	public Sociedad() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 562);
		
		// Conexion a base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = null;
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmRefrescos = new JMenuItem("Refrescos");
		mntmRefrescos.setIcon(new ImageIcon("C:\\Users\\josu\\eclipse-workspace\\Login sociedad\\img\\i_refresco.png"));
		mntmRefrescos.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmRefrescos);
		
		JMenuItem mntmBebi = new JMenuItem("Bebidas alcoholicas");
		mntmBebi.setIcon(new ImageIcon("C:\\Users\\josu\\eclipse-workspace\\Login sociedad\\img\\i_alcohol.png"));
		mntmBebi.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmBebi);
		
		JMenuItem mntmTabaco = new JMenuItem("Tabaco");
		mntmTabaco.setIcon(new ImageIcon("C:\\Users\\josu\\eclipse-workspace\\Login sociedad\\img\\i_tabaco.png"));
		mntmTabaco.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmTabaco);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_refrescos = new JPanel();
		panel_refrescos.setBackground(new Color(0, 204, 255));
		panel_refrescos.setBounds(0, 0, 127, 472);
		contentPane.add(panel_refrescos);
				
		JPanel panel_bebidas = new JPanel();
		panel_bebidas.setBackground(new Color(0, 204, 255));
		panel_bebidas.setBounds(137, 0, 127, 472);
		contentPane.add(panel_bebidas);
		
		JPanel panel_tabaco = new JPanel();
		panel_tabaco.setBackground(new Color(0, 204, 255));
		panel_tabaco.setBounds(274, 0, 127, 472);
		contentPane.add(panel_tabaco);
		
		txtfield_cantidadDisponible = new JTextField();
		txtfield_cantidadDisponible.setEditable(false);
		txtfield_cantidadDisponible.setBounds(440, 35, 46, 31);
		contentPane.add(txtfield_cantidadDisponible);
		txtfield_cantidadDisponible.setColumns(10);
		
		JLabel lblCantidadDisponible = new JLabel("Cantidad disponible");
		lblCantidadDisponible.setBounds(419, 10, 127, 14);
		contentPane.add(lblCantidadDisponible);
		
		JLabel lblNewLabel = new JLabel("Cantidad deseada");
		lblNewLabel.setBounds(539, 10, 117, 14);
		contentPane.add(lblNewLabel);
		
		txtfield_cantidad = new JTextField();
		txtfield_cantidad.setColumns(10);
		txtfield_cantidad.setBounds(559, 35, 46, 31);
		contentPane.add(txtfield_cantidad);
		
		txtfield_precio = new JTextField();
		txtfield_precio.setEditable(false);
		txtfield_precio.setColumns(10);
		txtfield_precio.setBounds(669, 35, 46, 31);
		contentPane.add(txtfield_precio);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(677, 10, 46, 14);
		contentPane.add(lblPrecio);
		
		JPanel panelGestion = new JPanel();
		panelGestion.setBounds(411, 0, 324, 472);
		contentPane.add(panelGestion);
		panelGestion.setLayout(null);
		
		JButton btt_7 = new JButton("7");
		btt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirNumero(7);
			}
		});
		btt_7.setBounds(88, 90, 50, 50);
		panelGestion.add(btt_7);
		
		JButton btt_8 = new JButton("8");
		btt_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(8);
			}
		});
		btt_8.setBounds(148, 90, 50, 50);
		panelGestion.add(btt_8);
		
		JButton btt_9 = new JButton("9");
		btt_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(9);
			}
		});
		btt_9.setBounds(208, 90, 50, 50);
		panelGestion.add(btt_9);
		
		JButton btt_4 = new JButton("4");
		btt_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(4);
			}
		});
		btt_4.setBounds(88, 151, 50, 50);
		panelGestion.add(btt_4);
		
		JButton btt_5 = new JButton("5");
		btt_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(5);
			}
		});
		btt_5.setBounds(148, 151, 50, 50);
		panelGestion.add(btt_5);
		
		JButton btt_6 = new JButton("6");
		btt_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(6);
			}
		});
		btt_6.setBounds(208, 151, 50, 50);
		panelGestion.add(btt_6);
		
		JButton btt_1 = new JButton("1");
		btt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(1);
}
		});
		btt_1.setBounds(88, 212, 50, 50);
		panelGestion.add(btt_1);
		
		JButton btt_2 = new JButton("2");
		btt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(2);
			}
		});
		btt_2.setBounds(148, 212, 50, 50);
		panelGestion.add(btt_2);
		
		JButton btt_3 = new JButton("3");
		btt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(3);
			}
		});
		btt_3.setBounds(208, 212, 50, 50);
		panelGestion.add(btt_3);
		
		JButton btt_0 = new JButton("0");
		btt_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(0);
			}
		});
		btt_0.setBounds(88, 273, 50, 50);
		panelGestion.add(btt_0);
		
		JButton btt_borrar = new JButton("<---");
		btt_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = txtfield_cantidad.getText().length();
				int number = txtfield_cantidad.getText().length() -1;
				String store;
				
				if(length > 0) {
					StringBuilder back = new StringBuilder(txtfield_cantidad.getText());
					back.deleteCharAt(number);
					store = back.toString();
					txtfield_cantidad.setText(store);
					//actualizar();
				}
			}
		});
		btt_borrar.setBounds(148, 273, 110, 50);
		panelGestion.add(btt_borrar);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(30, 373, 128, 50);
		panelGestion.add(btnPagar);
		
		JButton btnSalir = new JButton("Cerrar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(168, 373, 128, 50);
		panelGestion.add(btnSalir);
		
		JLabel lblProducto = new JLabel("");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProducto.setBounds(88, 434, 170, 14);
		panelGestion.add(lblProducto);
		
		try {
			Statement st = conexion.createStatement();
			tipo = "refresco";
			ResultSet rs = st.executeQuery("SELECT * from productos WHERE tipo = '" +tipo+"'");
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				JButton btnNewButton = new JButton(nombre);
				String precio = rs.getString("precio");
				int cantidadDisponible = rs.getInt("cantidad_disponible");
				int id = rs.getInt("id");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
						txtfield_precio.setText(precio + "€");
						lblProducto.setText(nombre);
						System.out.println(id);		
					}
				});
				panel_refrescos.add(btnNewButton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = conexion.createStatement();
			tipo = "bebida_alcoholica";
			ResultSet rs = st.executeQuery("SELECT * from productos WHERE tipo = '" +tipo+"'");
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				JButton btnNewButton = new JButton(rs.getString("nombre"));
				String precio = rs.getString("precio");
				int cantidadDisponible = rs.getInt("cantidad_disponible");
				int id = rs.getInt("id");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
						txtfield_precio.setText(precio + "€");
						lblProducto.setText(nombre);
						System.out.println(id);
					}
				});
				panel_bebidas.add(btnNewButton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = conexion.createStatement();
			tipo = "tabaco";
			ResultSet rs = st.executeQuery("SELECT * from productos WHERE tipo = '" +tipo+"'");
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				JButton btnNewButton = new JButton(nombre);
				String precio = rs.getString("precio");
				int cantidadDisponible = rs.getInt("cantidad_disponible");
				int id = rs.getInt("id");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
						txtfield_precio.setText(precio + "€");
						lblProducto.setText(nombre);
						System.out.println(id);			
					}
				});
				panel_tabaco.add(btnNewButton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}      
	}

	public String getTipo() {
		return tipo;
	}
	
	public void anadirNumero(int num) {
		txtfield_cantidad.setText(txtfield_cantidad.getText() + num);		
	}
	
	public void actualizar() throws ClassNotFoundException, SQLException {
		// Conexion a base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = null;
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
		
		Statement st = conexion.createStatement();
		String tipo = Sociedad.tipo;
		ResultSet rs = st.executeQuery("SELECT * from productos WHERE tipo = '"+tipo+"'");
		try {
			while(rs.next()) {
			int id = Sociedad.id;
			String nombre = rs.getString("nombre");
			String precio = rs.getString("precio");
			//lblProducto.setText(nombre);
			int cantidadDisponible = rs.getInt("cantidad_disponible");
			String cantidad = txtfield_cantidad.getText();
			int c = Integer.parseInt(cantidad);
			double p = Double.parseDouble(precio);
			double res = (double) (p * c);
			txtfield_precio.setText(Double.toString(res) + "€");
			txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
			System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}