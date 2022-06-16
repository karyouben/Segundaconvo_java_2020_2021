package fp.RegistroActividad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
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
	
	//EJERCICIO 1
	public List<String> usuariosConActividadEnPuntoConDistanciaMenorOIgual(Coordenada c,Double umbral){
		return registros.stream()
				.filter(r->r.getCoordenadaPuntoRutaMasCercanoA(c, umbral)!=null)
				.sorted(Comparator.comparing(RegistroActividad::getUsuario))
				.map(RegistroActividad::getUsuario)
				.distinct()
				.collect(Collectors.toList());
	}
	//EJERCICIO 2
	
//	public SortedMap<Integer,Long> totalDeMinutosPorActividad(String usuario){
//		return registros.stream()
//				.filter(r->r.getUsuario().equals(usuario))
//				.collect(Collectors.groupingBy(r->UtilesFechas.getWeekOfYear(r.fecha()),
//						TreeMap::new,Collectors.summingLong(r->r.duracion().toMinutes())));
		
//	}
	//EJERCICIO 3
	
	public TipoActividad getTipoActividadMasPracticada() {
		Map<TipoActividad,Integer> m=numDeUsuariosPorActividad2();
		Comparator<Map.Entry<TipoActividad, Integer>> c=Comparator.comparing(Map.Entry::getValue);
		return m.entrySet().stream()
				.max(c)
				.get()
				.getKey();
		
	}
	
	private Map<TipoActividad,Set<String>> numDeUsuariosPorActividad(){
		return registros.stream()
				.collect(Collectors.groupingBy(RegistroActividad::getTipo,
						Collectors.mapping(RegistroActividad::getUsuario, Collectors.toSet())));
	}
	
	private Map<TipoActividad,Integer> numDeUsuariosPorActividad2(){
		Map<TipoActividad,Set<String>> m=numDeUsuariosPorActividad();
		return m.entrySet().stream()
				.collect(Collectors.toMap(c->c.getKey(), c->c.getValue().size()));
	}
	
	//Ejercicio 4
	
//	public Boolean esUsuarioSaludableOMS(String usuario) {
//		SortedMap<Integer,Long> actividad=totalDeMinutosPorActividad(usuario);
//		SortedMap<Integer,Long> numActividades=totalDeMinutosPorActividad(usuario);
//		
//		return actividad.size()>=48 && actividad.entrySet().stream().allMatch(c->c.getValue()>=180L && numActividades.get(c.getKey())>=5L);
//		
//	}
	
//	public SortedMap<Integer,Long> getNumActividadesPorSemana(String usuario){
//		return registros.stream()
//				.filter(r->r.getUsuario().equals(usuario))
//				.collect(Collectors.groupingBy(r->UtilesFechas.getWeekOfYear(r.fecha()),TreeMap::new,Collectors.counting()));
//	}

}


