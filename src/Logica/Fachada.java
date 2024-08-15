package Logica;
import Persistencia.Persistencia;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import Excepciones.PersistenciaException;



public class Fachada extends UnicastRemoteObject implements IFachada{

	private List<String> M=new ArrayList<String>();

	public Fachada() throws RemoteException {
	}
	
	public void IngresarMensajes(String Mensaje)throws RemoteException {
		//desde la GUI traemos el texto y el Usuario (Ahora lo hacemos Harcode) lo guardamos en un VO y lo manejamos aca
		M.add(Mensaje);
	}
	
	public List<String> ListarMensajes() throws RemoteException {
		//Obtenemos la lista la pasamos a VO y se la mandamos a la GUI para mostrar
		List<String> LM = new ArrayList<String>();
		for (String aux : M) {
			LM.add(aux);
		}
		return LM;
	}
	
	public void RespaldarMensaje () throws PersistenciaException,RemoteException {
		Persistencia p=new Persistencia();
		List<String> L= M;
		p.Respaldar(L);

	}
	
	public void RecuperarMensaje () throws PersistenciaException,RemoteException{
		try {
			Persistencia p = new Persistencia();
			System.out.println("PAso");
			List<String> LM = p.Recuperar();
			for(String MSJ : LM) {
				System.out.println(MSJ);
				M.add(MSJ);
			}
		} catch (Exception e) {

			throw new PersistenciaException ("Error al Recuperar.");
		}
	}

}
