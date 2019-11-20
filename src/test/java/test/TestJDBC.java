package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.BeforeClass;
import org.junit.Test;

import controlador.LifterController;
import modelo.Genero;
import utilidades.Utilidades;

public class TestJDBC {

	@BeforeClass
	public static void setUp() {
			
		try {
			Utilidades utilidades = new Utilidades();
			
			//Establecemos la conexiçon y un objeto scriptrunner para lanzar el script de BD
			Connection con = utilidades.getConnection();
			ScriptRunner sr = new ScriptRunner(con);

			//Creamos un buffer para leer el sql create tables
			
			Reader reader = new BufferedReader(new FileReader("../Xilften/src/test/resources/create_test_table.sql"));

			//Ejecutamos el SQL create tables.
			sr.runScript(reader);

		} catch (FileNotFoundException e) {
			System.out.println("Error al cargar el fichero \\n Mas info:" + e.getMessage());
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("Error SQL \\n Mas info:" + e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Error de entrada salida \\n Mas info:" + e.getMessage());
			System.exit(1);
		}
	}

	@Test
	public void testObtenerGenerosVacio() {
		//Instanciamos el controlador
		LifterController controlador = new LifterController();
		
		//Llamamos al método
		try {
			List<Genero> lGeneros = controlador.obtenerGeneros();
			
			//Comprobamos que el numero de registros es 0
			assertEquals(lGeneros.size(), 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void testCrearGenero() {

		//Instanciamos el controlador
		LifterController controlador = new LifterController();

		//Creamos los generos que insertaremos en la base de datos
		
		
		try {
			Genero comedia = controlador.crearGenero("farfala", "Psas");
			Genero accion = controlador.crearGenero("Aventura", "Solas");
			//Comprobamos que los datos son insertados correctamente en la BD
			assertEquals("farfala", comedia.getNombreGenero());
			assertEquals("Psas", comedia.getDescripcionGenero());
			assertEquals(1, comedia.getIdGenero());

			assertEquals("Aventura", accion.getNombreGenero());
			assertEquals("Solas", accion.getDescripcionGenero());
			assertEquals(2, accion.getIdGenero());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testObtenerGeneros() {
		//Instanciamos el controlador
		LifterController controlador = new LifterController();
		
		//Llamamos al método
		
		try {
			List<Genero> lGeneros = controlador.obtenerGeneros();
			//Comprobamos que el el numero de registros es el esperado
			assertEquals(lGeneros.size(), 2);
			
			//Comprobamos que podemos obetener todoso lso registros correctamente
			assertEquals(lGeneros.get(0).getIdGenero(),1);
			assertEquals(lGeneros.get(0).getDescripcionGenero(),"Psas");
			assertEquals(lGeneros.get(0).getNombreGenero(),"farfala");
			
			assertEquals(lGeneros.get(1).getIdGenero(),2);
			assertEquals(lGeneros.get(1).getDescripcionGenero(),"Solas");
			assertEquals(lGeneros.get(1).getNombreGenero(),"Aventura");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
