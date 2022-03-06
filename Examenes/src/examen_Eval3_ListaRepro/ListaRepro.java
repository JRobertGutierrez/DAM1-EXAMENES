package examen_Eval3_ListaRepro;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class ListaRepro extends JFrame {
	/**
	 * Lista de reproducción - Clase ListaRepro
	 * 
	 * @author Robert G
	 */
	private JPanel contentPane;
	static JTextField textDuracion;
	static TextArea textAreaListaRepro;
	static ListaRepro frame4;
	static JLabel lblAviso;

	/**
	 * Create the frame.
	 */
	public ListaRepro() {
		setTitle("Lista de reproducci\u00F3n por duraci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDuracinEnMinutos = new JLabel("Duraci\u00F3n en minutos");
		lblDuracinEnMinutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuracinEnMinutos.setBounds(25, 43, 130, 25);
		contentPane.add(lblDuracinEnMinutos);

		textAreaListaRepro = new TextArea();
		textAreaListaRepro.setBounds(25, 95, 380, 140);
		contentPane.add(textAreaListaRepro);

		textDuracion = new JTextField();
		textDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ArrayList<String> canciones = new ArrayList<String>();

				try {
					canciones = Canciones.crearListaReproduccion(Integer.parseInt(textDuracion.getText()));
					lblAviso.setText("");
				} catch (Exception e) {
					lblAviso.setText("Solo números por favor");
				}
				String listaCanciones = "";

				for (String i : canciones) {
					listaCanciones += i + "\n";
					// System.out.println(i);
				}
				textAreaListaRepro.setText(listaCanciones);
			}
		});
		textDuracion.setBounds(179, 41, 130, 25);
		contentPane.add(textDuracion);
		textDuracion.setColumns(10);

		JButton button = new JButton("<html><p>Volver</p><p>a Opciones</p></html>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame4.setVisible(false);
				Opciones.frame2.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(319, 250, 105, 40);
		contentPane.add(button);

		JLabel lblInfo = new JLabel(
				"Introduce aqu\u00ED la duraci\u00F3n y te mostrar\u00E9 una lista de reproducci\u00F3n");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfo.setBounds(25, 18, 380, 14);
		contentPane.add(lblInfo);

		lblAviso = new JLabel("");
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(25, 250, 284, 40);
		contentPane.add(lblAviso);
	}
}
