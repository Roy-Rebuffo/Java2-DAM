package primero;

public class ejer02 {
	
	public static int alea(int li,int ls) {
		return (int)(Math.random()*(ls-li+1))+li;
	}
	
	public static void main(String[] args) {
		int nu;
		for(int i=1; i<=25; i++) {
			nu=alea(100,500);
			System.out.printf("El nº %d pertenece a la %d decena\n",
					nu,decena(nu));
		}
	}
	public static int decena(int n) {
		return (int)((n-1)/10)+1; 
	}
}


