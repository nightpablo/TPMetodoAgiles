package Utils;

import Entidad.Licencia;
import Entidad.Titular;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Impresion implements JRDataSource {

	private Titular tit;
	private Licencia lic;
	private Integer costocalculado;
	private Integer accion = -1;
	
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		 Object valor = null;

        if ("dni".equals(arg0.getName())) //cambiar por el nombre del campo de dni del jasper
        {
            valor = tit.getDNI();
        }
	
        if ("apellido".equals(arg0.getName())) 
        {
            valor = tit.getApellidos();
        }
        
        if ("nombre".equals(arg0.getName())) 
        {
            valor = tit.getNombres();
        }
		
        if ("local".equals(arg0.getName())) 
        {
            valor = tit.getLocalidad();
        }
        
        if ("domicilio".equals(arg0.getName())) 
        {
            valor = tit.getDireccion();
        }
        
        if ("Vencimien".equals(arg0.getName())) 
        {
            valor = lic.getFin_vigencia();
        }
        
        if ("observaciones".equals(arg0.getName())) 
        {
            valor = lic.getObservaciones();
        }
        
        if ("clase".equals(arg0.getName())) 
        {
            valor = tit.getClases();
        }
        
        if ("fNacimiento".equals(arg0.getName())) 
        {
            valor = tit.getFecha_nac();
        }
        
        if ("local".equals(arg0.getName())) 
        {
            valor =  tit.getLocalidad();
        }
        
        if ("donante".equals(arg0.getName())) 
        {
            valor = tit.isDonante()? "SI":"NO";
        }
        
        if ("grupo".equals(arg0.getName())) 
        {
            valor = tit.getGrupo();
        }
        
        if ("factor".equals(arg0.getName())) 
        {
            valor = tit.getFactor();
        }
        
        if ("otorgamiento".equals(arg0.getName())) 
        {
            valor = lic.getFecha_emision();
        }
        
        if ("observaciones".equals(arg0.getName())) 
        {
            valor = lic.getObservaciones();
        }
        
        if ("nombreyapellido".equals(arg0.getName())) 
        {
            valor = tit.getApellidos() + ", "+ tit.getNombres() ;
        }
        
        if ("costo".equals(arg0.getName())) 
        {
            valor = costocalculado;
        }
        
        
        
      
        
			return valor;
	}
	
	public void setting(Titular este, Licencia otro,Integer costo) {
		this.tit = este;
		this.lic = otro;
		this.costocalculado=costo;
	}

	@Override
	public boolean next() throws JRException {
		return ++accion<1;
	}

}