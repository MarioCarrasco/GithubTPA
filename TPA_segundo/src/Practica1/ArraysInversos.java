package Practica1;

public class ArraysInversos {

	public static void main(String[] args) {
		int array1[] = {2,3,8,4,5,6};
		int array3[] = {6,5,4,8,3,2};
		System.out.println("Los arrays son inversos: "+sonInversos(array1, array3, 0, array1.length-1));

	}

	// COMPARAR DOS ARRAYS Y VERIFICAR SI UNO ES EL INVERSO DEL OTRO
	public static boolean sonInversos(int array1[], int array2[], int ini, int fin) {
		//Caso base
		if(ini>fin) {
			return true;

		//Caso general
		}else {
			int mitad = (ini+fin)/2;

			if(array1[mitad]!=array2[array1.length-mitad-1]) {
				return false;
			}
			boolean x = sonInversos(array1, array2, ini, mitad-1);
			boolean y = sonInversos(array1, array2, mitad+1, fin);

			if(x==false) {
				return x;
			}
			if(y==false) {
				return y;
			}
		}
		return true;
	}

}
