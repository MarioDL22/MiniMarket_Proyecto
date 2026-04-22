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
import java.awt.Image;
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
import javax.swing.JScrollBar;

public class VistaAdministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim; 
	private JPanel panelIzquierdo;
	private JPanel panelGeneral;
	private JButton btnCerrarSesion;
	private JTextField txtFecha;
	private JTextField txtHora;
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
	private JPanel panelAlmacen;
	private JPanel subPanelAlmacen;
	private JButton btnGestionAlmacen;
	private JPanel panelVenta;
	private JPanel subPanelVenta;
	private JButton btnRealizarVenta;
	private JPanel panelRespaldoDatos;
	private JPanel subPanelRespaldo;
	private JPanel panelVerVentasDelivery;
	private JPanel panel_2;
	private JTextField txtMenAdministrador;

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
		}
		{
			panelGeneral = new JPanel();
			panelGeneral.setBackground(new Color(255, 255, 255));
			contentPanel.add(panelGeneral, BorderLayout.CENTER);
			panelGeneral.setLayout(new BorderLayout(0, 0));
			
			panelOpciones = new JPanel();
			panelOpciones.setLayout(null);
			panelOpciones.setPreferredSize(new Dimension(1200, 1200));
			
			scrollPane = new JScrollPane(panelOpciones);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			panelGeneral.add(scrollPane, BorderLayout.CENTER);
			
			panelModifUsuario = new JPanel();
			panelModifUsuario.setBackground(new Color(248, 248, 255));
			panelModifUsuario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelModifUsuario.setBounds(24, 75, 253, 263);
			panelOpciones.add(panelModifUsuario);
			panelModifUsuario.setLayout(null);
			
			subPanelModif = new JPanel();
			subPanelModif.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelModif.setBounds(10, 11, 233, 203);
			panelModifUsuario.add(subPanelModif);
			//subPanelModif.setLayout(null);
			subPanelModif.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/ImgModificarUsuario.png")); 
			Image img2 = logo.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo2 = new JLabel(new ImageIcon(img2)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelModif.add(fondo2, BorderLayout.CENTER);
			
			btnModificarUsuario = new JButton("Modificar Usuario");
			btnModificarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnModificarUsuario.setForeground(new Color(255, 51, 0));
			btnModificarUsuario.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnModificarUsuario.setBackground(new Color(255, 255, 255));
			btnModificarUsuario.setBounds(10, 225, 233, 27);
			panelModifUsuario.add(btnModificarUsuario);
			btnModificarUsuario.setBorderPainted(false);
			btnModificarUsuario.setFocusPainted(false);
			btnModificarUsuario.setOpaque(true);
			
			panelIngresarPersonas = new JPanel();
			panelIngresarPersonas.setLayout(null);
			panelIngresarPersonas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelIngresarPersonas.setBackground(new Color(248, 248, 255));
			panelIngresarPersonas.setBounds(299, 75, 253, 263);
			panelOpciones.add(panelIngresarPersonas);
			
			subPanelIngresar = new JPanel();
			subPanelIngresar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelIngresar.setBounds(10, 11, 233, 203);
			panelIngresarPersonas.add(subPanelIngresar);
			subPanelIngresar.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo2 = new ImageIcon(getClass().getResource("/imagenes/ImgIngresarUsurio.png")); 
			Image img3 = logo2.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo3 = new JLabel(new ImageIcon(img3)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelIngresar.add(fondo3, BorderLayout.CENTER);
			
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
			btnIngresarPersonas.setBounds(10, 225, 233, 27);
			panelIngresarPersonas.add(btnIngresarPersonas);
			
			panelGestionCliente = new JPanel();
			panelGestionCliente.setLayout(null);
			panelGestionCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGestionCliente.setBackground(new Color(248, 248, 255));
			panelGestionCliente.setBounds(577, 75, 253, 263);
			panelOpciones.add(panelGestionCliente);
			
			subPanelGestionCliente = new JPanel();
			subPanelGestionCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelGestionCliente.setBounds(10, 11, 233, 203);
			panelGestionCliente.add(subPanelGestionCliente);
			subPanelGestionCliente.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo3 = new ImageIcon(getClass().getResource("/imagenes/ImgGestionClientes.png")); 
			Image img4 = logo3.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo4 = new JLabel(new ImageIcon(img4)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelGestionCliente.add(fondo4, BorderLayout.CENTER);
			
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
			btnGestionarClientes.setBounds(10, 225, 233, 27);
			panelGestionCliente.add(btnGestionarClientes);
			
			panelGestionEmpleados = new JPanel();
			panelGestionEmpleados.setLayout(null);
			panelGestionEmpleados.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGestionEmpleados.setBackground(new Color(248, 248, 255));
			panelGestionEmpleados.setBounds(854, 75, 253, 263);
			panelOpciones.add(panelGestionEmpleados);
			
			subPanelGestionEmpleados = new JPanel();
			subPanelGestionEmpleados.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelGestionEmpleados.setBounds(10, 11, 233, 203);
			panelGestionEmpleados.add(subPanelGestionEmpleados);
			subPanelGestionEmpleados.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo4 = new ImageIcon(getClass().getResource("/imagenes/ImgGestionEmpleados.png")); 
			Image img5 = logo4.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo5 = new JLabel(new ImageIcon(img5)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelGestionEmpleados.add(fondo5, BorderLayout.CENTER);
			
			btnGestionarEmpleados = new JButton("Gestionar Empleados");
			btnGestionarEmpleados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnGestionarEmpleados.setOpaque(true);
			btnGestionarEmpleados.setForeground(new Color(255, 51, 0));
			btnGestionarEmpleados.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnGestionarEmpleados.setFocusPainted(false);
			btnGestionarEmpleados.setBorderPainted(false);
			btnGestionarEmpleados.setBackground(Color.WHITE);
			btnGestionarEmpleados.setBounds(10, 225, 233, 27);
			panelGestionEmpleados.add(btnGestionarEmpleados);
			
			panelAlmacen = new JPanel();
			panelAlmacen.setLayout(null);
			panelAlmacen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelAlmacen.setBackground(new Color(248, 248, 255));
			panelAlmacen.setBounds(24, 386, 253, 263);
			panelOpciones.add(panelAlmacen);
			
			subPanelAlmacen = new JPanel();
			subPanelAlmacen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelAlmacen.setBounds(10, 11, 233, 203);
			panelAlmacen.add(subPanelAlmacen);
			subPanelAlmacen.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo5 = new ImageIcon(getClass().getResource("/imagenes/ImgInventario.png")); 
			Image img6 = logo5.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo6 = new JLabel(new ImageIcon(img6)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelAlmacen.add(fondo6, BorderLayout.CENTER);
			
			btnGestionAlmacen = new JButton("Inventario");
			btnGestionAlmacen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnGestionAlmacen.setOpaque(true);
			btnGestionAlmacen.setForeground(new Color(255, 51, 0));
			btnGestionAlmacen.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnGestionAlmacen.setFocusPainted(false);
			btnGestionAlmacen.setBorderPainted(false);
			btnGestionAlmacen.setBackground(Color.WHITE);
			btnGestionAlmacen.setBounds(10, 225, 233, 27);
			panelAlmacen.add(btnGestionAlmacen);
			
			panelVenta = new JPanel();
			panelVenta.setLayout(null);
			panelVenta.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelVenta.setBackground(new Color(248, 248, 255));
			panelVenta.setBounds(299, 386, 253, 263);
			panelOpciones.add(panelVenta);
			
			subPanelVenta = new JPanel();
			subPanelVenta.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelVenta.setBounds(10, 11, 233, 203);
			panelVenta.add(subPanelVenta);
			subPanelVenta.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo6 = new ImageIcon(getClass().getResource("/imagenes/ImgRealizarVenta.png")); 
			Image img7 = logo6.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo7 = new JLabel(new ImageIcon(img7)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelVenta.add(fondo7, BorderLayout.CENTER);
			
			btnRealizarVenta = new JButton("Realizar Venta");
			btnRealizarVenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRealizarVenta.setOpaque(true);
			btnRealizarVenta.setForeground(new Color(255, 51, 0));
			btnRealizarVenta.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnRealizarVenta.setFocusPainted(false);
			btnRealizarVenta.setBorderPainted(false);
			btnRealizarVenta.setBackground(Color.WHITE);
			btnRealizarVenta.setBounds(10, 225, 233, 27);
			panelVenta.add(btnRealizarVenta);
			
			panelRespaldoDatos = new JPanel();
			panelRespaldoDatos.setLayout(null);
			panelRespaldoDatos.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelRespaldoDatos.setBackground(new Color(248, 248, 255));
			panelRespaldoDatos.setBounds(854, 386, 253, 263);
			panelOpciones.add(panelRespaldoDatos);
			
			subPanelRespaldo = new JPanel();
			subPanelRespaldo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelRespaldo.setBounds(10, 11, 233, 203);
			panelRespaldoDatos.add(subPanelRespaldo);
			subPanelRespaldo.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo7 = new ImageIcon(getClass().getResource("/imagenes/ImgRespaldoDatos.png")); 
			Image img8 = logo7.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo8 = new JLabel(new ImageIcon(img8)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelRespaldo.add(fondo8, BorderLayout.CENTER);
			
			JButton btnRespaldarDatos = new JButton("Respaldar Datos");
			btnRespaldarDatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRespaldarDatos.setOpaque(true);
			btnRespaldarDatos.setForeground(new Color(255, 51, 0));
			btnRespaldarDatos.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnRespaldarDatos.setFocusPainted(false);
			btnRespaldarDatos.setBorderPainted(false);
			btnRespaldarDatos.setBackground(Color.WHITE);
			btnRespaldarDatos.setBounds(10, 225, 233, 27);
			panelRespaldoDatos.add(btnRespaldarDatos);
			
			panelVerVentasDelivery = new JPanel();
			panelVerVentasDelivery.setLayout(null);
			panelVerVentasDelivery.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelVerVentasDelivery.setBackground(new Color(248, 248, 255));
			panelVerVentasDelivery.setBounds(577, 386, 253, 263);
			panelOpciones.add(panelVerVentasDelivery);
			
			JPanel subPanelVentasDelivery = new JPanel();
			subPanelVentasDelivery.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			subPanelVentasDelivery.setBounds(10, 11, 233, 203);
			panelVerVentasDelivery.add(subPanelVentasDelivery);
			subPanelVentasDelivery.setLayout(new BorderLayout(0, 0));
			
			ImageIcon logo8 = new ImageIcon(getClass().getResource("/imagenes/ImgDelivery.png")); 
			Image img9 = logo8.getImage().getScaledInstance(233, 203, Image.SCALE_SMOOTH);
			JLabel fondo9 = new JLabel(new ImageIcon(img9)); 
			fondo2.setHorizontalAlignment(SwingConstants.CENTER);
			subPanelVentasDelivery.add(fondo9, BorderLayout.CENTER);
			
			JButton btnVerVentasDelivery = new JButton("Ver Ventas Delivery");
			btnVerVentasDelivery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnVerVentasDelivery.setOpaque(true);
			btnVerVentasDelivery.setForeground(new Color(255, 51, 0));
			btnVerVentasDelivery.setFont(new Font("Sylfaen", Font.BOLD, 15));
			btnVerVentasDelivery.setFocusPainted(false);
			btnVerVentasDelivery.setBorderPainted(false);
			btnVerVentasDelivery.setBackground(Color.WHITE);
			btnVerVentasDelivery.setBounds(10, 225, 233, 27);
			panelVerVentasDelivery.add(btnVerVentasDelivery);
			
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBackground(new Color(255, 51, 0));
			panel_2.setBounds(24, 11, 199, 40);
			panelOpciones.add(panel_2);
			panel_2.setLayout(null);
			
			txtMenAdministrador = new JTextField();
			txtMenAdministrador.setText("Men\u00FA Administrador");
			txtMenAdministrador.setForeground(Color.WHITE);
			txtMenAdministrador.setFont(new Font("Sylfaen", Font.BOLD, 17));
			txtMenAdministrador.setFocusable(false);
			txtMenAdministrador.setEditable(false);
			txtMenAdministrador.setColumns(10);
			txtMenAdministrador.setBorder(null);
			txtMenAdministrador.setBackground(new Color(255, 51, 0));
			txtMenAdministrador.setBounds(10, 11, 179, 20);
			panel_2.add(txtMenAdministrador);
			
			txtEmpleado = new JTextField();
			txtEmpleado.setText(" Usuario: ");
			txtEmpleado.setBounds(233, 11, 179, 40);
			panelOpciones.add(txtEmpleado);
			txtEmpleado.setBackground(new Color(255, 51, 0));
			txtEmpleado.setEditable(false);
			txtEmpleado.setFont(new Font("Sylfaen", Font.BOLD, 15));
			txtEmpleado.setForeground(new Color(255, 255, 255));
			txtEmpleado.setColumns(10);
			txtEmpleado.setFocusable(false);
			txtEmpleado.setBorder(null);
		}
		
		ImageIcon otroIcon = new ImageIcon(getClass().getResource("/icons/world-icon.png")); 
		setIconImage(otroIcon.getImage());
	}
}
