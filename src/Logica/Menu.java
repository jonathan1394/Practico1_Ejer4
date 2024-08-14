package Logica;
import java.rmi.RemoteException;
import java.util.List;

import Excepciones.PersistenciaException;




public class Menu {

	
	public static void main(String[] args) throws PersistenciaException, RemoteException {
		
		Fachada f = new Fachada();
		f.RecuperarMensaje();
		//f.IngresarMensajes("otra cosa");
		//f.IngresarMensajes("otra cosa2");
		//f.IngresarMensajes("otra cosa3");
		//f.IngresarMensajes("otra cosa4");
		//f.IngresarMensajes("otra cosa5");
		List<String> lm = f.ListarMensajes();
		for (String aux : lm) {
			System.out.println(aux);
		}
		//f.RespaldarMensaje();

	}	
}
