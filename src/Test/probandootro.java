package Test;

import java.io.File;

import Entidad.Titular;
import Interfaz.EmitirLicencia;
import Utils.Impresion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class probandootro {

	public static void main(String[] args) throws Exception
    {

//		Titular tit = new Titular();
//		tit.setDNI(36001182);
//		Impresion imp = new Impresion();
////		imp.setting(tit, null);
//        JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src/Utils/report1.jasper");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, imp);  
//
//        JRPdfExporter exporter = new JRPdfExporter();  
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
//        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte2PDF.pdf")); 
//        exporter.exportReport();
////        new Imprimir(new JRViewer(jasperPrint), null);
//        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"reporte2PDF.pdf");
		String f = new File("").getCanonicalPath();
		
		f = f.replace("\\", "\\"+"\\");
		f+= "\\"+"\\"+"src"+"\\"+"\\"+"utils"+"\\"+"\\"+"generarComprobante.jpg";
		System.out.println(f);
		
		
		String myDocumentPath = System.getProperty("user.home") + "\\Documents";
        myDocumentPath = myDocumentPath.replace("\\", "\\"+"\\");
        System.out.println(myDocumentPath);
        
    }

}
