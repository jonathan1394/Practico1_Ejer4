package Persistencia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;
import Excepciones.PersistenciaException;



public class Persistencia extends UnicastRemoteObject implements Remote, IPersistencia {
	

	private static final long serialVersionUID = 1L;
	private String Ruta="./Datos.dat";
	
	public Persistencia() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<String> Recuperar() throws PersistenciaException, ClassNotFoundException, RemoteException {
		try {
			FileInputStream fileIn = new FileInputStream(Ruta);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	
			List<String> recuperado = (ArrayList<String>) objectIn.readObject();
	
			objectIn.close();
			fileIn.close();
			return recuperado;
		}catch(IOException e) {
			throw new PersistenciaException("Error Al Realizar la recuperacion");
		}
	}
	
	
	
	public void Respaldar(List<String> Lm) throws PersistenciaException, RemoteException {
		try {
			FileOutputStream fileOut = new FileOutputStream(Ruta);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	
			// Guarda todos los datos relevantes en el archivo binario
			objectOut.writeObject(Lm);
			//objectOut.writeObject(asignaturas);
			// Añade más líneas para guardar otros datos necesarios
	
			objectOut.close();
			fileOut.close();
		}catch (Exception e) {
			throw new PersistenciaException("Error al respaldar");
		}
	}
}
