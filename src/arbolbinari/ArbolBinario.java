package arbolbinari;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArbolBinario<T> {
    private NodoArbol<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public ArbolBinario(T datoRaiz) {
        this.raiz = new NodoArbol<>(datoRaiz);
    }

    public ArbolBinario(T datoRaiz, ArbolBinario<T> arbolIzq, ArbolBinario<T> arbolDer) {
        this.raiz = new NodoArbol<>(datoRaiz);
        if (arbolIzq != null) {
            this.raiz.setIzquierdo(arbolIzq.raiz);
        }
        if (arbolDer != null) {
            this.raiz.setDerecho(arbolDer.raiz);
        }
    }

    public T getRootData() {
        if (empty()) {
            throw new RuntimeException("El árbol está vacío.");
        }
        return raiz.getDato();
    }

    public int getHeight() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzq = calcularAltura(nodo.getIzquierdo());
        int alturaDer = calcularAltura(nodo.getDerecho());
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    public int getNumberNodes() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    public boolean empty() {
        return raiz == null;
    }

    public void clear() {
        raiz = null;
    }

    public Iterator<T> getInOrderIterator() {
        List<T> lista = new ArrayList<>();
        llenarInOrden(raiz, lista);
        return lista.iterator();
    }

    private void llenarInOrden(NodoArbol<T> nodo, List<T> lista) {
        if (nodo != null) {
            llenarInOrden(nodo.getIzquierdo(), lista);
            lista.add(nodo.getDato());
            llenarInOrden(nodo.getDerecho(), lista);
        }
    }

    public Iterator<T> getPreOrderIterator() {
        List<T> lista = new ArrayList<>();
        llenarPreOrden(raiz, lista);
        return lista.iterator();
    }

    private void llenarPreOrden(NodoArbol<T> nodo, List<T> lista) {
        if (nodo != null) {
            lista.add(nodo.getDato());
            llenarPreOrden(nodo.getIzquierdo(), lista);
            llenarPreOrden(nodo.getDerecho(), lista);
        }
    }

    public Iterator<T> getPostOrderIterator() {
        List<T> lista = new ArrayList<>();
        llenarPostOrden(raiz, lista);
        return lista.iterator();
    }

    private void llenarPostOrden(NodoArbol<T> nodo, List<T> lista) {
        if (nodo != null) {
            llenarPostOrden(nodo.getIzquierdo(), lista);
            llenarPostOrden(nodo.getDerecho(), lista);
            lista.add(nodo.getDato());
        }
    }
}
