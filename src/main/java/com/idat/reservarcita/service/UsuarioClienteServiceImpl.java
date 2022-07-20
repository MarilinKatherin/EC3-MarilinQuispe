package com.idat.reservarcita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.idat.reservarcita.dto.UsuarioClienteDTORequest;
import com.idat.reservarcita.dto.UsuarioClienteDTOResponse;
import com.idat.reservarcita.model.UsuarioCliente;
import com.idat.reservarcita.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService{

	private UsuarioClienteRepository repository;
	@Override
	public void guardar(UsuarioClienteDTORequest UsuarioClienteDTO) {
		UsuarioCliente usuarioCliente=new UsuarioCliente();		
		usuarioCliente.setUsuario(UsuarioClienteDTO.getUser());
		usuarioCliente.setPassword(UsuarioClienteDTO.getContraseña());
		usuarioCliente.setRol(UsuarioClienteDTO.getRoles());
		repository.save(usuarioCliente);		
	}

	@Override
	public void actualizar(UsuarioClienteDTORequest UsuarioClienteDTO) {
		UsuarioCliente usuarioCliente=new UsuarioCliente();
		usuarioCliente.setIdUsuario(UsuarioClienteDTO.getId());
		usuarioCliente.setUsuario(UsuarioClienteDTO.getUser());
		usuarioCliente.setPassword(UsuarioClienteDTO.getContraseña());
		usuarioCliente.setRol(UsuarioClienteDTO.getRoles());
		repository.saveAndFlush(usuarioCliente);
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public List<UsuarioClienteDTOResponse> listar() {
		List<UsuarioClienteDTOResponse> listar=new ArrayList<>();
		UsuarioClienteDTOResponse dto=null;
		List<UsuarioCliente> p=repository.findAll();
		
		for(UsuarioCliente usuarioCliente:p) {
			dto=new UsuarioClienteDTOResponse();
			dto.setId(usuarioCliente.getIdUsuario());
			dto.setUser(usuarioCliente.getUsuario());
			dto.setContraseña(usuarioCliente.getPassword());
			dto.setRoles(usuarioCliente.getRol());
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public UsuarioClienteDTOResponse obtenerById(Integer id) {
		UsuarioCliente usuarioCliente=repository.findById(id).orElse(null);
		UsuarioClienteDTOResponse dto=null;
		dto=new UsuarioClienteDTOResponse();
		dto.setId(usuarioCliente.getIdUsuario());
		dto.setUser(usuarioCliente.getUsuario());
		dto.setContraseña(usuarioCliente.getPassword());
		dto.setRoles(usuarioCliente.getRol());
		return dto;
	}

}
