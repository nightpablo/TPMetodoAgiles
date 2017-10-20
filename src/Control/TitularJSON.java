package Control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entidad.TableDatabase;
import Entidad.Titular;
import Utils.HTTPConection;
import Utils.Implements.ControlImplementation;

public class TitularJSON implements ControlImplementation<Titular>{

	@Override
	public void crear(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"POST",entrada.toJSON()});
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


}
