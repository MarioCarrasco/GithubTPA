package T4_arboles;

public class ArbolBinarioBusqueda<T> {

	class NodoBin {
		T info;
		NodoBin hijoIzq;
		NodoBin hijoDcho;

		NodoBin(NodoBin hIzq, T info, NodoBin hDcho) {
			this.hijoIzq = hIzq;
			this.hijoDcho = hDcho;
			this.info = info;
		}
	}

	private NodoBin raiz;

	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	public ArbolBinarioBusqueda(ArbolBinarioBusqueda<T> subIzq, T infoRaiz, ArbolBinarioBusqueda<T> subDcho) {
		NodoBin izq = subIzq == null? null : subIzq.raiz; 
		NodoBin dcho = subDcho == null? null : subDcho.raiz; 
		this.raiz = new NodoBin(izq, infoRaiz, dcho);
	}

	public boolean esVacio() {
		return raiz == null;
	}

	public T raiz() {
		return this.raiz.info;
	}

	public ArbolBinarioBusqueda<T> hijoIzquierdo() {
		ArbolBinarioBusqueda<T> subIzq = new ArbolBinarioBusqueda<T>();
		subIzq.raiz = this.raiz.hijoIzq;

		return subIzq;
	}

	public ArbolBinarioBusqueda<T> hijoDerecho() {
		ArbolBinarioBusqueda<T> subDcho = new ArbolBinarioBusqueda<T>();
		subDcho.raiz = this.raiz.hijoDcho;

		return subDcho;
	}

	public void dibujar(int nivel){

		if (!this.esVacio()){
			for (int i = 1; i<= nivel; i++)
				System.out.print("  ");
			System.out.println(this.raiz());
			this.hijoIzquierdo().dibujar(nivel+1);
			this.hijoDerecho().dibujar(nivel+1);			
		}
	}
	
	//IRD
    public void inorder() {
        if (!this.esVacio()) {
            this.hijoIzquierdo().inorder();
            System.out.print(this.raiz + ", ");
            this.hijoDerecho().inorder();
        }
    }
	
	//Ejercicio 1
	public void eliminarTerminales(ArbolBinarioBusqueda nodo) {
		if (!nodo.esVacio()) {
			if(nodo.hijoDerecho().esVacio() && nodo.hijoIzquierdo().esVacio()) {
				this.raiz = null;
			}
			else {
				if (nodo.hijoIzquierdo() != null) eliminarTerminales(nodo.hijoIzquierdo());
				if (nodo.hijoDerecho() != null) eliminarTerminales(nodo.hijoDerecho());
			}
		}
	}
	
	
	public static void main(String[] args) {
		ArbolBinarioBusqueda<Integer> d = new ArbolBinarioBusqueda<Integer>(new ArbolBinarioBusqueda<Integer>(),4,new ArbolBinarioBusqueda<Integer>());
		ArbolBinarioBusqueda<Integer> f = new ArbolBinarioBusqueda<Integer>(new ArbolBinarioBusqueda<Integer>(),6,new ArbolBinarioBusqueda<Integer>());
		ArbolBinarioBusqueda<Integer> e = new ArbolBinarioBusqueda<Integer>(new ArbolBinarioBusqueda<Integer>(),5,f);
		ArbolBinarioBusqueda<Integer> b = new ArbolBinarioBusqueda<Integer>(d,2,new ArbolBinarioBusqueda<Integer>());
		ArbolBinarioBusqueda<Integer> c = new ArbolBinarioBusqueda<Integer>(e,3,new ArbolBinarioBusqueda<Integer>());
		ArbolBinarioBusqueda<Integer> a = new ArbolBinarioBusqueda<Integer>(b,1,c);
		
		a.eliminarTerminales(a);
		a.dibujar(0);
		
	}
	
}
