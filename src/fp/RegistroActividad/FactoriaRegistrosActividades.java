package fp.RegistroActividad;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaRegistrosActividades {
	
	public static List<RegistroActividad> leeRegistros(String fichero){
		Checkers.checkNoNull(fichero);
		List<String> lineas=Ficheros.leeFichero("Error al leer el fichero", fichero);
		lineas.remove(0);
		
		List<RegistroActividad> res=new ArrayList<RegistroActividad>();
		for(String linea:lineas) {
			RegistroActividad r=parseaRegistro(linea);
			res.add(r);
		}return res;
	}

	private static RegistroActividad parseaRegistro(String linea) {
		Checkers.checkNoNull(linea);
		String[] trozos=linea.split(";");
		Checkers.check("Formato no valido ", trozos.length==6);
		String usuario=trozos[0].trim();
		TipoActividad tipo=TipoActividad.valueOf(trozos[1].trim().toUpperCase());
		Boolean registroRuta=Boolean.parseBoolean(trozos[2].trim());
		List<LocalDateTime> horas=parseaFecha(trozos[3].trim());
		List<Coordenada> coordenadas=parseaCoordenadas(trozos[4].trim());
		List<Double> alturas=parseaAlturas(trozos[5].trim());
		return new RegistroActividad(usuario, tipo,registroRuta, horas, coordenadas, alturas);
	}

	private static List<Double> parseaAlturas(String trim) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<Coordenada> parseaCoordenadas(String trim) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<LocalDateTime> parseaFecha(String cadena) {
		String[] arreglo=cadena.split(",");
		List<LocalDateTime> salida= new ArrayList<>();
		for(LocalDateTime c:arreglo ) {
			salida.add(c);
		}return salida;
	}

}
