package Control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entidad.Licencia;
import Entidad.Titular;
import Utils.HTTPConection;
import Utils.Implements.ControlImplementation;

public class LicenciaJSON implements ControlImplementation<Licencia>{

	
	
	public LicenciaJSON() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Licencia crear(Licencia entrada) {
		new HTTPConection().gestion(new Object[] {Licencia.NOMBRE_TABLA,"POST",entrada.toJSON()});
		return null;
	}
	
	public Licencia crear(Integer id_titular, String clases, Integer usuario, String fecha_nacimiento, Integer cantidadaño, String observaciones) {
		Licencia nuevo = new Licencia();
		nuevo.setId_titular(id_titular);
		nuevo.setClases(clases);
		nuevo.setUsuario(usuario);
		
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    String dd = Integer.toString(c.get(Calendar.DATE));
	    String mm = Integer.toString(c.get(Calendar.MONTH)+1);
	    String aaaa = Integer.toString(c.get(Calendar.YEAR));
	    
	    nuevo.setFecha_emision(dd+"/"+mm+"/"+aaaa);
	    
	    String[] ss = fecha_nacimiento.split("/");
	    nuevo.setInicio_vigencia(ss[0]+"/"+ss[1]+"/"+aaaa);
	    Integer año = Integer.parseInt(aaaa)+cantidadaño;
	    nuevo.setFin_vigencia(ss[0]+"/"+ss[1]+"/"+año);
	    nuevo.setObservaciones(observaciones);
	    
		crear(nuevo);
		ArrayList<Licencia> t = listarEnLista();
		return t.get(t.size()-1);
		
	}

	@Override
	public void modificar(Licencia entrada) {
//		new HTTPConection().gestion(new Object[] {Licencia.NOMBRE_TABLA,"PUT",entrada.toJSON(),entrada.getId_titular()});
	}

	@Override
	public void borrar(Licencia entrada) {
//		new HTTPConection().gestion(new Object[] {Licencia.NOMBRE_TABLA,"DELETE",entrada.getId_titular()});		
	}
	@Override
	public Licencia buscarPorId(Integer id) {
		ArrayList<Licencia> Entry = listarEnLista();
//        for(Titular i: Entry)
//            if(i.getId_titular()==id)
//                return i;
        return null;
	}

	@Override
	public ArrayList<Licencia> listarEnLista() {
        ArrayList<Licencia> salida = null;
        
		try {
			JSONArray lista = (JSONArray) new HTTPConection().gestion(new Object[] {Licencia.NOMBRE_TABLA,"GET"});
	        salida = new ArrayList<Licencia>();
			for(int i=0;i<lista.length();i++)
				salida.add(new Licencia((JSONObject) lista.get(i)));
		} catch (JSONException e) {
			e.printStackTrace();
		}

        return salida;
	}
	
	public ArrayList<Licencia> buscarLicenciasExpiradas() 
	{
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    Integer anioActual = c.get(Calendar.YEAR);
	    Integer mesActual = c.get(Calendar.MONTH)+1;
	    Integer diaActual = c.get(Calendar.DAY_OF_MONTH);
	    
	    ArrayList<Licencia> licenciasExpiradas =  new  ArrayList<Licencia>();
		ArrayList<Licencia> Entry = listarEnLista();
        
		
		for(Licencia l: Entry)
        {
        	Integer aVigencia = Integer.parseInt(l.getFin_vigencia().split("/")[2]);
    	    Integer mVigencia = Integer.parseInt(l.getFin_vigencia().split("/")[1]);
    	    Integer dVigencia = Integer.parseInt(l.getFin_vigencia().split("/")[0]);
    	    aVigencia-=anioActual;
    	    mVigencia-=mesActual;
    	    dVigencia-=diaActual;
    	    if(aVigencia<0)
    	    {
    	    	licenciasExpiradas.add(l);
    	    }
    	    else if(aVigencia==0)
    	    {
    	    	if(mVigencia<0)
    	    	{
    	    		licenciasExpiradas.add(l);
    	    	}
    	    	else if(mVigencia==0)
    	    	{
    	    		if(dVigencia<0)
    	    		{
    	    			licenciasExpiradas.add(l);
    	    		}
    	    	}
    	    }
    	 
        }
        return licenciasExpiradas;
	}
	
	
	public Boolean titularConAntiguedad(Titular t, String clase)
	{
		ArrayList <Licencia> licencias= listarEnLista();
		
		for(Licencia l: licencias)
		{
			if(l.getId_titular()==t.getId_titular())
			{
				if(l.getClases().contains(clase))
				{
					Integer añoEmision = Integer.parseInt(l.getFecha_emision().split("/")[2]);
					Integer mesEmision = Integer.parseInt(l.getFecha_emision().split("/")[1]);
				    Integer diaEmision = Integer.parseInt(l.getFecha_emision().split("/")[0]);
					Date d = new Date();
					Calendar c = Calendar.getInstance();
					c.setTime(d);
				    Integer añoActual = c.get(Calendar.YEAR);
				    Integer mesActual = c.get(Calendar.MONTH)+1;
				    Integer diaActual = c.get(Calendar.DAY_OF_MONTH);
				    
				    if(añoActual<añoEmision)
				    	return false;
				    else if(añoActual==añoEmision && mesActual<mesEmision)
				    	return false;
				    else if(añoActual==añoEmision && mesActual==mesEmision && diaActual<diaEmision)
				    	return false;
				    else
				    	return true;
				    	
				}
			}
		}
			
		return false;
		
	}
	
	public ArrayList<Titular> buscarTitularesConLicenciasExpiradas(ArrayList<Licencia> licenciasExpiradas) {
        
		ArrayList<Titular> titularesConLicenciaExpirada = new ArrayList<Titular>();
        
		TitularJSON tj = new TitularJSON();
		for(Licencia l: licenciasExpiradas)
		{
			Titular tE = tj.buscarPorId(l.getId_titular());
			titularesConLicenciaExpirada.add(tE);
		}

        return titularesConLicenciaExpirada;
	}
}
