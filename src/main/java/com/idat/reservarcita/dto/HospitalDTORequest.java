package com.idat.reservarcita.dto;

public class HospitalDTORequest {
	private Integer id;
	private String nombreHospital;
	private String detalleHospital;
	private String distritoHospital;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreHospital() {
		return nombreHospital;
	}
	public void setNombreHospital(String nombreHospital) {
		this.nombreHospital = nombreHospital;
	}
	public String getDetalleHospital() {
		return detalleHospital;
	}
	public void setDetalleHospital(String detalleHospital) {
		this.detalleHospital = detalleHospital;
	}
	public String getDistritoHospital() {
		return distritoHospital;
	}
	public void setDistritoHospital(String distritoHospital) {
		this.distritoHospital = distritoHospital;
	}
}
