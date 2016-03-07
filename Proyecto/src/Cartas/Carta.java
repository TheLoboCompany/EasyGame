package Cartas;

public class Carta {

	private String nombre;
	private String descripcion;
	private int destreza;
	private int cadencia;
	private int alcance;
	private int bala;
	private int cartucho;
	
	public Carta(String nombre, String descripcion, int destreza, int cadencia, int alcance, int bala, int cartucho){
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.destreza = destreza;
		this.cadencia = cadencia;
		this.alcance = alcance;
		this.bala = bala;
		this.cartucho = cartucho;
	}
	
	public String toString(){
		
		return "\nNombre: " + nombre + "\nDescripción: " + descripcion + "\nDestreza: " + destreza + "\nCadencia: " + cadencia + "\nAlcance: " + alcance + "\nBala: " + bala + "\nCartucho: " + cartucho;
	}
	
}