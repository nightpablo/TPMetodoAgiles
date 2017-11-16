package Test;


import Control.ContribuyenteJSON;
import Control.LicenciaJSON;
import Control.TitularJSON;
import Entidad.Contribuyente;
import Entidad.Licencia;
import Entidad.Titular;

public class IniciarBD {

	public static void main(String[] arg) {
		eliminarBD();
		cargarContribuyentes();
		cargarTitularesAntiguos();
	}
	
	private static void cargarTitularesAntiguos() {
		Titular t1 = new Titular("DNI",33221100,"Tinelli","Marcelo","1/4/1960","ShowMatch 9999","Rosario","B,C","B","-",true,"1/1/2008");
		t1 = new TitularJSON().crear(t1);
		Titular t2 = new Titular("DNI",33221101,"Rico","Claudio","1/4/1950","ShowMatch 9999","Rosario","A,D","AB","-",true,"1/1/2009");
		t2 = new TitularJSON().crear(t2);
		Titular t3 = new Titular("DNI",33221102,"Florez","Fatima","1/4/1981","ShowMatch 9999","San Carlos","B,C,D,E","AB","-",true,"1/1/2007");
		t3 = new TitularJSON().crear(t3);
		
		Licencia l1 = new Licencia(t1.getId_titular(),"10/10/2012","10/10/2016",0,"Usa un microfono","B,C");
		new LicenciaJSON().crear(l1);
		Licencia l2 = new Licencia(t2.getId_titular(),"10/10/2013","10/10/2017",0,"","A,D");
		new LicenciaJSON().crear(l2);
		Licencia l3 = new Licencia(t3.getId_titular(),"1/11/2012","1/11/2017",0,"","A,C,D,E");
		new LicenciaJSON().crear(l3);
	}

	private static void eliminarBD() {
		LicenciaJSON lj = new LicenciaJSON();
		TitularJSON tj = new TitularJSON();
		ContribuyenteJSON cj = new ContribuyenteJSON();
		for(Licencia i: lj.listarEnLista())
			lj.borrar(i);
		for(Titular i: tj.listarEnLista())
			tj.borrar(i);
		for(Contribuyente i: cj.listarEnLista())
			cj.borrar(i);
	}

	private static void cargarContribuyentes() {
		ContribuyenteJSON cj = new ContribuyenteJSON();
		for(int i=0;i<100;i++) 
			cj.crear(new Contribuyente(33221100+i));
	}

}
