package com.init.pqrs.entitys;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pqrs")
public class Pqr {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="asunto", nullable=false)
	private String asunto;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="created_at")
	private Date created_at;
	
	@Column(name="expired_at")
	private Date expired_at;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getTipo_pqr() {
		return tipo;
	}
	public void setTipo_pqr(String tipo_pqr) {
		this.tipo = tipo_pqr;
	}
	public String getEstado_pqr() {
		return estado;
	}
	public void setEstado_pqr(String estado_pqr) {
		this.estado = estado_pqr;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getExpired_at() {
		return expired_at;
	}
	public void setExpired_at(Date expired_at) {
		this.expired_at = expired_at;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
