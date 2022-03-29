package EjerciciosDyV;

public class Hoja2ejercicio2 {

	//encontrar el elemento minimo de un array
	
	public static void main(String[] args) {

		int array[] = {2,3,8,4,5,6,9,6,3,5,10,8};
		System.out.println(minimoDyV(array, 0, array.length-1));
		
	}
	
	public static int minimoDyV(int array[], int ini, int fin) {
		
		if(ini==fin) {
			return array[ini];
		}else {
			int mitad = (ini+fin)/2;
			int izq = minimoDyV(array, ini, mitad);
			int der = minimoDyV(array, mitad+1, fin);
			
			if(izq<der) {
				return izq;
			}else {
				return der;
			}
		}
	}
}
