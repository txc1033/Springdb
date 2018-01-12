package com.javifast.acciones;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javifast.beans.Camiseta;
import com.javifast.beans.Marca;
import com.javifast.service.ServiceCamiseta;
import com.javifast.springbd.App;

public class CrudCamiseta {

	ApplicationContext appContext = new ClassPathXmlApplicationContext("com/javifast/xml/beans.xml");
    ServiceCamiseta service = (ServiceCamiseta)appContext.getBean("serviceCamisetaImpl");
    Camiseta marca = (Camiseta)appContext.getBean("camiseta");
    Scanner sc = new Scanner(System.in);
	public CrudCamiseta(){   
    try {
    	int opcion;
    	do {
    		menuCrud();
            opcion = sc.nextInt();
    	switch(opcion) {
    	case 1:
    		agregarC();
    		break;
    	case 2:
    		consultarC();
    		break;
    	case 3:
    		modificarC();
    		break;
    	case 4:
    		eliminarC();
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
	private void modificarC() throws Exception {
		try {
			Marca ma = new Marca();
			System.out.println("Por favor ingrese id de la camiseta a modificar:");
			marca.setId(sc.nextInt());
			service.consultar(marca.getId());
			System.out.println("Se va modificar...");
			System.out.println("Por favor ingrese el numero de la camiseta a modificar:");
			marca.setNumero(sc.next());
			System.out.println("Por favor ingrese id de la  marca para la camiseta a modificar:");
			ma.setId(sc.nextInt());
			marca.setMarca(ma);
			service.modificar(marca);
			service.consultar(marca.getId());
		}catch(Exception e) {
			throw e;
		}
		
	}
	private void consultarC() throws Exception {
		try {
		int opcion;
		System.out.println("Por favor ingrese id de la camiseta que desea consultar\nen caso que desea consultar por todos ingrese 0");
		opcion = sc.nextInt();
		service.consultar(opcion);
		}catch(Exception e) {
			throw e;
		}
		
	}
	private void eliminarC() throws Exception {
		try {
		int opcion;
		System.out.println("Por favor ingrese id de la  camiseta a Eliminar:");
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
	private void agregarC() throws Exception {
        try {
		Marca ma = new Marca();
		System.out.println("Por favor ingrese id de la camiseta:");
		marca.setId(sc.nextInt());
		System.out.println("Por favor ingrese el numero de la camiseta:");
		marca.setNumero(sc.next());
		System.out.println("Por favor ingrese id de la marca para la camiseta:");
		ma.setId(sc.nextInt());
		marca.setMarca(ma);
		service.registrar(marca);
        }catch(Exception e) {
        	throw e;
        }
		
	}
	private void menuCrud() {
		System.out.println("*********Tabla Camiseta***********");
		System.out.println("* Porfavor seleccione una opcion *");
		System.out.println("* 1- Agregar   | 2- Consultar    *");
		System.out.println("* 3- Modificar | 4- Eliminar     *");
		System.out.println("* 0- Para salir del menu         *");
		System.out.println("**********************************");
	}
	
}
