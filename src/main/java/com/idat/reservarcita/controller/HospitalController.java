package com.idat.reservarcita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.idat.reservarcita.dto.HospitalDTORequest;
import com.idat.reservarcita.dto.HospitalDTOResponse;
import com.idat.reservarcita.service.HospitalService;

@Controller
@RequestMapping("/hospital/v1")
public class HospitalController {
	@Autowired
	private HospitalService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<HospitalDTOResponse>> listar() {
		return new ResponseEntity<List<HospitalDTOResponse>>( service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody HospitalDTORequest hospitals) {
		service.guardar(hospitals);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		HospitalDTOResponse p=service.obtenerById(id);
		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody HospitalDTORequest hospitals) {
		HospitalDTOResponse p=service.obtenerById(hospitals.getId());
		
		if(p != null) {
			service.actualizar(hospitals);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<HospitalDTOResponse> obtenerID(@PathVariable Integer id) {
		HospitalDTOResponse p=service.obtenerById(id);
		if(p != null) {			
			return new ResponseEntity<HospitalDTOResponse>(service.obtenerById(id),HttpStatus.OK);
		}
		return new ResponseEntity<HospitalDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
