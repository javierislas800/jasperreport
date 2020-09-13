package com.xmltocfdi_3_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.xmltocfdi_3_3.beans.Colectividad;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReporteColectividadesCaratula {

	public void createPDF(int numeroFilas) throws Exception {
		InputStream input = new FileInputStream(new File("/Users/javier/Proyectos/Workana/XmlToCFDI Jasper/MyReports/repColectividadesCaratula.jrxml"));
		//String jasperSubPath = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/Blank_A4.jasper";
				
		//Se agregan los parámetros para llenar el PDF.
		Map<String, Object> params = new HashMap<String, Object>();
				
		// Datos Carátula de Póliza
		params.put("NOMBRE",    "Nombre del negocio.");
		params.put("DSEMPRESA", "Nombre de la empresa.");
		params.put("DSNEGOCI", "Nombre del contratante");

		List<Colectividad> listItems = new ArrayList<Colectividad>();
		
		
		// Se agregan filas de datos.
		for (int i = 0; i < numeroFilas; i++) {
			Colectividad col1 = new Colectividad();
			col1.setAnalogos("A" + i);
			col1.setColectividad("C" + i);
			col1.setDerechoPoliza("D" + i);
			col1.setFilial("F" + i);
			col1.setPrimaNeta("PN" + i);
			col1.setRecargoFraccionado("RF" + i);
		
			listItems.add(col1);
		}

		// Se agregan filas vacias.
		int rowsToAdd = RowsEmptyUtil.getRowsEmpty(listItems.size());
		for (int i = 0; i < rowsToAdd; i++) {
			listItems.add(Colectividad.getEmptyBean());
		}
		
		
		JRBeanCollectionDataSource colectividadesJRBean = new JRBeanCollectionDataSource(listItems);
		params.put("CollectionColectividadBeanParam", colectividadesJRBean);		
		
		JasperDesign jasperDesign = JRXmlLoader.load(input);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
				
		//JasperViewer.viewReport(jasperPrint);

				
		byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
				
		String pdfPathname = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/Reporte_Colectividad" + numeroFilas + ".pdf";
		FileUtils.writeByteArrayToFile(new File(pdfPathname), pdfBytes);
	}
	
}
