package com.registro.usuarios.controlador.dto;

public class UsuarioRegistroDTO {

	private Long id;
	private String usuario;
	private String email;
	private String password;
	private String confirm;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	

	public UsuarioRegistroDTO(Long id, String usuario, String email, String password, String confirm) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
	}

	public UsuarioRegistroDTO() {

	}

}
