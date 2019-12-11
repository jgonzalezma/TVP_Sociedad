package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TicketFinal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	public JTextField txtField_cantidad, txtField_nombre, txtField_precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketFinal window = new TicketFinal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicketFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTicketDeLa = new JLabel("Ticket de la compra:");
		lblTicketDeLa.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		lblTicketDeLa.setBounds(155, 11, 159, 14);
		frame.getContentPane().add(lblTicketDeLa);
		
		JLabel lblCantidadComprada = new JLabel("Cantidad comprada:");
		lblCantidadComprada.setBounds(61, 106, 118, 14);
		frame.getContentPane().add(lblCantidadComprada);
		
		txtField_cantidad = new JTextField();
		txtField_cantidad.setBounds(185, 99, 52, 29);
		frame.getContentPane().add(txtField_cantidad);
		txtField_cantidad.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(61, 142, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(61, 71, 88, 14);
		frame.getContentPane().add(lblProducto);
		
		txtField_nombre = new JTextField();
		txtField_nombre.setColumns(10);
		txtField_nombre.setBounds(186, 57, 128, 31);
		frame.getContentPane().add(txtField_nombre);
		
		txtField_precio = new JTextField();
		txtField_precio.setColumns(10);
		txtField_precio.setBounds(185, 139, 52, 29);
		frame.getContentPane().add(txtField_precio);
	}
}
