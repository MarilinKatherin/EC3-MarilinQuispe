package com.idat.reservarcita.service;

import java.util.List;

import com.idat.reservarcita.dto.ClienteDTORequest;
import com.idat.reservarcita.dto.ClienteDTOResponse;

public interface ClienteService {
	void guardar(ClienteDTORequest Clientes);
	void actualizar(ClienteDTORequest Clientes);
	void eliminar(Integer id);	
	List<ClienteDTOResponse>listar();
	ClienteDTOResponse obtenerById(Integer id);
}
