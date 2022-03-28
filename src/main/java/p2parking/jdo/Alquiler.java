package p2parking.jdo;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Alquiler {
	
	Date fechaIni;
	Date fechaFin;
	float precio;
	
	Usuario alquilador;
	Plaza plaza;
	
	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Usuario getAlquilador() {
		return alquilador;
	}

	public void setAlquilador(Usuario alquilador) {
		this.alquilador = alquilador;
	}

	public Plaza getPlaza() {
		return plaza;
	}

	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}
	
	public Alquiler(Date fechaIni, Date fechaFin, float precio, Usuario alquilador, Plaza plaza) {
		super();
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.precio = precio;
		this.alquilador = alquilador;
		this.plaza = plaza;
	}

}
