package com.xmltocfdi_3_3.beans;

public class Colectividad {

	private String filial;
	private String colectividad;
	private String primaNeta;
	private String analogos;
	private String derechoPoliza;
	private String recargoFraccionado;
	
	public static Colectividad getEmptyBean() {
		Colectividad colectividad = new Colectividad();
		colectividad.setAnalogos("");
		colectividad.setColectividad("");
		colectividad.setDerechoPoliza("");
		colectividad.setFilial("");
		colectividad.setPrimaNeta("");
		colectividad.setRecargoFraccionado("");
		return colectividad;
	}
	
	public String getFilial() {
		return filial;
	}
	
	public void setFilial(String filial) {
		this.filial = filial;
	}
	
	public String getColectividad() {
		return colectividad;
	}
	
	public void setColectividad(String colectividad) {
		this.colectividad = colectividad;
	}
	
	public String getPrimaNeta() {
		return primaNeta;
	}
	
	public void setPrimaNeta(String primaNeta) {
		this.primaNeta = primaNeta;
	}
	
	public String getAnalogos() {
		return analogos;
	}
	
	public void setAnalogos(String analogos) {
		this.analogos = analogos;
	}
	
	public String getDerechoPoliza() {
		return derechoPoliza;
	}
	
	public void setDerechoPoliza(String derechoPoliza) {
		this.derechoPoliza = derechoPoliza;
	}
	
	public String getRecargoFraccionado() {
		return recargoFraccionado;
	}
	
	public void setRecargoFraccionado(String recargoFraccionado) {
		this.recargoFraccionado = recargoFraccionado;
	}
	
}
