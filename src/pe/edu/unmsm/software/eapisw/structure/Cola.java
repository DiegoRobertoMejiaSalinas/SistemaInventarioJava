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

    private Nodo<T> cab;
    private Nodo<T> ult;
    private Comparator<T> comparador;

    public Nodo<T> getCab() {
        return cab;
    }

    public void setCab(Nodo<T> cab) {
        this.cab = cab;
    }

    public Nodo<T> getUlt() {
        return ult;
    }

    public void setUlt(Nodo<T> ult) {
        this.ult = ult;
    }

    public void encolar(T elementoNuevo) {
        Nodo<T> nuevo = new Nodo<>(elementoNuevo);

        if (cab == null) {
            cab = nuevo;
            ult = nuevo;
        } else {
            Nodo<T> aux = cab;
            while (aux.sgte != null) {
                aux = aux.sgte;
            }
            aux.sgte = nuevo;
            ult = nuevo;
        }

    }

    public T desencolar() {

        T aux = cab.dato;
        if (cab == null) {

        } else {
            cab = cab.sgte;
        }
        return aux;

    }

    public String mostrarElementos() {
        Nodo<T> aux = cab;
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

        Nodo<T> aux = cab;

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
        for (Nodo<T> i = cab; i != null; i = i.sgte) {
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
        return "Cola{" + "cabecera=" + cab + '}';
    }

}
