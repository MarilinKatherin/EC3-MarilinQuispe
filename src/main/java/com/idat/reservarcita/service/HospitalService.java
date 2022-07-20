package com.idat.reservarcita.service;

import java.util.List;

import com.idat.reservarcita.dto.HospitalDTORequest;
import com.idat.reservarcita.dto.HospitalDTOResponse;

public interface HospitalService {
	void guardar(HospitalDTORequest Hospitals);
	void actualizar(HospitalDTORequest Hospitals);
	void eliminar(Integer id);	
	List<HospitalDTOResponse>listar();
	HospitalDTOResponse obtenerById(Integer id);
}
