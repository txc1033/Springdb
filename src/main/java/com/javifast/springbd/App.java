package com.javifast.springbd;

import java.util.Scanner;

import com.javifast.acciones.*;


/**
 * Hello world!
 *
 */
public class App 
{
	@SuppressWarnings("static-access")
	public App() {
		String[] javifast = new String[2];
		javifast[0] = "txc1033";
		this.main(javifast[1]);
	}
    public static void main(String... JavierMS)
    {       
      Scanner sc = new Scanner(System.in);
      menuInicial();
      int opcion = sc.nextInt();
      do {
    	  switch(opcion) {
    	  case 1:
    	  new  CrudJugador();
    	  break;
    	  case 2:
    	  new CrudEquipo();	  
          break;
    	  case 3:
    	  new CrudCamiseta();  
          break;	  
    	  case 4:
    	  new CrudMarca();	  
          break;
    	  case 0:
    		  System.out.println("Cerrando la aplicacion...");
    		  System.exit(0);
          break;
          default:
        	  System.out.println("Opcion no valida!!");
    	  }
      }while(opcion!=0);
    }

	private static void menuInicial() {
		System.out.println("************Editor de Tablas***************");
		System.out.println("* Bienvenido con que tabla desea trabajar *");
		System.out.println("*     1- Jugador    | 2- Equipo           *");
		System.out.println("*     3-  Camiseta  | 4- Marca            *");
		System.out.println("*     0- Para salir de la aplicacion      *");
		System.out.println("*******************************************");
		
	}
}
