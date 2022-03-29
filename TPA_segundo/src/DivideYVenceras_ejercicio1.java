
public class DivideYVenceras_ejercicio1 {

	public static void main(String[] args) {
		int array[] = {2, 1, 3, 9, 5, 6, 4, 8, 7};
		System.out.println("El mayor de manera iterativa es "+maximoTradicional(array));

		//Para el algoritmo DyV
		System.out.println("El mayor por dyV es " + maximoDyV(array));
	}

	public static int maximoTradicional(int array[]) {
		int i=0;
		int mayor = 0;
		while(i < array.length) {
			if(mayor < array[i]) {
				mayor = array[i];
			}
			i++;
		}
		return mayor;
	}

	public static int maximoDyV(int array[]) {
		/*int array2[] = new int[array.length - 1];			//array al que le voy quitando la última posición
		int max = 0;										//Variable que recibirá de la función el máximo momentaneo
		for (int i = 0; i < array2.length; i++) {			//Igualo los arrays pero el nuevo con un elemento menos
			array2[i] = array[i];
		}

		if (array.length == 1) {							//Para de hacer recursión cuando solo quede una posición en el vector que se le pasa a la función
			max = array[0];

		} else {
			max = maximoDyV(array2);
			if (max < array[array.length - 1]) {			//Si el max que se tiene es menor que el ultimo elemento del array se le asigna el valor
				max = array[array.length - 1];

			}
		}*/
		return 1; //return max;
	}


}
