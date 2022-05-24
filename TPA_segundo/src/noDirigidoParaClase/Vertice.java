package noDirigidoParaClase;

public class Vertice<T> {
    private final T id;

    public Vertice(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
    public void visitar() {
        System.out.print(id + " ");
    }
}
