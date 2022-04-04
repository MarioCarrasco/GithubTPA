package AlgoritmosDyV;

public class SeleccionDyV {

	public static void main(String[] args) {
		int array[] = {3,5,25,6,7,9,8,23};
		quicksort(array, 0, array.length-1);
		System.out.println(array.toString());
		System.out.println(seleccionar(array, 7));
	}
	
	
	public static int seleccionar(int[]lista, int k) {
		int ini = 0;
		int fin = lista.length-1;
		int x = pivotar(lista, ini, fin);
		while(k!=x) {
			if(x>k) {
				fin = x-1;
				System.out.println("x es mayor que k");
			}else {
				ini = x+1;
				x = pivotar(lista, ini, fin);
				System.out.println("Se ha hecho el pivote");
			}
		}
		System.out.println("Hora de devolver");
		return lista[x];
	}
	
	//QUICKSORT PARA LA ORDENACIÓN PREVIA
	public static void quicksort(int[]lista, int ini, int fin) {
		if(ini<fin) {
			int x=pivotar(lista, ini, fin);
			quicksort(lista, ini, x-1);
			quicksort(lista, x+1, fin);
		}
	}
	
	// PIVOTAR
	public static int pivotar(int[]lista, int ini, int fin) {
		int i=ini;//posicion del pivote
		double p=lista[ini];//valor del pivote
		for(int j=ini+1; j<=fin; j++) {
			if(lista[j]<=p) {
				i++;
				if(i!=j) {
					int aux=lista[i];
					lista[i]=lista[j];
					lista[j]=aux;
				}
			}
		}
		int aux2=lista[ini];
		lista[ini]=lista[i];
		lista[i]=aux2;
		return i;
	}

}
