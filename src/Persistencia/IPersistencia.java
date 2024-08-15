package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Excepciones.PersistenciaException;

public interface IPersistencia extends Remote {
	public List<String> Recuperar() throws PersistenciaException, ClassNotFoundException, RemoteException;
	public void Respaldar(List<String>  Lm) throws PersistenciaException, RemoteException;
}
