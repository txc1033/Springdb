package com.javifast.acciones;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.javifast.beans.Equipo;
import com.javifast.service.ServiceEquipo;
import com.javifast.springbd.App;


public class CrudEquipo {
	 ApplicationContext appContext = new ClassPathXmlApplicationContext("com/javifast/xml/beans.xml");
	    ServiceEquipo service = (ServiceEquipo)appContext.getBean("serviceEquipoImpl");
	    Equipo equipo = (Equipo)appContext.getBean("equipo");
	    Scanner sc = new Scanner(System.in);
		public CrudEquipo(){   
	    try {
	    	int opcion;
	    	do {
	    		menuCrud();
	            opcion = sc.nextInt();
	    	switch(opcion) {
	    	case 1:
	    		agregarE();
	    		break;
	    	case 2:
	    		consultarE();
	    		break;
	    	case 3:
	    		modificarE();
	    		break;
	    	case 4:
	    		eliminarE();
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
		private void modificarE() throws Exception {
			try {
				System.out.println("Por favor ingrese id del equipo a modificar:");
				equipo.setId(sc.nextInt());
				service.consultar(equipo.getId());
				System.out.println("Se va modificar...");
				System.out.println("Por favor ingrese nombre del equipo a modificar:");
				equipo.setNombre(sc.next());
				service.modificar(equipo);
				service.consultar(equipo.getId());
			}catch(Exception e) {
				throw e;
			}
			
		}
		private void consultarE() throws Exception {
			try {
			int opcion;
			System.out.println("Por favor ingrese id del equipo que desea consultar\nen caso que desea consultar por todos ingrese 0");
			opcion = sc.nextInt();
			service.consultar(opcion);
			}catch(Exception e) {
				throw e;
			}
			
		}
		private void eliminarE() throws Exception {
			try {
			int opcion;
			System.out.println("Por favor ingrese id del equipo a Eliminar:");
			opcion = sc.nextInt();
			System.out.println("Esta Seguro que desea borrar a:");
			service.consultar(opcion);
			equipo.setId(opcion);
			System.out.println("Escriba S/N:");
			String del = sc.next();
			switch(del.toLowerCase()) {
			case "s":
			service.eliminar(equipo);
			break;
			case "n":
			System.out.println("Se a cancelado la eliminacion de id: "+equipo.getId());
			break;	
			}
			}catch(Exception e){
				throw e;
			}

			
		}
		private void agregarE() throws Exception {
	        try {
			System.out.println("Por favor ingrese id del equipo:");
			equipo.setId(sc.nextInt());
			System.out.println("Por favor ingrese nombre del equipo:");
			equipo.setNombre(sc.next());
			service.registrar(equipo);
	        }catch(Exception e) {
	        	throw e;
	        }
			
		}
		private void menuCrud() {
			System.out.println("**********Tabla Equipo************");
			System.out.println("* Porfavor seleccione una opcion *");
			System.out.println("*  1- Agregar   | 2- Consultar   *");
			System.out.println("*  3- Modificar | 4- Eliminar    *");
			System.out.println("*  0- Para salir del menu        *");
			System.out.println("**********************************");
		}
		
}
