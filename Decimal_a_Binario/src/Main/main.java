//Pedir con scanner un puesto de red ej. 192.168.10.0
//Pedir la mascara de red ej. 255.255.255.0
//Pretendemos que nuestro desarrollo nos de la ip de red y la ip de broadcast
//Y la ip de un puesto dado (dime la ip del puesto 100)

package Main;

public class main {
	
	public static int bin_a_dec(String binario) {
		int c=0,numero=0;
		for(int i=binario.length()-1;i>=0;i--)
		numero +=Integer.valueOf(binario.substring(i,i+1))*Math.pow(2,c++);
		
		return numero;
	}
	public static String dec_a_binario(int n) {
		String cadena=dec_a_binario2(n);
		return "0".repeat(8-cadena.length())+cadena;
	}
	
	public static String dec_a_binario2(int n) {
		String cadena="";
		int resto;
		while(n>0) {
		     	resto=n%2;
		     	n=n/2;
		     	cadena =String.valueOf(resto)+cadena;
		}
		return cadena;
		
	}
	
public static void main(String[] args) {
	System.out.println(bin_a_dec("11111111"));
	
	String ip="192.168.1.10";
	String mascara="255.255.255.0";
	String[] matrizip=ip.split("\\.");
	String[] matrizmascara=mascara.split("\\.");
	String cadenaip="",cadenamascara="";
	
	for (String item : matrizip)cadenaip +=dec_a_binario(Integer.valueOf(item));
	for (String item : matrizmascara)cadenamascara +=dec_a_binario(Integer.valueOf(item));
	
	System.out.println(cadenaip);
	System.out.println(cadenamascara);
	
	int n=cadenamascara.indexOf("0");
	System.out.println(n);
	String red=cadenaip.substring(0,24);
	
	String ipred=red+"0".repeat(32-red.length());
	String ipBroadcast=red+"1".repeat(32-red.length());

	String dipred="",dipBroadcast="";
	for(int i=0;i<=3;i++)
		dipred +=bin_a_dec(ipred.substring((i*8),(i+1)*8))+".";
	for(int i=0;i<=3;i++)
		dipBroadcast +=bin_a_dec(ipBroadcast.substring((i*8),(i+1)*8))+".";
	
	System.out.println(dipred.substring(0,dipred.length()-1));
	System.out.println(dipBroadcast.substring(0,dipBroadcast.length()-1));
}
}
