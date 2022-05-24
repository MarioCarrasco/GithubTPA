package T4_arboles;

public class ArbolBin<T extends Comparable> {
	private ArbolBin<T> hijoIzq;
	private ArbolBin<T> hijoDer;
	private T raiz;
	public ArbolBin() {
		raiz = null;
	}
	public ArbolBin(T value) {
		raiz = value;
		this.hijoDer = new ArbolBin<>();
		this.hijoIzq = new ArbolBin<>();
	}
	public boolean esVacio() {
		return raiz == null;
	}
	public T getRaiz() {
		return raiz;
	}
	public void add(T value) {
		if (value!=null) {
			if (this.esVacio()) {
				this.raiz = value;
				this.hijoDer = new ArbolBin();
				this.hijoIzq = new ArbolBin();
			} else {
				switch (value.compareTo(raiz)) {
				case 0:
					break;
				case 1:
					if (this.hijoDer==null) {
						this.hijoDer = new ArbolBin<>(value);
					} else {
						this.hijoDer.add(value);
					}
					break;
				case -1:
					if (this.hijoIzq==null) {
						this.hijoIzq = new ArbolBin<>(value);
					} else {
						this.hijoIzq.add(value);
					}
					break;
				default:
					break;
				}
			}
		}
	}
	//IRD
	public void inorder() {
		if (!this.esVacio()) {
			this.hijoIzq.inorder();
			System.out.print(this.raiz + ", ");
			this.hijoDer.inorder();
		}
	}
	//DRI
	public void inorderInv() {
		if (!this.esVacio()) {
			this.hijoDer.inorderInv();
			System.out.print(this.raiz + ", ");
			this.hijoIzq.inorderInv();
		}
	}


	public void dibujar(int nivel){

		if (!this.esVacio()){
			for (int i = 1; i<= nivel; i++)
				System.out.print("  ");
			System.out.println(this.raiz);
			this.hijoIzq.dibujar(nivel+1);
			this.hijoDer.dibujar(nivel+1);			
		}
	}
	
	//Ejercicio 1
	public void eliminarTerminales() {
		if (!this.esVacio()) {
			if(this.hijoDer.esVacio() && this.hijoIzq.esVacio()) {
				this.raiz = null;
			}
			else {
				if (!this.hijoIzq.esVacio()) {
					this.hijoIzq.eliminarTerminales();
				}
				if (!this.hijoDer.esVacio()) {
					this.hijoDer.eliminarTerminales();
				}
			}
		}
	}

	public static void main(String[] args) {
		ArbolBin<Integer> abb = new ArbolBin<>();
		abb.add(10);
		abb.add(7);
		abb.add(2);
		abb.add(5);
		abb.add(15);
		abb.add(20);
		abb.add(14);
		//abb.inorder();
		//abb.inorderInv();
		
		abb.eliminarTerminales();
		abb.dibujar(0);
	}
}
