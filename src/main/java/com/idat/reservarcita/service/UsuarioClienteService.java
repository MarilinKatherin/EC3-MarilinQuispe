package com.idat.reservarcita.service;

import java.util.List;

import com.idat.reservarcita.dto.UsuarioClienteDTORequest;
import com.idat.reservarcita.dto.UsuarioClienteDTOResponse;

public interface UsuarioClienteService {
	void guardar(UsuarioClienteDTORequest UsuarioClientes);
	void actualizar(UsuarioClienteDTORequest UsuarioClientes);
	void eliminar(Integer id);	
	List<UsuarioClienteDTOResponse>listar();
	UsuarioClienteDTOResponse obtenerById(Integer id);
}
