package Logica;
import Logica.Mensaje;
import Persistencia.Persistencia;
import java.util.List;

import Excepciones.PersistenciaException;
import ValueObject.VOMensajes;

public class Fachada {

	private List<Mensaje> M;

	public Fachada(List<Mensaje> m) {
		super();
		M = m;
	}
	
	public void IngresarMensajes(VOMensajes VOM) {
		//desde la GUI traemos el texto y el Usuario (Ahora lo hacemos Harcode) lo guardamos en un VO y lo manejamos aca
		Mensaje m=null;
		m.setmensaje(VOM.getMensaje());
		m.setUsuario("Null");
		M.add(m);
	}
	
	public List<VOMensajes> ListarMensajes(){
		//Obtenemos la lista la pasamos a VO y se la mandamos a la GUI para mostrar
		List<VOMensajes> LM=null;
		for (Mensaje aux : M) {
			VOMensajes voaux = new VOMensajes(aux.getmensaje(), aux.getUsuario());
			LM.add(voaux);
		}
		return LM;
	}
	
	public void RespaldarMensaje () throws PersistenciaException {
		Persistencia p=new Persistencia();
		List<VOMensajes> LM=null;
		for (Mensaje aux : M) {
			VOMensajes voaux = new VOMensajes(aux.getmensaje(), aux.getUsuario());
			LM.add(voaux);
		}
		p.Respaldar(LM);

	}
	
	public void RecuperarMensaje () {
		
	}

}
