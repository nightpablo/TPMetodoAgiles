package Control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entidad.Contribuyente;
import Entidad.Titular;
import Utils.HTTPConection;
import Utils.Implements.ControlImplementation;

public class TitularJSON implements ControlImplementation<Titular>{

	@Override
	public Titular crear(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"POST",entrada.toJSON()});
		ArrayList<Titular> t = listarEnLista();
		return t.get(t.size()-1);
	}
	
	public Titular crear(String tipo_dni, String dni, String nombres, String apellidos, 
			String direccion, String localidad, String dia, String mes, String año, 
			String grupo, String factor, String donante) {
		Titular nuevo = new Titular();
		nuevo.setTipo_DNI(tipo_dni);
		nuevo.setDNI(Integer.parseInt(dni));
		nuevo.setNombres(nombres);
		nuevo.setApellidos(apellidos);
		nuevo.setDireccion(direccion);
		nuevo.setLocalidad(localidad);
		nuevo.setFecha_nac(dia+"/"+mes+"/"+año);
		nuevo.setGrupo(grupo);
		nuevo.setFactor(factor);
		nuevo.setDonante(donante.equals("Si")?true:false);
		nuevo.setClases("B,F");
		
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    String dd = Integer.toString(c.get(Calendar.DATE));
	    String mm = Integer.toString(c.get(Calendar.MONTH)+1);
	    String aaaa = Integer.toString(c.get(Calendar.YEAR));
	    
	    nuevo.setFecha_alta_titular(dd+"/"+mm+"/"+aaaa);

	    return nuevo;
	}

	@Override
	public void modificar(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"PUT",entrada.toJSON(),entrada.getId_titular()});		
	}

	@Override
	public void borrar(Titular entrada) {
		new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"DELETE",entrada.getId_titular()});		
	}

	@Override
	public Titular buscarPorId(Integer id) {
		ArrayList<Titular> Entry = listarEnLista();
        for(Titular i: Entry)
            if(i.getId_titular()==id)
                return i;
        return null;
	}
	
	public boolean existeTitular(Titular tit) {
		ArrayList<Titular> Entry = listarEnLista();
        for(Titular i: Entry)
            if(i.equals(tit))
                return true;
        return false;
	}
	
	public boolean existeTitular(Integer DNI) {
		ArrayList<Titular> Entry = listarEnLista();
        for(Titular i: Entry)
            if(i.getDNI().equals(DNI))
                return true;
        return false;
	}
	
	public boolean perteneceListaContribuyente(Integer DNI) {
		ArrayList<Contribuyente> Entry = new ContribuyenteJSON().listarEnLista();
		for(Contribuyente i: Entry) 
			if(i.getDni().equals(DNI))
                return true;
        return false;
	}

	@Override
	public ArrayList<Titular> listarEnLista() {
        ArrayList<Titular> salida = null;
        
		try {
			JSONArray lista = (JSONArray) new HTTPConection().gestion(new Object[] {Titular.NOMBRE_TABLA,"GET"});
	        salida = new ArrayList<Titular>();
			for(int i=0;i<lista.length();i++)
				salida.add(new Titular((JSONObject) lista.get(i)));
		} catch (JSONException e) {
			e.printStackTrace();
		}

        return salida;
	}

	public Integer calcularVigencia(Titular t) {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    String aaaa = Integer.toString(c.get(Calendar.YEAR));
	    
	    
	    //      				año actual          -                 año de nacimiento
	    Integer diferencia = Integer.parseInt(aaaa) - Integer.parseInt(t.getFecha_nac().split("/")[2]); 
		if(diferencia<21) return 1;			//1 año la primera vez y 3 años las siguientes
		else if(diferencia<=46) return 5;	//5 años
		else if(diferencia<=60) return 4;	//4 años
		else if(diferencia<=70) return 3;	//3 años
		return 1;	//1 años
	}

	public Integer calcularCosto(String listaClases, Integer vigencia) {
		int costo= 0;
		int costo_administrativo= 8;
		
		for(String i: listaClases.split(",")) {
		switch (i) {
			case "A":
		       switch (vigencia) {
		  		case 5:
		        	costo+= 40;
		       		break;
		 		case 4:
		       		costo+= 30;
		       		break;
				case 3:
		      		costo+= 25;
		       		 break;
		  		case 1:
		      		costo+= 20;
		      		 break;
				}
		        break;

		//---------------Clase B-----------------------------------------
		        case "B":
		        switch (vigencia) {
		  		case 5:
		  			costo+= 40;
		       		 break;
		 		case 4:
		       		 costo+= 30;
		       		 break;
				case 3:
		      		costo+= 25;
		       		 break;
		  		case 1:
		      		costo+= 20;
		      		break;
				}
		        break;

		//---------------Clase C --------------------------------
			     case "C":
		       switch (vigencia) {
		  		case 5:
		        	costo+= 47;
		       		 break;
		 		case 4:
		       		 costo+= 35;
		       		 break;
				case 3:
		      		costo+= 30;
		       		 break;
		  		case 1:
		      		costo+= 23;
		      		break;
				}
		        break;

		//---------------Clase D--------------------------------
		       case "D":
				switch (vigencia) {
		  		case 5:
		        	costo+= 59;
		       		 break;
		 		case 4:
		       		 costo+= 44;
		       		 break;
				case 3:
		      		costo+= 39;
		       		 break;
		  		case 1:
		      		costo+= 29;
		      		 break;
				}
		        break;

		//---------------Clase E--------------------------------
		       case "E":
		       switch (vigencia) {
		  		case 5:
		        	costo+= 59;
		       		 break;
		 		case 4:
		       		 costo+= 44;
		       		 break;
				case 3:
		      		costo+= 39;
		       		 break;
		  		case 1:
		      		costo+= 29;
		      		break;
				}
		        break;

		//---------------Clase F--------------------------------
		       case "F":
			        switch (vigencia) {
			  		case 5:
			        		 costo+= 40;
			       		 break;
			 		case 4:
			       		 costo+= 30;
			       		 break;
					case 3:
			      		costo+= 25;
			       		 break;
			  		case 1:
			      		costo+= 20;
			      		break;
					}
			        break;

		//---------------Clase G--------------------------------
		       case "G":
		       switch (vigencia) {
		  		case 5:
		        	costo+= 40;
		       		 break;
		 		case 4:
		       		 costo+= 30;
		       		 break;
				case 3:
		      		costo+= 25;
		       		 break;
		  		case 1:
		      		costo+= 20;
		      		break;
				}
		        break;
		        
		        // Opcion por defecto
				default:
				System.out.println("No existe esa clase o es incorrecta: Clase");
		        break;
		 
			}
		}
	return costo + costo_administrativo;
	}

}
