package com.javifast.dao;

import java.util.List;

import com.javifast.beans.Marca;

public interface DAOMarca {

	public boolean agregar(Marca marca) throws Exception;
	public boolean eliminar(Marca marca) throws Exception;
	public boolean modificar(Marca marca) throws Exception;
	public List<Marca> consultar(int id) throws Exception;
}
