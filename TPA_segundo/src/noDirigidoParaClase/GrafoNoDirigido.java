package noDirigidoParaClase;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Optimizado en memoria
 * @param <T>
 */
public class GrafoNoDirigido<T> {
    private final List<Vertice<T>> vertices;
    private final List<Arista<T>> aristas;

    public GrafoNoDirigido() {
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }

    public void crearArista(Vertice<T> v1, Vertice<T> v2, Integer ponderacion) {
        if (vertices.contains(v1) && vertices.contains(v2)) {
            aristas.add(new Arista<>(v1, v2, ponderacion));
        } else {
            throw new RuntimeException("Uno de los vertices no existe");
        }
    }

    public void addVertice(Vertice<T> v) {
        vertices.add(v);
    }

    public List<Arista<T>> getAristas(Vertice<T> v) {
        return aristas.stream().filter(tArista -> tArista.contain(v)).collect(Collectors.toList());
    }

    public List<Vertice<T>> getVerticesAdyacente(Vertice<T> v) {
        return getAristas(v).stream().map(tArista -> tArista.getOtherVertice(v)).collect(Collectors.toList());
    }

    public List<Vertice<T>> getVertices() {
        return vertices;
    }

    public List<Arista<T>> getAristas() {
        return aristas;
    }

    public void printListaAdyacencia() {
        for (Vertice<T> v: vertices) {
            v.visitar();
            System.out.print(": [");
            for (Arista<T> a: getAristas(v)) {
                System.out.print(a.getPonderacion());
                a.getOtherVertice(v).visitar();
                System.out.print("- ");
            }
            System.out.println("]");
        }
    }

    public void printMatrizDeAdyacencia() {
        for (Vertice<T> v: vertices) {
            v.visitar();
            System.out.print(": [");
            for (Arista<T> a: getAristas(v)) {
                System.out.print(a.getPonderacion());
                a.getOtherVertice(v).visitar();
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

        g.addVertice(b);
        g.addVertice(a);
        g.addVertice(c);
        g.addVertice(d);

        g.crearArista(a, b, 2);
        g.crearArista(a, c, 3);
        g.crearArista(a, d, 1);
        g.crearArista(d, c, 5);

        g.printListaAdyacencia();

        System.out.println();
        System.out.print("VERTICES: ");
        System.out.println(g.vertices.stream().map(Vertice::getId).collect(Collectors.toList()));
        System.out.print("ARISTAS: ");
        System.out.println(g.aristas.stream().map(ar -> "{"+ar.getX().getId()+","+ar.getY().getId()+"->"+ar.getPonderacion()+"},").collect(Collectors.toList()));
    }
}
