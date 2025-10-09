//HACER CLASE ABSTRACTA FIGURA GEOMÉTRICA
//CUYO ATRIBUTO SEA DATO 1, DE TIPO DOUBLE (RADIO)
//TIENE QUE INCORPORAR DOS METODOS ABSTRACTOS QUE SEAN EL AREA Y EL PERIMETRO
//CLASES ABSTRACTAS SON CLASES QUE NO SE PUEDEN INSTANCIAR
//METODOS ESTATICOS QUE CUANDO SE HEREDAN SE TIENEN QUE IMPLEMENTAR

//hacer un cuadrado de figura geo
//hacer un triangulo (nuevo atr. altura)

package primero;

import Clases.Biblioteca;

public class ejer12 {
	public static void main(String[] args) {
		System.out.println("NÚMERO -> 10.24567 \n->REDONDEAMOS 2 DECIMALES\n");
		System.out.println("REDONDEAR-> "+Biblioteca.redondear(10.24567,2));
		System.out.println("TRUNCAR-> "+ Biblioteca.truncar(10.24367,2)); 
	}
}
