package swing;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Gasto;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class Sociedad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String tipo = null, nuevoprecio, nom;
	private int nuevaCantidadDisponible, cantidad;
	private Double res, roundRes;
	private JTextField txtfield_cantidadDisponible;
	private JTextField txtfield_cantidad;
	private JTextField txtfield_precio;
	private JLabel lblProducto;
	private JButton btt_1, btt_2, btt_3, btt_4, btt_5, btt_6, btt_7, btt_8, btt_9, btt_0, btt_borrar, btnPagar, btnSalir;
	private ResultSet rs1, rs2, rs3;

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
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_refrescos = new JPanel();
		panel_refrescos.setBackground(new Color(0, 204, 255));
		panel_refrescos.setBounds(0, 40, 127, 483);
		contentPane.add(panel_refrescos);
				
		JPanel panel_bebidas = new JPanel();
		panel_bebidas.setBackground(new Color(0, 204, 255));
		panel_bebidas.setBounds(137, 40, 127, 483);
		contentPane.add(panel_bebidas);
		
		JPanel panel_tabaco = new JPanel();
		panel_tabaco.setBackground(new Color(0, 204, 255));
		panel_tabaco.setBounds(274, 40, 127, 483);
		contentPane.add(panel_tabaco);
		
		txtfield_cantidadDisponible = new JTextField();
		txtfield_cantidadDisponible.setEditable(false);
		txtfield_cantidadDisponible.setBounds(440, 75, 58, 39);
		contentPane.add(txtfield_cantidadDisponible);
		txtfield_cantidadDisponible.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(677, 50, 46, 14);
		contentPane.add(lblPrecio);
		
		JPanel panelGestion = new JPanel();
		panelGestion.setBackground(new Color(0, 191, 255));
		panelGestion.setBounds(411, 40, 324, 483);
		contentPane.add(panelGestion);
		panelGestion.setLayout(null);
		
		btt_7 = new JButton("7");
		btt_7.setEnabled(false);
		btt_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirNumero(7);
			}
		});
		btt_7.setBounds(88, 90, 50, 50);
		panelGestion.add(btt_7);
		
		btt_8 = new JButton("8");
		btt_8.setEnabled(false);
		btt_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(8);
			}
		});
		btt_8.setBounds(148, 90, 50, 50);
		panelGestion.add(btt_8);
		
		btt_9 = new JButton("9");
		btt_9.setEnabled(false);
		btt_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(9);
			}
		});
		btt_9.setBounds(208, 90, 50, 50);
		panelGestion.add(btt_9);
		
		btt_4 = new JButton("4");
		btt_4.setEnabled(false);
		btt_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(4);
			}
		});
		btt_4.setBounds(88, 151, 50, 50);
		panelGestion.add(btt_4);
		
		btt_5 = new JButton("5");
		btt_5.setEnabled(false);
		btt_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(5);
			}
		});
		btt_5.setBounds(148, 151, 50, 50);
		panelGestion.add(btt_5);
		
		btt_6 = new JButton("6");
		btt_6.setEnabled(false);
		btt_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(6);
			}
		});
		btt_6.setBounds(208, 151, 50, 50);
		panelGestion.add(btt_6);
		
		btt_1 = new JButton("1");
		btt_1.setEnabled(false);
		btt_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(1);
}
		});
		btt_1.setBounds(88, 212, 50, 50);
		panelGestion.add(btt_1);
		
		btt_2 = new JButton("2");
		btt_2.setEnabled(false);
		btt_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(2);
			}
		});
		btt_2.setBounds(148, 212, 50, 50);
		panelGestion.add(btt_2);
		
		btt_3 = new JButton("3");
		btt_3.setEnabled(false);
		btt_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(3);
			}
		});
		btt_3.setBounds(208, 212, 50, 50);
		panelGestion.add(btt_3);
		
		btt_0 = new JButton("0");
		btt_0.setEnabled(false);
		btt_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					actualizar();
					btnPagar.setEnabled(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btt_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(0);
			}
		});
		btt_0.setBounds(88, 273, 50, 50);
		panelGestion.add(btt_0);
		
		btt_borrar = new JButton("<---");
		btt_borrar.setEnabled(false);

		btt_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = txtfield_cantidad.getText().length();
				int number = txtfield_cantidad.getText().length() -1;
				String store;
				
				if(length > 0) {
					try {
						StringBuilder back = new StringBuilder(txtfield_cantidad.getText());
						back.deleteCharAt(number);
						store = back.toString();
						txtfield_cantidad.setText(store);
						cantidad = Integer.parseInt(txtfield_cantidad.getText());
						actualizar();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}catch (NumberFormatException e2) {
						/*Esta excepcion en concreto salta cuando la cantidad del producto se borra y aparece como string vacio, en este caso deshabilito la opcion de pagar
						 * para que el usuario no pueda coger un producto sin la cantidad especificada
						 */
						btnPagar.setEnabled(false);	
					}
				}else {
						btnPagar.setEnabled(false); // Con esto aseguramos que siga deshabilitado a menos que haya una cantidad especificada
				}
			}
		});
		btt_borrar.setBounds(148, 273, 110, 50);
		panelGestion.add(btt_borrar);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ticket ticket;
				ticket = new Ticket();
				ticket.setVisible(true);
				//Esto se ejecutar� al hacer click en el bot�n "si" en la ventana de impresi�n del ticket
				ticket.btnSi.addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
							try {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
								//La sql1 resta la cantidad comprada al producto en la bd
								//La sql2 a�ade a la entidad "gastos" en la bd la cantidad gastada en el producto, para luego hacer un seguimiento de los gastos realizados
								//La sqlCantidad en un select para consultar la cantidad disponible del producto y poder hacer una comparacion despues y que no se pueda quedar esta cantidad en negativo
								String sql1 = "UPDATE productos SET cantidad_disponible = cantidad_disponible - "+cantidad+" WHERE nombre = '"+nom+"';";
								String sql2 = "INSERT INTO gastos (id_usuario, gasto) values (?,?)";
								String sqlCantidad_dispo = "SELECT * FROM productos WHERE nombre = '"+nom+"'";
								
								PreparedStatement pstCantidad_dispo = conexion.prepareStatement(sqlCantidad_dispo);
								ResultSet rss = pstCantidad_dispo.executeQuery();
								while (rss.next()){
									//Se coge la cantidad disponible del producto y luego comparamos con la cantidad puesta para comprobar que la cantidad NO es mayor que la disponible
									int cantidadDispo = rss.getInt("cantidad_disponible");
									if(cantidadDispo >= cantidad) {
										PreparedStatement pst1 = conexion.prepareStatement(sql1);
										boolean rs = pst1.execute();
										rs = true;
		
										TicketFinal ticketFinal = new TicketFinal();
										ticketFinal.setVisible(true);
										ticketFinal.txtField_producto.setText(nom);						
										ticketFinal.txtField_precio.setText(roundRes.toString() + "�");
										String cant = Integer.toString(cantidad);
										ticketFinal.txtField_cantidad.setText(cant);
										
										PreparedStatement pst2 = conexion.prepareStatement(sql2);
										Gasto gasto = new Gasto();
										gasto.setId_usuario(Login.username);
										gasto.setCantidad(roundRes);
										
										pst2.setString(1, gasto.getId_usuario());
										pst2.setDouble(2, gasto.getCantidad());
										pst2.execute();
										
										}else {
											JOptionPane.showMessageDialog(null,"Has introducido " + cantidad + " y solo quedan " + cantidadDispo + " disponibles");
										}
									}

							} catch (SQLException e1) {
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							}
					}
				});
			}
		});
		btnPagar.setEnabled(false);
		btnPagar.setBounds(30, 373, 128, 50);
		panelGestion.add(btnPagar);
		
		btnSalir = new JButton("Cerrar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(168, 373, 128, 50);
		panelGestion.add(btnSalir);
		
		lblProducto = new JLabel("");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProducto.setBounds(88, 434, 170, 14);
		panelGestion.add(lblProducto);
		
		txtfield_cantidad = new JTextField();
		txtfield_cantidad.setBounds(140, 35, 58, 39);
		panelGestion.add(txtfield_cantidad);
		txtfield_cantidad.setEditable(false);
		txtfield_cantidad.setColumns(10);
		
		txtfield_precio = new JTextField();
		txtfield_precio.setBounds(256, 35, 58, 39);
		panelGestion.add(txtfield_precio);
		txtfield_precio.setEditable(false);
		txtfield_precio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cant. deseada");
		lblNewLabel.setBounds(136, 11, 101, 14);
		panelGestion.add(lblNewLabel);
		
		JLabel lblCantidadDisponible = new JLabel("Cant. disponible");
		lblCantidadDisponible.setBounds(10, 11, 101, 14);
		panelGestion.add(lblCantidadDisponible);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(0, 0, 735, 39);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel lblRefrescos = new JLabel("Refrescos");
		lblRefrescos.setIcon(new ImageIcon("C:\\Users\\josu\\eclipse-workspace\\Login sociedad\\img\\i_refresco.png"));
		lblRefrescos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRefrescos.setBounds(10, 0, 116, 39);
		panel_menu.add(lblRefrescos);
		
		JLabel lblBebidasAlc = new JLabel("Bebidas alc.");
		lblBebidasAlc.setIcon(new ImageIcon("C:\\Users\\josu\\eclipse-workspace\\Login sociedad\\img\\i_alcohol.png"));
		lblBebidasAlc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBebidasAlc.setBounds(136, 0, 128, 39);
		panel_menu.add(lblBebidasAlc);
		
		JLabel lblNewLabel_1 = new JLabel("Tabaco");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\josu\\eclipse-workspace\\Login sociedad\\img\\i_tabaco.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(284, 0, 128, 39);
		panel_menu.add(lblNewLabel_1);
		
		JLabel lblSociedad = new JLabel("SOCIEDAD");
		lblSociedad.setFont(new Font("Wide Latin", Font.PLAIN, 16));
		lblSociedad.setBounds(465, 0, 260, 39);
		panel_menu.add(lblSociedad);
		
		//Select de refrescos
		try {
			Statement st = conexion.createStatement();
			tipo = "refresco";
			rs1 = st.executeQuery("SELECT * from productos WHERE tipo = '" +tipo+"'");
			while(rs1.next()) {
				String nombre = rs1.getString("nombre");
				JButton btnNewButton = new JButton(nombre);
				btnNewButton.setPreferredSize(new Dimension(120,25));
				String precio = rs1.getString("precio");
				int cantidadDisponible = rs1.getInt("cantidad_disponible");
				rs1.getInt("id");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
						txtfield_precio.setText(precio + "�");
						lblProducto.setText(nombre);
						tipo = "refresco";
						botonesEnabled();
						nuevoprecio = precio;
						nuevaCantidadDisponible = cantidadDisponible;
						nom = nombre;
						cantidad = 1;
					}
				});
				panel_refrescos.add(btnNewButton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Select de bebidas alcoholicas
		try {
			Statement st = conexion.createStatement();
			tipo = "bebida_alcoholica";
			rs2 = st.executeQuery("SELECT * from productos WHERE tipo = '" +tipo+"'");
			while(rs2.next()) {
				String nombre = rs2.getString("nombre");
				JButton btnNewButton = new JButton(rs2.getString("nombre"));
				btnNewButton.setPreferredSize(new Dimension(120,25));
				String precio = rs2.getString("precio");
				int cantidadDisponible = rs2.getInt("cantidad_disponible");
				rs2.getInt("id");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
						txtfield_precio.setText(precio + "�");
						lblProducto.setText(nombre);
						tipo = "bebida_alcoholica";
						botonesEnabled();
						nuevoprecio = precio;
						nuevaCantidadDisponible = cantidadDisponible;
						nom = nombre;
						cantidad = 1;
					}
				});
				panel_bebidas.add(btnNewButton);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Select de tabacos
		try {
			Statement st = conexion.createStatement();
			tipo = "tabaco";
			rs3 = st.executeQuery("SELECT * from productos WHERE tipo = '" +tipo+"'");
			while(rs3.next()) {
				String nombre = rs3.getString("nombre");
				JButton btnNewButton = new JButton(nombre);
				btnNewButton.setPreferredSize(new Dimension(120,25));
				String precio = rs3.getString("precio");
				int cantidadDisponible = rs3.getInt("cantidad_disponible");
				rs3.getInt("id");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtfield_cantidadDisponible.setText(Integer.toString(cantidadDisponible));
						txtfield_precio.setText(precio + "�");
						lblProducto.setText(nombre);
						tipo = "tabaco";
						botonesEnabled();
						nuevoprecio = precio;
						nuevaCantidadDisponible = cantidadDisponible;
						nom = nombre;
						cantidad = 1;
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
		int length = txtfield_cantidad.getText().length();
		//Limitar la cantidad de productos a comprar a 3 cifras, el m�ximo de cantidad ser� 999
		if (length < 3){
			txtfield_cantidad.setText(txtfield_cantidad.getText() + num);
			cantidad = Integer.parseInt(txtfield_cantidad.getText());
			btnPagar.setEnabled(true);
		}
	}
	
	//Funci�n para actualizar el precio del producto clickado
	public void actualizar() throws ClassNotFoundException, SQLException {
			if(tipo == "refresco" || tipo == "bebida_alcoholica" || tipo == "tabaco") {
				String cant = txtfield_cantidad.getText();
				Double p = Double.parseDouble(nuevoprecio);
				Double c = Double.parseDouble(cant);
				res = p*c;
				roundRes = Math.round(res * 100.0) / 100.0;
				txtfield_precio.setText(Double.toString(roundRes) + "�");
				txtfield_cantidadDisponible.setText(Integer.toString(nuevaCantidadDisponible));
			}
	}
	
	//Funcion para activar todos los botones, al hacer click en cualquier producto se llamar� a esta funci�n
	public void botonesEnabled() {
		btt_0.setEnabled(true);
		btt_1.setEnabled(true);
		btt_2.setEnabled(true);
		btt_3.setEnabled(true);
		btt_4.setEnabled(true);
		btt_5.setEnabled(true);
		btt_6.setEnabled(true);
		btt_7.setEnabled(true);
		btt_8.setEnabled(true);
		btt_9.setEnabled(true);
		btt_borrar.setEnabled(true);
	}
}