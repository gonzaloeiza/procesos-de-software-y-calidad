package p2parking.jdo;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase de dominio de Alquiler. Esta clase contiene toda la informacion relevante a un alquiler
 * 
 * @author imanol
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Alquiler {
	
	/**
	 * Fecha de comienzo del alquiler
	 */
	Date fechaIni;
	
	/**
	 * Fecha de fin del alquiler
	 */
	Date fechaFin;
	
	/**
	 * Precio del alquiler
	 */
	float precio;
	
	/**
	 * Usuario que alquila la plaza
	 */
	Usuario alquilador;
	
	/**
	 * Plaza que se desea alquilar
	 */
	Plaza plaza;
	
	/**
	 * Geter de la fecha de inicio
	 * @return fecha de inicio
	 */
	public Date getFechaIni() {
		return fechaIni;
	}

	/**
	 * Seter de la fecha de inicio
	 * @param fechaIni Fecha de comienzo del alquiler
	 */
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * Geter de la fecha de fin de alquiler
	 * @return fecha de fin de alquiler
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Seter de la fecha fin del alquiler
	 * @param fechaFin Objeto de la fecha fin del alquiler
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Geter del precio del alquiler
	 * @return precio del alquiler
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Seter del precio de alquiler
	 * @param precio de alquiler
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Geter del usuario que alquila la plaza
	 * @return objeto del usuario que alquila la plaza
	 */
	public Usuario getAlquilador() {
		return alquilador;
	}

	/**
	 * Seter del usuario que alquila la plaza
	 * @param alquilador objeto usuario que alquila la plaza
	 */
	public void setAlquilador(Usuario alquilador) {
		this.alquilador = alquilador;
	}

	/**
	 * Geter de la plaza que se va a alquilar
	 * @return Objeto de plaza que se va a alquilar
	 */
	public Plaza getPlaza() {
		return plaza;
	}

	/**
	 * Seter de la plaza que se va a alquilar
	 * @param plaza Objeto de plaza que se va a alquilar
	 */
	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}
	
	/**
	 * Constructor de objeto Alquiler
	 * @param fechaIni fecha de inicio del alquiler
	 * @param fechaFin fecha de fin del alquiler
	 * @param precio precio del alquiler
	 * @param alquilador usuario que va a alquilar la plaza
	 * @param plaza plaza que se va a alquilar
	 */
	public Alquiler(Date fechaIni, Date fechaFin, float precio, Usuario alquilador, Plaza plaza) {
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.precio = precio;
		this.alquilador = alquilador;
		this.plaza = plaza;
	}

}
