package Entidad;

import org.json.JSONException;
import org.json.JSONObject;

import Utils.Implements.EntityImplementation;

public class Licencia implements EntityImplementation{

	public static final Object NOMBRE_TABLA = "licencias";
	private Integer id_licencia;
	private Integer id_titular;
	//SACAR FECHA DE EMISION
	private String fecha_emision;
	private String inicio_vigencia;
	private String fin_vigencia;
	private Integer usuario;
	private String observaciones;
	private String clases;
	
	public Licencia() {

	}

	public Integer getId_licencia() {
		return id_licencia;
	}

	public void setId_licencia(Integer id_licencia) {
		this.id_licencia = id_licencia;
	}

	public Integer getId_titular() {
		return id_titular;
	}

	public void setId_titular(Integer id_titular) {
		this.id_titular = id_titular;
	}

	public String getInicio_vigencia() {
		return inicio_vigencia;
	}

	public void setInicio_vigencia(String inicio_vigencia) {
		this.inicio_vigencia = inicio_vigencia;
	}

	public String getFin_vigencia() {
		return fin_vigencia;
	}

	public void setFin_vigencia(String fin_vigencia) {
		this.fin_vigencia = fin_vigencia;
	}

	public String getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getClases() {
		return clases;
	}

	public void setClases(String clases) {
		this.clases = clases;
	}
	
	@Override
	public void toEntity(JSONObject object) {
		try {
			id_licencia = object.getInt(TableDatabase.LICENCIA.ID_LICENCIA);
			id_titular = object.getInt(TableDatabase.LICENCIA.ID_TITULAR);
			inicio_vigencia = object.getString(TableDatabase.LICENCIA.INICIO_VIGENCIA);
			fecha_emision = object.getString(TableDatabase.LICENCIA.FECHA_EMISION);
			fin_vigencia = object.getString(TableDatabase.LICENCIA.FIN_VIGENCIA);
			usuario = object.getInt(TableDatabase.LICENCIA.USUARIO);
			observaciones = object.getString(TableDatabase.LICENCIA.OBSERVACIONES);
			clases = object.getString(TableDatabase.LICENCIA.CLASES);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put(TableDatabase.LICENCIA.ID_LICENCIA, id_licencia);
			jsonObject.put(TableDatabase.LICENCIA.ID_TITULAR, id_titular);
			jsonObject.put(TableDatabase.LICENCIA.INICIO_VIGENCIA, inicio_vigencia);
			jsonObject.put(TableDatabase.LICENCIA.FECHA_EMISION, fecha_emision);
			jsonObject.put(TableDatabase.LICENCIA.FIN_VIGENCIA, fin_vigencia);
			jsonObject.put(TableDatabase.LICENCIA.USUARIO, usuario);
			jsonObject.put(TableDatabase.LICENCIA.OBSERVACIONES, observaciones);
			jsonObject.put(TableDatabase.LICENCIA.CLASES, clases);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return jsonObject;
	}

}
