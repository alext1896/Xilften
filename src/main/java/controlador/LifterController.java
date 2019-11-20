package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import modelo.Genero;
import modelo.GeneroDAO;
import modelo.GeneroJDBC;
import modelo.Serie;
import modelo.SerieDAO;
import modelo.SerieJDBC;

public class LifterController {
	SerieDAO serieControlador = new SerieJDBC ();
	GeneroDAO generoControlador = new GeneroJDBC ();
	
	
	public Serie obtenerSerie (long idSerie) throws IOException{
		return serieControlador.obtenerSerie(idSerie);
	};
	
	public Serie crearSerie (String nombreSerie, String descripcionSerie, long idGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return serieControlador.crearSerie(nombreSerie, descripcionSerie, idGenero);
		
	};
	
	public boolean eliminarSerie (long idSerie) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return serieControlador.eliminarSerie(idSerie);
	};
	
	public List<Serie> obtenerCatalogoSeries () throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return serieControlador.obtenerCatalogoSeries();
		
	};
	
	public int obtenerNumeroSeries () throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return serieControlador.obtenerNumeroSeries();
	};
	
	public List<Serie> buscarSeriesPorNombre (String nombre, int index, int limit) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return serieControlador.buscarSeriesPorNombre(nombre, index, limit);
		
	};
	
	public List<Serie> obtenerSeriesPorGenero (long idGenero, int index, int count) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return serieControlador.obtenerSeriesPorGenero(idGenero, index, count);
	};
	
	public Serie editarSerie (Serie serie) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return serieControlador.editarSerie(serie);
	};
	
	
	public Genero obtenerGenero (long idGenero) throws IOException {
		return generoControlador.obtenerGenero(idGenero);
	};
	
	public Genero editarGenero (Genero generoPelicula) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return generoControlador.editarGenero(generoPelicula);
	};
	
	public List<Genero> obtenerGeneros () throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return generoControlador.obtenerGeneros();
	};
	
	public Genero crearGenero (String nombreGenero, String descripcionGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return generoControlador.crearGenero(nombreGenero, descripcionGenero);
		
	};
	
	public boolean eliminarGenero (long idGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException{
		return generoControlador.eliminarGenero(idGenero);
	};
	
	
}

