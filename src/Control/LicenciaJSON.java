package Control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;

import Entidad.Licencia;
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
	
	public void crear(Integer id_titular, String clases, Integer usuario, String fecha_nacimiento, Integer cantidadaño, String observaciones) {
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
        
//		try {
			JSONArray lista = (JSONArray) new HTTPConection().gestion(new Object[] {Licencia.NOMBRE_TABLA,"GET"});
	        salida = new ArrayList<Licencia>();
//			for(int i=0;i<lista.length();i++)
//				salida.add(new Licencia((JSONObject) lista.get(i)));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}

        return salida;
	}
}
