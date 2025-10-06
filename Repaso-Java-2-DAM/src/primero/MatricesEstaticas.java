//matrices estaticas
//pedir por pantalla el numero de filas y el numero de cols
//crear una matriz bidimensional con esas dimensiones
//rellenarlas con numeros aleatorios de 0 a 10
//imprimir la matriz en la que esten inculidas de los valores por fila y la suma de los valores por col.
//calcular medias por filas y columnas

package primero;

public class MatricesEstaticas {
	
	public static int tb[][] = new int [3][3];
	
	public static int alea(int li, int ls) {//función (método)
        return (int) ((Math.round(Math.random() * (ls - li)) + li));
    }

	public static void rellenarTB() {
		for (int i = 0; i < tb.length; i++) {
			for (int j = 0; j < tb[i].length; j++) {
				tb[i][j] = alea(0,10);
			}
		}
	}
	
	public static void visualizar() {
		for (int i = 0; i < tb.length; i++) {
			for (int j = 0; j < tb[i].length; j++) {
				System.out.print("   " +tb[i][j]);//Espacio "  " +... entre filas y cols
			}
			System.out.println();//Salto de linea
		}
	}
	
	public static void sumarFilas() {
	    for (int i = 0; i < tb.length; i++) {
	        int sumaFila = 0; // acumulador POR FILA, iniciamos dentro del bucle para que no acumule las filas y se reinicie por "vuelta"
	        for (int j = 0; j < tb[i].length; j++) {
	            sumaFila += tb[i][j]; 
	        }
	        System.out.println("Suma de la fila " + i + ": " + sumaFila);
	    }
	}
	
	public static void sumarCols() {
	    for (int j = 0; j < tb[0].length; j++) {
	    	int cols = 0; // acumulador por columna, iniciamos dentro del bucle para que no acumule las cols y se reinicie por "vuelta"
	        for (int i = 0; i < tb.length; i++) {
	        	cols += tb[i][j];
	        }
	        System.out.println("Suma de la columna " + j + ": " + cols);
	    }
	}

	public static void media() {
	    double mediaRows =0;
	    double mediaCols = 0;
	    // recorrer filas
	    for (int i = 0; i < tb.length; i++) {//iniciamos dentro del bucle para que no acumule las filas y se reinicie por "vuelta"
	        int t_rows = 0;
	        int c_rows = 0;
	        for (int j = 0; j < tb[i].length; j++) {
	            t_rows += tb[i][j];
	            c_rows++;
	        }
	        mediaRows = (double) t_rows / c_rows;
	        System.out.printf("Media fila %d: %.2f\n", i, mediaRows);
	    }

	    // recorrer columnas
	    for (int j = 0; j < tb[0].length; j++) {//iniciamos dentro del bucle para que no acumule las filas y se reinicie por "vuelta"
	    		int t_cols = 0;
	    		int c_cols = 0;
	        for (int i = 0; i < tb.length; i++) {
	            t_cols += tb[i][j];
	            c_cols++;
	        }
	        mediaCols = (double) t_cols / c_cols;
	        System.out.printf("Media columna es: %.2f\n", mediaCols);
	    }
	}
	
	public static void main(String[] args) {
		rellenarTB();
		visualizar();
		sumarFilas();
		sumarCols();
		media();
	}
}
