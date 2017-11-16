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
	public void pruebadeVigencia() {
		//Prueba de "Calcular vigencia"
		assertEquals(new Integer(5), new Integer(new TitularJSON().calcularVigencia(titular))); // 44 años
		titular.setFecha_nac("4/03/1970");
		assertEquals(new Integer(4), new Integer(new TitularJSON().calcularVigencia(titular))); // 47 años
		titular.setFecha_nac("4/03/1956");
		assertEquals(new Integer(3), new Integer(new TitularJSON().calcularVigencia(titular))); // 61 años
		titular.setFecha_nac("4/03/1946");
		assertEquals(new Integer(1), new Integer(new TitularJSON().calcularVigencia(titular))); // 71 años
		titular.setFecha_nac("4/03/1999");
		assertEquals(new Integer(1), new Integer(new TitularJSON().calcularVigencia(titular))); // 18 años

		//Defecto
		titular.setFecha_nac("4/03/1973");
	}
	
	@Test
	public void pruebaDeCosto() {
		//Prueba de "Calcular costo"
		TitularJSON tj = new TitularJSON();
		assertEquals(new Integer(48), new Integer(tj.calcularCosto("A", 5)));
		assertEquals(new Integer(38), new Integer(tj.calcularCosto("A", 4)));
		assertEquals(new Integer(33), new Integer(tj.calcularCosto("A", 3)));
		assertEquals(new Integer(28), new Integer(tj.calcularCosto("A", 1)));
		assertEquals(new Integer(48), new Integer(tj.calcularCosto("B", 5)));
		assertEquals(new Integer(38), new Integer(tj.calcularCosto("B", 4)));
		assertEquals(new Integer(33), new Integer(tj.calcularCosto("B", 3)));
		assertEquals(new Integer(28), new Integer(tj.calcularCosto("B", 1)));
		assertEquals(new Integer(55), new Integer(tj.calcularCosto("C", 5)));
		assertEquals(new Integer(43), new Integer(tj.calcularCosto("C", 4)));
		assertEquals(new Integer(38), new Integer(tj.calcularCosto("C", 3)));
		assertEquals(new Integer(31), new Integer(tj.calcularCosto("C", 1)));
		assertEquals(new Integer(67), new Integer(tj.calcularCosto("D", 5)));
		assertEquals(new Integer(52), new Integer(tj.calcularCosto("D", 4)));
		assertEquals(new Integer(47), new Integer(tj.calcularCosto("D", 3)));
		assertEquals(new Integer(37), new Integer(tj.calcularCosto("D", 1)));
		assertEquals(new Integer(67), new Integer(tj.calcularCosto("E", 5)));
		assertEquals(new Integer(52), new Integer(tj.calcularCosto("E", 4)));
		assertEquals(new Integer(47), new Integer(tj.calcularCosto("E", 3)));
		assertEquals(new Integer(37), new Integer(tj.calcularCosto("E", 1)));
		assertEquals(new Integer(48), new Integer(tj.calcularCosto("F", 5)));
		assertEquals(new Integer(38), new Integer(tj.calcularCosto("F", 4)));
		assertEquals(new Integer(33), new Integer(tj.calcularCosto("F", 3)));
		assertEquals(new Integer(28), new Integer(tj.calcularCosto("F", 1)));
		assertEquals(new Integer(48), new Integer(tj.calcularCosto("G", 5)));
		assertEquals(new Integer(38), new Integer(tj.calcularCosto("G", 4)));
		assertEquals(new Integer(33), new Integer(tj.calcularCosto("G", 3)));
		assertEquals(new Integer(28), new Integer(tj.calcularCosto("G", 1)));
		
		assertEquals(new Integer(88), new Integer(tj.calcularCosto("A,B", 5)));
		assertEquals(new Integer(68), new Integer(tj.calcularCosto("A,B", 4)));
		assertEquals(new Integer(58), new Integer(tj.calcularCosto("A,B", 3)));
		assertEquals(new Integer(48), new Integer(tj.calcularCosto("A,B", 1)));
		assertEquals(new Integer(135), new Integer(tj.calcularCosto("A,B,C", 5)));
		assertEquals(new Integer(103), new Integer(tj.calcularCosto("A,B,C", 4)));
		assertEquals(new Integer(88), new Integer(tj.calcularCosto("A,B,C", 3)));
		assertEquals(new Integer(71), new Integer(tj.calcularCosto("A,B,C", 1)));
		assertEquals(new Integer(194), new Integer(tj.calcularCosto("A,B,C,D", 5)));
		assertEquals(new Integer(147), new Integer(tj.calcularCosto("A,B,C,D", 4)));
		assertEquals(new Integer(127), new Integer(tj.calcularCosto("A,B,C,D", 3)));
		assertEquals(new Integer(100), new Integer(tj.calcularCosto("A,B,C,D", 1)));
		assertEquals(new Integer(253), new Integer(tj.calcularCosto("A,B,C,D,E", 5)));
		assertEquals(new Integer(191), new Integer(tj.calcularCosto("A,B,C,D,E", 4)));
		assertEquals(new Integer(166), new Integer(tj.calcularCosto("A,B,C,D,E", 3)));
		assertEquals(new Integer(129), new Integer(tj.calcularCosto("A,B,C,D,E", 1)));
		assertEquals(new Integer(293), new Integer(tj.calcularCosto("A,B,C,D,E,F", 5)));
		assertEquals(new Integer(221), new Integer(tj.calcularCosto("A,B,C,D,E,F", 4)));
		assertEquals(new Integer(191), new Integer(tj.calcularCosto("A,B,C,D,E,F", 3)));
		assertEquals(new Integer(149), new Integer(tj.calcularCosto("A,B,C,D,E,F", 1)));
		assertEquals(new Integer(333), new Integer(tj.calcularCosto("A,B,C,D,E,F,G", 5)));
		assertEquals(new Integer(251), new Integer(tj.calcularCosto("A,B,C,D,E,F,G", 4)));
		assertEquals(new Integer(216), new Integer(tj.calcularCosto("A,B,C,D,E,F,G", 3)));
		assertEquals(new Integer(169), new Integer(tj.calcularCosto("A,B,C,D,E,F,G", 1)));
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
		assertFalse(GestionCampos.evaluarDni("36111"));
		assertFalse(GestionCampos.evaluarDni("360011111"));
		
	}
	
	
	
	

}
