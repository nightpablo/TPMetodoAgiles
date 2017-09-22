package Utils.Implements;

import java.util.ArrayList;

public interface ControlImplementation<T> {
	
	public void crear(T entrada);
	
	public void modificar(T entrada);
	
	public void borrar(T entrada);
	
	public T buscarPorId(Integer id);
	
	public ArrayList<T> listarEnLista();
	
}
