package Control;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entidad.Contribuyente;
import Utils.HTTPConection;
import Utils.Implements.ControlImplementation;

public class ContribuyenteJSON implements ControlImplementation<Contribuyente>{

	public ContribuyenteJSON() {}

	@Override
	public Contribuyente crear(Contribuyente entrada) {
		new HTTPConection().gestion(new Object[] {Contribuyente.NOMBRE_TABLA,"POST",entrada.toJSON()});
		return null;
	}

	@Override
	public void modificar(Contribuyente entrada) {
		new HTTPConection().gestion(new Object[] {Contribuyente.NOMBRE_TABLA,"PUT",entrada.toJSON(),entrada.getId_contribuyente()});
	}

	@Override
	public void borrar(Contribuyente entrada) {
		new HTTPConection().gestion(new Object[] {Contribuyente.NOMBRE_TABLA,"DELETE",entrada.getId_contribuyente()});		
	}

	@Override
	public Contribuyente buscarPorId(Integer id) {
		ArrayList<Contribuyente> Entry = listarEnLista();
        for(Contribuyente i: Entry)
            if(i.getId_contribuyente()==id)
                return i;
        return null;
	}

	@Override
	public ArrayList<Contribuyente> listarEnLista() {
		ArrayList<Contribuyente> salida = null;
        
		try {
			JSONArray lista = (JSONArray) new HTTPConection().gestion(new Object[] {Contribuyente.NOMBRE_TABLA,"GET"});
	        salida = new ArrayList<Contribuyente>();
			for(int i=0;i<lista.length();i++)
				salida.add(new Contribuyente((JSONObject) lista.get(i)));
		} catch (JSONException e) {
			e.printStackTrace();
		}

        return salida;
	}

}
