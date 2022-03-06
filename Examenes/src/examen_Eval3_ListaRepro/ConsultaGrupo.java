package examen_Eval3_ListaRepro;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaGrupo extends JFrame {
	/**
	 * Lista de reproducción - Clase ConsultaGrupo
	 * 
	 * @author Robert G
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textNombreGrupo;
	static TextArea textAreaNombreGrupo;
	protected ResultSet rset;
	static ConsultaGrupo frame3;

	/**
	 * Create the frame.
	 */
	public ConsultaGrupo() {
		setTitle("Consulta de Canciones por Grupo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreGrupo = new JLabel("Nombre Grupo");
		lblNombreGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreGrupo.setBounds(25, 43, 100, 25);
		contentPane.add(lblNombreGrupo);

		textAreaNombreGrupo = new TextArea();
		textAreaNombreGrupo.setEnabled(true);
		textAreaNombreGrupo.setBounds(25, 89, 380, 140);
		contentPane.add(textAreaNombreGrupo);

		textNombreGrupo = new JTextField();
		textNombreGrupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ArrayList<String> canAL = new ArrayList<String>();
				try {
					canAL = Grupos.comprobarGrupo(textNombreGrupo.getText());
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
				String listaCanciones = "";
				for (String i : canAL) {
					listaCanciones += i + "\n";
				}
				textAreaNombreGrupo.setText(listaCanciones);
			}
		});
		textNombreGrupo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNombreGrupo.setBounds(131, 41, 275, 25);
		contentPane.add(textNombreGrupo);
		textNombreGrupo.setColumns(10);

		JButton btnVolver = new JButton("<html><p>Volver</p><p>a Opciones</p></html>");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(false);
				Opciones.frame2.setVisible(true);
			}
		});
		btnVolver.setBounds(319, 250, 105, 40);
		contentPane.add(btnVolver);

		JLabel lblInfo = new JLabel(
				"Introduce aqu\u00ED un grupo y te mostrar\u00E9 sus canciones en el area de texto");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfo.setBounds(26, 18, 380, 14);
		contentPane.add(lblInfo);
	}
}
