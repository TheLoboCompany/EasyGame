package Propiedades;

import java.io.IOException;
import java.util.Properties;

public class Propiedades extends Properties {
	
	public Propiedades(String idioma){
		
		if (idioma.equals("ESPANNOL")){
			getProperties("Espannol.properties");
		}else if (idioma.equals("INGLES")){
			getProperties("Ingles.properties");
		}else{
			getProperties("Espannol.properties");
		}
		
	}

	private void getProperties(String idioma) {

		try {
			this.load(getClass().getResourceAsStream(idioma));
		} catch (IOException e) {
		}
		
	}

}
