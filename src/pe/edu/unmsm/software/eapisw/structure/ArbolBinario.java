package pe.edu.unmsm.software.eapisw.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import pe.edu.unmsm.software.eapisw.model.Producto;

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

    //Buscar dato
    public NodoBinario buscar(T dato) {
        NodoBinario<T> aux = raiz;
        while (comparador.compare(aux.getDato(), dato) != 0) {
            if (comparador.compare(dato, aux.getDato()) < 0) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

    //Eliminar dato
    public boolean eliminar(T dato) {
        NodoBinario<T> aux = raiz;
        NodoBinario<T> padre = raiz;
        boolean esHijoIzq = true;
        while (comparador.compare(aux.getDato(), dato) != 0) {
            padre = aux;
            if (comparador.compare(dato, aux.getDato()) < 0) {
                esHijoIzq = true;
                aux = aux.izq;
            } else {
                esHijoIzq = false;
                aux = aux.der;
            }
            if (aux == null) {
                return false;
            }
        }//Fin del While
        
        //Si no tiene hijos
        if(aux.der==null && aux.izq==null){
            
        }
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

    public ArrayList<T> getInOrden() {
        ArrayList<T> lista = null;
        if (raiz != null) {
            NodoBinario<T> aux = raiz;
            lista = getInOrdenRecursivo(aux);
            return lista;
        }
        return null;
    }

    ArrayList<T> arrayL = new ArrayList<>();

    private ArrayList<T> getInOrdenRecursivo(NodoBinario<T> subarbol) {

        if (subarbol != null) {
            if (subarbol.izq != null) {
                getInOrdenRecursivo(subarbol.izq);
                arrayL.add((T) subarbol.getDato());

                if (subarbol.der != null) {
                    getInOrdenRecursivo(subarbol.der);
                }
            } else {
                arrayL.add((T) subarbol.getDato());
            }
        }
        return arrayL;
    }

    public static void main(String[] args) {
        ArbolBinario<Producto> arbol = new ArbolBinario<>();
        arbol.insertar(new Producto("rytytrtty", "Gauyta", "65", "8787", 5, 98));
        arbol.insertar(new Producto("ztyuasd", "Gatga", "65", "8787", 5, 98));
        arbol.insertar(new Producto("dfas", "Gafga", "65", "8787", 5, 98));
        arbol.insertar(new Producto("vcxc", "Gsdaa", "65", "8787", 5, 98));
        arbol.insertar(new Producto("aaytr", "Gsdaa", "65", "8787", 5, 98));

        System.out.println(arbol.getInOrden());

    }

}
