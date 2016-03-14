package Cartas;

import java.awt.Color;
import java.awt.Component;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Propiedades.Propiedades;

public class AgregarCartasApp {

	private JFrame ventana;
	private JPanel pnlInterfaz, pnlIzquierda, pnlDerecha;
	private JLabel txtNombre, txtDescripcion, txtFuerza, txtDestreza, txtCadencia, txtAlcance, txtBalas, txtCartuchos;
	private JTextField tfNombre, tfDescripcion, tfFuerza, tfDestreza, tfCadencia, tfAlcance, tfBalas, tfCartuchos;
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
		tfNombre = new JTextField(20);
		txtDescripcion = new JLabel(propiedades.getProperty("Descripcion"));
		tfDescripcion = new JTextField(20);
		txtFuerza = new JLabel(propiedades.getProperty("Fuerza"));
		tfFuerza = new JTextField(20);
		txtDestreza = new JLabel(propiedades.getProperty("Destreza"));
		tfDestreza = new JTextField(20);
		txtCadencia = new JLabel(propiedades.getProperty("Cadencia"));
		tfCadencia = new JTextField(20);
		txtAlcance = new JLabel(propiedades.getProperty("Alcance"));
		tfAlcance = new JTextField(20);
		txtBalas = new JLabel(propiedades.getProperty("Balas"));
		tfBalas = new JTextField(20);
		txtCartuchos = new JLabel(propiedades.getProperty("Cartuchos"));
		tfCartuchos = new JTextField(20);
		
		// creacion de textos, un area para buscar una direccion de una imagen y mostrarla
		// y a continuacion tres botones
		
		btnSalir = new JButton(propiedades.getProperty("Salir"));
		btnGuardar = new JButton(propiedades.getProperty("Guardar"));
		btnLimpiar = new JButton(propiedades.getProperty("Limpiar"));

	}

	private void crearPanel() {
		
		pnlInterfaz = new JPanel();
//		pnlInterfaz.setLayout(new BoxLayout(pnlInterfaz, BoxLayout.Y_AXIS));
		pnlInterfaz.setBackground(Color.blue);

		panelIzquierdo(txtNombre, tfNombre);
		panelIzquierdo(txtFuerza, tfFuerza);
		panelIzquierdo(txtDestreza, tfDestreza);
		panelIzquierdo(txtCadencia, tfCadencia);
		panelIzquierdo(txtAlcance, tfAlcance);
		panelIzquierdo(txtBalas, tfBalas);
		panelIzquierdo(txtCartuchos, tfCartuchos);
		
		pnlDerecha = new JPanel();
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlDerecha.setBackground(Color.green);
		pnlIzquierda.add(btnGuardar);
		
		pnlInterfaz.add(pnlDerecha);
	}

	private void panelIzquierdo(JLabel texto, JTextField caja) {
		pnlIzquierda = new JPanel();
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.X_AXIS));
		pnlIzquierda.setBackground(Color.red);
		pnlIzquierda.add(texto);
		pnlIzquierda.add(caja);
		
		pnlInterfaz.add(pnlIzquierda);
	}

	private void crearVentana(String nombreVentana) {

		ventana = new JFrame();
//		 ventana.setUndecorated(true);
		ventana.setTitle(nombreVentana + "tituloCreadorCarta");
		ventana.setSize(400, 400);
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setContentPane(pnlInterfaz);
	}

}
