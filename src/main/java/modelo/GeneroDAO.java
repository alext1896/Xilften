package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public interface GeneroDAO {
	
	public Genero obtenerGenero (long idGenero) throws IOException;
	
	public Genero editarGenero (Genero generoPelicula) throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public List<Genero> obtenerGeneros () throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public Genero crearGenero (String nombreGenero, String descripcionGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
	
	public boolean eliminarGenero (long idGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException;
}
