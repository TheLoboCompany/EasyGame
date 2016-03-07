package Tablero;

public class Zombies {

	private String tipoZombie;
	private int ataque;
	private int vida;
	private int armadura;
	private int accion;
	
	public Zombies(String tipoZombie){
		
		//TODO si el tipo es humano, se asignan atributos de zombies humanos.
		//si por el contrario es animal, se le asignan atributos de zombies animales.
		
	}
	
	public void recibirDanio(int numeroDados){
		
		//TODO si el numero es mas grande que la defensa, el zombie es destruido
		
	}
	
	public void mover(){
		
		//TODO cada vuelta, se mueven los zombies hacia los jugadores tantas casillas como "accion" tenga.
		
	}
	
	public void atacar(){
		
		//TODO inflinje tanto danio como ataque tenga.
		
	}
	
	public void obtenerAccion(){
		
		//TODO se obtiene tirando un dado, lo que saque, son las acciones que puede realizar.
		
	}
	
}
