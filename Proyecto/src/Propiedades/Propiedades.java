package Propiedades;

import java.io.IOException;
import java.util.Properties;

public class Propiedades extends Properties {
	
	public Propiedades(String idiomaATraducir){
		
		if (idiomaATraducir.equals("ESPANNOL")){
			getProperties("Espannol.propiedades");
		}else if (idiomaATraducir.equals("INGLES")){
			getProperties("Ingles.propiedades");
		}else{
			getProperties("Espannol.propiedades");
		}
		
	}

	public void getProperties(String idioma) {

		try {
			this.load(getClass().getResourceAsStream(idioma));
		} catch (IOException e) {
		}
		
	}

}
