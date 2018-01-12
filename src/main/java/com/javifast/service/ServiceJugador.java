package com.javifast.service;


import com.javifast.beans.Jugador;

public interface ServiceJugador {

	public void registrar(Jugador jugador) throws Exception;
	public void eliminar(Jugador jugador) throws Exception;
	public void modificar(Jugador jugador) throws Exception;
	public void consultar(int id) throws Exception;
	
}
