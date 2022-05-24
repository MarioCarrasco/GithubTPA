package noDirigidoParaClase;

public class Arista<T> {
    private final Vertice<T> x;
    private final Vertice<T> y;
    private final Integer ponderacion;

    public Arista(Vertice<T> x, Vertice<T> y, Integer ponderacion) {
        this.x = x;
        this.y = y;
        this.ponderacion = ponderacion;
    }

    public Vertice<T> getX() {
        return x;
    }

    public Vertice<T> getY() {
        return y;
    }

    public Integer getPonderacion() {
        return ponderacion;
    }

    public boolean contain(Vertice<T> v) {
        return x.equals(v) || y.equals(v);
    }

    public Vertice<T> getOtherVertice(Vertice<T> v) {
        if (x.equals(v)) {
            return y;
        } else if (y.equals(v)) {
            return x;
        }
        return null;
    }
}
