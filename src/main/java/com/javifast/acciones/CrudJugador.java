package com.javifast.acciones;

import java.util.Scanner;
import com.javifast.beans.Camiseta;
import com.javifast.beans.Equipo;
import com.javifast.beans.Jugador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javifast.service.ServiceJugador;
import com.javifast.springbd.App;

public class CrudJugador {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("com/javifast/xml/beans.xml");
    ServiceJugador service = (ServiceJugador)appContext.getBean("serviceJugadorImpl");
    Jugador jugador = (Jugador)appContext.getBean("jugador");
    Scanner sc = new Scanner(System.in);
	public CrudJugador(){   
    try {
    	int opcion;
    	do {
    		menuCrud();
            opcion = sc.nextInt();
    	switch(opcion) {
    	case 1:
    		agregarJ();
    		break;
    	case 2:
    		consultarJ();
    		break;
    	case 3:
    		modificarJ();
    		break;
    	case 4:
    		eliminarJ();
    		break;
    	case 0:
    		new App();
    	break;
    	default:
    		System.out.println("Opcion no valida!!");
    	}
    	
    	}while(opcion!=0);
    }catch(Exception e) {
    	System.out.println(e.getMessage());
    }
	
	}
	private void modificarJ() throws Exception {
		try {
			Equipo eq = new Equipo();
			Camiseta ca = new Camiseta();
			System.out.println("Por favor ingrese id del jugador a modificar:");
			jugador.setId(sc.nextInt());
			service.consultar(jugador.getId());
			System.out.println("Se va modificar...");
			System.out.println("Por favor ingrese nombre del jugador a modificar:");
			jugador.setNombre(sc.next());
			System.out.println("Por favor ingrese id del Equipo para el jugador a modificar:");
			eq.setId(sc.nextInt());
			jugador.setEquipo(eq);
			System.out.println("Por favor ingrese id de la Camiseta para el jugador a modificar:");
			ca.setId(sc.nextInt());
			jugador.setCamiseta(ca);
			service.modificar(jugador);
			service.consultar(jugador.getId());
		}catch(Exception e) {
			throw e;
		}
		
	}
	private void consultarJ() throws Exception {
		try {
		int opcion;
		System.out.println("Por favor ingrese id del jugador que desea consultar\nen caso que desea consultar por todos ingrese 0");
		opcion = sc.nextInt();
		service.consultar(opcion);
		}catch(Exception e) {
			throw e;
		}
		
	}
	private void eliminarJ() throws Exception {
		try {
		int opcion;
		System.out.println("Por favor ingrese id del jugador a Eliminar:");
		opcion = sc.nextInt();
		System.out.println("Esta Seguro que desea borrar a:");
		service.consultar(opcion);
		jugador.setId(opcion);
		System.out.println("Escriba S/N:");
		String del = sc.next();
		switch(del.toLowerCase()) {
		case "s":
		service.eliminar(jugador);
		break;
		case "n":
		System.out.println("Se a cancelado la eliminacion de id: "+jugador.getId());
		break;	
		}
		}catch(Exception e){
			throw e;
		}

		
	}
	private void agregarJ() throws Exception {
        try {
		Equipo eq = new Equipo();
		Camiseta ca = new Camiseta();
		System.out.println("Por favor ingrese id del jugador:");
		jugador.setId(sc.nextInt());
		System.out.println("Por favor ingrese nombre del jugador:");
		jugador.setNombre(sc.next());
		System.out.println("Por favor ingrese id del Equipo para el jugador:");
		eq.setId(sc.nextInt());
		jugador.setEquipo(eq);
		System.out.println("Por favor ingrese id de la Camiseta para el jugador:");
		ca.setId(sc.nextInt());
		jugador.setCamiseta(ca);
		service.registrar(jugador);
        }catch(Exception e) {
        	throw e;
        }
		
	}
	private void menuCrud() {
		System.out.println("**********Tabla Jugador***********");
		System.out.println("* Porfavor seleccione una opcion *");
		System.out.println("* 1- Agregar   | 2- Consultar    *");
		System.out.println("* 3- Modificar | 4- Eliminar     *");
		System.out.println("* 0- Para salir del menu         *");
		System.out.println("**********************************");
	}
	
}
