package com.xmltocfdi_3_3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Test {

	static public void main(String args[]) throws Exception {
		System.out.println("Inicia...");
		createPDF();
		System.out.println("Termina de crear el archivo.");
	}
	
	static public void createPDF() throws Exception {
		//JasperReport jasperReport = JasperCompileManager.compileReport("/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/cfdi_v3_3.jrxml");
		
		//System.out.println("Despues de compilar el jrxml.");
		
		String jasperPath = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/cfdi_v3_3.jasper";
		
		//Prefiero usar el .jrxml a la aplicacion que el .jasper por que es mas facil de versionar
		String sourceFileName = jasperPath;   
		
		
		//File theFile = new File(sourceFileName);
		//JasperDesign jasperDesign = JRXmlLoader.load(theFile);//Se carga el archivo

		//Si el reporte va a tener un query fijo, puedes omitir este paso
		//JRDesignQuery newQuery = new JRDesignQuery();
		//newQuery.setText("SELECT * FROM miTabla WHERE X = Y");
		//jasperDesign.setQuery(newQuery);

		//Map parameters = new HashMap();//Parametros que usa el jasperreports
		//Este parametro sirve para meter una funcion que el reporte va a ejecutar para encontrar la ruta fisica de sus imagenes
		/*parameters.put("REPORT_FILE_RESOLVER", new FileResolver() {
		                public File resolveFile(String fileName) {
		                    return new File(getServletContext().getRealPath("") + "\\mis_imagenes\\"+fileName); 
		                }
		            });*/
		//Se compila el archivo a .jasper
		//JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

		//Se agregan los parámetros para llenar el PDF.
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("emisor", "TEQUILA CARRERA SA DE CV");
		params.put("rfcEmisor", "WAS070721UM3");
		
		// Se crea el pdf
		JasperPrint jasperPrint = new JasperPrint();
		jasperPrint = JasperFillManager.fillReport(sourceFileName, params, new JREmptyDataSource());
	
		
		
		
		
		
		byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
		
		String pdfPathname = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/test1.pdf";
		FileUtils.writeByteArrayToFile(new File(pdfPathname), pdfBytes);
		//createFile(pdfBytes, pdfPathname);
		
		
	}

}