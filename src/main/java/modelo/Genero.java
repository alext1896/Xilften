package modelo;

public class Genero {
	private long idGenero;
	private String nombreGenero, descripcionGenero;
	
	public Genero (long idGenero, String nombreGenero, String descripcionGenero) {
		this.idGenero = idGenero;
		this.nombreGenero = nombreGenero;
		this.descripcionGenero = descripcionGenero;
		
	}
	
	public Genero () {
		
	}
	
	public long getIdGenero () {
		return idGenero;
		
	}
	
	public String getNombreGenero () {
		return nombreGenero;
		
	}
	
	public void setNombreGenero (String nombreGenero) {
		this.nombreGenero = nombreGenero;
		
	}
	
	public String getDescripcionGenero () {
		return descripcionGenero;
		
	}
	
	public void setDescriocionGenero (String nombreGenero) {
		this.descripcionGenero = nombreGenero;
		
	}
	
public String toString () {
		
		String toString = "\n ID Genero: " + idGenero + "\n Genero: " + nombreGenero;
		
		return toString;
	}
}
