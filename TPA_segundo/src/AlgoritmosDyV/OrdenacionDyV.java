									package AlgoritmosDyV;

public class OrdenacionDyV {

	public static void main(String[] args) {

		int array[] = {3,5,25,6,7,9,8,23};

		System.out.print("Mergesort: ");
		//mergesort(array, 0, array.length-1);
		mergesort(array);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}

		System.out.println();

		System.out.print("Quicksort: ");
		quicksort(array, 0, array.length-1);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	//tenemos dos algoritmos de ordenación: MERGESORT y QUICKSORT

	//---------------------MERGESORT----------------------//
	public static void mergesort(int[] l) {
		if (l.length > 1) {
			int med = ((l.length-1) / 2);
			int[] izq = new int[med+1];
			int[] der = new int[((l.length-2)-med)+1];
			for(int i=0; i<l.length; i++) {
				if (i<=med) {
					izq[i] = l[i];
				} else {
					der[(i%(der.length))] = l[i];
				}
			}
			mergesort(izq);
			mergesort(der);
			merge(izq, der, l);
		}
		
	}
	
	public static void merge(int[] izq, int[] der, int[] l) {
		int i = 0;
		int j = 0;
		for(int cont=0; cont<l.length; cont++) {
			if (j>=der.length || (i<izq.length && izq[i] < der[j])) {
				l[cont] = izq[i++];
			} else {
				l[cont] = der[j];
				j++;
			}
		}
	}

	//---------------------QUICKSORT----------------------//
	public static int pivotar(int[]lista, int ini, int fin) {
		//i=posicion pivote | p=valor pivote
		int i=ini; 
		double p=lista[ini];
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

	public static void quicksort(int[]lista, int ini, int fin) {
		if(ini<fin) {
			int x=pivotar(lista, ini, fin);
			quicksort(lista, ini, x-1);
			quicksort(lista, x+1, fin);
		}
	}
}
