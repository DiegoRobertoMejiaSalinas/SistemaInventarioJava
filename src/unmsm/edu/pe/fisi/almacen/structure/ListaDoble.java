/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.fisi.almacen.structure;

import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ListaDoble<T> implements Iterable<T> {

    public class NodoDoble<T> {

        private NodoDoble<T> sig;
        private NodoDoble<T> ant;
        private T dato;

        public NodoDoble(T dato) {
            this.dato = dato;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public NodoDoble<T> getSig() {
            return sig;
        }

        public void setSig(NodoDoble<T> sig) {
            this.sig = sig;
        }

        public NodoDoble<T> getAnt() {
            return ant;
        }

        public void setAnt(NodoDoble<T> ant) {
            this.ant = ant;
        }
        
        

    }

    private NodoDoble<T> cabecera;
    private NodoDoble<T> ultimo;
    private Comparator<T> comparador;
    private int cant = 0;

    public NodoDoble<T> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoDoble<T> cabecera) {
        this.cabecera = cabecera;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoDoble<T> ultimo) {
        this.ultimo = ultimo;
    }

    public void insertarAlInicio(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        nuevoNodo.sig = cabecera;

        if (cabecera != null) {
            cabecera.ant = nuevoNodo;
        } else {
            ultimo = nuevoNodo;

        }
        cabecera = nuevoNodo;

    }

    public void insertarAlFinal(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        NodoDoble<T> aux = cabecera;

        if (cabecera == null) {
            cabecera = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            while (aux.sig != null) {
                aux = aux.sig;
            }

            aux.sig = nuevoNodo;
            nuevoNodo.ant = aux;
            nuevoNodo.sig = null;
            ultimo = nuevoNodo;
        }

    }

    public void eliminarPosicion(int pos) { // dato

        NodoDoble<T> aux = cabecera;
        int cont = 1;

        if (cabecera == null) {
            //
        } else {
            if (pos > cant || pos == 1) {
                //
            } else {

                while (cont != pos) {
                    aux = aux.sig;
                }
                aux.ant.sig = aux.sig;
                aux.sig.ant = aux.ant;
            }
        }

    }

    ///////////////COMPARADORES
    public Comparator<T> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    ///////////////ITERADORES
    private class IteradorDescendente implements Iterator<T> {

        NodoDoble<T> aux;

        public IteradorDescendente() {
            aux = cabecera;
        }

        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public T next() {
            T datoG = aux.dato;
            aux = aux.sig;
            return datoG;
        }

    }

    public Iterator<T> getDescendingIterator() {
        return new IteradorDescendente();
    }

    private class IteradorAscendente implements Iterator<T> {

        NodoDoble<T> aux;

        public IteradorAscendente() {
            aux = ultimo;
        }

        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public T next() {
            T datoG = aux.dato;
            aux = aux.ant;
            return datoG;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorAscendente();
    }

    private boolean esElementoIndex(int index) {
        return index >= 0 && index < cant;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + cant;
    }

    private void verificarElemento(int index) {
        if (!esElementoIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private NodoDoble<T> node(int index) {
        if (index < (cant >> 1)) {
            NodoDoble<T> x = cabecera;
            for (int i = 0; i < index; i++) {
                x = x.sig;
            }
            return x;
        } else {
            NodoDoble<T> x = ultimo;
            for (int i = cant - 1; i > index; i--) {
                x = x.ant;
            }
            return x;
        }
    }

    public T get(int index) {
        verificarElemento(index);
        return node(index).dato;
    }

    public Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public int cantNodos() {

        NodoDoble<T> nodo = cabecera;

        while (nodo != null) {
            cant++;
            nodo = nodo.sig;
        }

        return cant;
    }

    public void ordenarPorBurbuja() {
        for (NodoDoble<T> i = cabecera; i != null; i = i.sig) {
            for (NodoDoble<T> j = i; j != null; j = j.sig) {
                if (comparador.compare(i.dato, j.dato) > 0) {
                    //Intercambiar
                    intercambiar(i, j);
                }
            }
        }
    }

    private void intercambiar(NodoDoble<T> i, NodoDoble<T> j) {
        T aux = i.dato;
        i.dato = j.dato;
        j.dato = aux;
    }

    @Override
    public String toString() {
        return "Lista{" + "cabecera=" + cabecera + '}';
    }

}
