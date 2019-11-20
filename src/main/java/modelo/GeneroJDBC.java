package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import utilidades.Utilidades;

public class GeneroJDBC implements GeneroDAO {
	
	private long idGenero;
	private String nombreGenero, descripcionGenero;
	
	private static final String SELECT_GENERO_IDGENERO = "select * from generos where idGenero = ?";
	private static final String CREAR_GENERO = "insert into generos (nombreGenero, descripcionGenero) values (?, ?)";
	private static final String UPDATE_GENERO = "update generos set nombreGenero = ?, descripcionGenero = ? where idGenero = ?";
	private static final String SELECT_GENEROS = "select * from generos";
	private static final String DELETE_GENERO = "delete from generos where idGenero = ?";

	Genero genero = null;
	//MÉTODOS
	
	public GeneroJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	public GeneroJDBC(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	
	public Genero obtenerGenero (long idGenero) throws IOException {
		/* Conexion a la Base de Datos */
		Connection con = null;
		/* Sentencia sql */
		PreparedStatement stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		ResultSet rs = null;
		
		
		try {
			con = new Utilidades().getConnection();
			// Creacion de la sentencia
			stmt = con.prepareStatement(SELECT_GENERO_IDGENERO);
			// Ejecucion de la consulta y obtencion de resultados en un ResultSet
			
			stmt.setLong(1, idGenero);
			
			rs = stmt.executeQuery();
			
			// Recuperacion de los datos del ResultSet
			while (rs.next() == true) {
				idGenero = rs.getLong("idGenero");
				nombreGenero = rs.getString("nombreGenero");
				descripcionGenero = rs.getString("descripcionGanero");
				
				genero = new Genero (idGenero, nombreGenero, descripcionGenero);
			} 
			
			return genero;
			
		} catch (SQLException sqle) {
			// En una aplicacion real, escribo en el log y delego
			System.out.println("Ha habido un error de sql");
			System.err.println(sqle.getMessage());
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				// En una aplicacon real, escribo en el log, no delego porque
				// es error al liberar recursos
			}
		}
			return null;
	}
	
	public Genero editarGenero (Genero generoPelicula) throws FileNotFoundException, InvalidPropertiesFormatException, IOException {
		/* Conexion a la Base de Datos */
		Connection con = null;
		/* Sentencia sql */
		PreparedStatement stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		
	
		try {
			con = new Utilidades().getConnection();
			// Creacion de la sentencia
			stmt = con.prepareStatement(UPDATE_GENERO);
			// Ejecucion de la consulta
			
			stmt.setString(1, generoPelicula.getNombreGenero());
			stmt.setString(2, generoPelicula.getDescripcionGenero());
			stmt.setLong(3, generoPelicula.getIdGenero());
			
			stmt.executeUpdate();
			
			genero = new Genero (generoPelicula.getIdGenero(), generoPelicula.getNombreGenero(), generoPelicula.getDescripcionGenero());
			
			return genero;

		}catch (SQLException sqle) {
			// En una aplicacion real, escribo en el log y delego
			System.out.println("Ha habido un error de sql");

			System.err.println(sqle.getMessage());
			
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				System.out.println("Ha habido un error de sql");

				// En una aplicacon real, escribo en el log, no delego porque es error al liberar recursos
			}
		}
		return null;
	}
	
	public List<Genero> obtenerGeneros () throws FileNotFoundException, InvalidPropertiesFormatException, IOException {

		/* Conexion a la Base de Datos */
		Connection con = null;
		/* Sentencia sql */
		PreparedStatement stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		ResultSet rs = null;
		
		try {
			con = new Utilidades().getConnection();
			// Creacion de la sentencia
			stmt = con.prepareStatement(SELECT_GENEROS);
			
			rs = stmt.executeQuery();
			
			// Recuperacion de los datos del ResultSet
			List <Genero> listaGeneros = new ArrayList<Genero> ();
			
			while (rs.next()) {
				idGenero = rs.getLong("idGenero");
				nombreGenero = rs.getString("nombreGenero");
				descripcionGenero = rs.getString("descripcionGenero");
				
				genero = new Genero (idGenero, nombreGenero, descripcionGenero);
				
				listaGeneros.add(genero);
			} 
			
			return listaGeneros;

		}catch (SQLException sqle) {
			System.out.println("Ha habido un error de sql");

			System.err.println(sqle.getMessage());
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {			
				System.out.println("Ha habido un error de sql");

				// En una aplicacon real, escribo en el log, no delego porque es error al liberar recursos
			}
		}
		return null;
		
		
	}
	
	public Genero crearGenero (String nombreGenero, String descripcionGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		
		try {
			con = new Utilidades().getConnection();
			
			stmt = con.prepareStatement(CREAR_GENERO, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1 , nombreGenero );
			stmt.setString(2, descripcionGenero);
			
			int affectedRows = stmt.executeUpdate();
			if (affectedRows == 0) {
			 throw new SQLException("No se pudo guardar");
			}
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
			  idGenero = generatedKeys.getInt(1);
			};
			
			genero = new Genero (idGenero, nombreGenero, descripcionGenero);
			
			return genero;
			
		}catch (SQLException sqle) {
			System.out.println("Ha habido un error de sql");

			// En una aplicacion real, escribo en el log y delego
			System.err.println(sqle.getMessage());
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				// En una aplicacon real, escribo en el log, no delego porque
				// es error al liberar recursos
			}
		}
		return null;
	}
	
	public boolean eliminarGenero (long idGenero) throws FileNotFoundException, InvalidPropertiesFormatException, IOException {
		/* Conexion a la Base de Datos */
		Connection con = null;
		/* Sentencia sql */
		PreparedStatement stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		ResultSet rs = null;
		
		try {
			con = new Utilidades().getConnection();
			// Creacion de la sentencia
			stmt = con.prepareStatement(DELETE_GENERO);
			stmt.setLong(1, idGenero);
			
			stmt.executeUpdate();
			
			return true;
			
		}catch (SQLException sqle) {
			System.out.println("Ha habido un error de sql");

			// En una aplicacion real, escribo en el log y delego
			System.err.println(sqle.getMessage());
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades.closeConnection(con);
				}
			} catch (SQLException sqle) {
				// En una aplicacon real, escribo en el log, no delego porque
				// es error al liberar recursos
			}
		}
		return false;
	}
	
	
}
