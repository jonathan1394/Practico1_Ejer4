package Logica;

public class Mensaje {
 private String Mensaje;
 private String Usuario;

 public Mensaje(String mensaje, String usuario) {
	super();
	Mensaje = mensaje;
	Usuario = usuario;
 }

public String getmensaje() {
	return Mensaje;
}

public void setmensaje(String mensaje) {
	Mensaje = mensaje;
}

public String getUsuario() {
	return Usuario;
}

public void setUsuario(String usuario) {
	Usuario = usuario;
}
 
 
 
 
}
