package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Empleado;
import logico.MiniMarket;
import logico.TipoRol;

import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PrincipalLogin extends JFrame {

	private JPanel panelFondo;
	private Dimension dim; 
	private JPanel panelLogin;
	private JPanel panelLogo;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnAcceder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MiniMarket.cargarDatos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalLogin frame = new PrincipalLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "¡Ha ocurrido un error!" + "\nConflicto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalLogin() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MiniMarket.guardarDatos();
			}
		});
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize(); 
		setSize(dim.width, dim.height - 45);
		setLocationRelativeTo(null);

		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelFondo);
		panelFondo.setLayout(null);

		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/fondoPrincipal2.jpg")); 
		Image img = icono.getImage().getScaledInstance(dim.width, dim.height - 45, Image.SCALE_SMOOTH);

		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(255, 255, 255));
		panelLogin.setBounds(534, 101, 265, 478);
		panelFondo.add(panelLogin);
		panelLogin.setLayout(null);

		panelFondo.setComponentZOrder(panelLogin, 0);

		panelLogo = new JPanel();
		panelLogo.setBounds(44, 37, 178, 130);
		panelLogo.setLayout(new BorderLayout());
		panelLogin.add(panelLogo);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/logoMiniMarket.png")); 
		Image img2 = logo.getImage().getScaledInstance(178, 130, Image.SCALE_SMOOTH);
		JLabel fondo2 = new JLabel(new ImageIcon(img2)); 
		fondo2.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogo.add(fondo2, BorderLayout.CENTER);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setForeground(Color.BLACK);
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreDeUsuario.setBounds(28, 202, 158, 25);
		panelLogin.add(lblNombreDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasea.setBounds(28, 302, 158, 25);
		panelLogin.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBounds(28, 225, 211, 34);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(28, 323, 211, 34);
		panelLogin.add(txtPassword);
		
		btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accederPestana();
			}
		});
		btnAcceder.setBackground(new Color(255, 51, 0));
		btnAcceder.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnAcceder.setForeground(new Color(255, 255, 255));
		btnAcceder.setBounds(64, 398, 136, 41);
		panelLogin.add(btnAcceder);
		JLabel fondo = new JLabel(new ImageIcon(img)); 
		fondo.setBounds(0, 0, dim.width, dim.height - 45);
		panelFondo.add(fondo);
		
		if(MiniMarket.getInstance().getMisEmpleados().size() == 1) {
			txtUsuario.setText("admin");
			txtUsuario.setBackground(SystemColor.info);
			txtPassword.setText("admin123");
			txtPassword.setBackground(SystemColor.info);
		}else {
			txtUsuario.setText("");
			txtPassword.setText("");
		}
		
		getRootPane().setDefaultButton(btnAcceder);
		ImageIcon otroIcon = new ImageIcon(getClass().getResource("/icons/id-card-icon.png")); 
		setIconImage(otroIcon.getImage());
	}
	
	private void accederPestana() {
		String usuario = txtUsuario.getText().trim(); 
		String password = new String(txtPassword.getPassword()).trim();
		
		if(usuario.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "¡Debe llenar todos los campos para acceder!", "Error", JOptionPane.WARNING_MESSAGE);
		}else {
			Empleado usuarioLogueado = null; 
			for (Empleado auxEmpleado : MiniMarket.getInstance().getMisEmpleados()) {
				if(auxEmpleado.getMiUsuario().getUsuario().equalsIgnoreCase(usuario) && auxEmpleado.getMiUsuario().getPassword().equalsIgnoreCase(password)) {
					usuarioLogueado = auxEmpleado; 
				}
			}
			
			if(usuarioLogueado != null) {
				if(usuarioLogueado.getMiUsuario().isEstado() == false) {
					JOptionPane.showMessageDialog(null, "¡Este usuario se encuentra inactivo en el sistema!" + "\nRazones: " + "\n1. Ya no trabaja para la empresa" + "\n2. No está creado en el sistema", "Aviso", JOptionPane.WARNING_MESSAGE);
					txtUsuario.setText("");
					txtPassword.setText("");
				}else {
					setVisible(false);
					if(usuarioLogueado.getMiUsuario().getRol() == TipoRol.Administrador) {
						
					}else if (usuarioLogueado.getMiUsuario().getRol() == TipoRol.Cajero) {
						
					}else if (usuarioLogueado.getMiUsuario().getRol() == TipoRol.Delivery) {
						
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error de Login", JOptionPane.ERROR_MESSAGE);
				txtPassword.setText("");
			}
		}
	}
	
	/*public void mostrarLogin() {
		if (panelAdmin != null) {
			panelAdmin.setVisible(false);
		}
		if (panelComercial != null) {
			panelComercial.setVisible(false);
		}
		if (panelTecnico != null) {
			panelTecnico.setVisible(false);
		}
		if (MiniMarket.getInstance().getMisPersonas().size() == 1) {
			txtUsuario.setText("admin");
			txtPassword.setText("admin123");
		} else {
			txtUsuario.setText("");
			txtUsuario.setBackground(Color.WHITE);
			txtPassword.setText("");
			txtPassword.setBackground(Color.WHITE);
		}
		setVisible(true);
		getRootPane().setDefaultButton(btnAcceder);
		getContentPane().revalidate();
		getContentPane().repaint();
		return; 
	}*/
}
