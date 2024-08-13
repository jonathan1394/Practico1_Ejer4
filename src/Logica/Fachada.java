package Logica;
import Logica.Mensaje;
import java.util.List;

import ValueObject.VOMensajes;

public class Fachada {

	private List<Mensaje> M;

	public Fachada(List<Mensaje> m) {
		super();
		M = m;
	}
	
	public void IngresarMensajes(VOMensajes VOM) {
		//desde la GUI traemos el texto y el Usuario (Ahora lo hacemos Harcode) lo guardamos en un VO y lo manejamos aca
	}
	
	public List<VOMensajes> ListarMensajes(){
		//Obtenemos la lista la pasamos a VO y se la mandamos a la GUI para mostrar
		List<VOMensajes> LM=null;
		
		return LM;
		
	}
	
	public void RespaldarMensaje () {
		
	}
	
	public void RecuperarMensaje () {
		
	}

}
