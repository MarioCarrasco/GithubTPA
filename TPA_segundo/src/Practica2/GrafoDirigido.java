package Practica2;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Optimizado en memoria
 * @param <T>
 */
public class GrafoDirigido<T> {
    private List<Vertice<T>> vertices;
    private List<Arista<T>> aristas;

    public GrafoDirigido() {
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }

    public void insertarArista(Vertice<T> v1, Vertice<T> v2, Integer ponderacion) {
        if (vertices.contains(v1) && vertices.contains(v2)) {
            aristas.add(new Arista<>(v1, v2, ponderacion));
        } else {
            throw new RuntimeException("Uno de los vertices no existe");
        }
    }

    public void eliminarArista(Vertice<T> v1, Vertice<T> v2) {
        aristas.remove(getArista(v1,v2));
    }

    public Arista<T> getArista(Vertice<T> v1, Vertice<T> v2) {
        return aristas.stream().filter(a -> a.getX().equals(v1) && a.getY().equals(v2)).findFirst().orElseGet(null);
    }

    public Vertice<T> getVertice(T id) {
        return vertices.stream().filter(a -> a.getId().equals(id)).findFirst().orElseGet(null);
    }

    public long grado(Vertice<T> v) {
        return gradoDeEntrada(v) + gradoDeSalida(v);
    }

    public boolean existeArista(Vertice<T> v1, Vertice<T> v2) {
        return aristas.stream().anyMatch(a -> a.getX().equals(v1) && a.getY().equals(v2));
    }

    public Integer costeArista(Vertice<T> v1, Vertice<T> v2) {
        if (existeArista(v1, v2)) {
            return aristas.stream().filter(a -> a.getX().equals(v1) && a.getY().equals(v2)).findFirst().get().getPonderacion();
        }
        return Integer.MAX_VALUE;
    }

    public List<Vertice<T>> sucesores(Vertice<T> v) {
        return getAristasSalida(v).stream().map(Arista::getY).collect(Collectors.toList());
    }

    public List<Vertice<T>> predecesores(Vertice<T> v) {
        return getAristasEntrada(v).stream().map(Arista::getX).collect(Collectors.toList());
    }

    public int numVertices() {
        return vertices.size();
    }

    public void vaciar() {
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public void insertarVertice(Vertice<T> v) {
        vertices.add(v);
    }

    public void eliminarVertice(Vertice<T> v) {
        vertices.remove(v);
    }

    public List<Arista<T>> getAristasSalida(Vertice<T> v) {
        return aristas.stream().filter(tArista -> tArista.getX().equals(v)).collect(Collectors.toList());
    }

    public List<Arista<T>> getAristasEntrada(Vertice<T> v) {
        return aristas.stream().filter(tArista -> tArista.getY().equals(v)).collect(Collectors.toList());
    }

    public long gradoDeEntrada(Vertice<T> v) {
        return getAristasEntrada(v).size();
    }

    public long gradoDeSalida(Vertice<T> v) {
        return getAristasSalida(v).size();
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
            for (Arista<T> a: getAristasSalida(v)) {
                System.out.print(a.getPonderacion());
                a.getOtherVertice(v).visitar();
                System.out.print("- ");
            }
            System.out.println("]");
        }
    }


    public void alcanzable(Vertice<T> v, List<Vertice<T>> visitados) {
        List<Arista<T>> aristas = this.getAristasSalida(v);
        aristas.forEach(tArista -> {
            if (!visitados.contains(tArista.getY())) {
                visitados.add(tArista.getY());
                this.alcanzable(tArista.getY(), visitados);
            }
        });
    }

    public static void main(String[] args) {
        GrafoDirigido<String> g = new GrafoDirigido<>();

        Vertice<String> a = new Vertice<>("A");
        Vertice<String> b = new Vertice<>("B");
        Vertice<String> c = new Vertice<>("C");
        Vertice<String> d = new Vertice<>("D");
        Vertice<String> e = new Vertice<>("E");
        Vertice<String> f = new Vertice<>("F");

        g.insertarVertice(b);
        g.insertarVertice(a);
        g.insertarVertice(c);
        g.insertarVertice(d);
        g.insertarVertice(e);
        g.insertarVertice(f);

        g.insertarArista(a, b, 2);
        g.insertarArista(a, c, 3);
        g.insertarArista(a, d, 1);
        g.insertarArista(d, c, 5);
        g.insertarArista(c, e, 5);
        g.insertarArista(e, f, 5);

        g.printListaAdyacencia();

        System.out.println("Grado entrada C = " + g.gradoDeEntrada(c));
        System.out.print("Predecesores = ");
        g.predecesores(c).stream().map(Vertice::getId).forEach(System.out::print);
        System.out.println();
        System.out.println("Grado salida C = " + g.gradoDeSalida(c));
        System.out.print("Sucesores = ");
        g.sucesores(c).stream().map(Vertice::getId).forEach(System.out::print);
        System.out.println();
        System.out.println("Grado salida A = " + g.gradoDeSalida(a));

        System.out.println();
        System.out.print("VERTICES: ");
        System.out.println(g.vertices.stream().map(Vertice::getId).collect(Collectors.toList()));
        System.out.print("ARISTAS: ");
        System.out.println(g.aristas.stream().map(ar -> "{"+ar.getX().getId()+","+ar.getY().getId()+"->"+ar.getPonderacion()+"},").collect(Collectors.toList()));

        g.eliminarVertice(f);

        System.out.println();
        System.out.print("VERTICES: ");
        System.out.println(g.vertices.stream().map(Vertice::getId).collect(Collectors.toList()));
        System.out.print("ARISTAS: ");
        System.out.println(g.aristas.stream().map(ar -> "{"+ar.getX().getId()+","+ar.getY().getId()+"->"+ar.getPonderacion()+"},").collect(Collectors.toList()));

        g.eliminarArista(e, f);

        System.out.println();
        System.out.print("VERTICES: ");
        System.out.println(g.vertices.stream().map(Vertice::getId).collect(Collectors.toList()));
        System.out.print("ARISTAS: ");
        System.out.println(g.aristas.stream().map(ar -> "{"+ar.getX().getId()+","+ar.getY().getId()+"->"+ar.getPonderacion()+"},").collect(Collectors.toList()));

        System.out.println();
        System.out.println(g.costeArista(a, c));
        System.out.println(Objects.equals(g.costeArista(a, c), g.getArista(g.getVertice("A"), g.getVertice("C")).getPonderacion()));

        ArrayList<Vertice<String>> visitados = new ArrayList<>();
        g.alcanzable(a, visitados);

        visitados.forEach(stringVertice -> {
            System.out.print(stringVertice.getId());
        });
        System.out.println();
    }
}
