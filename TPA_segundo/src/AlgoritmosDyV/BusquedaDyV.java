package AlgoritmosDyV;

public class BusquedaDyV {

	public static void main(String[] args) {
		int array[] = {1,4,6,9,16,23,56};
		int numero = 16;
		//System.out.println(busquedaWhile(array, numero));

		System.out.println(busBin(array, numero));
	}

	//por bucle for (tradicional)
	public static int busquedaWhile(int array[], int a) {
		int i=0;
		boolean encontrado = false;

		while(i<array.length && !encontrado) {
			if(array[i]==a) {
				encontrado = true;
				System.out.println(encontrado);
				return i;
			}
			else {
				i++;
			}
		}
		System.out.println(encontrado);
		return -1;
	}

	//por bucle while con array ordenado(tradicional)
	public static int busquedaFor(int array[], int a) {
		if(a<array[0]||a>array[array.length]){
			return -1;
		}

		int i=0;
		boolean encontrado = false;

		while(i<array.length && !encontrado) {
			if(array[i]==a) {
				encontrado = true;
				System.out.println(encontrado);
				return i;
			}
			else {
				i++;
			}
		}
		System.out.println(encontrado);
		return -1;
	}

	//BUSQUEDA BINARIA
	//por divide y venceras (busqueda binaria, tiene que estar ordenado el array)
	public static int busBin(int[] lista, int x) {
		if(lista.length==0||x>lista[lista.length-1]||x<lista[0]) { //verificamos que el numero se encuentra dentro de los limites del array y que el array no esta vacio
			return -1;
		}else { //si se cumple todo, llamamos al algoritmo recursivo busBinDV
			return busBinDV(lista, x, 0, lista.length-1);
		}

	}

	public static int busBinDV(int[] lista, int x, int ini, int fin) { //recibe(array ordenado, numero a buscar, posicion del primer elemento del array, ultima posición del array)
		if(ini>fin) { //si la primera posición del array es mayor que la ultima posición del array la lista no nos vale y devolvemos que no se ha encontrado
			return -1;
		} else {
			int mitad = (ini+fin)/2; //calculamos la posición de la mitad del array

			if(x==lista[mitad]) { //en el caso de que el numero que se encuentra en la posición media del array, ya tenemos la solución, la devolvemos
				return mitad;
			}

			else { //Si no, aplicamos recursividad verificando si el numero a encontrar se encuentra en la mitad izquierda o en la derecha
				if(x<lista[mitad]) { //si se encuentra en la primera mitad, llamamos a la función otra vez con el array inicial, el numero a buscar, el limite inferior (que sera 0) y el superior (que sera la mitad menos 1, porque el numero que se encuentra en la mitad ya ha sido comprobado)
					return busBinDV(lista, x, ini, mitad-1);
				}
				else { //si es mayor al numero que se encuentra en la posición de la mitad, se hace lo mismo, pero con limite inferior siendo la mitad mas 1 y el superior la longitud del array menos 1 (que en este caso es j)
					return busBinDV(lista, x, mitad+1,fin);

				}
			}
		}
	}
}
