package AlgoritmosDyV;

public class SeleccionDyV {

	public static void main(String[] args) {
		int array[] = {3,5,25,6,7,9,8,23};
		seleccionar(array, 3);
	}
	
	
	public static int seleccionar(int[]lista, int k) {
		int ini = 0;
		int fin = lista.length;
		int x = pivotar(lista, ini, fin);
		while(k!=x) {
			if(x>k) {
				fin = x-1;
			}else {
				ini = x+1;
				x = pivotar(lista, ini, fin);
			}
		}
		return lista[x];
	}

	
	// PIVOTAR
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

}
