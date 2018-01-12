package com.javifast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javifast.beans.Jugador;
import com.javifast.beans.Marca;
import com.javifast.dao.DAOMarca;

@Service // se marca la implementacion como servicio para llevar un orden de las capas
public class ServiceMarcaImpl implements ServiceMarca{

	@Autowired
	private DAOMarca daoMarca;
	
	@Override
	public void registrar(Marca marca) throws Exception {
		try {
			boolean estado;
			estado = daoMarca.agregar(marca);
			if(estado == true) {
				System.out.println("Dato agregado");
				}else {
				System.out.println("No se pudo agregar");
				}
			}catch(Exception e){
				throw e;
			}
		
		
	}

	@Override
	public void modificar(Marca marca) throws Exception {
		try {
			boolean estado;
			estado = daoMarca.modificar(marca);
			if(estado == true) {
			System.out.println("Dato modificado");
			}else {
			System.out.println("No se pudo modificar");
			}
			}catch(Exception e){
				throw e;
			}
		
	}

	@Override
	public void consultar(int id) throws Exception {
		try {
			List<Marca> resultado = null;
			resultado = daoMarca.consultar(id);
			for (Marca db : resultado) {
                System.out.println("*************************\n"+
			                       "Id consultada: "+db.getId()+
                		           "\nMarca: "+db.getNombre()+
                		           "\n*************************");
            }
			}catch(Exception e){
				throw e;
			}
			
		}

	@Override
	public void eliminar(Marca marca) throws Exception {
		try {
			boolean estado;
			estado = daoMarca.eliminar(marca);
			if(estado == true) {
				System.out.println("Dato eliminado");
				}else {
				System.out.println("No se pudo eliminar");
				}
			}catch(Exception e){
				throw e;
			}
		
	}

}
