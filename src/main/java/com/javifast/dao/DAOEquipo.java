package com.javifast.dao;

import java.util.List;

import com.javifast.beans.Equipo;

public interface DAOEquipo {
	public boolean agregar(Equipo equipo) throws Exception;
	public boolean eliminar(Equipo equipo) throws Exception;
	public boolean modificar(Equipo equipo) throws Exception;
	public List<Equipo> consultar(int id) throws Exception;
}
