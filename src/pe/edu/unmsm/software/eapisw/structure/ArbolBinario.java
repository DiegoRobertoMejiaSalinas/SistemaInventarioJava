
package pe.edu.unmsm.software.eapisw.structure;

import java.util.Comparator;
import java.util.Iterator;

public class ArbolBinario<T extends Comparable<T>> {

    private class NodoBinario<T> {

        private NodoBinario izq;
        private NodoBinario der;
        private T dato;

        public NodoBinario(T dato) {
            this.dato = dato;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

    }

    private NodoBinario<T> raiz;
    //COMPARADOR
    private final Comparator<T> comparador = (T o1, T o2) -> o1.compareTo(o2);

    public void insertar(T dato) {
        NodoBinario<T> nuevo = new NodoBinario<>(dato);
        insertarRecursivo(nuevo, raiz);
    }

    private boolean insertarRecursivo(NodoBinario<T> nuevo, NodoBinario<T> aux) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (comparador.compare(nuevo.dato, aux.dato) < 0) {
                if (aux.izq == null) {
                    aux.izq = nuevo;
                } else {
                    insertarRecursivo(nuevo, aux.izq);
                }
            } else {
                if (comparador.compare(nuevo.dato, aux.dato) == 0) {
                    return false;
                } else {
                    if (aux.der == null) {
                        aux.der = nuevo;
                    } else {
                        insertarRecursivo(nuevo, aux.der);
                    }
                }
            }
        }
        return true;
    }

    //PREORDEN
    public void preOrden() {
        NodoBinario<T> aux = raiz;
        preOrdenRecursivo(aux);
    }

    private void preOrdenRecursivo(NodoBinario<T> subarbol) {
        if (subarbol != null) {
            System.out.println(subarbol.dato);
            preOrdenRecursivo(subarbol.izq);
            preOrdenRecursivo(subarbol.der);
        }
    }

    //INORDEN
    public void inOrden() {
        if (raiz != null) {
            NodoBinario<T> aux = raiz;
            inOrdenRecursivo(aux);
        }
    }

    private void inOrdenRecursivo(NodoBinario<T> subarbol) {
        if (subarbol != null) {
            inOrdenRecursivo(subarbol.izq);
            System.out.println(subarbol.dato);
            inOrdenRecursivo(subarbol.der);
        }
    }

    //POSTORDEN
    public void postOrden() {
        if (raiz != null) {
            NodoBinario<T> aux = raiz;
            postOrdenRecursivo(aux);
        }
    }

    private void postOrdenRecursivo(NodoBinario<T> subarbol) {
        if (subarbol != null) {
            postOrdenRecursivo(subarbol.izq);
            postOrdenRecursivo(subarbol.der);
            System.out.println(subarbol.dato);
        }
    }

}
