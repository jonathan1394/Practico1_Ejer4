package Persistencia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import ValueObject.VOMensajes;
import Excepciones.PersistenciaException;



public class Persistencia {
	private String Ruta="./datos.dat";
	
	public List<VOMensajes> Recuperar() throws PersistenciaException,  java.lang.ClassNotFoundException {
		try {
			FileInputStream fileIn = new FileInputStream(Ruta);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	
			List<VOMensajes> recuperado = (List<VOMensajes>) objectIn.readObject();
	
			objectIn.close();
			fileIn.close();
			return recuperado;
		}catch(IOException e) {
			throw new PersistenciaException("Error Al Realizar la recuperacion");
		}
	}
	
	
	
	public void Respaldar(List<VOMensajes> Lvo) throws PersistenciaException  {
		try {
			FileOutputStream fileOut = new FileOutputStream(Ruta);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	
			// Guarda todos los datos relevantes en el archivo binario
			objectOut.writeObject(Lvo);
			//objectOut.writeObject(asignaturas);
			// Añade más líneas para guardar otros datos necesarios
	
			objectOut.close();
			fileOut.close();
		}catch (Exception e) {
			throw new PersistenciaException("Error al respaldar");
		}
	}
}
