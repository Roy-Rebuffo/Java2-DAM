package primero;

import java.util.Scanner;

public class MatrizRepetido {

	public static Scanner sc = new Scanner(System.in);

	public static int alea(int li, int ls) {// función (método)
		return (int) ((Math.round(Math.random() * (ls - li)) + li));
	}

	public static void main(String[] args) {
		int nf = 0;
		int nc = 0;

		System.out.println("nº filas");
		nf = Integer.valueOf(sc.nextLine());
		System.out.println("nº cols");
		nc = Integer.valueOf(sc.nextLine());
		
		int matriz[][] = new int[nf][nc];
		rellenar(matriz);
		imprimir(matriz);
	}

	public static void rellenar(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = alea(0, 10);
			}
		}
	}

	public static void imprimir(int m[][]) {
		int suma;
		int totales [] = new int[m[0].length];//nos da el largo de columnas de la fila 0
		
		for (int i = 0; i < m.length; i++) {
			suma = 0;// suma de filas
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%5d", m[i][j]);
				suma += m[i][j]; //suma las filas
				totales [j] += m[i][j]; //suma de columnas
			}
			System.out.printf("%5d\n %.2f\n", suma, (double) suma / m[i].length); // sacamos la suma de las filas y la media asi
		}
		/**********************************************************************************/
		// Imprimir totales por columna
		for (int i = 0; i < totales.length; i++) System.out.printf("%5d", totales[i]);
		System.out.println();

		// Imprimir medias por columna (con decimales)
		for (int i = 0; i < totales.length; i++) System.out.printf("%5.2f", (double) totales[i] / m.length);
		System.out.println();

	}
}
