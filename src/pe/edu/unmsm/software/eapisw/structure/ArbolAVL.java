package pe.edu.unmsm.software.eapisw.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pe.edu.unmsm.software.eapisw.model.Producto;

public class ArbolAVL<T extends Comparable<T>> {

    private Comparator<T> comparador = (T o1, T o2) -> o1.compareTo(o2);
    private int cantidad = 0;
    private NodoAVL<T> raiz;

    public class NodoAVL<T> {

        public NodoAVL<T> izquierda, derecha, padre;
        private int altura = 1;
        private T dato;

        private NodoAVL(T val) {
            this.dato = val;
        }

        public NodoAVL getIzquierda() {
            return izquierda;
        }

        public void setIzquierda(NodoAVL izquierda) {
            this.izquierda = izquierda;
        }

        public NodoAVL getDerecha() {
            return derecha;
        }

        public void setDerecha(NodoAVL derecha) {
            this.derecha = derecha;
        }

        public NodoAVL getPadre() {
            return padre;
        }

        public void setPadre(NodoAVL padre) {
            this.padre = padre;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

    }

    public int getAltura(NodoAVL subarbol) {
        if (subarbol == null) {
            return 0;
        }
        return subarbol.altura;
    }

    ///////////////COMPARADORES
    public Comparator<T> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    //public NodoAVL<T> insertar(T valor){
    public void insertar(T valor) {

        //NodoAVL<T> nuevo = new NodoAVL<>(valor);
        //insertarRecursivo(raizDef, nuevo);
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoAVL<T> insertarRecursivo(NodoAVL<T> nodo, T valor) {
        //Para arbol ABB
        if (nodo == null) {
            cantidad++;
            return (new NodoAVL(valor));
        }

        if (comparador.compare(valor, nodo.dato) < 0) { //valor < nodo.dato
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);

        } else {
            nodo.derecha = insertarRecursivo(nodo.derecha, valor);
        }

        //Actualiza la altura del nodo anterior
        nodo.altura = Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha)) + 1;

        //Consigue el balance del nodo
        int balance = getBalance(nodo);

        // Caso Izquierdo Izquierdo
        if (balance > 1 && comparador.compare(valor, nodo.izquierda.dato) < 0) { //valor < nodo.izquierda.dato
            return rotacionDerecha(nodo);
        }

        // Caso Derecho Derecho
        if (balance < -1 && comparador.compare(valor, nodo.derecha.dato) > 0) { //valor > nodo.derecha.dato
            return rotacionIzquierda(nodo);
        }

        // Caso Izquierdo Derecho
        if (balance > 1 && comparador.compare(valor, nodo.izquierda.dato) > 0) { //valor > nodo.izquierda.dato
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        // Caso Derecho Izquierdo
        if (balance < -1 && comparador.compare(valor, nodo.derecha.dato) < 0) { //valor < nodo.derecha.dato
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        // Se realiza la rotacion
        x.derecha = y;
        y.izquierda = T2;

        //  Actualizar alturas
        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;
        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;

        // Retorna la nueva raiz
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        // Se realiza la rotacion
        y.izquierda = x;
        x.derecha = T2;

        //  Actualizar alturas
        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;
        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;

        // Retorna la nueva raiz
        return y;
    }

    private int getBalance(NodoAVL N) {
        if (N == null) {
            return 0;
        }
        return getAltura(N.izquierda) - getAltura(N.derecha);
    }

    public void preOrden(NodoAVL root) {
        if (root != null) {
            preOrden(root.izquierda);
            //System.out.printf("%d ", root.dato);
            System.out.println(root.getDato());
            preOrden(root.derecha);
        }
    }

    public NodoAVL nodoMinimo(NodoAVL node) {
        NodoAVL current = node;
        while (current.izquierda != null) {
            current = current.izquierda;
        }
        return current;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void borrar(T value) {
        raiz = borrarNodo(raiz, value);

    }

    private NodoAVL borrarNodo(NodoAVL<T> raiz, T value) {
        // Hará borrado ABB
        if (raiz == null) {
            return raiz;
        }

        // Para arbol ABB
        if (comparador.compare(value, raiz.dato) < 0) { //value < raiz.dato
            raiz.izquierda = borrarNodo(raiz.izquierda, value);
        } else if (comparador.compare(value, raiz.dato) > 0) { //value > raiz.dato
            raiz.derecha = borrarNodo(raiz.derecha, value);
        } else {
            // Nodo con solo uno o sin hijo
            if ((raiz.izquierda == null) || (raiz.derecha == null)) {

                NodoAVL aux;
                if (raiz.izquierda != null) {
                    aux = raiz.izquierda;
                } else {
                    aux = raiz.derecha;
                }

                // Sin hijos
                if (aux == null) {
                    aux = raiz;
                    raiz = null;

                } else // Un solo hijo
                {
                    raiz = aux; // Copia el contenido del hijo no vacio
                }
                aux = null;
                cantidad--;
            } else {
                // Nodo con dos hijos: Consigue el sucesor inOrden
                // (El más pequeño en el subarbol derecho)
                NodoAVL<T> temp = nodoMinimo(raiz.derecha);

                // Copia el sucesor inOrden al nodo actual
                raiz.dato = temp.dato;

                // Elimina el sucesor inOrden
                raiz.derecha = borrarNodo(raiz.derecha, temp.dato);
            }
        }

        if (raiz == null) {
            return raiz;
        }

        // Actualizar altura del nodo actual
        raiz.altura = Math.max(getAltura(raiz.izquierda), getAltura(raiz.derecha)) + 1;

        // Conseguir el balance del nodo actual
        int balance = getBalance(raiz);

        // Casos en caso de desbalanceo
        // Caso Izquierdo Izquierdo
        if (balance > 1 && getBalance(raiz.izquierda) >= 0) {
            return rotacionDerecha(raiz);
        }

        // Caso Izquierdo Derecho
        if (balance > 1 && getBalance(raiz.izquierda) < 0) {
            raiz.izquierda = rotacionIzquierda(raiz.izquierda);
            return rotacionDerecha(raiz);
        }

        // Caso Derecho Derecho
        if (balance < -1 && getBalance(raiz.derecha) <= 0) {
            return rotacionIzquierda(raiz);
        }

        // Caso Derecho Izquierdo
        if (balance < -1 && getBalance(raiz.derecha) > 0) {
            raiz.derecha = rotacionDerecha(raiz.derecha);
            return rotacionIzquierda(raiz);
        }

        return raiz;
    }

    public NodoAVL<T> getRaiz() {
        return this.raiz;
    }

    //Buscar dato
    public NodoAVL<T> buscar(T dato) {
        NodoAVL<T> aux = raiz;
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

    ArrayList<T> arrayL = new ArrayList<>();

    private void getArray(NodoAVL<T> subarbol) {
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
        ArbolAVL<Producto> arbol= new ArbolAVL();
        
        arbol.insertar(new Producto("112", "sa", null, null, 3213, 12));
        arbol.insertar(new Producto("24", "bm", null, null, 54, 10.2));
        arbol.insertar(new Producto("3", "cv", null, null, 2, 45));
        arbol.insertar(new Producto("4", "df", null, null, 3, 4));
        arbol.insertar(new Producto("5", "z", null, null, 10, 42.54));
        arbol.insertar(new Producto("6", "zxc", null, null, 1, 415.2));
        arbol.insertar(new Producto("7", "cx", null, null, 9, 15.9));
        arbol.insertar(new Producto("8", "bv", null, null, 6, 12.2));
        arbol.insertar(new Producto("9", "uyi", null, null, 356, 1.3));
        arbol.insertar(new Producto("12", "ty", null, null, 454, 9));
        arbol.insertar(new Producto("134", "iuiu", null, null, 39, 4.65));
        
        System.out.println(arbol.getCantidad());
        
        ArrayList<Producto> array= arbol.getInOrden();
        
        //System.out.println(array);
    }

}
