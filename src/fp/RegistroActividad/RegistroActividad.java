package fp.RegistroActividad;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class RegistroActividad {
	private String usuario;
	private TipoActividad tipo;
	private Boolean registroRuta;
	private List<LocalDateTime> horas;
	private List<Coordenada> coordenadas;
	private List<Double> alturas;
	

	public Double alturaMaxima() {
		return alturas.stream()
				.max(Comparator.comparing(Double::doubleValue))
				.orElse(null);
	}
	
	//constructor 1
	public RegistroActividad(String usuario,TipoActividad tipo,LocalDateTime inicio,
			LocalDateTime fin) {
		this.usuario=usuario;
		this.tipo=tipo;
		this.registroRuta=false;
		
	}
	
	//constructor 2
	public RegistroActividad(String usuario,TipoActividad tipo,Boolean registroRuta, List<LocalDateTime> horas,
			List<Coordenada> coordenadas,List<Double> alturas) {
		Checkers.check("La listas horas,coordenadas y alturas deben tener el mismo numero "
				+ "de elementos que debe ser >=2",
				horas.size()==coordenadas.size()  && horas.size()==alturas.size() 
				&& horas.size()>=2);
		Checkers.check("La listas de horas debe tener exactamente dos elementos,"
				+ "y las listas de coordenadas y alturas deben estar vacías,si la"
				+ "actividad no tiene registro de ruta",horas.size() ==2 && coordenadas==null 
				&& alturas==null && registroRuta==false );
		Checkers.check("La fecha-hora debe ser anterior a la fecha-hora de la posicion i+1 "
				+ "y posterior a la fecha-hora de la posicion i-1 ", sonHorasOk(horas) );
		Checkers.check("Las actividades tipo PILATES Y BICICLETA_ESTATICA"
				+ "no pueden tener registro de ruta", registroRuta==true && 
				!tipo.equals(TipoActividad.PILATES) && !tipo.equals(TipoActividad.BICICLETA_ESTATICA) );
		
		this.usuario=usuario;
		this.tipo=tipo;
		this.registroRuta=true;
		this.horas=new ArrayList<>();
		this.coordenadas=new ArrayList<>();
		this.alturas=new ArrayList<>();
	}
	
	
	
	private Boolean sonHorasOk(List<LocalDateTime> horas) {
		Boolean res=true;
		for(int i=0; i<horas.size()-2;i++) {
			if(!horas.get(i).isBefore(horas.get(i+1))) {
				res=false;
				break;		
			}
		}return res;
	}
	

	
	
	public LocalDateTime inicio() {
	return horas.stream().findFirst().get();
	}
	
	public LocalDateTime fin() {
	int	m  =horas.size();
	return  horas.get(m-1);
	}
	
	public Duration duracion() {
		return Duration.between(inicio(), fin());
		
	}
	
	public LocalDate fecha() {
		return inicio().toLocalDate();
	}
	
	public List<Double> distancias() {
		Double latitud=0.0;
		Double longitud=0.0;
		List<Double> distancias= new ArrayList<>();
		for(Coordenada c:coordenadas) {
			Double res=Math.sqrt(Math.pow(latitud-c.latitud(),2)+Math.pow(longitud-c.longitud(), 2));
			latitud +=c.latitud();
			longitud+=c.longitud();
			distancias.add(res);	
		}
		return distancias;
	}
	
	public Double Sumdistancias() {
		Double latitud=0.0;
		Double longitud=0.0;
		Double res1=0.0;
		for(Coordenada c:coordenadas) {
			Double res=Math.sqrt(Math.pow(latitud-c.latitud(),2)+Math.pow(longitud-c.longitud(), 2));
			latitud +=c.latitud();
			longitud+=c.longitud();
			res1+=res;	
		}
		return res1;
	}
	
	//OTRAS OPERACIONES
	
	public Coordenada getCoordenadaPuntoRutaMasCercanoA(Coordenada c,Double umbral){
		Coordenada res=null;
		Double distRes=null;
		for(Coordenada coord:this.coordenadas) {
			Double d=coord.distancia(c);
			if(d<=umbral) {
				if(distRes== null|| distRes>d) {
					res=coord;
					distRes=d;
				}
			}
		}return res;
	}




	public TipoActividad getTipo() {
		return tipo;
	}




	public void setTipo(TipoActividad tipo) {
		this.tipo = tipo;
	}




	public String getUsuario() {
		return usuario;
	}




	public Boolean getRegistroRuta() {
		return registroRuta;
	}




	public List<LocalDateTime> getHoras() {
		return horas;
	}




	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}




	public List<Double> getAlturas() {
		return alturas;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horas.get(0) == null) ? 0 : horas.get(0).hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RegistroActividad))
			return false;
		RegistroActividad other = (RegistroActividad) obj;
		if (horas.get(0) == null) {
			if (other.horas.get(0) != null)
				return false;
		} else if (!horas.get(0).equals(other.horas.get(0)))
			return false;
		if (tipo != other.tipo)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "" + usuario + ":" + horas + "-" + tipo + "";
	}
	
	
	
	
	
	
 }


