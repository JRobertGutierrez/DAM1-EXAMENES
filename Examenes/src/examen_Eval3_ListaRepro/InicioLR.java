package examen_Eval3_ListaRepro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class InicioLR extends JFrame {
	/**
	 * Lista de reproducción - Clase InicioLR
	 * 
	 * @author Robert G
	 */
	private static final long serialVersionUID = 1L;
	static ResultSet rset;
	private JPanel contentPane;
	static JTextField txtUsu;
	static JPasswordField txtCon;
	static InicioLR frame1;
	static JLabel lblAviso;
	static String gustoUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new InicioLR();
					frame1.setVisible(true);
					Opciones.frame2 = new Opciones();
					Opciones.frame2.setVisible(false);
					ConsultaGrupo.frame3 = new ConsultaGrupo();
					ConsultaGrupo.frame3.setVisible(false);
					ListaRepro.frame4 = new ListaRepro();
					ListaRepro.frame4.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioLR() {
		setTitle("Ventana Principal de la Aplicaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsu = new JLabel("Usuario:");
		lblUsu.setBounds(49, 61, 131, 33);
		lblUsu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUsu);

		txtUsu = new JTextField();
		txtUsu.setBounds(185, 61, 176, 33);
		txtUsu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsu.setColumns(10);
		contentPane.add(txtUsu);

		JLabel lblCon = new JLabel("Contrase\u00F1a:");
		lblCon.setBounds(49, 99, 131, 33);
		lblCon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCon);

		txtCon = new JPasswordField();
		txtCon.setBounds(185, 99, 176, 33);
		txtCon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(txtCon);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(49, 137, 100, 43);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkUser()) {
					try {
						checkAuth();
					} catch (SQLException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		contentPane.add(btnEntrar);

		JButton btnsalir = new JButton("Salir");
		btnsalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsalir.setBounds(261, 137, 100, 43);
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnsalir);

		lblAviso = new JLabel("");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(49, 201, 292, 43);
		contentPane.add(lblAviso);

		JLabel lblApp = new JLabel("Acceso a PlayList");
		lblApp.setForeground(SystemColor.textHighlight);
		lblApp.setFont(new Font("Chaparral Pro", Font.PLAIN, 18));
		lblApp.setBounds(49, 11, 130, 30);
		contentPane.add(lblApp);

		JButton btnNewButton = new JButton("<html><p>Borrar</p><p>Campos</p></html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarCampos();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(155, 137, 100, 43);
		contentPane.add(btnNewButton);

		JLabel lblVersion = new JLabel("V-1.0");
		lblVersion.setFont(new Font("Chaparral Pro", Font.PLAIN, 18));
		lblVersion.setBounds(351, 230, 50, 30);
		contentPane.add(lblVersion);

	}

	// Comprobar que existe el user y los datos son correctos. Si el usuario es correcto
	// devuelve un valor.
	@SuppressWarnings("deprecation")
	public static boolean checkUser() {
		boolean userCorrecto = false; // lo pongo a true para avanzar
		// ResultSet rset = null;
		if (txtUsu.getText().isEmpty() || txtCon.getText().isEmpty()) { // Si hay algún campo vacío...
			lblAviso.setText("Acceso denegado - Introduce tus credenciales");
		} else { // Si rellenas los dos campos
			try {
				InicioLR.rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
				("select login,password from usuarios");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while (rset.next()) {
					if (txtUsu.getText().equals(rset.getString(1))) {// Si el usuario introducido es igual que el
																		// usuario de la columna 1
						if (txtCon.getText().equals(rset.getString(2))) {// Si la contraseña introducida es igual que la
																			// contraseña de la columna 2
							userCorrecto = true;// Si es asi el usuario es correcto
						} else {// En caso contrario no es correcta la contraseña
							lblAviso.setText("Contraseña incorrecta.");
						}
					} else {// En este caso contrario no coinciden las credenciales aunque uno de los dos campos
							// sea correcto
						lblAviso.setText("Credenciales incorrectas.");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userCorrecto;
	}

	// Comprueba si el usuario es administrador. El programa hace una cosa u otra depende
	// del resultado.
	public static void checkAuth() throws SQLException, IOException {
		boolean admin = false; // lo pongo a true para avanzar
		try {
			InicioLR.rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
			("select tipo_usuario,tipo_musica from usuarios where login='" + txtUsu.getText() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rset.next()) {// He creado gustoUser para los gustos sobre el usuario
				gustoUser = rset.getString(2);
				if (rset.getString(1).equals("A")) {// Si la columna 1 contiene A es administrador
					admin = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (admin) {
			frame1.setVisible(false); // Oculta la interfaz gráfica.
			MenuAdmin.menuPrincipal(); // Abre el menú para administradores, en este caso en consola
		} else {
			frame1.setVisible(false);
			Opciones.lblBienvenida.setText("Hola " + txtUsu.getText() + " te doy la bienvenida");
			Opciones.frame2.setVisible(true);
		}
	}

	// Método para vaciar los campos de la ventana
	public static void borrarCampos() {
		txtUsu.setText("");
		txtCon.setText("");
		lblAviso.setText("");
	}
}
