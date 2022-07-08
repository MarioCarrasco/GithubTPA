package Practica2;


import java.util.ArrayList;
import java.util.List;
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
	 * (los visitados), haciendo esto recorriendo todos los vertices del grafo. Esto se repetirá hasta que la lista de vertices del grafo quede vacía.
	 * se devolverá la lista de vertices visitados.
	 */
	public List<Vertice<T>> ordTopologica() {
		List<Vertice<T>> visitados = new ArrayList<>(); //lista de visitados
		int i=0;
        while(visitados.size()!=vertices.size()) { //recorremos todos los vertices del grafo            
            if(!visitados.contains(vertices.get(i%vertices.size()))) {
            	//predecesores que no estan en la lista de eliminados
            	List<Vertice<T>> predecesores = this.predecesores(vertices.get(i%vertices.size()));
            	List<Vertice<T>> listResultado = predecesores.stream().filter(e -> !visitados.contains(e)).collect(Collectors.toList()); //en esta lista quedan los vertices predecesores que no esten en visitados
            	if(listResultado.size()==0) { //si la lista resultante de eliminar los vertices eliminados de los predecesores del vertice esta vacía, esta no tendra predecesores
                	visitados.add(vertices.get(i%vertices.size()));
                } 
            }
            i++;
        }
        return visitados;
    }


	public static void main(String[] args) {
		//CREACION DEL GRAFO (es el grafo especificado en la practica)
		GrafoDirigido<String> G = new GrafoDirigido<>();

		Vertice<String> a = new Vertice<>("1");
		Vertice<String> b = new Vertice<>("2");
		Vertice<String> c = new Vertice<>("3");
		Vertice<String> d = new Vertice<>("4");
		Vertice<String> e = new Vertice<>("5");
		Vertice<String> f = new Vertice<>("6");
		Vertice<String> g = new Vertice<>("7");
		Vertice<String> h = new Vertice<>("8");

		G.insertarVertice(a);
		G.insertarVertice(b);
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

        ArrayList<Vertice<String>> visitados = new ArrayList<>();
        visitados = (ArrayList<Vertice<String>>) G.ordTopologica();
        
        System.out.print("Ordenacion topologica: ");
        //visitados.forEach(vertice -> {System.out.print(vertice.getId()+" ");});
        visitados.stream().map(Vertice::getId).forEach(System.out::print); //imprimimos los elementos de la lista devuelta uno a uno

	}
}
