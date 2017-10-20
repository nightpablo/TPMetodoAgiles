package Utils;

import java.util.Arrays;

import javax.swing.JTextField;

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
		if(!entrada.matches("[a-zA-Z"
				+ "\\u00f1"
				+ "\\u00d1"
				+ "áàéèíìóòúùuÁÀÉÈÍÌÓÒÚÙ]+"))
			return false;
		return true;
	}
	
	public static boolean evaluarDni(String entrada) {
		return entrada.length() <= 8 && entrada.length() >= 7;
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
	/*
	public boolean evaluarEmail(String entrada) {
		if(!entrada.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			return false;
		return true;
	}*/
	
	public static Object[] evaluarTodosLosCampos(JTextField[] listacampos, String[] opciones) {
		boolean[] listaCorrectos = new boolean[listacampos.length];
		Integer alerta = 0;
		
		//Evaluamos si es campo vacio
		int j=0;
		for(JTextField i : listacampos) {
			listaCorrectos[j] = !evaluarCampoVacio(i.getText());
			if(!listaCorrectos[j]) alerta = 1;
			j++;
			
		}
		// Retornamos directamente para avisar que hay campos vacios
		if(alerta == 1)
			return new Object[] {listaCorrectos, alerta};
		
		//Sino, Evaluamos si cada uno cumple con las correspondientes...
		j=0;
		for(JTextField i : listacampos) {
				switch(opciones[j]) {
					case "numerico":
						listaCorrectos[j] = evaluarNumérico(i.getText());
						break;
					case "letras":
						listaCorrectos[j] = evaluarLetras(i.getText());
						break;
					case "alfanumerico":
						listaCorrectos[j] = evaluarAlfanumérico(i.getText());
						break;
					case "dni":
						listaCorrectos[j] = evaluarNumérico(i.getText()) && evaluarDni(i.getText());
						break;
					case "dia":
						listaCorrectos[j] = evaluarNumérico(i.getText()) && evaluarDia(i.getText());
						break;
					case "mes":
						listaCorrectos[j] = evaluarNumérico(i.getText()) && evaluarMes(i.getText());
						break;
					case "año":
						listaCorrectos[j] = evaluarNumérico(i.getText()) && evaluarAnio(i.getText());
						break;
					default:
						break;
				}
				System.out.println(opciones[j]+" - Evaluando: "+i.getText()+". Es "+listaCorrectos[j]);
				if(!listaCorrectos[j]) alerta = 2;
				j++;
		}
		
		return new Object[] {listaCorrectos,alerta};
	}
}
