package Utils;

import Entidad.Licencia;
import Entidad.Titular;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Impresion implements JRDataSource {

	private Titular tit;
	private Licencia lic;
	private Integer accion = -1;
	
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		 Object valor = null;

        if ("field_DNI".equals(arg0.getName())) //cambiar por el nombre del campo de dni del jasper
        {
            valor = tit.getDNI();
        }
		return valor;
	}
	
	public void setting(Titular este, Licencia otro) {
		this.tit = este;
		this.lic = otro;
	}

	@Override
	public boolean next() throws JRException {
		return ++accion<1;
	}

}
