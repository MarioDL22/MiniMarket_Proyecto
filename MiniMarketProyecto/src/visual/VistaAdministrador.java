package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import logico.Empleado;
import javax.swing.JScrollPane;

public class VistaAdministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim; 
	private JPanel panelIzquierdo;
	private JPanel panelGeneral;
	private JButton btnCerrarSesion;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtBienvenido;
	private JTextField txtEmpleado;
	private Empleado elEmpleado; 
	private PrincipalLogin volverLogin;
	private JScrollPane scrollPane;
	private JPanel panelOpciones;
	private JPanel panelModifUsuario;
	private JPanel subPanelModif;
	private JButton btnModificarUsuario;
	private JPanel panelIngresarPersonas;
	private JPanel subPanelIngresar;
	private JButton btnIngresarPersonas;
	private JPanel panelGestionCliente;
	private JPanel subPanelGestionCliente;
	private JButton btnGestionarClientes;
	private JPanel panelGestionEmpleados;
	private JPanel subPanelGestionEmpleados;
	private JButton btnGestionarEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VistaAdministrador dialog = new VistaAdministrador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VistaAdministrador() {
		setTitle("Vista Administrador");
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize(); 
		setSize(dim.width, dim.height - 45);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panelIzquierdo = new JPanel();
			panelIzquierdo.setBackground(new Color(255, 51, 0));
			panelIzquierdo.setPreferredSize(new Dimension(180, 45));
			contentPanel.add(panelIzquierdo, BorderLayout.WEST);
			panelIzquierdo.setLayout(null);
			
			btnCerrarSesion = new JButton("> Cerrar Sesi\u00F3n");
			btnCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea realmente cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
					if (confirmacion == JOptionPane.YES_OPTION) {
						//volverLogin.mostrarLogin();
					}
				}
			});
			btnCerrarSesion.setBorderPainted(false);
			btnCerrarSesion.setFocusPainted(false);
			btnCerrarSesion.setBackground(new Color(255, 255, 255));
			btnCerrarSesion.setOpaque(true);
			btnCerrarSesion.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnCerrarSesion.setForeground(new Color(255, 51, 0));
			btnCerrarSesion.setBounds(10, 633, 160, 30);
			panelIzquierdo.add(btnCerrarSesion);
			
			txtFecha = new JTextField();
			txtFecha.setBackground(new Color(255, 51, 0));
			txtFecha.setFont(new Font("Sylfaen", Font.BOLD, 15));
			txtFecha.setForeground(new Color(255, 255, 255));
			txtFecha.setEditable(false);
			txtFecha.setBounds(10, 11, 84, 20);
			panelIzquierdo.add(txtFecha);
			txtFecha.setColumns(10);
			txtFecha.setBorder(null);
			LocalDate hoy = LocalDate.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			txtFecha.setText(hoy.format(formato));
			txtFecha.setFocusable(false);
			
			txtHora = new JTextField();
			txtHora.setBackground(new Color(255, 51, 0));
			txtHora.setFont(new Font("Sylfaen", Font.BOLD, 15));
			txtHora.setForeground(new Color(255, 255, 255));
			txtHora.setEditable(false);
			txtHora.setBounds(100, 11, 70, 20);
			panelIzquierdo.add(txtHora);
			txtHora.setColumns(10);
			
			Timer timer = new Timer(1000, e -> {
				LocalTime horaActual = LocalTime.now(); 
				DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("hh:mm a");
				txtHora.setText(horaActual.format(formatoHora));
			});
			timer.start(); 
			txtHora.setFocusable(false);
			txtHora.setBorder(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 33, 180, 2);
			panelIzquierdo.add(panel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(0, 620, 180, 2);
			panelIzquierdo.add(panel_1);
			
			txtBienvenido = new JTextField();
			txtBienvenido.setText("Bienvenido");
			txtBienvenido.setForeground(Color.WHITE);
			txtBienvenido.setFont(new Font("Sylfaen", Font.BOLD, 15));
			txtBienvenido.setFocusable(false);
			txtBienvenido.setEditable(false);
			txtBienvenido.setColumns(10);
			txtBienvenido.setBorder(null);
			txtBienvenido.setBackground(new Color(255, 51, 0));
			txtBienvenido.setBounds(10, 42, 84, 20);
			panelIzquierdo.add(txtBienvenido);
			
			txtEmpleado = new JTextField();
			txtEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
			txtEmpleado.setBackground(new Color(255, 51, 0));
			txtEmpleado.setEditable(false);
			txtEmpleado.setFont(new Font("Sylfaen", Font.BOLD, 15));
			txtEmpleado.setForeground(new Color(255, 255, 255));
			txtEmpleado.setBounds(84, 42, 86, 20);
			panelIzquierdo.add(txtEmpleado);
			txtEmpleado.setColumns(10);
			//txtEmpleado.setText(elEmpleado.getIdentificador());
			txtEmpleado.setFocusable(false);
			txtEmpleado.setBorder(null);
		}
		{
			panelGeneral = new JPanel();
			panelGeneral.setBackground(new Color(255, 255, 255));
			contentPanel.add(panelGeneral, BorderLayout.CENTER);
			panelGeneral.setLayout(new BorderLayout(0, 0));
			
			scrollPane = new JScrollPane();
			panelGeneral.add(scrollPane, BorderLayout.CENTER);
			
			panelOpciones = new JPanel();
			panelOpciones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelOpciones.setBackground(new Color(255, 255, 255));
			scrollPane.setViewportView(panelOpciones);
			panelOpciones.setLayout(null);
			
			panelModifUsuario = new JPanel();
			panelModifUsuario.setBackground(new Color(248, 248, 255));
			panelModifUsuario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelModifUsuario.setBounds(24, 22, 233, 227);
			panelOpciones.add(panelModifUsuario);
			panelModifUsuario.setLayout(null);
			
			subPanelModif = new JPanel();
			subPanelModif.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelModif.setBounds(10, 11, 213, 167);
			panelModifUsuario.add(subPanelModif);
			subPanelModif.setLayout(new BorderLayout(0, 0));
			
			btnModificarUsuario = new JButton("Modificar Usuario");
			btnModificarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnModificarUsuario.setForeground(new Color(255, 51, 0));
			btnModificarUsuario.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnModificarUsuario.setBackground(new Color(255, 255, 255));
			btnModificarUsuario.setBounds(10, 189, 213, 27);
			panelModifUsuario.add(btnModificarUsuario);
			btnModificarUsuario.setBorderPainted(false);
			btnModificarUsuario.setFocusPainted(false);
			btnModificarUsuario.setOpaque(true);
			
			panelIngresarPersonas = new JPanel();
			panelIngresarPersonas.setLayout(null);
			panelIngresarPersonas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelIngresarPersonas.setBackground(new Color(248, 248, 255));
			panelIngresarPersonas.setBounds(299, 22, 233, 227);
			panelOpciones.add(panelIngresarPersonas);
			
			subPanelIngresar = new JPanel();
			subPanelIngresar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelIngresar.setBounds(10, 11, 213, 167);
			panelIngresarPersonas.add(subPanelIngresar);
			subPanelIngresar.setLayout(new BorderLayout(0, 0));
			
			btnIngresarPersonas = new JButton("Ingresar Personas");
			btnIngresarPersonas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnIngresarPersonas.setOpaque(true);
			btnIngresarPersonas.setForeground(new Color(255, 51, 0));
			btnIngresarPersonas.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnIngresarPersonas.setFocusPainted(false);
			btnIngresarPersonas.setBorderPainted(false);
			btnIngresarPersonas.setBackground(Color.WHITE);
			btnIngresarPersonas.setBounds(10, 189, 213, 27);
			panelIngresarPersonas.add(btnIngresarPersonas);
			
			panelGestionCliente = new JPanel();
			panelGestionCliente.setLayout(null);
			panelGestionCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGestionCliente.setBackground(new Color(248, 248, 255));
			panelGestionCliente.setBounds(577, 22, 233, 227);
			panelOpciones.add(panelGestionCliente);
			
			subPanelGestionCliente = new JPanel();
			subPanelGestionCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelGestionCliente.setBounds(10, 11, 213, 167);
			panelGestionCliente.add(subPanelGestionCliente);
			subPanelGestionCliente.setLayout(new BorderLayout(0, 0));
			
			btnGestionarClientes = new JButton("Gestionar Clientes");
			btnGestionarClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnGestionarClientes.setOpaque(true);
			btnGestionarClientes.setForeground(new Color(255, 51, 0));
			btnGestionarClientes.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnGestionarClientes.setFocusPainted(false);
			btnGestionarClientes.setBorderPainted(false);
			btnGestionarClientes.setBackground(Color.WHITE);
			btnGestionarClientes.setBounds(10, 189, 213, 27);
			panelGestionCliente.add(btnGestionarClientes);
			
			panelGestionEmpleados = new JPanel();
			panelGestionEmpleados.setLayout(null);
			panelGestionEmpleados.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGestionEmpleados.setBackground(new Color(248, 248, 255));
			panelGestionEmpleados.setBounds(854, 22, 233, 227);
			panelOpciones.add(panelGestionEmpleados);
			
			subPanelGestionEmpleados = new JPanel();
			subPanelGestionEmpleados.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelGestionEmpleados.setBounds(10, 11, 213, 167);
			panelGestionEmpleados.add(subPanelGestionEmpleados);
			subPanelGestionEmpleados.setLayout(new BorderLayout(0, 0));
			
			btnGestionarEmpleados = new JButton("Gestionar Empleados");
			btnGestionarEmpleados.setOpaque(true);
			btnGestionarEmpleados.setForeground(new Color(255, 51, 0));
			btnGestionarEmpleados.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnGestionarEmpleados.setFocusPainted(false);
			btnGestionarEmpleados.setBorderPainted(false);
			btnGestionarEmpleados.setBackground(Color.WHITE);
			btnGestionarEmpleados.setBounds(10, 189, 213, 27);
			panelGestionEmpleados.add(btnGestionarEmpleados);
		}
		
		ImageIcon otroIcon = new ImageIcon(getClass().getResource("/icons/world-icon.png")); 
		setIconImage(otroIcon.getImage());
	}
}
