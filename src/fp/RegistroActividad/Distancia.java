package fp.RegistroActividad;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Distancia {
	private List<Double> distancias;
	
	public Distancia(Stream<Double> distancias) {
		this.distancias=distancias.collect(Collectors.toList());
	}

}
