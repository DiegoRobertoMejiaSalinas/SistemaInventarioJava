package pe.edu.unmsm.software.eapisw.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
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
    private Comparator<T> comparador = (T o1, T o2) -> o1.compareTo(o2);

    ///////////////COMPARADORES
    public Comparator<T> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    public void insert(T dato) {
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
                    //System.out.println("Se repite");
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

    public void insertar(T valor) {
        if (raiz == null) {
            raiz = new NodoBinario<>(valor);
            return ;
        } else {
            NodoBinario<T> actual = raiz;

            while (true) {
                //System.out.println(raiz.dato);
                //System.out.println(valor.compareTo(actual.dato));
                //return ;
                if (valor.compareTo(actual.dato) > 0) {
                    if (actual.derecha != null) {
                        actual = actual.derecha;
                    } else {
                        actual.derecha = new NodoBinario(valor);
                        longitud++;
                        return ;
                    }
                } else if (valor.compareTo(actual.dato) < 0) {
                    if (actual.izquierda != null) {
                        actual = actual.izquierda;
                    } else {
                        actual.izquierda = new NodoBinario(valor);
                        longitud++;
                        return ;
                    }
                } else {
                    //System.out.println("g");
                    return ;
                }
            }
        }
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
            if (subarbol.getDato() != null) {
                arrayL.add(subarbol.getDato());
            }
            getArray(subarbol.derecha);
        }
    }

    public ArrayList getInOrden() {
        getArray(raiz);
        return arrayL;
    }
}
