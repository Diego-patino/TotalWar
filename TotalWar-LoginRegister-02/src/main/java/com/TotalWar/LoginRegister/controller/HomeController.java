package com.TotalWar.LoginRegister.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TotalWar.LoginRegister.models.Comentarios;
import com.TotalWar.LoginRegister.models.MetodosDePago;
import com.TotalWar.LoginRegister.models.Response;
import com.TotalWar.LoginRegister.service.IComentarioService;
import com.TotalWar.LoginRegister.service.IPagoService;



@Controller

public class HomeController {

	@GetMapping("/")
	public String home() {
		return "Home";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/register")
	public String Register() {
		return "registro";
	}

	@Autowired
	@Qualifier("ComenService")
	private IComentarioService InterfaceComentario;

	@Value("${title.generic}")
	private String tituloPagina;

	@Autowired
	@Qualifier("Service1")
	private IPagoService InterfacePago1;

	
	@GetMapping({"/pagos","/donaciones","/Pagos","/Donaciones"})
	public String HolaMundo(Model model) {

		
		model.addAttribute("tituloPagina", tituloPagina);
		
		if (InterfacePago1.crearPago().getEstado()) {
			
			model.addAttribute("listapagos",InterfacePago1.crearPago().getListdata());
			model.addAttribute("titulo2", "Cualquier ayuda es bienvenida");
			
		} 

			model.addAttribute("Estado",InterfacePago1.crearPago().getMensaje());
			
		MetodosDePago metodosDePago = new MetodosDePago();
		
		String resp = InterfacePago1.PagoResp(metodosDePago);
		
		 model.addAttribute("respuesta",resp);
		
		return "Pago";
	};
	
	
	@GetMapping("/home2")
	public String CrearComentario(Model model){
		
		Comentarios comentarios = new Comentarios();

		model.addAttribute("comentarios", comentarios);
		model.addAttribute("TituloPagina", tituloPagina);
		model.addAttribute("titulo", "Crear Comentario");
		Response<Comentarios> rspta = InterfaceComentario.listarComentario();
		
		if (rspta.getEstado()) {

			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("listaComentarios", rspta.getListdata());
			model.addAttribute("MensajeError", rspta.getMensajeError());
			
		} else {
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("MensajeError", rspta.getMensajeError());
			return "redirect:/error";
		}
		
		return "Home2";
		
	};
	
	@GetMapping("/home2/editar-comentario/{idComentario}")
	public String EditarComentario(@PathVariable int idComentario,  Model model) {
		model.addAttribute("TituloPagina", tituloPagina);
		model.addAttribute("TituloPagina2", tituloPagina);
		model.addAttribute("titulo", "Crear Comentario");
		Response<Comentarios> edit = InterfaceComentario.editarComentario(idComentario);
		

		model.addAttribute("comentarios", edit.getData());
		
		
		
		if (edit.getEstado()) {

			model.addAttribute("Mensaje", edit.getMensaje());
			model.addAttribute("listaComentarios", edit.getData());
			model.addAttribute("MensajeError", edit.getMensajeError());
			
		} else {
			model.addAttribute("Mensaje", edit.getMensaje());
			model.addAttribute("MensajeError", edit.getMensajeError());
			return "redirect:/error";
		}
		
		return "Home2";
		
	}
	
	@GetMapping("/home2/eliminar-comentario/{idComentario}")
	public String EliminarComentario(@PathVariable int idComentario, Model model) {
		
		Response<Comentarios> edit = InterfaceComentario.eliminarComentario(idComentario);
		
		if (edit.getEstado()) {
			return "redirect:/home2";
		} else {
			model.addAttribute("Mensaje", edit.getMensaje());
			model.addAttribute("MensajeError", edit.getMensajeError());
			return "redirect:/error";
		}
		
	}
	
	@PostMapping("/home2")
	public String Formulario(@Valid Comentarios comentarios , BindingResult result, Model model){
		
		if (result.hasErrors()) {	
			Response<Comentarios> rspta = InterfaceComentario.listarComentario();
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("MensajeError", rspta.getMensajeError());
			model.addAttribute("listaComentarios", rspta.getListdata());
			return "Home2";
		}
		
		Response<Comentarios> rspta = InterfaceComentario.crearComentario(comentarios);
		
		if (rspta.getEstado()) {
			return "redirect:/home2";
		} else {
			model.addAttribute("Mensaje", rspta.getMensaje());
			return "redirect:/error";
		}
			
		
	};
	
	
	
	
	
}



