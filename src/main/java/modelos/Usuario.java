package modelos;

public class Usuario {
	
	private String nombre, contrase�a, rol;
	
	private int id;
		
	
	
	public Usuario(String nombre, String contrase�a, String rol) {
		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.rol = rol;
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrase�a=" + contrase�a + ", rol=" + rol + ", id=" + id + "]";
	}
	
	

	
}
