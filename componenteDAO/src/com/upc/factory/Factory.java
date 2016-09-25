package com.upc.factory;

import com.upc.dao.ICategoriadao;
import com.upc.dao.ICursodao;
import com.upc.dao.IInscripciondao;
import com.upc.dao.ITemariodao;
import com.upc.dao.IUsuariodao;
import com.upc.dao.impl.Categoriadao;
import com.upc.dao.impl.Cursodao;
import com.upc.dao.impl.Inscripciondao;
import com.upc.dao.impl.Temariodao;
import com.upc.dao.impl.Usuariodao;

public class Factory {
	// Implementacion de singleton
	private static Factory fac;

	private Factory() {

	}

	public static Factory getInstance() {
		if (fac == null)
			fac = new Factory();
		return fac;
	}
	
	public ICategoriadao getCategoriadao()
	{
		return new Categoriadao();
	}
	
	public ICursodao getCursodao()
	{
		return new Cursodao();
	}
	
	public IInscripciondao getInscripciondao()
	{
		return new Inscripciondao();
	}
	
	public ITemariodao getTemariodao()
	{
		return new Temariodao();
	}
	
	public IUsuariodao getUsuariodao()
	{
		return new Usuariodao();
	}
}
