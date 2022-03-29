
public class ejercicio2_primo {

	public static void main (String args[]) {
		System.out.println(esPrimo(13));
	}
	
	/*Codificar la función esPrimo (int) que reciba como entrada un número mayor que
	cero, y devuelva verdadero si es un número primo y false en caso contrario. Calcular de forma
	razonada su complejidad.*/
	
	public static boolean esPrimo (int n) {
	    boolean primo = true;
	    int i = 2;
		while(primo && (i<n)) {
	        if (n % i == 0) {
	            primo = false;
	            break;
	        }
	        i++;
	    }
		return primo;
	}
	
}
