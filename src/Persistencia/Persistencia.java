package Persistencia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ValueObject.VOMensages;
import Excepciones.PersistenciaException;



public class Persistencia {
	public VOMensages Recuperar(String NombreArchivo) throws PersistenciaException,  java.lang.ClassNotFoundException {
		try {
			FileInputStream fileIn = new FileInputStream(NombreArchivo);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	
			VOMensages recuperado = (VOMensages) objectIn.readObject();
	
			objectIn.close();
			fileIn.close();
			return recuperado;
		}catch(IOException e) {
			throw new PersistenciaException("Error Al Realizar la recuperacion");
		}
	}
	
	
	
	public void Respaldar(String NombreArchivo, VOMensages vo) throws PersistenciaException  {
		try {
			FileOutputStream fileOut = new FileOutputStream(NombreArchivo);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	
			// Guarda todos los datos relevantes en el archivo binario
			objectOut.writeObject(vo);
			//objectOut.writeObject(asignaturas);
			// Añade más líneas para guardar otros datos necesarios
	
			objectOut.close();
			fileOut.close();
		}catch (Exception e) {
			throw new PersistenciaException("Error al respaldar");
		}
	}
}
