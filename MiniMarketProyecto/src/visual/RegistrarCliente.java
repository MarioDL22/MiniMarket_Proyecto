package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.MiniMarket;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	
	private Cliente myCliente = null; 

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente(Cliente cliente) {
		myCliente = cliente; 
		
		if(myCliente == null) {
			setTitle("Registrar Cliente");
		}else {
			setTitle("Actualizar Cliente");
		}
		
		setBounds(100, 100, 416, 292);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBackground(new Color(255, 51, 0));
			panel.setBounds(0, 0, 434, 38);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Registrar Cliente");
				lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 18));
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setBounds(10, 11, 152, 16);
				panel.add(lblNewLabel);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Identificador");
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBounds(10, 54, 110, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtId.setForeground(Color.BLACK);
		txtId.setEditable(false);
		txtId.setBounds(114, 49, 276, 20);
		contentPanel.add(txtId);
		txtId.setColumns(10);
		txtId.setText("MNM-C-" + MiniMarket.genIdCliente);
		txtId.setFocusable(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNombre.setBounds(10, 88, 75, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setBounds(114, 80, 276, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		lblCdula.setForeground(Color.BLACK);
		lblCdula.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblCdula.setBounds(10, 117, 59, 14);
		contentPanel.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedula.setEditable(false);
		txtCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCedula.setForeground(Color.BLACK);
		txtCedula.setBounds(114, 111, 276, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		txtCedula.setText("No Llenar");
		txtCedula.setFocusable(false);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setForeground(Color.BLACK);
		lblTelfono.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblTelfono.setBounds(10, 144, 75, 20);
		contentPanel.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(114, 142, 276, 20);
		contentPanel.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setForeground(Color.BLACK);
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(114, 173, 276, 20);
		contentPanel.add(txtDireccion);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblDireccin.setBounds(10, 175, 81, 18);
		contentPanel.add(lblDireccin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				if(myCliente != null) {
					btnRegistrar = new JButton("Actualizar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(myCliente == null) {
							Cliente elCliente = new Cliente(txtId.getText(), txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtDireccion.getText()); 
							MiniMarket.getInstance().ingresarCliente(myCliente);
							JOptionPane.showMessageDialog(null, "¡Cliente Registrado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							limpiar(); 
						}else {
							myCliente.setNombre(txtNombre.getText());
							txtCedula.setText(myCliente.getCedula());
							txtCedula.setEnabled(false);
							myCliente.setTelefono(txtTelefono.getText());
							myCliente.setDireccion(txtDireccion.getText());
							
							
							dispose();
						}
					}
				});
				btnRegistrar.setForeground(Color.BLACK);
				btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnRegistrar.setBackground(SystemColor.menu);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setBackground(SystemColor.menu);
				btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCancelar.setForeground(Color.BLACK);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		cargarClientes(); 
		ImageIcon otroIcon = new ImageIcon(getClass().getResource("/icons/id-card-icon.png")); 
		setIconImage(otroIcon.getImage());
	}
	
	private void cargarClientes() {
		if(myCliente != null) {
			txtId.setText(myCliente.getIdentificador());
			txtNombre.setText(myCliente.getNombre());
			txtCedula.setText(myCliente.getCedula());
			txtCedula.setEnabled(false);
			txtTelefono.setText(myCliente.getTelefono());
			txtDireccion.setText(myCliente.getDireccion());
		}
	}
	
	private void limpiar() {
		txtId.setText("MNM-C-" + MiniMarket.genIdCliente);
		txtNombre.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
	}
}
