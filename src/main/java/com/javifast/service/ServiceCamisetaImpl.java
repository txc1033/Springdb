package com.javifast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javifast.beans.Camiseta;
import com.javifast.dao.DAOCamiseta;

@Service
public class ServiceCamisetaImpl implements ServiceCamiseta{

	@Autowired
	private DAOCamiseta daoCamiseta;
	
	@Override
	public void registrar(Camiseta camiseta) throws Exception {
		try {
			boolean estado;
			estado = daoCamiseta.agregar(camiseta);
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
	public void eliminar(Camiseta camiseta) throws Exception {
		try {
			boolean estado;
			estado = daoCamiseta.eliminar(camiseta);
			if(estado == true) {
				System.out.println("Dato eliminado");
				}else {
				System.out.println("No se pudo eliminar");
				}
			}catch(Exception e){
				throw e;
			}
	}

	@Override
	public void modificar(Camiseta camiseta) throws Exception {
		try {
			boolean estado;
			estado = daoCamiseta.modificar(camiseta);
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
			List<Camiseta> resultado = null;
			resultado = daoCamiseta.consultar(id);
			for (Camiseta db : resultado) {
                System.out.println("*************************\n"+
			                       "Id consultada: "+db.getId()+
                		           "\nNumero: "+db.getNumero()+
                		           "\nId De La Marca: "+db.getMarca().getId()+
                		           "\n*************************");
            }
			}catch(Exception e){
				throw e;
			}
	}

}
