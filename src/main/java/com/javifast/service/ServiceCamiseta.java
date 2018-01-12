package com.javifast.service;

import com.javifast.beans.Camiseta;

public interface ServiceCamiseta {
 
	public void registrar(Camiseta camiseta) throws Exception;
	public void eliminar(Camiseta camiseta) throws Exception;
	public void modificar(Camiseta camiseta) throws Exception;
	public void consultar(int id) throws Exception;
}
