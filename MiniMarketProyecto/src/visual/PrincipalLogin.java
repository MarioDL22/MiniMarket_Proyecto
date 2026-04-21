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

import logico.MiniMarket;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PrincipalLogin extends JFrame {

	private JPanel panelFondo;
	private Dimension dim; 
	private JPanel panelLogin;
	private JPanel panelLogo;
	private JTextField txtUsuario;
	private JTextField textField;
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
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(28, 323, 211, 34);
		panelLogin.add(textField);
		
		btnAcceder = new JButton("Acceder");
		btnAcceder.setBackground(new Color(255, 51, 0));
		btnAcceder.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnAcceder.setForeground(new Color(255, 255, 255));
		btnAcceder.setBounds(64, 398, 136, 41);
		panelLogin.add(btnAcceder);
		JLabel fondo = new JLabel(new ImageIcon(img)); 
		fondo.setBounds(0, 0, dim.width, dim.height - 45);
		panelFondo.add(fondo);
	}
}
