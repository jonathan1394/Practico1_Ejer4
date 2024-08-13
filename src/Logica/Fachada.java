package Logica;
import Logica.Mensage;
import java.util.List;

import ValueObject.VOMensages;

public class Fachada {

	private List<Mensage> M;

	public Fachada(List<Mensage> m) {
		super();
		M = m;
	}
	
	public void IngresarMensages(VOMensages VOM) {
		//desde la GUI traemos el texto y el Usuario (Ahora lo hacemos Harcode) lo guardamos en un VO y lo manejamos aca
	}
	
	public List<VOMensages> ListarMensages(){
		//Obtenemos la lista la pasamos a VO y se la mandamos a la GUI para mostrar
		List<VOMensages> LM=null;
		
		return LM;
		
	}
	
	public void RespaldarMensage () {
		
	}
	
	public void RecuperarMensage () {
		
	}

}
