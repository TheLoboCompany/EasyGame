package Cartas;

import java.awt.Color;
import java.awt.Component;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Propiedades.Propiedades;

public class AgregarCartasApp {

	private JFrame ventana;
	private JPanel pnlInterfaz, pnlIzquierda, pnlDerecha;
	private JLabel txtNombre, txtDescripcion, txtFuerza, txtDestreza, txtCadencia, txtAlcance, txtBalas, txtCartuchos;
	private JButton btnSalir, btnLimpiar, btnGuardar;

	public AgregarCartasApp() {

		inicializarInterfaz("");
		crearPanel();
		crearVentana("Juego_Cartas");

	}

	public void inicializarInterfaz(String idioma) {
		
		Properties propiedades = new Propiedades(idioma);
		
		// creacion de textos y sus areas(con su titulo) primera parte.
		
		txtNombre = new JLabel(propiedades.getProperty("Nombre"));
		// cuadro donde se inserta el valor;
		txtDescripcion = new JLabel(propiedades.getProperty("Descripcion"));
		// cuadro donde se inserta el valor;
		txtFuerza = new JLabel(propiedades.getProperty("Fuerza"));
		// cuadro donde se inserta el valor;
		txtDestreza = new JLabel(propiedades.getProperty("Destreza"));
		// cuadro donde se inserta el valor;
		txtCadencia = new JLabel(propiedades.getProperty("Cadencia"));
		// cuadro donde se inserta el valor;
		txtAlcance = new JLabel(propiedades.getProperty("Alcance"));
		// cuadro donde se inserta el valor;
		txtBalas = new JLabel(propiedades.getProperty("Balas"));
		// cuadro donde se inserta el valor;
		txtCartuchos = new JLabel(propiedades.getProperty("Cartuchos"));
		// cuadro donde se inserta el valor;
		
		// creacion de textos, un area para buscar una direccion de una imagen y mostrarla
		// y a continuacion tres botones
		
		btnSalir = new JButton(propiedades.getProperty("Guardar"));
		btnSalir = new JButton(propiedades.getProperty("Limpiar"));
		btnSalir = new JButton(propiedades.getProperty("Salir"));

	}

	private void crearPanel() {
		
		pnlInterfaz = new JPanel();
		pnlInterfaz.setLayout(new BoxLayout(pnlInterfaz, BoxLayout.Y_AXIS));
		pnlInterfaz.setBackground(Color.blue);
		
		pnlIzquierda = new JPanel();
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlIzquierda.setBackground(Color.red);
		pnlInterfaz.add(pnlIzquierda);
		
		pnlDerecha = new JPanel();
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlDerecha.setBackground(Color.green);
		pnlInterfaz.add(pnlDerecha);

	}

	private void crearVentana(String nombreVentana) {

		ventana = new JFrame();
//		 ventana.setUndecorated(true);
		ventana.setTitle(nombreVentana + "tituloCreadorCarta");
		ventana.setSize(400, 400);
		ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.X_AXIS));
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setContentPane(pnlInterfaz);
	}

}
