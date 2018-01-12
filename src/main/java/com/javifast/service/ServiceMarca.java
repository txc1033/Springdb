package com.javifast.service;

import com.javifast.beans.Marca;

public interface ServiceMarca {

	public void registrar(Marca marca) throws Exception;
	public void eliminar(Marca marca) throws Exception;
	public void modificar(Marca marca) throws Exception;
	public void consultar(int id) throws Exception;
}
