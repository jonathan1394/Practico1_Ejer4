package Controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;


import Excepciones.PersistenciaException;
import Grafica.VAdminChatVer;
import Grafica.VAdminRespaldar;
import Grafica.VClienteChat;
import Grafica.VentanaError;
import Grafica.vMenu;
import Logica.IFachada;

public class ControladorMenu {
	private IFachada f = null;
	private vMenu MiVentana;

	public ControladorMenu(vMenu VP) {
		// TODO Auto-generated constructor stub
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
	
	public void AdminChatVer() {
		VAdminChatVer VACV = new VAdminChatVer();
		if(VACV.getHayError()) {
			VACV.dispose();
		}else {
			VACV.setVisible(true);
		}
	}
	
	public void AdminRespaldar() throws RemoteException, PersistenciaException {
		VAdminRespaldar VAR = new VAdminRespaldar();
		if(VAR.getHayError()) {
			VAR.dispose();
		}else {
			VAR.setVisible(true);
		}
	}
	
	public void ClienteChat(){
		VClienteChat VCC = new VClienteChat();
		if(VCC.getHayError()) {
			VCC.dispose();
		}else {
			VCC.setVisible(true);
		}
	}
}
