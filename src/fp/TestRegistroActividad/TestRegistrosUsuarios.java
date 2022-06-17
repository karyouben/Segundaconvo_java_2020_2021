package fp.TestRegistroActividad;


import java.util.List;

import fp.RegistroActividad.Coordenada;
import fp.RegistroActividad.FactoriaRegistrosActividades;
import fp.RegistroActividad.RegistroActividad;
import fp.RegistroActividad.RegistrosUsuarios;

public abstract class TestRegistrosUsuarios {

	public static void main(String[] args) {
		List<RegistroActividad> registros=FactoriaRegistrosActividades.leeRegistros("data/Registros.csv");
		RegistrosUsuarios r= new RegistrosUsuarios(registros);
		System.out.println("\nTestGetTipoActividadMasPracticada");
		System.out.println("===================================");
		testGetTipoActividadMasPracticada(r);
		System.out.println("\nTestUsuariosConActividadEnPuntoConDistanciaMenorOIgual");
		System.out.println("===================================");
		Coordenada c=new Coordenada(20.3, 50.4);
		testUsuariosConActividadEnPuntoConDistanciaMenorOIgual(r,c,30.0);
		System.out.println("\nTestTotalDeMinutosPorActividad");
		System.out.println("===================================");
		testTotalDeMinutosPorActividad(r,"Daniel");
		System.out.println("\nTestEsUsuarioSaludableOMS");
		System.out.println("===================================");
		testEsUsuarioSaludableOMS(r,"Daniel");
		
	}

	private static void testGetTipoActividadMasPracticada(RegistrosUsuarios r) {
		try {
			String msg=String.format("El tipo de actividad mas practicada es: %s", 
					r.getTipoActividadMasPracticada());
			System.out.println(msg);

	  }catch(Exception e) {
		System.err.println("Excepcion capturada inesesperada" + e.getMessage());
	}

	}
	
	private static void testUsuariosConActividadEnPuntoConDistanciaMenorOIgual(RegistrosUsuarios r,Coordenada c, Double umbral) {
		try {
			String msg=String.format("Los usuaros con actividad en la coordenada %d en el umbral "+ umbral +" son %s ", 
					r.usuariosConActividadEnPuntoConDistanciaMenorOIgual(c, umbral));
			System.out.println(msg);

	  }catch(Exception e) {
		System.err.println("Excepcion capturada inesesperada" + e.getMessage());
	}
		
	}
	
	private static void testTotalDeMinutosPorActividad(RegistrosUsuarios r, String nombre) {
		try {
			String msg=String.format("El total de minutos por actividad del usuario %d son: %s ", 
					nombre,r.totalDeMinutosPorActividad(nombre));
			System.out.println(msg);

	  }catch(Exception e) {
		System.err.println("Excepcion capturada inesesperada" + e.getMessage());
	}
	}
	
	private static void testEsUsuarioSaludableOMS(RegistrosUsuarios r, String nombre) {
		try {
			String msg=String.format("¿El usuario %d es saludable segun los requisitos de la OMS? %s ", 
					r.esUsuarioSaludableOMS(nombre));
			System.out.println(msg);

	  }catch(Exception e) {
		System.err.println("Excepcion capturada inesesperada" + e.getMessage());
	}
		
	}

}
