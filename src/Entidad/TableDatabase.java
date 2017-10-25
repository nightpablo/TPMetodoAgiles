package Entidad;

public class TableDatabase {
	static class TITULAR{
		static final String NOMBRE_TABLA = "titulares";
		static final String ID_TITULAR = "id";
		static final String TIPO_DNI = "tipo_doc";
		static final String DNI = "dni";
		static final String APELLIDOS = "apellidos";
		static final String NOMBRES = "nombres";
		static final String FECHA_NAC = "fecha_nac";
		static final String DIRECCION = "direccion";
		static final String LOCALIDAD = "localidad";
		static final String CLASES = "clases";
		static final String GRUPO = "grupo";
		static final String FACTOR = "factor";
		static final String DONANTE = "donante";
		static final String FECHA_ALTA_TITULAR = "fecha_alta_titular";
	}
	
	static class LICENCIA{
		static final String ID_LICENCIA = "id";
		static final String ID_TITULAR = "id_titular";
		static final String INICIO_VIGENCIA = "inicio_vigencia";
		static final String FECHA_EMISION = "fecha_emision";
		static final String FIN_VIGENCIA = "fin_vigencia";
		static final String USUARIO = "usuario";
		static final String CLASES = "clases";
		static final String OBSERVACIONES = "observaciones";
	}

}
