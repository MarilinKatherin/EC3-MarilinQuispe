package com.idat.reservarcita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.reservarcita.dto.HospitalDTORequest;
import com.idat.reservarcita.dto.HospitalDTOResponse;
import com.idat.reservarcita.model.Hospital;
import com.idat.reservarcita.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	HospitalRepository repository;
	@Override
	public void guardar(HospitalDTORequest HospitalDTO) {
		Hospital hospital=new Hospital();		
		hospital.setNombre(HospitalDTO.getNombreHospital());
		hospital.setDescripcion(HospitalDTO.getDetalleHospital());
		hospital.setDistrito(HospitalDTO.getDistritoHospital());		
		repository.save(hospital);		
	}

	@Override
	public void actualizar(HospitalDTORequest HospitalDTO) {
		Hospital hospital=new Hospital();	
		hospital.setIdHospital(HospitalDTO.getId());
		hospital.setNombre(HospitalDTO.getNombreHospital());
		hospital.setDescripcion(HospitalDTO.getDetalleHospital());
		hospital.setDistrito(HospitalDTO.getDistritoHospital());		
		repository.saveAndFlush(hospital);		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listar() {
		List<HospitalDTOResponse> listar=new ArrayList<>();
		HospitalDTOResponse dto=null;
		List<Hospital> p=repository.findAll();
		for(Hospital hospital:p) {
			dto=new HospitalDTOResponse();
			dto.setId(hospital.getIdHospital());
			dto.setNombreHospital(hospital.getNombre());
			dto.setDetalleHospital(hospital.getDescripcion());
			dto.setDistritoHospital(hospital.getDistrito());
			listar.add(dto);			
		}
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerById(Integer id) {
		Hospital hospital=repository.findById(id).orElse(null);
		HospitalDTOResponse dto=null;
		dto=new HospitalDTOResponse();
		dto.setId(hospital.getIdHospital());
		dto.setNombreHospital(hospital.getNombre());
		dto.setDetalleHospital(hospital.getDescripcion());
		dto.setDistritoHospital(hospital.getDistrito());
		return dto;
	}

}
