package listaAdyacencia;

import listaAdyacencia.model.Arista;
import listaAdyacencia.model.Vertice;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta implementacion no es la mas optima para no dirigidos pero es el equivalente a listaAdyacencia.GrafoDirigido con el ajuste de duplicar informacion
 * @param <T>
 */
public class GrafoNoDirigido<T> {
    private final List<Vertice<T>> vertices;

    public GrafoNoDirigido() {
        this.vertices = new ArrayList<>();
    }

    public void crearArista(Vertice<T> v1, Vertice<T> v2, Integer ponderacion) {
        if (vertices.contains(v1) && vertices.contains(v2)) {
            v1.addAdyacente(v2, ponderacion);
            //DIFERENCIA CON EL DIRIGIDO
            v2.addAdyacente(v1, ponderacion);
        } else {
            throw new RuntimeException("Uno de los vertices no existe");
        }
    }

    public void addVertice(Vertice<T> v) {
        vertices.add(v);
    }

    public void printListaAdyacencia() {
        for (Vertice<T> v: vertices) {
            v.visitar();
            System.out.print(": [");
            for (Arista<T> a: v.adyacentes()) {
                System.out.print(a.getPonderacion());
                a.getSucesor().visitar();
                System.out.print("- ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        GrafoNoDirigido<String> g = new GrafoNoDirigido<>();

        Vertice<String> a = new Vertice<>("A");
        Vertice<String> b = new Vertice<>("B");
        Vertice<String> c = new Vertice<>("C");
        Vertice<String> d = new Vertice<>("D");

        g.addVertice(a);
        g.addVertice(b);
        g.addVertice(c);
        g.addVertice(d);

        g.crearArista(a, b, 2);
        g.crearArista(a, c, 3);
        g.crearArista(a, d, 1);
        g.crearArista(d, c, 5);

        g.printListaAdyacencia();

    }
}
