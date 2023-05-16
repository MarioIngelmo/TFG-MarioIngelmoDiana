package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.security;

public class Credenciales {
	
	private String usuario;
	private String clave;
	
	public Credenciales() { }

	public Credenciales(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
