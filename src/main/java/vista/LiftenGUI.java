package vista;

import java.io.IOException;

import modelo.Genero;
import modelo.SerieJDBC;

public class LiftenGUI {

	public static void main(String[] args) throws IOException {
		SerieJDBC serie = new SerieJDBC ();
		Genero genero = new Genero (2, "Aventura", "Solas");
		
//		genero.crearGenero("Suspense", "Miedito");
		//serie.crearSerie("Serie1", "Descripcion 1", 2);
		
		System.out.println(serie.obtenerSeriesPorNombreYGenero("Serie1", genero, 0, 1));
	}

}
