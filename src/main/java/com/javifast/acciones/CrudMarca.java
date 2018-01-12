package com.javifast.acciones;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.javifast.beans.Marca;
import com.javifast.service.ServiceMarca;
import com.javifast.springbd.App;


public class CrudMarca {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("com/javifast/xml/beans.xml");
    ServiceMarca service = (ServiceMarca)appContext.getBean("serviceMarcaImpl");
    Marca marca = (Marca)appContext.getBean("marca");
    Scanner sc = new Scanner(System.in);
	public CrudMarca(){   
    try {
    	int opcion;
    	do {
    		menuCrud();
            opcion = sc.nextInt();
    	switch(opcion) {
    	case 1:
    		agregarM();
    		break;
    	case 2:
    		consultarM();
    		break;
    	case 3:
    		modificarM();
    		break;
    	case 4:
    		eliminarM();
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
	private void modificarM() throws Exception {
		try {
			System.out.println("Por favor ingrese id de la marca a modificar:");
			marca.setId(sc.nextInt());
			service.consultar(marca.getId());
			System.out.println("Se va modificar...");
			System.out.println("Por favor ingrese nombre de la marca a modificar:");
			marca.setNombre(sc.next());
			service.modificar(marca);
			service.consultar(marca.getId());
		}catch(Exception e) {
			throw e;
		}
		
	}
	private void consultarM() throws Exception {
		try {
		int opcion;
		System.out.println("Por favor ingrese id de la marca que desea consultar\nen caso que desea consultar por todos ingrese 0");
		opcion = sc.nextInt();
		service.consultar(opcion);
		}catch(Exception e) {
			throw e;
		}
		
	}
	private void eliminarM() throws Exception {
		try {
		int opcion;
		System.out.println("Por favor ingrese id de la  marca a Eliminar:");
		opcion = sc.nextInt();
		System.out.println("Esta Seguro que desea borrar a:");
		service.consultar(opcion);
		marca.setId(opcion);
		System.out.println("Escriba S/N:");
		String del = sc.next();
		switch(del.toLowerCase()) {
		case "s":
		service.eliminar(marca);
		break;
		case "n":
		System.out.println("Se a cancelado la eliminacion de id: "+marca.getId());
		break;	
		}
		}catch(Exception e){
			throw e;
		}

		
	}
	private void agregarM() throws Exception {
        try {
		System.out.println("Por favor ingrese id de la marca:");
		marca.setId(sc.nextInt());
		System.out.println("Por favor ingrese nombre de la marca:");
		marca.setNombre(sc.next());
		service.registrar(marca);
        }catch(Exception e) {
        	throw e;
        }
		
	}
	private void menuCrud() {
		System.out.println("**********Tabla Marca*************");
		System.out.println("* Porfavor seleccione una opcion *");
		System.out.println("*   1- Agregar   | 2- Consultar  *");
		System.out.println("*   3- Modificar | 4- Eliminar   *");
		System.out.println("*   0- Para salir del menu       *");
		System.out.println("**********************************");
	}
	
}
