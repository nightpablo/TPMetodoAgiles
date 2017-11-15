package Entidad;

import org.json.JSONException;
import org.json.JSONObject;

import Utils.Implements.EntityImplementation;

public class Titular implements EntityImplementation {

	public static final Object NOMBRE_TABLA = "titulares";
	private Integer id_titular;
	private String tipo_dni;
	private Integer dni;
	private String apellidos;
	private String nombres;
	private String fecha_nac;
	private String direccion;
	private String localidad;
	private String clases; // "A,B" o "A,F" o "A"
	private String grupo; // "AB" "A" "B" "O"
	private String factor;
	private boolean donante; // "true" "false"
	private String fecha_alta_titular;

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

	public String getTipo_DNI() {
		return tipo_dni;
	}

	public void setTipo_DNI(String tipo_dni) {
		this.tipo_dni = tipo_dni;
	}

	public Integer getDNI() {
		return dni;
	}

	public void setDNI(Integer dni) {
		this.dni = dni;
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getClases() {
		return clases;
	}

	public void setClases(String clases) {
		this.clases = clases;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public boolean isDonante() {
		return donante;
	}

	public void setDonante(boolean donante) {
		this.donante = donante;
	}

	public String getFecha_alta_titular() {
		return fecha_alta_titular;
	}

	public void setFecha_alta_titular(String fecha_alta_titular) {
		this.fecha_alta_titular = fecha_alta_titular;
	}

	@Override
	public void toEntity(JSONObject object) {
		try {
			id_titular = object.getInt(TableDatabase.TITULAR.ID_TITULAR);
			tipo_dni = object.getString(TableDatabase.TITULAR.TIPO_DNI);
			dni = object.getInt(TableDatabase.TITULAR.DNI);
			apellidos = object.getString(TableDatabase.TITULAR.APELLIDOS);
			nombres = object.getString(TableDatabase.TITULAR.NOMBRES);
			fecha_nac = object.getString(TableDatabase.TITULAR.FECHA_NAC);
			direccion = object.getString(TableDatabase.TITULAR.DIRECCION);
			localidad = object.getString(TableDatabase.TITULAR.LOCALIDAD);
			clases = object.getString(TableDatabase.TITULAR.CLASES);
			grupo = object.getString(TableDatabase.TITULAR.GRUPO); // "AB+" "A" "B" "O"
			factor = object.getString(TableDatabase.TITULAR.FACTOR);
			donante = object.getString(TableDatabase.TITULAR.DONANTE).equals("Si") ? true : false; // "true" "false"
			fecha_alta_titular = object.getString(TableDatabase.TITULAR.FECHA_ALTA_TITULAR);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put(TableDatabase.TITULAR.ID_TITULAR, id_titular);
			jsonObject.put(TableDatabase.TITULAR.TIPO_DNI, tipo_dni);
			jsonObject.put(TableDatabase.TITULAR.DNI, dni);
			jsonObject.put(TableDatabase.TITULAR.APELLIDOS, apellidos);
			jsonObject.put(TableDatabase.TITULAR.NOMBRES, nombres);
			jsonObject.put(TableDatabase.TITULAR.FECHA_NAC, fecha_nac);
			jsonObject.put(TableDatabase.TITULAR.DIRECCION, direccion);
			jsonObject.put(TableDatabase.TITULAR.LOCALIDAD, localidad);
			jsonObject.put(TableDatabase.TITULAR.CLASES, clases);
			jsonObject.put(TableDatabase.TITULAR.GRUPO, grupo);
			jsonObject.put(TableDatabase.TITULAR.FACTOR, factor);
			jsonObject.put(TableDatabase.TITULAR.DONANTE, donante ? "Si" : "No");
			jsonObject.put(TableDatabase.TITULAR.FECHA_ALTA_TITULAR, fecha_alta_titular);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		System.out.println("JSON: " + jsonObject.toString());

		return jsonObject;
	}

	@Override
	public boolean equals(Object obj) {
		return getDNI().equals(((Titular)obj).getDNI());
	}
}
