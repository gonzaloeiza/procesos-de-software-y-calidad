package p2parking.server;

import java.util.Date;

public class Alquiler {
	
	private Date fechaIni;
	private Date fechaFin;
	private Usuario alquilador;
	private Plaza plaza;
	
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
	public Usuario getAlquilador() {
		return alquilador;
	}
	public void setAlquilador(Usuario alquilador) {
		this.alquilador = alquilador;
	}
	public Alquiler(Date fechaIni, Date fechaFin, Usuario alquilador, Plaza plaza) {
		super();
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.alquilador = alquilador;
		this.plaza = plaza;
	}
	public Plaza getPlaza() {
		return plaza;
	}
	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}
}
