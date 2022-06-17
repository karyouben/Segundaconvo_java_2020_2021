package fp.TestRegistroActividad;

import java.util.List;

import fp.RegistroActividad.FactoriaRegistrosActividades;
import fp.RegistroActividad.RegistroActividad;

public class TestFactoriaRegistrosActividades {

	public static void main(String[] args) {
		TestleeRegistros("data/registros.csv");

	}

	private static void TestleeRegistros(String fichero) {
		System.out.println("\nTestLeeRegistros =========");
		List<RegistroActividad> registros=FactoriaRegistrosActividades.leeRegistros(fichero);
		System.out.println(" Registro actividad: ");
		for(RegistroActividad r:registros) {
			System.out.println(r);
		}
		
	}

}
