package com.TotalWar.LoginRegister.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TotalWar.LoginRegister.models.Comentarios;
import com.TotalWar.LoginRegister.models.Response;
import com.TotalWar.LoginRegister.repository.ComentarioDAO;


@Primary
@Service

@Component("ComenService")
public class ComentarioService implements IComentarioService{

	
	@Autowired
	ComentarioDAO comentarioRepository;
	
	
	public Response<Comentarios> crearComentario(Comentarios comentarioRecibido) {

		 Response<Comentarios> response = new Response<>();
		 
		 try {
			 Comentarios cmt = comentarioRepository.save(comentarioRecibido);
			 response.setEstado(true);
			 response.setMensaje(cmt.getNombre()+", tu comentario ha sido creado correctamente");
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje(e.getMessage());
		}
		 
		 return response;
	}
	

	@Override
	public Response<Comentarios> listarComentario() {

		Response<Comentarios> response = new Response<>();
	
		try {
			response.setEstado(true);
			response.setListdata((List<Comentarios>) comentarioRepository.findAll());
			response.setMensaje("Bandeja de Comentarios");
			response.setMensajeError("Escribe tu opinion al respecto llenando el formulario");
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Ocurrieron cosas");
			response.setMensajeError(e.getStackTrace().toString());
		}
			
		
		
		return response;
	}


	public Response<Comentarios> editarComentario(Integer ID) {

		Response<Comentarios> response = new Response<>();
		
		
		try {
			Optional<Comentarios> p = comentarioRepository.findById(ID);
			response.setData(p.get());
			response.setEstado(true);
			response.setMensaje("Editando el comentario numero de " +p.get().getNombre());;
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al editar comentario");;
			response.setMensajeError(e.getStackTrace().toString());
			
						
		}
		
		return response;
	}


	@Override
	public Response<Comentarios> eliminarComentario(Integer ID) {

		Response<Comentarios> response = new Response<>();
		
		
		try {
			comentarioRepository.deleteById(ID);
			response.setEstado(true);
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al borrar comentario");;
			response.setMensajeError(e.getStackTrace().toString());
			
						
		}
		
		return response;
	}


}
