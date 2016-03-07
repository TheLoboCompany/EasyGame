package Personajes;

import Cartas.Carta;

public class Humano {

	private Clase clase;
	private int vida;
	private int municion;
	private int bala;
	private int cartucho;
	private int defensa;
	private Carta[] inventario;
	private int fuerza;
	private int destreza;
	private int velocidad;
	
	public Humano(Clase clase, int vida, int velocidad, int defensa, int fuerza, int destreza, int municion, int bala, int cartucho, int inventario) throws HumanoException{
		
		if(clase == null)
			throw new HumanoException("Error, el personaje debe de ser de algún tipo. Tipo asignado: " + clase);
		if(vida < 1)
			throw new HumanoException("Error, la vida del personaje no puede ser infrior a 1. Vida asignada: " + vida);
		if(velocidad < 1)
			throw new HumanoException("Error, la velocidad del personaje no puede ser infrior a 1. Velocidad asignada: " + velocidad);
		if(defensa < 1)
			throw new HumanoException("Error, la defensa del personaje no puede ser infrior a 1. Defensa asignada: " + defensa);
		if(fuerza < 1)
			throw new HumanoException("Error, la fuerza del personaje no puede ser infrior a 1. Fuerza asignada: " + fuerza);
		if(destreza < 1)
			throw new HumanoException("Error, la destreza del personaje no puede ser infrior a 1. Destreza asignada: " + destreza);
		if(municion < 0)
			throw new HumanoException("Error, la municion del personaje no puede ser infrior a 0. Municion asignada: " + municion);
		if(bala < 0)
			throw new HumanoException("Error, la bala del personaje no puede ser infrior a 0. Bala asignada: " + bala);
		if(cartucho < 0)
			throw new HumanoException("Error, el cartucho del personaje no puede ser infrior a 0. Cartucho asignada: " + cartucho);
		if(inventario < 1)
			throw new HumanoException("Error, el inventario del personaje no puede ser infrior a 1. Inventario asignada: " + inventario);
		
		this.clase = clase;
		this.vida = vida;
		this.velocidad = velocidad;
		this.defensa = defensa;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.municion = municion;
		this.bala = bala;
		this.cartucho = cartucho;
		this.inventario = new Carta[inventario];
		
	}
	
}
