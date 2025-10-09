package primero;

import java.util.ArrayList;
import java.util.Scanner;

import Clases.*; //Ponemos asterisco para que herede lo del padre e hijos 

public class PrincipalHerenciaFG {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void submenu(ArrayList<FiguraGeometrica> f) {
		String[] items = {"1.-Cuadrado","2.-Rectangulo","3.-Cubo","4.-Circulo", "5.-Salir"};
		String basura;
		double vdato1,vdato2;
		boolean seguir = true;
		int opcion;
		while(seguir) {
			opcion = Biblioteca.menu(sc, items);
			switch(opcion) {
			case 1: //cuadrado
				System.out.print("Dime el lado:");
				vdato1 = Double.valueOf(sc.nextLine());
				f.add(new Cuadrado (vdato1));
				break;
			case 2: //rectangulo
				System.out.print("Dime el lado");
				vdato1 = Double.valueOf(sc.nextLine());
				System.out.print("Dime la altura");
				vdato2 = Double.valueOf(sc.nextLine());
				f.add(new Rectangulo (vdato1,vdato2));
				break;
			case 3: //cubo
				System.out.print("Dime el lado del cubo");
				vdato1 = Double.valueOf(sc.nextLine());
				f.add(new Cubo (vdato1));
				break;
			case 4: //circulo
				System.out.print("Dime el radio");
				vdato1 = Double.valueOf(sc.nextLine());
				f.add(new Circulo (vdato1));
				break;
			case 5: 
				seguir = false;
				break;
			}
			if(opcion !=5) {
				System.out.println("Pulse una tecla para continuar");
				basura = sc.nextLine();
			}
		}
	}

	public static void imprimir(FiguraGeometrica fg) {//le pasamos el array por parámetro
			System.out.printf("Perimetro = %.2f\n Area = %.2f\n %s\n",fg.perimetro(),fg.area(),fg.toString());
	}
	
	public static void cuantos(ArrayList<FiguraGeometrica> f) {
		int ncubos = 0, ncuadrados = 0, ncirculos = 0, nrectangulos = 0;
		for(FiguraGeometrica figu : f) {
			if(figu instanceof Cubo) {
				ncubos ++;
				imprimir(figu);
			} else if (figu instanceof Cuadrado) {
				ncuadrados++;
				imprimir(figu);
			} else if (figu instanceof Rectangulo) {
				nrectangulos++;
				imprimir(figu);
			} else if (figu instanceof Circulo) {
				ncirculos++;
				imprimir(figu);
			}
		}
		System.out.print("Cubo" + ncubos);
	}
	
	public static void imprimir(ArrayList<FiguraGeometrica> f, String cual) {
		for(FiguraGeometrica figu : f) {
			if(cual.compareToIgnoreCase("CUBO")==0 && figu instanceof Cubo) {
				imprimir(figu);
			} else if (cual.compareToIgnoreCase("CUADRADO")==0 && figu instanceof Cuadrado) {
				imprimir(figu);
			} else if (cual.compareToIgnoreCase("RECTANGULO")==0 && figu instanceof Rectangulo) {
				imprimir(figu);
			} else if (cual.compareToIgnoreCase("CIRCULO")==0 && figu instanceof Circulo) {
				imprimir(figu);
			}
		}
	}
	
	public static void imprimir(ArrayList<FiguraGeometrica> f) {
		for(FiguraGeometrica figu : f) {
			System.out.printf("perimetro=%.2f area=%.2f %s \n", figu.perimetro(),figu.area(), figu.toString());
			if(figu instanceof Cubo)
				System.out.println("Volumen= " + ((Cubo) figu).Volumen());
		}
	}
	
	public static void main(String[] args) {
		ArrayList<FiguraGeometrica> figuras = new ArrayList <FiguraGeometrica>(); //se va como parametro al metodo imprimir	
		
		int opcion;
		String basura;
		boolean seguir = true;
		String cual = "";
		String[] opciones = {"1. -Añadir FG", "2.-Listar", "3.-Ver FG", "4.-Salir"};
		
		while(seguir) {
			opcion = Biblioteca.menu(sc, opciones);
			switch(opcion) {
			case 1: //añadir
				submenu(figuras);
				break;
			case 2: //listar
				imprimir(figuras);
				break;
			case 3: //ver
				System.out.print("Dime el tipo de figura: ");
				cual = sc.nextLine();
				imprimir(figuras,cual.toUpperCase());
				break;
			case 4: 
				seguir = false;
				break;
			}
			if(opcion !=3) {
				System.out.println("Pulse una tecla para continuar");
				basura = sc.nextLine();
			}
		}

		//creamos obj. circulo
		figuras.add(new Circulo(10));
		figuras.add(new Circulo(20));
		figuras.add(new Circulo(30));
		//creamos obj. rectangulo
		figuras.add(new Rectangulo(2,10));
		figuras.add(new Rectangulo(12,100));
		figuras.add(new Rectangulo(28,109));
		//creamos obj. cuadrado
		figuras.add(new Cuadrado(2));
		figuras.add(new Cuadrado(12));
		figuras.add(new Cuadrado(28));
		
		figuras.add(new Cubo(2));
		figuras.add(new Cubo(12));
		figuras.add(new Cubo(28));

		cuantos(figuras);
	}
}