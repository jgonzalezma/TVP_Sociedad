package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Sociedad extends JFrame {

	private JPanel contentPane;


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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
		setBounds(100, 100, 553, 363);
		
		// Conexion a base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = null;
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmRefrescos = new JMenuItem("Refrescos");
		mntmRefrescos.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmRefrescos);
		
		JMenuItem mntmBebi = new JMenuItem("Bebidas alcoholicas");
		mntmBebi.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmBebi);
		
		JMenuItem mntmTabaco = new JMenuItem("Tabaco");
		mntmTabaco.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmTabaco);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_refrescos = new JPanel();
		panel_refrescos.setBackground(new Color(0, 204, 255));
		panel_refrescos.setBounds(0, 0, 161, 300);
		contentPane.add(panel_refrescos);
				
		JPanel panel_bebidas = new JPanel();
		panel_bebidas.setBackground(new Color(0, 204, 255));
		panel_bebidas.setBounds(180, 0, 161, 300);
		contentPane.add(panel_bebidas);
		
		JPanel panel_tabaco = new JPanel();
		panel_tabaco.setBackground(new Color(0, 204, 255));
		panel_tabaco.setBounds(362, 0, 165, 300);
		contentPane.add(panel_tabaco);
		
		/* Consulta a la base de datos los productos, y lo pone como 1 producto = 1 boton (3 columnas, refrescos, 
		 	bebidas alcoholicas y tabaco )
		 */
		try {
			
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from refrescos");
			while(rs.next()) {
				JButton btnNewButton = new JButton(rs.getString("nombre"));
				// Creamos 2 variables para precio y cantidad para guardarlos y usarlos despues
				String precio = rs.getString("precio");
				int cantidadDisponible = rs.getInt("cantidad_disponible");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*
						 * Creamos el frame nuevo y metemos los valores de las variables de precio y cantidad
						 */
						Cantidad_Producto cantidadProducto;
						try {
							cantidadProducto = new Cantidad_Producto();
							String cantidad = cantidadProducto.txtfield_cantidad.getText();
							int c = Integer.parseInt(cantidad);
							double p = Double.parseDouble(precio);
							double res = (double) (p * c);
							cantidadProducto.txtfield_precio.setText(Double.toString(res));
							cantidadProducto.setVisible(true);
							cantidadProducto.txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				panel_refrescos.add(btnNewButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from bebidas_alcoholicas");
			while(rs.next()) {
				JButton btnNewButton = new JButton(rs.getString("nombre"));
				String precio = rs.getString("precio");
				int cantidadDisponible = rs.getInt("cantidad_disponible");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Cantidad_Producto cantidadProducto;
						try {
							cantidadProducto = new Cantidad_Producto();
							cantidadProducto.setVisible(true);
							cantidadProducto.txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
							cantidadProducto.txtfield_precio.setText(precio + "€");
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				panel_bebidas.add(btnNewButton);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from tabaco");
			while(rs.next()) {
				JButton btnNewButton = new JButton(rs.getString("nombre"));
				String precio = rs.getString("precio");
				int cantidadDisponible = rs.getInt("cantidad_disponible");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Cantidad_Producto cantidadProducto;
						
						try {
							cantidadProducto = new Cantidad_Producto();
							cantidadProducto.setVisible(true);
							cantidadProducto.txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
							cantidadProducto.txtfield_precio.setText(precio + "€");
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				panel_tabaco.add(btnNewButton);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
