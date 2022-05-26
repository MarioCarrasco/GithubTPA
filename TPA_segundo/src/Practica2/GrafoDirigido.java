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
    
    /*
     * Mi idea es crear una lista en la que se insertaran los valores del grafo que no tengan predecesores
     * en ese momento, se elegirá el primer vertice de esta lista (en este caso yo lo he elegido asi) y se 
     * eliminara de la lista y del grafo, y cuando esta lista quede vacia se hara una llamada recursiva de nuevo 
     * al método, haciendo lo mismo hasta que el grafo este vacio
    */
    public void ordTopologica(GrafoDirigido<T> grafo) {
    	
    }

    

    public static void main(String[] args) {
        GrafoDirigido<String> G = new GrafoDirigido<>();

        Vertice<String> a = new Vertice<>("1");
        Vertice<String> b = new Vertice<>("2");
        Vertice<String> c = new Vertice<>("3");
        Vertice<String> d = new Vertice<>("4");
        Vertice<String> e = new Vertice<>("5");
        Vertice<String> f = new Vertice<>("6");
        Vertice<String> g = new Vertice<>("7");
        Vertice<String> h = new Vertice<>("8");

        G.insertarVertice(b);
        G.insertarVertice(a);
        G.insertarVertice(c);
        G.insertarVertice(d);
        G.insertarVertice(e);
        G.insertarVertice(f);
        G.insertarVertice(g);
        G.insertarVertice(h);

        G.insertarArista(a, b, 0);
        G.insertarArista(a, f, 0);
        G.insertarArista(b, c, 0);
        G.insertarArista(b, g, 0);
        G.insertarArista(c, d, 0);
        G.insertarArista(d, h, 0);
        G.insertarArista(g, d, 0);
        G.insertarArista(g, h, 0);
        G.insertarArista(f, c, 0);
        G.insertarArista(f, g, 0);
        G.insertarArista(e, f, 0);


        G.printListaAdyacencia();

        System.out.println("Grado entrada 3 = " + G.gradoDeEntrada(c));
        System.out.print("Predecesores = ");
        G.predecesores(c).stream().map(Vertice::getId).forEach(System.out::print);
        System.out.println();
        System.out.println("Grado salida 3 = " + G.gradoDeSalida(c));
        System.out.print("Sucesores = ");
        G.sucesores(c).stream().map(Vertice::getId).forEach(System.out::print);
        System.out.println();
        System.out.println("Grado salida 1 = " + G.gradoDeSalida(a));

        System.out.println();
        System.out.print("VERTICES: ");
        System.out.println(G.vertices.stream().map(Vertice::getId).collect(Collectors.toList()));
        System.out.print("ARISTAS: ");
        System.out.println(G.aristas.stream().map(ar -> "{"+ar.getX().getId()+","+ar.getY().getId()+"->"+ar.getPonderacion()+"},").collect(Collectors.toList()));
        System.out.println();

        ArrayList<Vertice<String>> visitados = new ArrayList<>();
        G.alcanzable(a, visitados);

        visitados.forEach(stringVertice -> {
            System.out.print(stringVertice.getId()+" ");
        });
        System.out.println();
        
        //Llamada al metodo de ordenacion topologica
        System.out.println();
    }
}
