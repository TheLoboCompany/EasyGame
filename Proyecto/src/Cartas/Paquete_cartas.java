package Cartas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Paquete_cartas {

	private Carta[] cartas;

	public void cargarCartas(String archivo) {

		String resultado = "";

		try {

			BufferedReader lineaAProcesar = new BufferedReader(new FileReader(archivo));

			while (!(resultado = lineaAProcesar.readLine()).contains("numero_cartas:")) {
			}

			int caracter = 0;
			boolean encontrado = false;
			while (caracter < resultado.length() && encontrado == false) {
				char c = resultado.charAt(caracter);
				if (c == ':') {
					cartas = new Carta[Integer.parseInt(resultado.substring(caracter + 1))];
					encontrado = true;
				}
				caracter++;
			}

			introducirCartas(lineaAProcesar);

			for (int i = 0; i < cartas.length; i++) {
				System.out.println(cartas[i]);
			}

		} catch (NullPointerException e) {
			System.out.println("Error al crear las cartas");
		} catch (NumberFormatException e) {
			System.out.println("Error, no se ha encontrado la catidad de cartas.");
		} catch (Exception e) {
			System.out.println("Error de la clase paquete_cartas desconocido.");
		}

	}

	private void introducirCartas(BufferedReader lineaAProcesar) throws IOException {

		String linea = "";
		int i = 0;

		String nombre = "";
		String descripcion = "";
		int destreza = 0;
		int cadencia = 0;
		int alcance = 0;
		int bala = 0;
		int cartucho = 0;

		while (i < cartas.length && (linea = lineaAProcesar.readLine()) != null) {
			if (linea.contains("nombre:")) {
				nombre = obtenerDatos(linea);
			}
			if (linea.contains("descripcion:")) {
				descripcion = obtenerDatos(linea);
			}
			if (linea.contains("destreza:")) {
				destreza = Integer.parseInt(obtenerDatos(linea));
			}
			if (linea.contains("cadencia:")) {
				cadencia = Integer.parseInt(obtenerDatos(linea));
			}
			if (linea.contains("alcance:")) {
				alcance = Integer.parseInt(obtenerDatos(linea));
			}
			if (linea.contains("bala:")) {
				bala = Integer.parseInt(obtenerDatos(linea));
			}
			if (linea.contains("cartucho:")) {
				cartucho = Integer.parseInt(obtenerDatos(linea));
			}
			if (linea.contains("]")) {
				cartas[i] = new Carta(nombre, descripcion, destreza, cadencia, alcance, bala, cartucho);
				i++;
			}
		}
	}

	private String obtenerDatos(String linea) {

		String resultado = "";

		for (int i = 0; i < linea.length(); i++) {
			char c = linea.charAt(i);
			if (c == ':') {
				resultado = linea.substring(i + 1);
			}
		}

		return resultado.trim();
	}

}
