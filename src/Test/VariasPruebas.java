package Test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.*;

import Control.TitularJSON;
import Entidad.Titular;
import Utils.GestionCampos;

public class VariasPruebas {

	Titular titular;
	
	@Before
	public void inicializar() {
		titular = new Titular();
		titular.setId_titular(1);
		titular.setTipo_DNI("dni");
		titular.setDNI(36111111);
		titular.setNombres("Jose Maria");
		titular.setApellidos("Listorti");
		titular.setFecha_nac("4/03/1973"); //Actualmente tiene 44 años
		titular.setDireccion("Showmatch 9999");
		titular.setLocalidad("Buenos Aires");
		titular.setClases("A,B");
		titular.setGrupo("A");
		titular.setFactor("-");
		titular.setDonante(false);
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    String dd = Integer.toString(c.get(Calendar.DATE));
	    String mm = Integer.toString(c.get(Calendar.MONTH)+1);
	    String aaaa = Integer.toString(c.get(Calendar.YEAR));
	    titular.setFecha_alta_titular(dd+"/"+mm+"/"+aaaa);
	}
	
	@Test
	public void pruebaDeTitular() {
		
		//Prueba de "Calcular vigencia"
		assertEquals(new Integer(5), new Integer(new TitularJSON().calcularVigencia(titular))); // 44 años
		titular.setFecha_nac("4/03/1970");
		assertEquals(new Integer(4), new Integer(new TitularJSON().calcularVigencia(titular))); // 47 años
		titular.setFecha_nac("4/03/1956");
		assertEquals(new Integer(2), new Integer(new TitularJSON().calcularVigencia(titular))); // 61 años
		titular.setFecha_nac("4/03/1946");
		assertEquals(new Integer(1), new Integer(new TitularJSON().calcularVigencia(titular))); // 71 años
		titular.setFecha_nac("4/03/1999");
		assertEquals(new Integer(1), new Integer(new TitularJSON().calcularVigencia(titular))); // 18 años
		
		
		
		
		
		
		//Defecto
		titular.setFecha_nac("4/03/1973");
	}
	
	@Test
	public void pruebaDeCampos() {
		//Inicio de test donde es verdadera
		assertTrue(GestionCampos.evaluarNumérico("1347"));
		assertTrue(GestionCampos.evaluarLetras("hola buenos dias"));
		assertTrue(GestionCampos.evaluarAlfanumérico("calle al 3500"));
		assertTrue(GestionCampos.evaluarAnio("1980"));
		assertTrue(GestionCampos.evaluarMes("11"));
		assertTrue(GestionCampos.evaluarDia("31"));
		assertTrue(GestionCampos.evaluarDni("36111111"));
		
		//Inicio de test donde es falsa
		assertFalse(GestionCampos.evaluarNumérico("hola buenos dias"));
		assertFalse(GestionCampos.evaluarNumérico("calle al 3500"));
		assertFalse(GestionCampos.evaluarLetras("1347"));
		assertFalse(GestionCampos.evaluarLetras("calle al 3500"));
		assertFalse(GestionCampos.evaluarAlfanumérico("@hola"));
		assertFalse(GestionCampos.evaluarAnio("0"));
		assertFalse(GestionCampos.evaluarAnio("1899"));
		assertFalse(GestionCampos.evaluarMes("0"));
		assertFalse(GestionCampos.evaluarMes("13"));
		assertFalse(GestionCampos.evaluarDia("0"));
		assertFalse(GestionCampos.evaluarDia("32"));
		assertFalse(GestionCampos.evaluarDni("0"));
		assertFalse(GestionCampos.evaluarDni("361111"));
		assertFalse(GestionCampos.evaluarDni("360011111"));
		
	}
	
	
	
	

}
