package fp.RegistroActividad;

import java.util.ArrayList;
import java.util.List;

public record Coordenada(Double latitud,Double longitud) {
	
	
	public Double distancia(Coordenada c) {
		Double latitud=0.0;
		Double longitud=0.0;
		Double res=Math.sqrt(Math.pow(latitud-c.latitud(),2)+Math.pow(longitud-c.longitud(), 2));
		return res;
	}


}
