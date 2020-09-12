package com.xmltocfdi_3_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReporteColectividadesCaratula {

	public void createPDF() throws Exception {
		InputStream input = new FileInputStream(new File("/Users/javier/Proyectos/Workana/XmlToCFDI Jasper/MyReports/repColectividadesCaratula.jrxml"));
		//String jasperSubPath = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/Blank_A4.jasper";
				
		//Se agregan los parámetros para llenar el PDF.
		Map<String, Object> params = new HashMap<String, Object>();
				
		// Datos Carátula de Póliza
		params.put("NOMBRE",    "Nombre del negocio.");
		params.put("DSEMPRESA", "Nombre de la empresa.");


		//List<String> listItems = new ArrayList<String>();
		//JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
				
		JasperDesign jasperDesign = JRXmlLoader.load(input);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
				
		//JasperViewer.viewReport(jasperPrint);

				
		byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
				
		String pdfPathname = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/I 11 PACIFIC EDGE_generated.pdf";
		FileUtils.writeByteArrayToFile(new File(pdfPathname), pdfBytes);
	}
	
}
