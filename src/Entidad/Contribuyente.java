package Entidad;

import org.json.JSONException;
import org.json.JSONObject;

import Utils.Implements.EntityImplementation;

public class Contribuyente implements EntityImplementation {

	public static final Object NOMBRE_TABLA = "contribuyentes";
	private Integer id_contribuyente;
	private Integer dni;
	
	public Contribuyente(JSONObject object) {
		toEntity(object);
	}
	
	public Contribuyente(Integer dni) {
		this.dni = dni;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getId_contribuyente() {
		return id_contribuyente;
	}

	public void setId_contribuyente(Integer id_contribuyente) {
		this.id_contribuyente = id_contribuyente;
	}

	@Override
	public void toEntity(JSONObject object) {
		try {
			id_contribuyente = object.getInt(TableDatabase.CONTRIBUYENTE.ID_CONSTRIBUYENTE);
			dni = object.getInt(TableDatabase.CONTRIBUYENTE.DNI);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put(TableDatabase.CONTRIBUYENTE.ID_CONSTRIBUYENTE, id_contribuyente);
			jsonObject.put(TableDatabase.CONTRIBUYENTE.DNI, dni);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}

}
