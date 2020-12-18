package com.init.pqrs.entitys;

import java.sql.Date;

public class CreatePqrForm {
	private String email;
	private String userEmail;
	private String tipo;
	private String asunto;
	private String estado;
	private Date expired_at;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getExpired_at() {
		return expired_at;
	}
	public void setExpired_at(Date expired_at) {
		this.expired_at = expired_at;
	}
	
}
