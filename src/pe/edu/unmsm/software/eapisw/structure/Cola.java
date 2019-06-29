package pe.edu.unmsm.software.eapisw.structure;

import java.util.Comparator;
import java.util.Iterator;

public class Cola<T> implements Iterable<T> {

    public class Nodo<T> {
        
        private Nodo<T> sgte;
        private T dato;

        public Nodo(T dato) {
            this.dato = dato;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }
        
    }

    private Nodo<T> cabecera;
    private Nodo<T> ultimo;
    private Comparator<T> comparador;
    private int longitud;

    public Nodo<T> getCab() {
        return cabecera;
    }

    public void setCab(Nodo<T> cab) {
        this.cabecera = cab;
    }

    public Nodo<T> getUlt() {
        return ultimo;
    }

    public void setUlt(Nodo<T> ult) {
        this.ultimo = ult;
    }

    public void encolar(T elementoNuevo) {
        Nodo<T> nuevo = new Nodo<>(elementoNuevo);

        if (cabecera == null) {
            cabecera = nuevo;
            ultimo = nuevo;
        } else {
            Nodo<T> aux = cabecera;
            while (aux.sgte != null) {
                aux = aux.sgte;
            }
            aux.sgte = nuevo;
            ultimo = nuevo;
        }
        longitud++;

    }

    public T desencolar() {

        T aux = cabecera.dato;
        if (cabecera == null) {

        } else {
            cabecera = cabecera.sgte;
            longitud--;
        }
        return aux;

    }

    public int getLongitud() {
        return longitud;
    }
    
    

    public String mostrarElementos() {
        Nodo<T> aux = cabecera;
        String represenCad = "";
        while (aux != null) {
            represenCad += aux.dato + ", ";
            aux = aux.sgte;
        }
        return represenCad;
    }

    public Comparator<T> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    class IteradorCola implements Iterator<T> {

        Nodo<T> aux = cabecera;

        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public T next() {
            T dato = aux.dato;
            aux = aux.sgte;
            return dato;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorCola();
    }
    
    public void ordenarPorBurbuja() {
        for (Nodo<T> i = cabecera; i != null; i = i.sgte) {
            for (Nodo<T> j = i; j != null; j = j.sgte) {
                if (comparador.compare(i.dato, j.dato) > 0) {
                    //Intercambiar
                    intercambiar(i, j);
                }
            }
        }
    }

    private void intercambiar(Nodo<T> i, Nodo<T> j) {
        T aux = i.dato;
        i.dato = j.dato;
        j.dato = aux;
    }

    @Override
    public String toString() {
        return "Cola{" + "cabecera=" + cabecera + '}';
    }

}
