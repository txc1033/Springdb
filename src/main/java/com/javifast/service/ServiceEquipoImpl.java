package com.javifast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javifast.beans.Equipo;
import com.javifast.beans.Marca;
import com.javifast.dao.DAOEquipo;

@Service
public class ServiceEquipoImpl implements ServiceEquipo {

	@Autowired
	private DAOEquipo daoEquipo;
	
	@Override
	public void registrar(Equipo equipo) throws Exception {
		try {
			boolean estado;
			estado = daoEquipo.agregar(equipo);
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
	public void eliminar(Equipo equipo) throws Exception {
		try {
			boolean estado;
			estado = daoEquipo.eliminar(equipo);
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
	public void modificar(Equipo equipo) throws Exception {
		try {
			boolean estado;
			estado = daoEquipo.modificar(equipo);
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
			List<Equipo> resultado = null;
			resultado = daoEquipo.consultar(id);
			for (Equipo db : resultado) {
                System.out.println("*************************\n"+
			                       "Id consultada: "+db.getId()+
                		           "\nEquipo: "+db.getNombre()+
                		           "\n*************************");
            }
			}catch(Exception e){
				throw e;
			}
	}

}
