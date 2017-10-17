package Utils;

public class GestionCampos {

	public GestionCampos() {}
	
	public boolean evaluarCampoVacio(String entrada) {
		if(entrada.isEmpty())
			return true;
		return false;
	}

	public boolean evaluarAlfanum�rico(String entrada) {
		if(!entrada.matches("[a-zA-Z0-9"
				+ "\\u00f1"
				+ "\\u00d1"
				+ "����������u����������]+"))
			return false;
		return true;
	}
	
	public boolean evaluarNum�rico(String entrada) {
		if(!entrada.matches("[0-9]+"))
			return false;
		return true;
	}
	
	public boolean evaluarLetras(String entrada) {
		if(!entrada.matches("[a-zA-Z"
				+ "\\u00f1"
				+ "\\u00d1"
				+ "����������u����������]+"))
			return false;
		return true;
	}
	
	public boolean evaluarEmail(String entrada) {
		if(!entrada.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			return false;
		return true;
	}
}
