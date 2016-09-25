package com.upc.dto;

public class Curso {
	private int idCurso;
	private String Nombre;
	private Categoria idCategoria;
	private String Monto;
	
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getMonto() {
		return Monto;
	}

	public void setMonto(String monto) {
		Monto = monto;
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", Nombre=" + Nombre + ", idCategoria=" + idCategoria + ", Monto=" + Monto
				+ "]";
	}
}