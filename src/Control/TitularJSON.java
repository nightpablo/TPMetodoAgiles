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

public class TitularJSON implements ControlImplementation<Titular>{

	@Override
	public Titular crear(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"POST",entrada.toJSON()});
		ArrayList<Titular> t = listarEnLista();
		return t.get(t.size()-1);
	}
	
	public Titular crear(String tipo_dni, String dni, String nombres, String apellidos, 
			String direccion, String localidad, String dia, String mes, String año, 
			String grupo, String factor, String donante) {
		Titular nuevo = new Titular();
		nuevo.setTipo_DNI(tipo_dni);
		nuevo.setDNI(Integer.parseInt(dni));
		nuevo.setNombres(nombres);
		nuevo.setApellidos(apellidos);
		nuevo.setDireccion(direccion);
		nuevo.setLocalidad(localidad);
		nuevo.setFecha_nac(dia+"/"+mes+"/"+año);
		nuevo.setGrupo(grupo);
		nuevo.setFactor(factor);
		nuevo.setDonante(donante.equals("Si")?true:false);
		nuevo.setClases("B,F");
		
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    String dd = Integer.toString(c.get(Calendar.DATE));
	    String mm = Integer.toString(c.get(Calendar.MONTH)+1);
	    String aaaa = Integer.toString(c.get(Calendar.YEAR));
	    
	    nuevo.setFecha_alta_titular(dd+"/"+mm+"/"+aaaa);

	    return nuevo;
	}

	@Override
	public void modificar(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"PUT",entrada.toJSON(),entrada.getId_titular()});		
	}

	@Override
	public void borrar(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"DELETE",entrada.getId_titular()});		
	}

	@Override
	public Titular buscarPorId(Integer id) {
		ArrayList<Titular> Entry = listarEnLista();
        for(Titular i: Entry)
            if(i.getId_titular()==id)
                return i;
        return null;
	}
	
	public Titular buscarPorDni(Integer dni) {
		ArrayList<Titular> Entry = listarEnLista();
        for(Titular i: Entry)
            if(i.getDNI()==dni)
                return i;
        return null;
	}
	
	public boolean existeTitular(Titular tit) {
		ArrayList<Titular> Entry = listarEnLista();
        for(Titular i: Entry)
            if(i.equals(tit))
                return true;
        return false;
	}
	
	public boolean existeTitular(Integer DNI) {
		ArrayList<Titular> Entry = listarEnLista();
        for(Titular i: Entry)
            if(i.getDNI().equals(DNI))
                return true;
        return false;
	}

	@Override
	public ArrayList<Titular> listarEnLista() {
        ArrayList<Titular> salida = null;
        
		try {
			JSONArray lista = (JSONArray) new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"GET"});
	        salida = new ArrayList<Titular>();
			for(int i=0;i<lista.length();i++)
				salida.add(new Titular((JSONObject) lista.get(i)));
		} catch (JSONException e) {
			e.printStackTrace();
		}

        return salida;
	}

	public ArrayList<Titular> buscarTitularesConLicenciasExpiradas(ArrayList<Licencia> licenciasExpiradas) {
        
		ArrayList<Titular> titularesConLicenciaExpirada = new ArrayList<Titular>();
        
		
		for(Licencia l: licenciasExpiradas)
		{
			Titular tE = this.buscarPorId(l.getId_titular());
			titularesConLicenciaExpirada.add(tE);
		}

        return titularesConLicenciaExpirada;
	}
	
	public Integer calcularVigencia(Titular t) {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    String aaaa = Integer.toString(c.get(Calendar.YEAR));
	    
	    
	    //      				año actual          -                 año de nacimiento
	    Integer diferencia = Integer.parseInt(aaaa) - Integer.parseInt(t.getFecha_nac().split("/")[2]); 
		if(diferencia<21) return 1;			//1 año la primera vez y 3 años las siguientes
		else if(diferencia<=46) return 5;	//5 años
		else if(diferencia<=60) return 4;	//4 años
		else if(diferencia<=70) return 2;	//2 años
		return 1;	//1 años
	}

}
