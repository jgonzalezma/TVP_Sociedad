package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtfield_user;
	private JTextField txtfield_password;
	boolean focusUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtfield_user = new JTextField();
		txtfield_user.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focusUser = true;
			}
		});
		
		txtfield_user.setToolTipText("");
		txtfield_user.setBounds(10, 97, 152, 31);
		contentPane.add(txtfield_user);
		txtfield_user.setColumns(10);
		txtfield_user.requestFocus();
		
		txtfield_password = new JTextField();
		txtfield_password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focusUser = false;
			}
		});
		txtfield_password.setColumns(10);
		txtfield_password.setBounds(10, 164, 152, 31);
		contentPane.add(txtfield_password);
			
		JButton btn_login = new JButton("Log in");
				
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtfield_user.getText();
				String password = txtfield_password.getText();
				
				// Conexion a base de datos
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion = null;
					conexion = DriverManager.getConnection("jdbc:mysql://localhost/sociedad","root", "");
					
					PreparedStatement st;
					ResultSet rs = null;
					try {
						st = conexion.prepareStatement("SELECT * FROM usuarios WHERE num_usuario = '" + username + "'");
						rs = st.executeQuery();
						
						if (rs.next())
							{
							
							if (username.equals(rs.getString("num_usuario")) && password.equals(rs.getString("pass_usuario"))) {
								JOptionPane.showMessageDialog(null, "Has logeado correctamente");
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
								
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Datos incorrectos, intentalo de nuevo");
							}
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}



			}
		});
		
		btn_login.setBounds(35, 228, 103, 37);
		contentPane.add(btn_login);
		
		JLabel lblUsuario = new JLabel("Numero de usuario");
		lblUsuario.setBounds(43, 72, 152, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(51, 139, 72, 14);
		contentPane.add(lblContrasena);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(7);
			}
		});
		btn_7.setBounds(205, 31, 50, 50);
		contentPane.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(8);
			}
		});
		btn_8.setBounds(265, 31, 50, 50);
		contentPane.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(9);
			}
		});
		btn_9.setBounds(325, 31, 50, 50);
		contentPane.add(btn_9);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(4);
			}
		});
		btn_4.setBounds(205, 93, 50, 50);
		contentPane.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(5);
			}
		});
		btn_5.setBounds(265, 93, 50, 50);
		contentPane.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(6);
			}
		});
		btn_6.setBounds(327, 93, 50, 50);
		contentPane.add(btn_6);
		
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(1);
			}
		});
		btn_1.setBounds(205, 154, 50, 50);
		contentPane.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(2);
			}
		});
		btn_2.setBounds(265, 154, 50, 50);
		contentPane.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(3);
			}
		});
		btn_3.setBounds(327, 154, 50, 50);
		contentPane.add(btn_3);
		
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirNumero(0);
			}
		});
		btn_0.setBounds(205, 221, 50, 50);
		contentPane.add(btn_0);
		
		JButton btn_borrar = new JButton("<---");
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = txtfield_user.getText().length();
				int number = txtfield_user.getText().length() -1;
				String store;
				
				if(length > 0) {
					StringBuilder back = new StringBuilder(txtfield_user.getText());
					back.deleteCharAt(number);
					store = back.toString();
					txtfield_user.setText(store);
				}
			}
		});
		
		
		btn_borrar.setBounds(265, 221, 110, 50);
		contentPane.add(btn_borrar);
		
		JLabel lblTpvSociedad = new JLabel("TPV SOCIEDAD");
		lblTpvSociedad.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblTpvSociedad.setBounds(20, 26, 142, 24);
		contentPane.add(lblTpvSociedad);
	}
	
	public void anadirNumero(int num) {
		if(focusUser == true ) {
			txtfield_user.setText(txtfield_user.getText() + num);
		}else {
			txtfield_password.setText(txtfield_password.getText() + num);
		}
		
	}
}
