package listaAdyacencia.model;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
    private final List<Arista<T>> listaAdyacencia;
    private final T id;

    public Vertice(T id) {
        this.id = id;
        this.listaAdyacencia = new ArrayList<>();
    }

    public List<Arista<T>> adyacentes() {
        return listaAdyacencia;
    }

    public T getId() {
        return id;
    }

    public void addAdyacente(Vertice<T> vertice, Integer ponderacion) {
        Arista<T> arista = new Arista<>(vertice, ponderacion);
        if (!listaAdyacencia.contains(arista)) {
            listaAdyacencia.add(arista);
        }
    }

    public void visitar() {
        System.out.print(id + " ");
    }
}
