package Entidad;

import org.json.JSONException;
import org.json.JSONObject;

import Utils.Implements.EntityImplementation;

public class Titular implements EntityImplementation {

	public static final Object NOMBRE_TABLA = "titulares";
	private Integer id_titular;
	private String tipo_doc;
	private Integer doc;
	private String apellidos;
	private String nombres;
	private String fecha_nac;
	private String direccion;
	private String clases; // "A,B" o "A,F" o "A"
	private String grupo_sanguineo; // "AB+" "AB-"
	private boolean donante; // "true" "false"
	
	public Titular() {
		
	}

	public Titular(JSONObject jsonObject) {
		toEntity(jsonObject);
	}

	public Integer getId_titular() {
		return id_titular;
	}

	public void setId_titular(Integer id_titular) {
		this.id_titular = id_titular;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public Integer getDoc() {
		return doc;
	}

	public void setDoc(Integer doc) {
		this.doc = doc;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getClases() {
		return clases;
	}

	public void setClases(String clases) {
		this.clases = clases;
	}

	public String getGrupoSanguineo() {
		return grupo_sanguineo;
	}

	public void setGrupoSanguineo(String grupo_sanguineo) {
		this.grupo_sanguineo = grupo_sanguineo;
	}

	public boolean isDonante() {
		return donante;
	}

	public void setDonante(boolean donante) {
		this.donante = donante;
	}

	@Override
	public void toEntity(JSONObject object) {
		try {
			id_titular = object.getInt(TableDatabase.TITULAR.ID_TITULAR);
			tipo_doc = object.getString(TableDatabase.TITULAR.TIPO_DOC);
			doc = object.getInt(TableDatabase.TITULAR.DOCUMENTO);
			apellidos = object.getString(TableDatabase.TITULAR.APELLIDOS);
			nombres = object.getString(TableDatabase.TITULAR.NOMBRES);
			fecha_nac = object.getString(TableDatabase.TITULAR.FECHA_NAC);
			direccion = object.getString(TableDatabase.TITULAR.DIRECCION);
			clases = object.getString(TableDatabase.TITULAR.CLASES);
			grupo_sanguineo = object.getString(TableDatabase.TITULAR.GRUPO_SANGUINEO); // "AB+" "AB-"
			donante = object.getString(TableDatabase.TITULAR.DONANTE).equals("Si")? true:false; // "true" "false"
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		
		try {
			jsonObject.put(TableDatabase.TITULAR.ID_TITULAR,id_titular);
			jsonObject.put(TableDatabase.TITULAR.TIPO_DOC,tipo_doc);
			jsonObject.put(TableDatabase.TITULAR.DOCUMENTO,doc);
//			jsonObject.put(TableDatabase.TITULAR, );
			
			
//			jsonObject.put("nombre",nombre);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println("JSON: "+jsonObject.toString());
		
		return jsonObject;
	}

}
