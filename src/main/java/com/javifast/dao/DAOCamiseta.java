package com.javifast.dao;

import java.util.List;

import com.javifast.beans.Camiseta;

public interface DAOCamiseta {

	public boolean agregar(Camiseta camiseta) throws Exception;
	public boolean eliminar(Camiseta camiseta) throws Exception;
	public boolean modificar(Camiseta camiseta) throws Exception;
	public List<Camiseta> consultar(int id) throws Exception;
}
