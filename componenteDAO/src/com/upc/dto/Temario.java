package com.upc.dto;

public class Temario {
	private int idTemario;
	private String nombre;
	private Curso idCurso;

	public int getIdTemario() {
		return idTemario;
	}

	public void setIdTemario(int idTemario) {
		this.idTemario = idTemario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public String toString() {
		return "Temario [idTemario=" + idTemario + ", nombre=" + nombre + ", idCurso="
				+ idCurso + "]";
	}
}