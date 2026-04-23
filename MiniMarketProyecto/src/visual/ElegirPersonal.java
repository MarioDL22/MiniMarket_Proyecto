package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import logico.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class ElegirPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	public static JButton btnRegistrarCliente;
	public static JButton btnRegistrarEmpleado;
	private Cliente elCliente; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ElegirPersonal dialog = new ElegirPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ElegirPersonal() {
		setTitle("Elegir Tipo Persona");
		setBounds(100, 100, 409, 173);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 51, 0));
		panel.setBounds(0, 0, 434, 39);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elija el tipo de persona a << Registrar >>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 375, 17);
		panel.add(lblNewLabel);
		
		btnRegistrarCliente = new JButton("Registrar Cliente");
		btnRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RegistrarCliente registrar = new RegistrarCliente(elCliente); 
				registrar.setModal(true);
				registrar.setVisible(true);
				setVisible(true);
			}
		});
		btnRegistrarCliente.setFocusPainted(false);
		btnRegistrarCliente.setOpaque(true);
		btnRegistrarCliente.setForeground(Color.BLACK);
		btnRegistrarCliente.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnRegistrarCliente.setBackground(new Color(255, 255, 255));
		btnRegistrarCliente.setBounds(29, 50, 156, 29);
		contentPanel.add(btnRegistrarCliente);
		
		btnRegistrarEmpleado = new JButton("Registrar Empleado");
		btnRegistrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarEmpleado.setFocusPainted(false);
		btnRegistrarEmpleado.setOpaque(true);
		btnRegistrarEmpleado.setForeground(Color.BLACK);
		btnRegistrarEmpleado.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnRegistrarEmpleado.setBackground(new Color(255, 255, 255));
		btnRegistrarEmpleado.setBounds(205, 50, 156, 29);
		contentPanel.add(btnRegistrarEmpleado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				//btnCerrar.setBorderPainted(false);
				btnCerrar.setFocusPainted(false);
				btnCerrar.setOpaque(true);
				btnCerrar.setForeground(Color.BLACK);
				btnCerrar.setBackground(SystemColor.menu);
				btnCerrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
		//
		ImageIcon otroIcon = new ImageIcon(getClass().getResource("/icons/people-check-icon.png")); 
		setIconImage(otroIcon.getImage());
	}
}
