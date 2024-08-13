package ValueObject;

public class VOMensajes {


	private String Mensaje;
	private String Usuario;
	
	public VOMensajes(String mensaje, String usuario) {
		super();
		Mensaje = mensaje;
		Usuario = usuario;
	}
	
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
}
