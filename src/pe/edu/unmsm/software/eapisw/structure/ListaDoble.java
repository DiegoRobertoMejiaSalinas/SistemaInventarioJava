package pe.edu.unmsm.software.eapisw.structure;

import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ListaDoble<T> implements Iterable<T> {

    public class NodoDoble<T> {

        private NodoDoble<T> siguiente;
        private NodoDoble<T> anterior;
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

        public NodoDoble<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoDoble<T> sig) {
            this.siguiente = sig;
        }

        public NodoDoble<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(NodoDoble<T> ant) {
            this.anterior = ant;
        }

    }

    private NodoDoble<T> cabecera;
    private NodoDoble<T> ultimo;
    private Comparator<T> comparador;
    private int longitud = 0;

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

    public void setFirst(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        nuevoNodo.siguiente = cabecera;

        if (cabecera != null) {
            cabecera.anterior = nuevoNodo;
        } else {
            ultimo = nuevoNodo;

        }
        cabecera = nuevoNodo;
        longitud++;

    }

    public void setLast(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        NodoDoble<T> aux = cabecera;

        if (cabecera == null) {
            cabecera = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevoNodo;
            nuevoNodo.anterior = aux;
            nuevoNodo.siguiente = null;
            ultimo = nuevoNodo;
        }
        longitud++;

    }

    public void remove(int pos) { // dato

        NodoDoble<T> aux = cabecera;
        int cont = 1;

        if (cabecera == null) {
            //
        } else {
            if (pos > longitud || pos == 1) {
                //
            } else {

                while (cont != pos) {
                    aux = aux.siguiente;
                }
                aux.anterior.siguiente = aux.siguiente;
                aux.siguiente.anterior = aux.anterior;
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
            aux = aux.siguiente;
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
            aux = aux.anterior;
            return datoG;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorAscendente();
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < longitud;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + longitud;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private NodoDoble<T> node(int index) {
        if (index < (longitud >> 1)) {
            NodoDoble<T> x = cabecera;
            for (int i = 0; i < index; i++) {
                x = x.siguiente;
            }
            return x;
        } else {
            NodoDoble<T> x = ultimo;
            for (int i = longitud - 1; i > index; i--) {
                x = x.anterior;
            }
            return x;
        }
    }

    public T get(int index) {
        checkElementIndex(index);
        return node(index).dato;
    }

    public Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public int getLongitud() {

        return longitud;
    }

    /*public void ordenamientoBurbuja() {
        for (NodoDoble<T> i = cabecera; i != null; i = i.siguiente) {
            for (NodoDoble<T> j = i; j != null; j = j.siguiente) {
                if (comparador.compare(i.dato, j.dato) > 0) {
                    //Intercambiar
                    intercambiar(i, j);
                }
            }
        }
    }*/
    
    public void ordenamientoBurbuja(){
        for (NodoDoble<T> i = getCabecera(); i != null; i = i.getSiguiente()) {
            for (NodoDoble<T> j = i; j != null; j = j.getSiguiente()) {
                if (comparador.compare(i.getDato(), j.getDato()) > 0) {
                    intercambiar(i, j);
                }
            }
        }
    }

    public void ordenamientoInsercion() {
        int n = getLongitud();

        for (int i = 1; i < n; i++) {
            T key = node(i).getDato();
            int j = i - 1;

            while (j >= 0 && comparador.compare(node(j).getDato(), key) > 0) {
                node(j + 1).setDato(node(j).getDato());
                j = j - 1;
            }
            node(j + 1).setDato(key);
        }
    }

    public void ordenamientoSeleccion() {
        int n = getLongitud();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparador.compare(node(j).getDato(), node(min_idx).getDato()) < 0) {
                    min_idx = j;
                }
            }
            intercambiar(node(min_idx), node(i));

        }
    }

    public void ordenamientoQuicksort(int izquierda, int derecha) {
        T pivote = node(izquierda).getDato();

        int i = izquierda;
        int j = derecha;

        while (i < j) {

            while (comparador.compare(node(i).getDato(), pivote) <= 0 && i < j) {
                i++;
            }
            while (comparador.compare(node(j).getDato(), pivote) > 0) {
                j--;
            }

            if (i < j) {
                intercambiar(node(i), node(j));
            }
        }

        node(izquierda).setDato(node(j).getDato());
        node(j).setDato(pivote);

        if (izquierda < j - 1) {
            ordenamientoQuicksort(izquierda, j - 1);
        }
        if (j + 1 < derecha) {
            ordenamientoQuicksort(j + 1, derecha);
        }
    }

    private void intercambiar(NodoDoble<T> i, NodoDoble<T> j) {
        T aux = i.dato;
        i.dato = j.dato;
        j.dato = aux;
    }

    @Override
    public String toString() {
        NodoDoble<T> aux = cabecera;
        String cont = "";
        while (aux != null) {
            cont += aux.getDato() + "\n";
            aux = aux.getSiguiente();
        }
        return cont;
    }

    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();
        lista.setLast(5);
        lista.setLast(2);
        lista.setLast(54);
        lista.setLast(23);
        lista.setLast(1);
        lista.setLast(67);
        System.out.println(lista);
        System.out.println("Ordenamiento");
        lista.ordenamientoBurbuja();
        System.out.println(lista);
    }

}
