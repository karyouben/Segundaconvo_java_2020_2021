package fp.RegistroActividad;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Horas {
	private List<LocalDateTime> horas;
	
	public Horas(Stream<LocalDateTime> horas) {
		this.horas=horas.collect(Collectors.toList());
	}

}
