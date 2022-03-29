
public class recursividad_1 {

	public static void main (String args[]) {
		int contador = 0;
		int suma = 0;
		int array[] = {1, 2, 5};
		int resultado = sumaContenidoArray(array, contador, suma);
		
		System.out.println(resultado);
	}
	
	
	public static int sumaContenidoArray(int array[], int contador, int suma) {
		if (array.length == contador) {
			return suma;
		}
		else {
			//System.out.println(array[contador]);
			suma = array[contador] + suma;
			contador++;
			suma = sumaContenidoArray(array, contador, suma);
		}
		return suma;
	}
	
}
