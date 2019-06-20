package pe.edu.unmsm.software.eapisw.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArbolAVL<T extends Comparable<T>> {

    private final Comparator<T> comparador = (T o1, T o2) -> o1.compareTo(o2);
    private int cantidad = 0;

    public class NodoAVL<T> {

        private NodoAVL<T> izquierda, derecha, padre;
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

    public NodoAVL insertar(NodoAVL<T> nodo, T valor) {
        //Para arbol ABB
        if (nodo == null) {
            cantidad++;
            return (new NodoAVL(valor));
        }

        if (comparador.compare(valor, nodo.dato) < 0) { //valor < nodo.dato
            nodo.izquierda = insertar(nodo.izquierda, valor);

        } else if (comparador.compare(valor, nodo.dato) > 0) {
            nodo.derecha = insertar(nodo.derecha, valor);
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
            System.out.printf("%d ", root.dato);
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

    public NodoAVL borrarNodo(NodoAVL<T> raiz, T value) {
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

    public void imprimirArbolito(NodoAVL root) {

        if (root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.altura,
                width = (int) Math.pow(2, height - 1);

        // Preparing variables for loop.
        List<NodoAVL> current = new ArrayList<NodoAVL>(1);
        List<NodoAVL> next = new ArrayList<NodoAVL>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength * width);
        for (int i = 0; i < maxHalfLength * width; i++) {
            sb.append(' ');
        }
        String textBuffer;

        // Iterating through height levels.
        for (int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));

            // Creating spacer space indicator.
            textBuffer = sb.toString();

            // Print tree node elements
            for (NodoAVL n : current) {

                System.out.print(textBuffer);

                if (n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.dato);
                    next.add(n.izquierda);
                    next.add(n.derecha);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            // Print tree node extensions for next level.
            if (i < height - 1) {

                for (NodoAVL n : current) {

                    System.out.print(textBuffer);

                    if (n == null) {
                        System.out.print("        ");
                    } else {
                        System.out.printf("%s      %s",
                                n.izquierda == null ? " " : "/", n.derecha == null ? " " : "\\");
                    }

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            // Renewing indicators for next run.
            elements *= 2;
            current = next;
            next = new ArrayList<NodoAVL>(elements);

        }

    }

    public static void main(String[] args) {
        ArbolAVL t = new ArbolAVL();
        ArbolAVL.NodoAVL root = null;
        root = t.insertar(root, 6);
        root = t.insertar(root, 2);
        root = t.insertar(root, 1);

        t.imprimirArbolito(root);
        //t.
    }
    /*public static void main(String args[]) {
     ArbolAVL t = new ArbolAVL();
     ArbolAVL.NodoAVL root = null;
     while (true) {
     System.out.println("(1) Insert");
     System.out.println("(2) Delete");

     try {
     BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
     String s = bufferRead.readLine();

     if (Integer.parseInt(s) == 1) {
     System.out.print("Value to be inserted: ");
     root = t.insertar(root, Integer.parseInt(bufferRead.readLine()));
     } else if (Integer.parseInt(s) == 2) {
     System.out.print("Value to be deleted: ");
     root = t.borrarNodo(root, Integer.parseInt(bufferRead.readLine()));
     } else {
     System.out.println("Invalid choice, try again!");
     continue;
     }

     t.imprimirArbolito(root);
     System.out.println("\n\nCantidad: " + t.getCantidad());

     } catch (IOException e) {
     e.printStackTrace();
     }
     }
     }*/
}
