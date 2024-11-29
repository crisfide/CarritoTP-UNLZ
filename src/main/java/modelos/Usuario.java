package modelos;

public class Usuario {
	
	private String nombre, contraseña, rol;
	
	private int id;
	
	private double saldo;
		
	
	
	public Usuario(String nombre, String contraseña, String rol) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.rol = rol;
		this.saldo = 0;
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", rol=" + rol + ", id=" + id + "]";
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

	
}
