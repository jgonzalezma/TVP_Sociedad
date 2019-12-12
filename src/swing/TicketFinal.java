package swing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketFinal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtField_producto, txtField_cantidad, txtField_precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketFinal frame = new TicketFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public TicketFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ticketFinal = new JLabel("Resumen del ticket");
		lbl_ticketFinal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ticketFinal.setBounds(132, 24, 206, 20);
		contentPane.add(lbl_ticketFinal);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(45, 75, 65, 20);
		contentPane.add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(45, 106, 65, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(45, 141, 65, 14);
		contentPane.add(lblPrecio);
		
		txtField_producto = new JTextField();
		txtField_producto.setEditable(false);
		txtField_producto.setBounds(120, 75, 106, 20);
		contentPane.add(txtField_producto);
		txtField_producto.setColumns(10);
		
		txtField_cantidad = new JTextField();
		txtField_cantidad.setEditable(false);
		txtField_cantidad.setBounds(120, 103, 40, 30);
		contentPane.add(txtField_cantidad);
		txtField_cantidad.setColumns(10);
		
		txtField_precio = new JTextField();
		txtField_precio.setEditable(false);
		txtField_precio.setColumns(10);
		txtField_precio.setBounds(120, 138, 40, 30);
		contentPane.add(txtField_precio);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(45, 197, 89, 23);
		contentPane.add(btnCerrar);
	}
}