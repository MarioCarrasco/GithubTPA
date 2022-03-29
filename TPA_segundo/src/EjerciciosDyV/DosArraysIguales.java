package EjerciciosDyV;

public class DosArraysIguales {

	public static void main(String[] args) {
		int array1[] = {2,3,8,4,5,6};
		int array2[] = {2,3,8,4,5,6};
		System.out.println(sonIguales(array1, array2, 0, array1.length-1));
	}
	
	// COMPARAR DOS ARRAYS Y VERIFICAR SI SON IGUALES
	public static int sonIguales(int array1[], int array2[], int ini, int fin) {
		
		if(ini==fin) {
			if(array1[ini]==array2[ini]) {
				return -1;
			}else {
				return ini;
			}
			
		}else {
			int mitad = (ini+fin)/2;
			int x = sonIguales(array1, array2, ini, mitad);
			int y = sonIguales(array1, array2, mitad+1, fin);
			
			if(x!=-1) {
				return x;
			}
			
			if(y!=-1) {
				return y;
			}
		}
		return -1;
	}

}
