package Utils;

public class GestionCampos {

	public GestionCampos() {}
	
	public static boolean evaluarCampoVacio(String entrada) {
		return entrada.isEmpty();
	}
	
	public static boolean evaluarAlfanumérico(String entrada) {
		if(!entrada.matches("[a-zA-Z0-9 "
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
		if(!entrada.matches("[a-zA-Z "
				+ "\\u00f1"
				+ "\\u00d1"
				+ "áàéèíìóòúùuÁÀÉÈÍÌÓÒÚÙ]+"))
			return false;
		return true;
	}
	
	public static boolean evaluarDni(String entrada) {
		return entrada.length() <= 8 && entrada.length() >= 6;
	}
	public static boolean evaluarDia(String entrada) {
		return Integer.parseInt(entrada) <= 31 && Integer.parseInt(entrada) >= 1;
	}
	public static boolean evaluarMes(String entrada) {
		return Integer.parseInt(entrada) <= 12 && Integer.parseInt(entrada) >= 1;
	}
	public static boolean evaluarAnio(String entrada) {
		return Integer.parseInt(entrada) >= 1900;
	}
	
	public static Object[] evaluarTodosLosCampos(String[] listacampos, String[] opciones) {
		boolean[] listaCorrectos = new boolean[listacampos.length];
		Integer alerta = 0;
		
		//Evaluamos si es campo vacio
		int j=0;
		for(String i : listacampos) {
			listaCorrectos[j] = !evaluarCampoVacio(i);
			if(!listaCorrectos[j]) alerta = 1;
			j++;
			
		}
		// Retornamos directamente para avisar que hay campos vacios
		if(alerta == 1)
			return new Object[] {listaCorrectos, alerta};
		
		//Sino, Evaluamos si cada uno cumple con las correspondientes...
		j=0;
		for(String i : listacampos) {
				switch(opciones[j]) {
					case "numerico":
						listaCorrectos[j] = evaluarNumérico(i);
						break;
					case "letras":
						listaCorrectos[j] = evaluarLetras(i);
						break;
					case "alfanumerico":
						listaCorrectos[j] = evaluarAlfanumérico(i);
						break;
					case "dni":
						listaCorrectos[j] = evaluarNumérico(i) && evaluarDni(i);
						break;
					case "dia":
						listaCorrectos[j] = evaluarNumérico(i) && evaluarDia(i);
						break;
					case "mes":
						listaCorrectos[j] = evaluarNumérico(i) && evaluarMes(i);
						break;
					case "año":
						listaCorrectos[j] = evaluarNumérico(i) && evaluarAnio(i);
						break;
					default:
						break;
				}
				if(!listaCorrectos[j]) alerta = 2;
				j++;
		}
		
		return new Object[] {listaCorrectos,alerta};
	}
}
