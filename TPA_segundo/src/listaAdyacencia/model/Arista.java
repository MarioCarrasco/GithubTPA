package listaAdyacencia.model;

public class Arista<T> {
    private final Vertice<T> sucesor;
    private final Integer ponderacion;

    public Arista(Vertice<T> sucesor, Integer ponderacion) {
        this.sucesor = sucesor;
        this.ponderacion = ponderacion;
    }

    public Vertice<T> getSucesor() {
        return sucesor;
    }

    public Integer getPonderacion() {
        return ponderacion;
    }
}
