package EjerciciosDyV;

public class BusBinMatrizDyV {

	public static void main(String[] args) {
		int matriz[][] = {{1,4,6},{9,16,23}};
		int numero = 10;

		System.out.println(busBin(matriz, numero));
	}

	//BUSQUEDA BINARIA
	//por divide y venceras (busqueda binaria, tiene que estar ordenado el array)
	public static String busBin(int[][] matriz, int x) {
		if(matriz.length==0||x>matriz[matriz.length-1][matriz[0].length-1]||x<matriz[0][0]) { //verificamos que el numero se encuentra dentro de los limites del array y que el array no esta vacio
			return "-1";
		}else { //si se cumple todo, llamamos al algoritmo recursivo busBinDV
			int resultado = -1;
			int i = 0;
			while(resultado==-1 && i<matriz.length) {
				resultado = busBinDV(matriz[i], x, 0, matriz[i].length-1);
				i++;
			}
			return String.valueOf(resultado) +" "+ String.valueOf(i-1);
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




















	/*
	//BUSQUEDA BINARIA
	//por divide y venceras (busqueda binaria, tiene que estar ordenado el array)
	public static int busBin(int[][] matriz, int x) {
		if(matriz.length==0||x>matriz[matriz.length-1][matriz[0].length-1]||x<matriz[0][0]) { //verificamos que el numero se encuentra dentro de los limites del array y que el array no esta vacio
			return -1;
		}else { //si se cumple todo, llamamos al algoritmo recursivo busBinDV
			return busBinDV(matriz, x, 0, matriz.length, matriz[0].length);
		}

	}

	public static int busBinDV(int[][] lista, int x) { //recibe(array ordenado, numero a buscar, posicion del primer elemento del array, ultima posición del array)
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

	}*/
}