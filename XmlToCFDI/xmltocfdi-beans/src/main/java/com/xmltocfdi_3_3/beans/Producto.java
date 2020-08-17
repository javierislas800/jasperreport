package com.xmltocfdi_3_3.beans;

public class Producto {

	private String noIdentificacion;
	private String descripcion;
	private String uMedida;
	private String precioU;
	private String descuento;
	private String cantidad;
	private String importe;
	
	public Producto(String noIdentificacion, String descripcion, String uMedida, String precioU, String descuento, String cantidad, String importe) {
		super();
		this.noIdentificacion = noIdentificacion;
		this.descripcion = descripcion;
		this.uMedida = uMedida;
		this.precioU = precioU;
		this.descuento = descuento;
		this.cantidad = cantidad;
		this.importe = importe;
	}

	public String getNoIdentificacion() {
		return noIdentificacion;
	}

	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getuMedida() {
		return uMedida;
	}

	public void setuMedida(String uMedida) {
		this.uMedida = uMedida;
	}

	public String getPrecioU() {
		return precioU;
	}

	public void setPrecioU(String precioU) {
		this.precioU = precioU;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}
	
}
