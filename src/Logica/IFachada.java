package Logica;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Excepciones.PersistenciaException;

public interface IFachada extends Remote {

	public void IngresarMensajes(String VOM) throws RemoteException;
	
	public List<String> ListarMensajes()throws RemoteException;
	
	public void RespaldarMensaje () throws PersistenciaException,RemoteException;
	
	public void RecuperarMensaje ()throws PersistenciaException,RemoteException;
}
