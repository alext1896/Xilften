package modelo;

public class Serie {
	private long idSerie, idGenero;
	private String descripcionSerie, nombreSerie;
	
	public Serie (long idSerie, String nombreSerie, String descripcionSerie, long idGenero) {
		this.idSerie = idSerie;
		this.nombreSerie = nombreSerie;
		this.descripcionSerie = descripcionSerie;
		this.idGenero = idGenero;
	}
	
	public Serie () {
	}
	
	public long getIdSerie () {
		return idSerie;
	}
	
	public long getIdGenero () {
		return idGenero;
	}
	
	public String getNombreSerie () {
		return nombreSerie;
	}
	
	public String getDescripcionSerie () {
		return descripcionSerie;
	}
	
	public void setNombreSerie (String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}
	
	public void setDescripcionSerie (String descripcionSerie) {
		this.descripcionSerie = descripcionSerie;
	}
	
	public void setIdGenero (long idGenero) {
		this.idGenero = idGenero;
	}
	
	public String toString () {
		String toString = "\n ID Serie: " + idSerie + "\n Nombre: " + nombreSerie + "\n Descripcion: " + descripcionSerie + "\n idGenero: " + idGenero;
		
		return toString;
	}
}
