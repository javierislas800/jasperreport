package com.xmltocfdi_3_3;

public class Test {

	static public void main(String args[]) throws Exception {
		System.out.println("Inicia...");
		
		ReporteColectividadesCaratula reporte = new ReporteColectividadesCaratula();
		reporte.createPDF(1);
		reporte.createPDF(10);
		reporte.createPDF(170);
		
		System.out.println("Termina.");
		
		/*
		testRows(5);
		testRows(22);
		testRows(23);
		testRows(40);
		testRows(66);
		testRows(70);
		testRows(109);
		testRows(110);
		testRows(152);
		testRows(170);
		testRows(238);
		testRows(240);*/
		
		
		
		
	}
	
	static public void testRows(int rows) {
		int fd = rows;
		int fa = RowsEmptyUtil.getRowsEmpty(fd);
		int totales = fd + fa;
		System.out.println("Filas datos: " + fd + " Filas agregadas: " + fa  + " Totales: " + totales);
		
	}

}
