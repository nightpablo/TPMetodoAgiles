package Utils;

public class GestionCampos {

	public GestionCampos() {}
	
	public static boolean evaluarCampoVacio(String entrada) {
		if(entrada.isEmpty())
			return true;
		return false;
	}
	
	public static boolean evaluarAlfanumérico(String entrada) {
		if(!entrada.matches("[a-zA-Z0-9"
				+ "\\u00f1"
				+ "\\u00d1"
				+ "áàéèíìóòúùuÁÀÉÈÍÌÓÒÚÙ]+"))
			return false;
		return true;
	}
	
	public static boolean evaluarNumérico(String entrada) {
		if(!entrada.matches("[0-9]+"))
			return false;
		return true;
	}
	
	public static boolean evaluarLetras(String entrada) {
		if(!entrada.matches("[a-zA-Z"
				+ "\\u00f1"
				+ "\\u00d1"
				+ "áàéèíìóòúùuÁÀÉÈÍÌÓÒÚÙ]+"))
			return false;
		return true;
	}
	
	public static boolean evaluarDni(String entrada) {
		if(!entrada.matches("[0-9]+")  || entrada.length()> 8)
			return false;
		return true;
	}
	public static boolean evaluarDia(String entrada) {
		int numero= Integer.parseInt(entrada);
		
		if(!entrada.matches("[0-9]+") || numero > 31)
			return false;
		return true;
	}
	public static boolean evaluarMes(String entrada) {
		int numero= Integer.parseInt(entrada);
		
		if(!entrada.matches("[0-9]+") || numero > 12)
			return false;
		return true;
	}
	public static boolean evaluarAnio(String entrada) {
		int numero= Integer.parseInt(entrada);
		
		if(!entrada.matches("[0-9]+") || numero > 2000 || numero< 1600)
			return false;
		return true;
	}
	/*
	public boolean evaluarEmail(String entrada) {
		if(!entrada.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			return false;
		return true;
	}*/
}
