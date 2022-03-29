
public class Ejercicio_recursivo {

	public static void main(String[] args) {
		int i = 0;
		int array[] = {1,4,2,5,3};
		buscarEl(3, array, i);
	}

	/*Metodo que reciba una lista y un objeto y devuelva si ese objeto se encuentra dentro o no*/
	public static int buscarEl(int a, int array[], int i) {

		if((i==(array.length)-1) && a!=array[i]) {
			System.out.print("NO exixte el termino en el array");
			return -1;
		}
		else if(a == (array[i])) {
			System.out.print("SI exixte el termino en el array");
			return array[i];
		}
		else {
			i = i+1;
			return buscarEl(a, array, i);
		}
	}
}
