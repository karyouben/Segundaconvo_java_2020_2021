package fp.RegistroActividad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistrosUsuarios {
	private List<RegistroActividad> registros;

	public List<RegistroActividad> getRegistros() {
		return registros;
	}
	public RegistrosUsuarios() {
		registros=new ArrayList<>();
	}
	
	public RegistrosUsuarios(Stream<RegistroActividad> registros) {
		this.registros=registros.collect(Collectors.toList());
	}
	
	public RegistrosUsuarios(List<RegistroActividad> registros) {
		this.registros=new ArrayList<RegistroActividad>(registros);
	}
	
	public RegistrosUsuarios(Collection<RegistroActividad> registros) {
		this.registros=new ArrayList<RegistroActividad>(registros);
	}
	
	public List<String> usuariosConActividadEnPuntoConDistanciaMenorOIgual(Coordenada c,Double umbral){
		return registros.stream()
				.filter(r->r.getCoordenadaPuntoRutaMasCercanoA(c, umbral)!=null)
				.sorted(Comparator.comparing(RegistroActividad::getUsuario))
				.map(RegistroActividad::getUsuario)
				.distinct()
				.collect(Collectors.toList());
	}

}


