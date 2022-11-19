package com.TotalWar.LoginRegister.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TotalWar.LoginRegister.models.MetodosDePago;
import com.TotalWar.LoginRegister.models.Response;

@Primary
@Service

@Component("Service1")
public class PagoService implements IPagoService{
	
	
	public Response<MetodosDePago> crearPago() {
		
		Response<MetodosDePago> response = new Response<>();
		boolean estadoCreacion = false;
		List<MetodosDePago> listapagos = new ArrayList<>();
		
		MetodosDePago pagos1 = new MetodosDePago();
		pagos1.setNombre("PayPal");
		pagos1.setDetalle("Correo: AbHuamani@kapin.com ");

		MetodosDePago pagos2 = new MetodosDePago();
		pagos2.setNombre("YAPE");
		pagos2.setDetalle("A nombre de ABRAHAM LUJAN CARRION");

		MetodosDePago pagos3 = new MetodosDePago();
		pagos3.setNombre("BCP");
		pagos3.setDetalle("Cuenta: 1234-4567-7897-4158 ");

		listapagos.add(pagos1);
		listapagos.add(pagos2);
		listapagos.add(pagos3);
		
		if (listapagos.size() > 0) {
			
			estadoCreacion = true;
			response.setEstado(estadoCreacion);
			response.setMensaje("Elije tu metodo mas facil para brindar apoyo");
			response.setListdata(listapagos);
		} else {
			
			response.setEstado(estadoCreacion);
			response.setMensaje("Se produjo un error al crear los metodos de pagos disponibles");
			
		} return response;
	}


	@Override
	public String PagoResp(MetodosDePago m) {
		
		String r = "ola sebas";
		
		if (m != null) {
			r = "fino";
		}
		return r;
	}

}
