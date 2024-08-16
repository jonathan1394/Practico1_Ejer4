package Logica;
import Persistencia.IPersistencia;
import Persistencia.Persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Excepciones.PersistenciaException;



public class Fachada extends UnicastRemoteObject implements IFachada{

	private List<String> M=new ArrayList<String>();
	private IPersistencia P=null;
	
	
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
		if(P==null) {
			ConectarBD();
		}
		List<String> L= M;
		P.Respaldar(L);

	}
	
	public void RecuperarMensaje () throws PersistenciaException,RemoteException{
		try {
			if(P==null) {
				ConectarBD();
			}

			List<String> LM = P.Recuperar();
			for(String MSJ : LM) {
				M.add(MSJ);
			}
		} catch (Exception e) {

			throw new PersistenciaException ("Error al Recuperar.");
		}
	}

	private void ConectarBD() {
		try {
			Properties p = new Properties();
			String NomArch = "src\\\\config\\\\config.properties";
			p.load(new FileInputStream(NomArch));
			String ip = p.getProperty("ip");
			String puerto = p.getProperty("puerto");
			P = (IPersistencia) Naming.lookup("//" + ip + ":" + "1010" + "/Persistencia");
		} catch (RemoteException e) {
			System.out.println("No es posible Conectarce con el servidor!!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			// JOptionPane.showMessageDialog(null,e.getMessage());
			System.out.println("La direccion no tiene un formato válido");
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			// JOptionPane.showMessageDialog(null,e.getMessage());
			System.out.println("El objeto no está vinculado");
		} catch (IOException e) {
			// JOptionPane.showMessageDialog(null,e.getMessage());
			System.out.println("Se produjo un error de entrada/salida:");
		}
		
	}
}
