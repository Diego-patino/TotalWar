package com.TotalWar.LoginRegister.models;

import java.util.List;

public class Response<T> {
	
	private boolean estado;
	private String mensaje;
	private List<T> Listdata;
	private String mensajeError;
	private T data;
	
	public List<T> getListdata() {
		return Listdata;
	}
	public void setListdata(List<T> listdata) {
		Listdata = listdata;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
