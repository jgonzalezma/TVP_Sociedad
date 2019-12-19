package reportes;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class DemoReporte {

	public static void main(String[] args) throws JRException {
		// descarga dentro del mismo proyecto
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"C:\\Users\\josu\\git\\TVP_Sociedad\\informe\\Reporte.jasper", null,
				Conexion.conectar());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();
		}
}
