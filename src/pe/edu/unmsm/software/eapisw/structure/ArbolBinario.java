package pe.edu.unmsm.software.eapisw.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import pe.edu.unmsm.software.eapisw.model.Producto;

public class ArbolBinario<T extends Comparable<T>> {

    private class NodoBinario<T> {

        private NodoBinario izquierda;
        private NodoBinario derecha;
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
    private int longitud;
    //COMPARADOR
    private final Comparator<T> comparador = (T o1, T o2) -> o1.compareTo(o2);

    public void insertar(T dato) {
        NodoBinario<T> nuevo = new NodoBinario<>(dato);
        insertarRecursivo(nuevo, raiz);
    }

    public int getLongitud() {
        return longitud;
    }

    private boolean insertarRecursivo(NodoBinario<T> nuevo, NodoBinario<T> aux) {
        if (this.raiz == null) {
            raiz = nuevo;
            longitud++;
        } else {
            if (comparador.compare(nuevo.dato, aux.dato) < 0) {
                if (aux.izquierda == null) {
                    aux.izquierda = nuevo;
                    longitud++;
                } else {
                    insertarRecursivo(nuevo, aux.izquierda);
                }
            } else {
                if (comparador.compare(nuevo.dato, aux.dato) == 0) {
                    return false;
                } else {
                    if (aux.derecha == null) {
                        aux.derecha = nuevo;
                        longitud++;
                    } else {
                        insertarRecursivo(nuevo, aux.derecha);
                    }
                }
            }
        }
        return true;
    }

    //Buscar dato
    public NodoBinario<T> buscar(T dato) {
        NodoBinario<T> aux = raiz;
        while (comparador.compare(aux.getDato(), dato) != 0) {
            if (comparador.compare(dato, aux.getDato()) < 0) {
                aux = aux.izquierda;
            } else {
                aux = aux.derecha;
            }
            if (aux == null) {
                return null;
            }
        }
        //System.out.println(aux);
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
                aux = aux.izquierda;
            } else {
                esHijoIzq = false;
                aux = aux.derecha;
            }
            if (aux == null) {
                return false;
            }
        }//Fin del While

        //Si no tiene hijos
        if (aux.derecha == null && aux.izquierda == null) {
            if (aux == raiz) { //Si solo hay un elemento
                raiz = null;
            } else if (esHijoIzq) { //Si el hijo es izquierdo
                padre.izquierda = null;
            } else {//Si el hijo es derecho
                padre.derecha = null;
            }//Fin del if
        } else if (aux.derecha == null) {
            if (aux == raiz) { //Lo apuntaremos al hijo izquierdo si solo la raiz tiene hijo izquierdo
                raiz = aux.izquierda;
            } else if (esHijoIzq) { //Si el hijo es izquierdo
                padre.izquierda = aux.izquierda;
            } else {//Si el hijo es derecho
                padre.derecha = aux.izquierda;
            }//Fin del if
        } else if (aux.izquierda == null) {
            if (aux == raiz) { //Lo apuntaremos al hijo izquierdo si solo la raiz tiene hijo derecho
                raiz = aux.derecha;
            } else if (esHijoIzq) { //Si el hijo es izquierdo
                padre.izquierda = aux.derecha;
            } else {//Si el hijo es derecho
                padre.derecha = aux.derecha;
            }//Fin del if
        } else { //Si tiene dos hijos
            NodoBinario<T> reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.izquierda = reemplazo;
            } else {
                padre.derecha = reemplazo;
            }

            reemplazo.izquierda = aux.izquierda;
        }

        return true;
    }

    //Halla el nodo Reemplazo
    public NodoBinario<T> obtenerNodoReemplazo(NodoBinario<T> subarbol) {
        NodoBinario<T> reemplazarPadre = subarbol;
        NodoBinario<T> reemplazo = subarbol;
        NodoBinario<T> aux = subarbol.derecha;
        while (aux != null) {
            reemplazarPadre = reemplazo; //Se reasigna el padre
            reemplazo = aux; //Se reasigna el hijo
            aux = aux.izquierda; //Reasignamos el auxiliar
        }

        if (reemplazo != subarbol.derecha) {
            reemplazarPadre.izquierda = reemplazo.derecha;
            reemplazo.derecha = subarbol.derecha;
        }
        return reemplazo;
    }

    //PREORDEN
    public void preOrden() {
        NodoBinario<T> aux = raiz;
        preOrdenRecursivo(aux);
    }

    private void preOrdenRecursivo(NodoBinario<T> subarbol) {
        if (subarbol != null) {
            System.out.println(subarbol.dato);
            preOrdenRecursivo(subarbol.izquierda);
            preOrdenRecursivo(subarbol.derecha);
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
            inOrdenRecursivo(subarbol.izquierda);
            System.out.println(subarbol.dato);
            inOrdenRecursivo(subarbol.derecha);
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
            postOrdenRecursivo(subarbol.izquierda);
            postOrdenRecursivo(subarbol.derecha);
            System.out.println(subarbol.dato);
        }
    }

    ArrayList<T> arrayL = new ArrayList<>();

    private void getArray(NodoBinario<T> subarbol) {
        if (subarbol != null) {
            getArray(subarbol.izquierda);
            arrayL.add(subarbol.getDato());
            getArray(subarbol.derecha);
        }
    }

    public ArrayList getInOrden() {
        getArray(raiz);
        return arrayL;
    }

    public static void main(String[] args) {
        ArbolBinario<Producto> arbol = new ArbolBinario<>();
        Producto pA = new Producto("aaytr", "Gsdaa", "65", "8787", 5, 98);
        Producto pB = new Producto("rytytrtty", "Gauyta", "65", "8787", 5, 98);
        Producto pC = new Producto("ztyuasd", "Gatga", "65", "8787", 5, 98);
        Producto pD = new Producto("dfas", "Gafga", "65", "8787", 5, 98);
        Producto pE = new Producto("vcxc", "Gsdaa", "65", "8787", 5, 98);
        arbol.insertar(pA);
        arbol.insertar(pB);
        arbol.insertar(pC);
        arbol.insertar(pD);
        arbol.insertar(pE);
        arbol.insertar(new Producto("tyutyu", "Gsdaa", "65", "8787", 5, 98));
        arbol.insertar(new Producto("fddfdd", "Gsdaa", "65", "8787", 5, 98));
        arbol.insertar(new Producto("paaaa", "Gsdaa", "65", "8787", 5, 98));
        arbol.insertar(new Producto("gaaaaa", "Gsdaa", "65", "8787", 5, 98));
        arbol.insertar(new Producto("juaasasjuas", "Gsdaa", "65", "8787", 5, 98));

        arbol.inOrden();

        System.out.println("\n--------------------------\n");

        //System.out.println(arbol.buscar(pC).dato);
        //arbol.inOrden();
        //ArrayList<Producto> arr = arbol.getInOrdenRecursivo(arbol.raiz);
        //System.out.println(arr);
    }
}
