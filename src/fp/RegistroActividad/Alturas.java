package fp.RegistroActividad;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Alturas {
	private List<Double> alturas;
	
	public Alturas(Stream<Double> alturas) {
		this.alturas=alturas.collect(Collectors.toList());
	}

}
