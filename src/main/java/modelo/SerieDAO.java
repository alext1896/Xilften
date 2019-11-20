package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public interface SerieDAO {
	
	public Serie obtenerSerie (long idSerie) throws IOException;
	
	public Serie crearSerie (String nombreSerie, String descripcionSerie, long idGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException ;
	
	public boolean eliminarSerie (long idSerie) throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public List<Serie> obtenerCatalogoSeries () throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public int obtenerNumeroSeries () throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public List<Serie> buscarSeriesPorNombre (String nombre, int index, int limit) throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public List<Serie> obtenerSeriesPorGenero (long idGenero, int index, int count) throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public Serie editarSerie (Serie serie) throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
}
