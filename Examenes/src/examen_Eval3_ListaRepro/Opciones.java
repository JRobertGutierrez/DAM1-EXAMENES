package examen_Eval3_ListaRepro;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Opciones extends JFrame {
	/**
	 * Lista de reproducción - Clase Opciones
	 * 
	 * @author Robert G
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Opciones frame2;
	static JLabel lblBienvenida;

	/**
	 * Create the frame.
	 */
	public Opciones() {
		setTitle("Opciones de usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnConsultarGrupos = new JButton("Consultar Grupos");
		btnConsultarGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaGrupo.textNombreGrupo.setText("");// Con esto vacío el campo cada vez
				ConsultaGrupo.textAreaNombreGrupo.setText("");// Con esto vacío el area de texto cada vez
				frame2.setVisible(false);
				try {
					Grupos.leerCsv(); // Lee los ficheros csv.
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
				ConsultaGrupo.frame3.setVisible(true);
			}
		});
		btnConsultarGrupos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarGrupos.setBounds(25, 107, 155, 30);
		contentPane.add(btnConsultarGrupos);

		JButton btnCrearListaReproduccin = new JButton("Crear Lista Reproducci\u00F3n");
		btnCrearListaReproduccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaRepro.textDuracion.setText("");// Con esto vacío el campo cada vez
				ListaRepro.textAreaListaRepro.setText("");// Con esto vacío el area de texto cada vez
				frame2.setVisible(false);
				try {
					Canciones.leerCsv(); // Lee los ficheros csv.
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
				ListaRepro.frame4.setVisible(true);
			}
		});
		btnCrearListaReproduccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearListaReproduccin.setBounds(216, 107, 200, 30);
		contentPane.add(btnCrearListaReproduccin);

		JButton btnVolver = new JButton("<html><p>Volver</p><p>a Login</p></html>");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioLR.txtUsu.setText("");// Vacío el campo usuario
				InicioLR.txtCon.setText("");// Vacío el campo contraseña
				InicioLR.lblAviso.setText("");// Vacío el campo aviso
				frame2.setVisible(false);
				InicioLR.frame1.setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(326, 210, 90, 40);
		contentPane.add(btnVolver);

		JLabel lblConsultarGruposY = new JLabel("Consultar Grupos y crear listas de reproducci\u00F3n");
		lblConsultarGruposY.setForeground(SystemColor.textHighlight);
		lblConsultarGruposY.setFont(new Font("Chaparral Pro", Font.PLAIN, 18));
		lblConsultarGruposY.setBounds(25, 11, 385, 28);
		contentPane.add(lblConsultarGruposY);

		lblBienvenida = new JLabel("");
		lblBienvenida.setForeground(new Color(60, 179, 113));
		lblBienvenida.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblBienvenida.setBounds(25, 50, 385, 20);
		contentPane.add(lblBienvenida);
	}
}
