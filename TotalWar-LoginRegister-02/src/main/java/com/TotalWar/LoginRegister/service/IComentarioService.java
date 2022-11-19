package com.TotalWar.LoginRegister.service;

import com.TotalWar.LoginRegister.models.Comentarios;
import com.TotalWar.LoginRegister.models.Response;

public interface IComentarioService {
	
	public Response<Comentarios> crearComentario(Comentarios c);
	
	public Response<Comentarios> listarComentario();
	
	public Response<Comentarios> editarComentario(Integer ID);
	
	public Response<Comentarios> eliminarComentario(Integer ID);

}
