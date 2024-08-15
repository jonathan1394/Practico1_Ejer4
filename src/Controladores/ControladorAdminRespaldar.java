package Controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import Excepciones.PersistenciaException;
import Grafica.VAdminChatVer;
import Grafica.VAdminRespaldar;
import Grafica.VentanaError;
import Logica.IFachada;

public class ControladorAdminRespaldar {
	private IFachada f = null;
	private VAdminRespaldar MiVentana;

	public ControladorAdminRespaldar(VAdminRespaldar VP) {
		try {
			this.MiVentana = VP;
			Properties p = new Properties();
			String NomArch = "src\\\\config\\\\config.properties";
			p.load(new FileInputStream(NomArch));
			String ip = p.getProperty("ip");
			String puerto = p.getProperty("puerto");
			f = (IFachada) Naming.lookup("//" + ip + ":" + puerto + "/fachada");
		} catch (RemoteException e) {
			DevolverError("No es posible Conectarce con el servidor!!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			// JOptionPane.showMessageDialog(null,e.getMessage());
			DevolverError("La direccion no tiene un formato válido");
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			// JOptionPane.showMessageDialog(null,e.getMessage());
			DevolverError("El objeto no está vinculado");
		} catch (IOException e) {
			// JOptionPane.showMessageDialog(null,e.getMessage());
			DevolverError("Se produjo un error de entrada/salida:");
		}
	}
	
	public void DevolverError(String error) {
		MiVentana.setHayError(true);
		VentanaError VE= new VentanaError(error);
		VE.setVisible(true);

	}
	
	public void Guardar() throws RemoteException, PersistenciaException {
		f.RespaldarMensaje();
	}
	
	public String ListarMensaje() throws RemoteException, PersistenciaException {
		List<String> L = f.ListarMensajes();
		String aux="";
		for(String S:L) {
			aux = aux + S + "\n";
		}
		return aux;
	}
}
