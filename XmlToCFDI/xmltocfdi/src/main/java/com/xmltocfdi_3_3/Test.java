package com.xmltocfdi_3_3;

public class Test {

	static public void main(String args[]) throws Exception {
		System.out.println("Inicia...");
		
		ReporteColectividadesCaratula reporte = new ReporteColectividadesCaratula();
		reporte.createPDF();

		System.out.println("Termina de crear el archivo.");
	}

}
