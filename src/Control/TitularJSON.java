package Control;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entidad.Titular;
import Utils.HTTPConection;
import Utils.Implements.ControlImplementation;

public class TitularJSON implements ControlImplementation<Titular>{

	@Override
	public void crear(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"POST",entrada.toJSON()});
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
