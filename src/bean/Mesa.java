package bean;

import java.sql.Date;

public class Mesa {
	private int id;
	private String id_usuario;
	private Date fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String nombre) {
		this.id_usuario = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
