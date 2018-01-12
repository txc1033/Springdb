package com.javifast.service;

import com.javifast.beans.Equipo;

public interface ServiceEquipo {

	public void registrar(Equipo equipo) throws Exception;
	public void eliminar(Equipo equipo) throws Exception;
	public void modificar(Equipo equipo) throws Exception;
	public void consultar(int id) throws Exception;
	
}
