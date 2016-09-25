package com.upc.dto;

public class Inscripcion {
	private int idInscripcion;
	private String Fecha_inscripcion;
	private Usuario idUsuario;
	private Curso idCurso;

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public String getFecha_inscripcion() {
		return Fecha_inscripcion;
	}

	public void setFecha_inscripcion(String fecha_inscripcion) {
		Fecha_inscripcion = fecha_inscripcion;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", Fecha_inscripcion=" + Fecha_inscripcion
				+ ", idUsuario=" + idUsuario + ", idCurso=" + idCurso + "]";
	}
}