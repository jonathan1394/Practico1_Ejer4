package RMI.Server;
import java.io.FileInputStream;
import java.io.IOException;
//import RMI.Cliente.Requerimientos;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import Persistencia.IPersistencia;
import Persistencia.Persistencia;

import java.util.Properties;

public class ServerPersistencia {
	public static void main(String[] args) {
		try {
			
			Properties p = new Properties();
			String NomArch = "src\\config\\config.properties";
			p.load(new FileInputStream(NomArch));
			String ip = p.getProperty("ip");
			String puerto = p.getProperty("puerto");

			// pongo a correr el rmiregistry
			LocateRegistry.createRegistry(Integer.parseInt(puerto));
			// instancio mi Objeto Remoto y lo publico
			IPersistencia P = new Persistencia();
			System.out.println("Preparando servidor en: //" + ip + ":" + puerto + "/fachada");
			Naming.rebind("//" + ip + ":" + puerto + "/fachada", P);
			System.out.println("Servidor de Persistencia Corriendo ...");
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

