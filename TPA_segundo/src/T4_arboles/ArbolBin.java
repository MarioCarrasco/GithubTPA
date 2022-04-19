package T4_arboles;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArbolBin<T> {
	
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


	public ArbolBin() {
		raiz = null;
	}
	public ArbolBin(ArbolBin<T> subIzq, T infoRaiz, ArbolBin<T> subDcho) {
		NodoBin izq = subIzq == null? null : subIzq.raiz; 
		NodoBin dcho = subDcho == null? null : subDcho.raiz; 
		this.raiz = new NodoBin(izq, infoRaiz, dcho);
	}
	public boolean esVacio() {
		return raiz == null;
	}


	public ArbolBin<T> hijoIzquierdo() {
		ArbolBin<T> subIzq = new ArbolBin<T>();
		subIzq.raiz = this.raiz.hijoIzq;
		return subIzq;
	}
	public T raiz() {
		return this.raiz.info;
	}
	public ArbolBin<T> hijoDerecho() {
		ArbolBin<T> subDcho = new ArbolBin<T>();
		subDcho.raiz = this.raiz.hijoDcho;
		return subDcho;
	}



	public static void main(String[] args) {

	}

	//METODOS
	//recorrido inorden IRD
	public static void inorden(ArbolBin arbol){
		if (!arbol.esVacio()){
			inorden(arbol.hijoIzquierdo());
			visitar(arbol.raiz());
			inorden(arbol.hijoDerecho());
		}
	}
	//IRD de otra forma
	public static void inorden2(ArbolBin arbol) {
		if(!arbol.hijoIzquierdo().esVacio()) {//hijo izquierdo
			preorder(arbol.hijoIzquierdo());
		}
		System.out.println(arbol.raiz().toString()+", ");//raiz
		if(!arbol.hijoDerecho().esVacio()) {//hijo derecho
			preorder(arbol.hijoDerecho());
		}
	}


	//recorrido preorden RID
	public static void preorden(ArbolBin arbol){
		if (! arbol.esVacio()){
			visitar(arbol.raiz());
			preorden(arbol.hijoIzquierdo());
			preorden(arbol.hijoDerecho());
		}
	}
	//RID de otra forma
	public static void preorder(ArbolBin arbol) {
		System.out.println(arbol.raiz().toString()+", ");
		if(!arbol.hijoIzquierdo().esVacio()) {
			preorder(arbol.hijoIzquierdo());
		}
		if(!arbol.hijoDerecho().esVacio()) {
			preorder(arbol.hijoDerecho());
		}
	}

	
	//recorrido postorden IDR
	public static void postorden(ArbolBin arbol){
		if (! arbol.esVacio()){
			visitar(arbol.raiz());
			postorden(arbol.hijoIzquierdo());
			postorden(arbol.hijoDerecho());
		}
	}
	//IDR de otra forma
	public static void postorden2(ArbolBin arbol) {
		if(!arbol.hijoIzquierdo().esVacio()) {
			preorder(arbol.hijoIzquierdo());
		}
		if(!arbol.hijoDerecho().esVacio()) {
			preorder(arbol.hijoDerecho());
		}
		System.out.println(arbol.raiz().toString()+", ");
	}

	//recorrido en anchura NO HAY FORMA RECURSIVA
	public static void anchura(ArbolBin arbol){
		if (! arbol.esVacio()){
			ArbolBin a = arbol;
			LinkedList<ArbolBin> c = new LinkedList<ArbolBin>();
			c.push(a);//insertamos en la cola
			while (! c.isEmpty()){
				a = c.getFirst();
				c.pop();//sacamos de la cola el ultimo elemento
				visitar(a);
				if (!a.hijoIzquierdo().esVacio())
					c.add(a.hijoIzquierdo());
				if (!a.hijoDerecho().esVacio())
					c.add(a.hijoDerecho());
			}
		}
	}

}
