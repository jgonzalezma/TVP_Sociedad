package swing;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Cantidad_Producto extends JFrame {

	private JPanel contentPane;
	public JTextField txtfield_cantidad;
	public JTextField txtfield_cantidadDisponible;
	public JTextField txtfield_precio;
	JLabel lblProducto = new JLabel("");
	
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
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtfield_cantidad = new JTextField();
		txtfield_cantidad.setEditable(false);
		
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
		
		JButton btt_borrar = new JButton("<---");
		btt_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int length = txtfield_cantidad.getText().length();
				int number = txtfield_cantidad.getText().length() -1;
				String store;
				
				if(length > 0) {
					StringBuilder back = new StringBuilder(txtfield_cantidad.getText());
					back.deleteCharAt(number);
					store = back.toString();
					txtfield_cantidad.setText(store);
					actualizar();
				}
			}
		});
		btt_borrar.setBounds(80, 290, 110, 50);
		contentPane.add(btt_borrar);
		
		JButton btt_0 = new JButton("0");
		btt_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(0);
			}
		});
		btt_0.setBounds(20, 290, 50, 50);
		contentPane.add(btt_0);
		
		JButton btn_1 = new JButton("1");
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(1);
			}
		});
		btn_1.setBounds(20, 223, 50, 50);
		contentPane.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(2);
			}
		});
		btn_2.setBounds(80, 223, 50, 50);
		contentPane.add(btn_2);
		
		JButton btt_3 = new JButton("3");
		btt_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(3);
			}
		});
		btt_3.setBounds(142, 223, 50, 50);
		contentPane.add(btt_3);
		
		JButton btt_6 = new JButton("6");
		btt_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(6);
			}
		});
		btt_6.setBounds(142, 162, 50, 50);
		contentPane.add(btt_6);
		
		JButton btt_9 = new JButton("9");
		btt_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(9);
			}
		});
		btt_9.setBounds(140, 100, 50, 50);
		contentPane.add(btt_9);
		
		JButton btt_5 = new JButton("5");
		btt_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(5);
			}
		});
		btt_5.setBounds(80, 162, 50, 50);
		contentPane.add(btt_5);
		
		JButton btt_4 = new JButton("4");
		btt_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(4);
			}
		});
		btt_4.setBounds(20, 162, 50, 50);
		contentPane.add(btt_4);
		
		JButton btt_7 = new JButton("7");
		btt_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(7);
			}
		});
		btt_7.setBounds(20, 100, 50, 50);
		contentPane.add(btt_7);
		
		JButton btt_8 = new JButton("8");
		btt_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizar();
			}
		});
		btt_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(8);
			}
		});
		btt_8.setBounds(80, 100, 50, 50);
		contentPane.add(btt_8);
		
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
		lblProducto.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		
		
		lblProducto.setBounds(260, 308, 126, 32);
		contentPane.add(lblProducto);
		
	}
	public void anadirNumero(int num) {
		txtfield_cantidad.setText(txtfield_cantidad.getText() + num);		
	}
	public void actualizar() {
		String nombre = Sociedad.nombre;
		System.out.println(nombre);
		String precio = Sociedad.precio;
		int cantidadDisponible = Sociedad.cantidadDisponible;
		String cantidad = txtfield_cantidad.getText();
		int c = Integer.parseInt(cantidad);
		double p = Double.parseDouble(precio);
		double res = (double) (p*c);
		
		// Conexion a base de datos
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = null;
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
			
			Statement st = conexion.createStatement();
			String tipo = Sociedad.tipo;
			ResultSet rs = st.executeQuery("SELECT * from productos WHERE tipo = '"+tipo+"'");
			
			txtfield_precio.setText(Double.toString(res) + "€");
			txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void actualizar2() throws ClassNotFoundException, SQLException {
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
			lblProducto.setText(nombre);
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
