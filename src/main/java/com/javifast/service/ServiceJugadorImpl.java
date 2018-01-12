package com.javifast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javifast.beans.Jugador;
import com.javifast.dao.DAOJugador;
import com.javifast.dao.DAOMarca;

@Service
public class ServiceJugadorImpl implements ServiceJugador {

	@Autowired
	private DAOJugador daoJugador;
	
	@Override
	public void registrar(Jugador jugador) throws Exception {
		try {
			boolean estado;
			estado = daoJugador.agregar(jugador);
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
	public void modificar(Jugador jugador) throws Exception {
		try {
			boolean estado;
			estado = daoJugador.modificar(jugador);
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
			List<Jugador> resultado = null;
			resultado = daoJugador.consultar(id);
			for (Jugador db : resultado) {
                System.out.println("*************************\n"+
			                       "Id consultada: "+db.getId()+
                		           "\nNombre: "+db.getNombre()+
                		           "\nCodigo de equipo: " + db.getEquipo().getId()+
                		           "\nCodigo de camiseta: " + db.getCamiseta().getId()+
                		           "\n*************************");
            }
			}catch(Exception e){
				throw e;
			}
			
		}

	@Override
	public void eliminar(Jugador jugador) throws Exception {
		try {
			boolean estado;
			estado = daoJugador.eliminar(jugador);
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
