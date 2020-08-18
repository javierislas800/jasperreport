package com.xmltocfdi_3_3;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.zxing.qrcode.QRCodeWriter;
import com.xmltocfdi_3_3.beans.Mercancia;
import com.xmltocfdi_3_3.beans.Producto;
import com.xmltocfdi_3_3.qr.QRUtil;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

public class Test {

	static public void main(String args[]) throws Exception {
		System.out.println("Inicia...");
		createPDF();
		
		
		//createQR();
		System.out.println("Termina de crear el archivo.");
	}
	
	static public void createQR() throws Exception {
		String qr = "https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx?&id=EC1E4A98-AB90-43B3-875E-FD168ED2D1C7&re=WAS070721UM3&rr=XEXX010101000&tt=000000000000096985.000000&fe=bly6Aw==";
		String filePath = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/qr_java.png";
		QRUtil.generateQRCodeImage(qr, filePath);
	}
	
	static public void createPDF() throws Exception {
		//JasperReport jasperReport = JasperCompileManager.compileReport("/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/cfdi_v3_3.jrxml");
		
		//System.out.println("Despues de compilar el jrxml.");
		
		String jasperPath = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/cfdi_v3_3.jasper";
		//String jasperSubPath = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/Blank_A4.jasper";
		
		String imagesPath = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/";
		
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
		
		// IMAGES DIR
		params.put("imagesDir", imagesPath);
		
		// DATOS EMISOR
		params.put("emisor", "TEQUILA CARRERA SA DE CV");
		params.put("rfcEmisor", "WAS070721UM3");
		params.put("regimenFiscal", "601 - General de Ley Personas Morales");
		
		// DATOS RECEPTOR
		params.put("receptor", "Pacific Edge Wine & Spirits");
		params.put("rfcReceptor", "XEXX010101000");
		params.put("uso", "G01 - Adquisición de mercancias");
		params.put("residencia", "USA");
		params.put("identidad", "470873333");
		
		// DATOS FACTURA
		params.put("factura", "EC1E4A98-AB90-43B3-875E-FD168ED2D1C7");
		params.put("fechaEmision", "2019-07-12T10:44:43");
		params.put("lugarExpedicion", "45116");
		params.put("tipoComprobante", "I - Ingreso");
		params.put("serie", "I");
		params.put("folio", "11");
		params.put("moneda", "USD -");
		params.put("tipoCambio", Float.parseFloat("19.1227"));
		params.put("formaPago", "99 - Por definir");
		params.put("metodoPago", "PPD - Pago en parcialidades o");
		params.put("condicionesPago", "50% In Adv 50% Reception");
		
		// Lista de productos
		Producto p1 = new Producto("1819588013100J", 
				  				   "50202200 - Bebidas alcohólicas Tequila Tesoro Number 5\n" + 
				  				   "Blanco 100% Agave 12/750 ML 40% Alc. Vol. (80 Proof)", 
				  				   "XBX - Caja",
				  				   "$81.50",
				  				   "",
				  				   "630.00", 
				  				   "$51,345.00");
		
		Producto p2 = new Producto("1819588013117", 
				  				   "50202200 - Bebidas alcohólicas Tequila Tesoro Number 5\n" + 
				  				   "Reposado 100% Agave 12/750 ML 40% Alc. Vol. (80 Proof)", 
				  				   "XBX - Caja",
				  				   "$81.50",
				  				   "",
				  				   "560.00", 
				  				   "$45,640.00");
		
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(p1);
		productos.add(p2);
		
		//for (int i = 0; i< 25; i++)
		//	productos.add(p1);
		
		JRDataSource productosDataSource = new JRBeanCollectionDataSource(productos);
		
		// Lista de mercancias
		Mercancia m1 = new Mercancia();
		m1.setNoIdentificacion("1819588013100");
		m1.setCantidadAduana("5670");
		m1.setValorUnitario("9.06");
		
		// Lista de mercancias
		Mercancia m2 = new Mercancia();
		m2.setNoIdentificacion("1819588013117");
		m2.setCantidadAduana("5040");
		m2.setValorUnitario("9.07");
				
		List<Mercancia> mercancias = new ArrayList<Mercancia>();
		mercancias.add(m1);
		mercancias.add(m2);
		
		JRDataSource mercanciasDataSource = new JRBeanCollectionDataSource(mercancias);
		
		//Totales
		params.put("importeLetra", "Noventa y seis mil novecientos ochenta y cinco 00/100 USD");
		params.put("observaciones", "Standard Export Packing (USA) Tesoro Number 5 Materials (Bottle, Label, Cap, & Case)");
		
		params.put("subtotal", "$96,985.00");
		params.put("total",    "$96,985.00");
		params.put("totalArtsFacturados", "2");
		
		// Sellos
		params.put("selloDigital", "ALmszy4C/MT/iIjE90FWvysKJH2wDd9fmiYpsXi4X96cn1vGkgsZwWt1TZ688UdAtj/DUSI6EsEBYnvJsRyqCfGR98l0i90eZeCpww1lHn27ZrBHQd2a20z3U6jrJknLGj3FHG6l4SPTeYD56EdGDxBm1jQn7YeNSoOi62\n" + 
				"XbIXeOuay/pbP7f2hW4fdrhPCdSVrjeRtdZCp3nrnYVkr2W8yFjKMAH7mZsYpZYrMEsmiJKDSoN5nPkR7QYxMQ+eh6QC5XTGE205ZwLUF+uAfuMJDmywhoiqaq988p9z8rtCb1ukyFGegEs2G3TFHspy9K+QPQ+9i\n" + 
				"vo5QEz3QJbly6Aw==");
		params.put("selloSAT", "PEerMD/N7C8ue79PIgd3oT4HhguTRNEL8AmrUy/tyBnFZRpQtoKtveDClfeEcP1G90URd/HzCA///Vi+CjIjHvYxPccx0dPX4s0GwcSLtAngYLsK5zVdJIXRYS9CcYGny0QT/pOHilUq/W+Xh8awzOXiPI0739/VyzA/wVh\n" + 
				"V5Z1VNIK+5yrt8qq25eIbo4SXgc1kf8gImiJFXnQ5yPg4Vffmg2iN7H6MO7xpxgaNLHYKyFzMIwzd62+NxdgrvL1iwP+mmjc98dNmwMN/knU4o4eNCpnVqyDPtFOeKTPlwdTpN9f3Mb/");
		
		
		
		// QR
		String qr = "https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx?&id=EC1E4A98-AB90-43B3-875E-FD168ED2D1C7&re=WAS070721UM3&rr=XEXX010101000&tt=000000000000096985.000000&fe=bly6Aw==";
		params.put("qr", qr);
		
		// Datos QR
		params.put("cadenaComplemento", "||1.1|EC1E4A98-AB90-43B3-875E-FD168ED2D1C7|2019-07-\n" + 
				"12T10:44:44|LEV031201SE6|ALmszy4C/MT/iIjE90FWvysKJH2wDd9fmiYpsXi4X96cn1vGkgsZwWt1TZ688UdAtj/DUSI6EsEBYnvJs\n" + 
				"RyqCfGR98l0i90eZeCpww1lHn27ZrBHQd2a20z3U6jrJknLGj3FHG6l4SPTeYD56EdGDxBm1jQn7YeNSoOi62XbIXeOuay/pbP7f2hW\n" + 
				"4fdrhPCdSVrjeRtdZCp3nrnYVkr2W8yFjKMAH7mZsYpZYrMEsmiJKDSoN5nPkR7QYxMQ+eh6QC5XTGE205ZwLUF+uAfuMJDmyw\n" + 
				"hoiqaq988p9z8rtCb1ukyFGegEs2G3TFHspy9K+QPQ+9ivo5QEz3QJbly6Aw==|00001000000405179533||");
		params.put("numeroSerieSAT", "00001000000405179533");
		params.put("fechaHoraCertificado", "2019-07-12T10:44:44");
		params.put("numeroSerieEmisor", "00001000000406781419");
		
		
		
		
		
		
		
		params.put("SUB_REPORT", "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/cfdi_v3_3_sub.jasper");
		params.put("DATA_SOURCE", mercancias);
		
		
		
		// Se crea el pdf
		JasperPrint jasperPrint = new JasperPrint();
		jasperPrint = JasperFillManager.fillReport(jasperPath, params, productosDataSource);
		
		
		
		
		// Se crea el pdf con 2 layouts.
		/*JasperReport mainreport = JasperCompileManager.compileReport(jasperPath);
		//JasperReport subreport = JasperCompileManager.compileReport(jasperSubPath);
		Map<String, Object> paramsReport = new HashMap<String, Object>();
		//paramsReport.put("SUB_REPORT", subreport);
		//paramsReport.put("DATA_SOURCE", mercancias);

		JasperPrint jasperPrint = JasperFillManager.fillReport(mainreport,params,new JRBeanCollectionDataSource(productos));
		*/
		
		
		
		
		//JRPdfExporter exporter = new JRPdfExporter();     
		  //Add the list as a Parameter
		//  exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
		  
		  
		//throw the JasperPrint Objects in a list
		  /*List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		  jasperPrintList.add(jasperPrint);
		  jasperPrintList.add(jasperPrint);*/


		  /*
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();     
		  JRPdfExporter exporter = new JRPdfExporter();     
		  //Add the list as a Parameter
		  exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
		  //this will make a bookmark in the exported PDF for each of the reports
		  //exporter.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
		  exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);       
		  exporter.exportReport();      
		  byte[] pdfBytes = baos.toByteArray();
		*/
		
		
		
		byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
		
		String pdfPathname = "/Users/javier/Proyectos/Workana/XmlToCFDI/xmltocfdi/src/main/resources/test1.pdf";
		FileUtils.writeByteArrayToFile(new File(pdfPathname), pdfBytes);
		//createFile(pdfBytes, pdfPathname);
		
		
	}

}
