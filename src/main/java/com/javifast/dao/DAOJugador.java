package com.javifast.dao;

import java.util.List;

import com.javifast.beans.Jugador;

public interface DAOJugador {

	public boolean agregar(Jugador jugador) throws Exception;
	public boolean eliminar(Jugador jugador) throws Exception;
	public boolean modificar(Jugador jugador) throws Exception;
	public List<Jugador> consultar(int id) throws Exception;
	
}
