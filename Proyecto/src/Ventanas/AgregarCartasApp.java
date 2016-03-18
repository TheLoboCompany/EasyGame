package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GrayFilter;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Propiedades.Propiedades;

public class AgregarCartasApp extends JFrame implements ActionListener{

	private static final String EXTENSION = "png";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String NOMBRE_JUEGO = "Juego_Cartas";
	private static final String NOMBRE_VENTANA = " - Creador de cartas";
	private static final int ALTO_VENTANA = 400;
	private static final int ANCHO_VENTANA = 800;
	private static final int TAMANIO_CAJA = 15;
	private static final int ANCHO_CARTA = 200;
	private static final int ALTO_CARTA = 200;
	
	private String tituloAtributos;
	private String tituloImagen;
	private String errorArchivo;
	private String extensionArchivo;
	private String ErrorNombreVentana;

	private File archivoImg;
	private BufferedImage imagen;
	
	private JPanel pnlNorte, pnlSur, pnlInterfaz, pnlIzquierda, pnlDerecha, pnlEste, pnlOeste, pnlAtributos, pnlNombres;
	private JLabel txtNombre, txtDescripcion, txtFuerza, txtDestreza, txtCadencia, txtAlcance, txtBalas, txtCartuchos, txtBuscador, imgCarta;
	private JTextField tfNombre, tfDescripcion, tfFuerza, tfDestreza, tfCadencia, tfAlcance, tfBalas, tfCartuchos, tfBuscador;
	private JButton btnSalir, btnLimpiar, btnGuardar, btnBuscar;
	
	private Border lineaTitulo = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	
	public AgregarCartasApp() {

		inicializarDatos("");
		propiedadesDatos();
		diseniarPanel();
		crearVentana();

	}

	private void propiedadesDatos() {

		imgCarta.setPreferredSize(new Dimension(ANCHO_CARTA, ALTO_CARTA));
		imgCarta.setBorder(lineaTitulo);
		imgCarta.setHorizontalAlignment(JTextField.CENTER);
		
		btnGuardar.setVerticalAlignment(JButton.BOTTOM);
		
	}

	public void inicializarDatos(String idioma) {
		
		Properties propiedades = new Propiedades(idioma);
		
		// creacion de textos y sus areas(con su titulo) primera parte.
		
		txtNombre = new JLabel(propiedades.getProperty("Nombre"));
		tfNombre = new JTextField(TAMANIO_CAJA);
		txtDescripcion = new JLabel(propiedades.getProperty("Descripcion"));
		tfDescripcion = new JTextField(TAMANIO_CAJA);
//		para hacer una caja mas grande 
		txtFuerza = new JLabel(propiedades.getProperty("Fuerza"));
		tfFuerza = new JTextField(TAMANIO_CAJA);
		txtDestreza = new JLabel(propiedades.getProperty("Destreza"));
		tfDestreza = new JTextField(TAMANIO_CAJA);
		txtCadencia = new JLabel(propiedades.getProperty("Cadencia"));
		tfCadencia = new JTextField(TAMANIO_CAJA);
		txtAlcance = new JLabel(propiedades.getProperty("Alcance"));
		tfAlcance = new JTextField(TAMANIO_CAJA);
		txtBalas = new JLabel(propiedades.getProperty("Balas"));
		tfBalas = new JTextField(TAMANIO_CAJA);
		txtCartuchos = new JLabel(propiedades.getProperty("Cartuchos"));
		tfCartuchos = new JTextField(TAMANIO_CAJA);
		
		// creacion de textos, un area para buscar una direccion de una imagen y mostrarla
		// y a continuacion tres botones
		
		imgCarta = new JLabel(propiedades.getProperty("Foto"));
		
		txtBuscador = new JLabel(propiedades.getProperty("BuscarImagen"));
		tfBuscador = new JTextField(TAMANIO_CAJA);
		btnBuscar = new JButton(propiedades.getProperty("Buscar"));
		btnBuscar.addActionListener(this);
		
		btnSalir = new JButton(propiedades.getProperty("Salir"));
		btnSalir.addActionListener(this);
		btnGuardar = new JButton(propiedades.getProperty("Guardar"));
		btnGuardar.addActionListener(this);
		btnLimpiar = new JButton(propiedades.getProperty("Limpiar"));
		btnLimpiar.addActionListener(this);
		
		tituloAtributos = propiedades.getProperty("TituloAtributos");
		tituloImagen = propiedades.getProperty("TituloImagen");
		
		errorArchivo = propiedades.getProperty("ErrorArchivo");
		extensionArchivo = propiedades.getProperty("ExtensionArchivo");
		ErrorNombreVentana = propiedades.getProperty("ErrorNombreVentana");

	}

	private void diseniarPanel() {
		
		pnlInterfaz = new JPanel();
		pnlInterfaz.setLayout(new BoxLayout(pnlInterfaz, BoxLayout.Y_AXIS));
		
		pnlNorte = new JPanel();
		pnlNorte.setLayout(new BoxLayout(pnlNorte, BoxLayout.X_AXIS));
		pnlInterfaz.add(pnlNorte);
		
		pnlSur = new JPanel();
		pnlSur.setLayout(new BoxLayout(pnlSur, BoxLayout.X_AXIS));
		pnlSur.add(btnGuardar);
		pnlSur.add(btnLimpiar);
		pnlSur.add(btnSalir);
		pnlInterfaz.add(pnlSur);
		
		pnlEste = new JPanel();
		pnlEste.setLayout(new BoxLayout(pnlEste, BoxLayout.Y_AXIS));
		pnlEste.setBorder(BorderFactory.createTitledBorder(tituloAtributos));
		pnlNorte.add(pnlEste);
		
		pnlOeste = new JPanel();
		pnlOeste.setLayout(new BoxLayout(pnlOeste, BoxLayout.Y_AXIS));
		pnlOeste.setBorder(BorderFactory.createTitledBorder(tituloImagen));
		pnlNorte.add(pnlOeste);

		panelIzquierdo(txtNombre, tfNombre);
		panelIzquierdo(txtFuerza, tfFuerza);
		panelIzquierdo(txtDestreza, tfDestreza);
		panelIzquierdo(txtCadencia, tfCadencia);
		panelIzquierdo(txtAlcance, tfAlcance);
		panelIzquierdo(txtBalas, tfBalas);
		panelIzquierdo(txtCartuchos, tfCartuchos);
		panelIzquierdo(txtDescripcion, tfDescripcion);
		
		pnlDerecha = new JPanel();
		pnlDerecha.add(txtBuscador);
		pnlOeste.add(pnlDerecha);
		
		panelDerecho(tfBuscador,btnBuscar);
		
		pnlDerecha = new JPanel();
		pnlDerecha.add(imgCarta);
		pnlOeste.add(pnlDerecha);
		
	}
	
	private void panelDerecho(JTextField caja, JButton boton) {
		pnlDerecha = new JPanel();
		pnlDerecha.add(caja);
		pnlDerecha.add(boton);
		
		pnlOeste.add(pnlDerecha);
	}

	private void panelIzquierdo(JLabel texto, JTextField caja) {
		
		pnlIzquierda = new JPanel();
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.X_AXIS));
			
			pnlNombres = new JPanel(new FlowLayout(FlowLayout.LEFT));
			pnlNombres.add(texto);
			
			
			pnlAtributos = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			pnlAtributos.add(caja);
			
			pnlIzquierda.add(pnlNombres);
			pnlIzquierda.add(pnlAtributos);
		pnlEste.add(pnlIzquierda);
	}

	private void crearVentana() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle(NOMBRE_JUEGO + NOMBRE_VENTANA);
		setMinimumSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));
		setVisible(true);
		setContentPane(pnlInterfaz);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir){
			this.dispose();
		}
		if (e.getSource() == btnLimpiar){
			tfAlcance.setText("");	tfCadencia.setText("");
			tfBalas.setText("");	tfCartuchos.setText("");
			tfBuscador.setText("");	tfDescripcion.setText("");
			tfDestreza.setText("");	tfFuerza.setText("");
			tfNombre.setText("");	imgCarta.setIcon(null);
		}
		if (e.getSource() == btnGuardar){
			
		}
		if (e.getSource() == btnBuscar){
			JFileChooser elegirArchivo = new JFileChooser();
			FileNameExtensionFilter filtroImg = new FileNameExtensionFilter(extensionArchivo, EXTENSION);
			elegirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
			elegirArchivo.setFileFilter(filtroImg);
			
			int resultado = elegirArchivo.showOpenDialog(this);
			
			File archivo = elegirArchivo.getSelectedFile();
			
			if ((archivo == null) || (archivo.getName().equals(""))){
				JOptionPane.showMessageDialog(this, errorArchivo, ErrorNombreVentana, JOptionPane.ERROR_MESSAGE);
			}
			
			tfBuscador.setText(archivo.getAbsolutePath());
			
			archivoImg = new File(tfBuscador.getText());
			
			imagen = new BufferedImage(imgCarta.getWidth(), imgCarta.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics g = imagen.getGraphics();
			imgCarta.paint(g);
			
			try {
				
				ImageIO.write(imagen, EXTENSION, archivoImg);
				
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(this, "ERROR!", "Imagen no válida", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
