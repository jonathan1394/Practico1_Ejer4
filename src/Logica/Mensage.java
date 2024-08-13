package Logica;

public class Mensage {
 private String Mensage;
 private String Usuario;

 public Mensage(String mensage, String usuario) {
	super();
	Mensage = mensage;
	Usuario = usuario;
 }

public String getMensage() {
	return Mensage;
}

public void setMensage(String mensage) {
	Mensage = mensage;
}

public String getUsuario() {
	return Usuario;
}

public void setUsuario(String usuario) {
	Usuario = usuario;
}
 
 
 
 
}
