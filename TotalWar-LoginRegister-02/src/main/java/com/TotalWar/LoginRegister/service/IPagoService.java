package com.TotalWar.LoginRegister.service;

import com.TotalWar.LoginRegister.models.MetodosDePago;
import com.TotalWar.LoginRegister.models.Response;

public interface IPagoService {
	
	public Response<MetodosDePago> crearPago();
	
	public String PagoResp(MetodosDePago m);
}
