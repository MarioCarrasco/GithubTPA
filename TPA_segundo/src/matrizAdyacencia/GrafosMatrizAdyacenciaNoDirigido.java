package matrizAdyacencia;

import java.util.ArrayList;
import java.util.List;

public class GrafosMatrizAdyacenciaNoDirigido {

    private final List<List<Integer>> matriz;

    public GrafosMatrizAdyacenciaNoDirigido() {
        matriz = new ArrayList<>();
    }

    public void addVertice() {
        //Agrego mi nueva fila
        matriz.add(new ArrayList<>());
        if (matriz.size() > 0) {
            //En el caso de que ya se insertara un vertice antes, lo tomo como referencia, el vertice 0
            // de esta manera la nueva fila que no tenia columnas, va a tener la misma cantidad que el primer vertice
            // asi la matriz es rectangular
            for (int i = 0; i < matriz.get(0).size(); i++) {
                matriz.get(matriz.size() - 1).add(0);
            }
        }
        //He insertado la fila para el nuevo vertice pero me falta añadir su columna, para esto debo hacer una insercion
        //en cada una de las filas y así pasamos de tener una matriz NxN-1 a una NxN
        for (int i=0; i<matriz.size(); i++) {
            matriz.get(i).add(0);
        }

    }

    public void addArista(int x, int y) {
        if (x < matriz.size() && matriz.get(x).size() > y) {
            //Si la arista es valida (los nodos se han insertado) lo que hacemos es borrar la relacion que ya tenian
            //e insertar un 1 en la posicion que acabamos de eliminar, porque no existe la funcion set
            matriz.get(x).remove(y);
            matriz.get(x).add(y, 1);

            matriz.get(y).remove(x);
            matriz.get(y).add(x, 1);
        }
    }

    public void printMatrizAdyacencia() {
        for (int i=0; i<matriz.size(); i++) {
            for (int j=0; j<matriz.get(i).size(); j++) {
                System.out.print(matriz.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafosMatrizAdyacenciaNoDirigido g = new GrafosMatrizAdyacenciaNoDirigido();

        g.addVertice();
        g.addVertice();
        g.addVertice();

        g.addArista(0, 2);

        g.printMatrizAdyacencia();

    }
}
