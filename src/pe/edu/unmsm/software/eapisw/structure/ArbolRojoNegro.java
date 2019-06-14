package pe.edu.unmsm.software.eapisw.structure;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ArbolRojoNegro<T extends Comparable<? super T>> implements Serializable {

    public class NodoRojoNegro<T extends Comparable<? super T>> implements Serializable {
        // -----------------------------------------------------------------
        // Constantes
        // -----------------------------------------------------------------

        private static final long serialVersionUID = 1L;

        public static final int NEGRO = 1;
        public static final int ROJO = 0;

        // -----------------------------------------------------------------
        // Atributos
        // -----------------------------------------------------------------
        private NodoRojoNegro<T> derecho;
        private NodoRojoNegro<T> izquierdo;
        private T elem;
        private int color;
        private NodoRojoNegro<T> padre;

        // -----------------------------------------------------------------
        // Constructores
        // -----------------------------------------------------------------
        protected NodoRojoNegro(T elem) {
            this.elem = elem;
            color = ROJO;
            cambiarHijoDerecho(new NodoRojoNegro<T>());
            cambiarHijoIzquierdo(new NodoRojoNegro<T>());
            padre = null;
        }

        private NodoRojoNegro() {
            this.elem = null;
            color = NEGRO;
            padre = null;
        }

        // -----------------------------------------------------------------
        // Métodos consultores básicos
        // -----------------------------------------------------------------
        public NodoRojoNegro<T> darPadre() {
            return padre;
        }

        public NodoRojoNegro<T> darTio() {
            if (padre == null || padre.padre == null) {
                return null;
            } else {
                if (padre.padre.esHijoDerecho(padre)) {
                    return padre.padre.izquierdo;
                } else {
                    return padre.padre.derecho;
                }
            }

        }

        public int darColor() {
            return color;
        }

        public NodoRojoNegro<T> darHijoDerecho() {
            return derecho;
        }

        public boolean esHijoDerecho(NodoRojoNegro<T> nodo) {
            return derecho == nodo;
        }

        public NodoRojoNegro<T> darHijoIzquierdo() {
            return izquierdo;
        }

        public boolean esHijoIzquierdo(NodoRojoNegro<T> nodo) {
            return izquierdo == nodo;
        }

        public boolean hijoDerechoHoja() {
            return derecho.elem == null;
        }

        public boolean hijoIzquierdoHoja() {
            return izquierdo.elem == null;
        }

        public NodoRojoNegro<T> darMayor() {
            return hijoDerechoHoja() ? this : derecho.darMayor();
        }

        public NodoRojoNegro<T> darMenor() {
            return hijoIzquierdoHoja() ? this : izquierdo.darMenor();
        }

        public void darPreorden(List<T> preorden) {
            preorden.add(elem);
            if (!hijoIzquierdoHoja()) {
                izquierdo.darPreorden(preorden);
            }
            if (!hijoDerechoHoja()) {
                derecho.darPreorden(preorden);
            }
        }

        public boolean esHoja() {
            return elem == null;
        }

        public int darPeso() {
            return esHoja() ? 0 : 1 + derecho.darPeso() + izquierdo.darPeso();
        }

        public void darHojas(List<NodoRojoNegro<T>> hojas) {
            if (esHoja()) {
                hojas.add(this);
            } else {
                if (!hijoDerechoHoja()) {
                    derecho.darHojas(hojas);
                }
                if (!hijoIzquierdoHoja()) {
                    izquierdo.darHojas(hojas);
                }
            }
        }

        public int darAltura() {
            if (esHoja()) {
                return 0;
            }
            int a1 = izquierdo.darAltura();
            int a2 = derecho.darAltura();
            return (a1 >= a2) ? a1 + 1 : a2 + 1;
        }

        public boolean existe(T e) {
            try {
                darNodo(e);
                return true;
            } catch (Exception e1) {
                return false;
            }

        }

        public NodoRojoNegro<T> darNodo(T elem) throws Exception {
            int comp = elem.compareTo(this.elem);
            if (comp == 0) {
                return this;
            } else if (comp < 0) {
                if (!hijoIzquierdoHoja()) {
                    return izquierdo.darNodo(elem);
                } else {
                    return null;
                }
            } else {
                if (!hijoDerechoHoja()) {
                    return derecho.darNodo(elem);
                } else {
                    return null;
                }
            }

        }

        public T darInfoNodo() {
            return elem;
        }

        public boolean hijoDerechoNegro() {
            return derecho.color == NEGRO;
        }

        public boolean hijoIzquierdoNegro() {
            return izquierdo.color == NEGRO;
        }

        public boolean hijosNegros() {
            return hijoDerechoNegro() && hijoIzquierdoNegro();
        }

        public NodoRojoNegro<T> darHermano() {
            if (padre == null) {
                return null;
            } else {
                return padre.esHijoDerecho(this) ? padre.izquierdo : padre.derecho;
            }
        }

        // -----------------------------------------------------------------
        // Setters
        // -----------------------------------------------------------------
        private void cambiarPadre(NodoRojoNegro<T> padre) {
            this.padre = padre;
        }

        protected void cambiarColor(int color) {
            this.color = color;
        }

        private void cambiarHijoDerecho(NodoRojoNegro<T> hijo) {
            if (hijo != null) {
                hijo.cambiarPadre(this);
            }
            derecho = hijo;
        }

        private void cambiarHijoIzquierdo(NodoRojoNegro<T> hijo) {
            if (hijo != null) {
                hijo.cambiarPadre(this);
            }
            izquierdo = hijo;
        }

        //Intercambia la información de un nodo con el ingresado
        private void cambiarElem(NodoRojoNegro<T> nodo) {
            if (nodo.elem != null) {
                T aux = elem;
                elem = nodo.elem;
                nodo.elem = aux;
            } else {
                elem = null;
                color = NEGRO;
                derecho = izquierdo = null;
            }
        }

        //Rota a la izquierda el nodo.
        private NodoRojoNegro<T> rotarIzquierda() {
            if (hijoDerechoHoja()) {
                return this;
            } else {
                NodoRojoNegro<T> hijoDerechoAux = derecho;
                cambiarHijoDerecho(hijoDerechoAux.darHijoIzquierdo());
                hijoDerechoAux.cambiarPadre(padre);
                hijoDerechoAux.cambiarHijoIzquierdo(this);
                return hijoDerechoAux;
            }
        }

        // Rota a la derecha el nodo.
        private NodoRojoNegro<T> rotarDerecha() {
            if (hijoIzquierdoHoja()) {
                return this;
            } else {
                NodoRojoNegro<T> hijoIzquierdoAux = izquierdo;
                cambiarHijoIzquierdo(hijoIzquierdoAux.darHijoDerecho());
                hijoIzquierdoAux.cambiarPadre(padre);
                hijoIzquierdoAux.cambiarHijoDerecho(this);
                return hijoIzquierdoAux;
            }
        }

        // -----------------------------------------------------------------
        // Métodos de inserción
        // -----------------------------------------------------------------
        //Inserta un nodo en la raiz de un árbol rojo negro son.
        protected NodoRojoNegro<T> insertar(NodoRojoNegro<T> nodo) throws Exception {
            insertarNormal(nodo);
            Retorno r = new Retorno(null);
            nodo.balanceoRojoNegroCaso1(r);
            return r.respuesta;
        }

        //Inserta un nuevo nodo   como si el árbol fuera un árbol binario ordenado.
        private void insertarNormal(NodoRojoNegro<T> nodo) throws Exception {
            if (elem.compareTo(nodo.darInfoNodo()) == 0) {
            } else if (elem.compareTo(nodo.darInfoNodo()) < 0) {
                if (hijoDerechoHoja()) {
                    derecho = nodo;
                    nodo.cambiarPadre(this);
                } else {
                    derecho.insertarNormal(nodo);
                }
            } else {
                if (hijoIzquierdoHoja()) {
                    izquierdo = nodo;
                    nodo.cambiarPadre(this);
                } else {
                    izquierdo.insertarNormal(nodo);
                }
            }
        }

        //de un nuevo nodo agregado en el árbol.
        private NodoRojoNegro<T> balanceoRojoNegroCaso1(Retorno r) {
            if (padre == null) {
                color = NEGRO;
                r.respuesta = this;
            } else {
                balanceoRojoNegroCaso2(r);
            }
            return r.respuesta;
        }

        //Segundo caso de balanceo en inserción.
        //Si el padre del nodo agregado es negro no se debe hacer nada ya que
        //reemplazar una hoja con un nodo rojo no afecta las propiedades del
        //árbol.
        private void balanceoRojoNegroCaso2(Retorno r) {
            if (padre.darColor() == ROJO) {
                balanceoRojoNegroCaso3(r);
            } else {
                r.respuesta = null;
            }

        }

        //Tercer caso de balanceo en inserción.
        //El nodo agregado tiene un padre y un tio rojos.
        private void balanceoRojoNegroCaso3(Retorno r) {
            NodoRojoNegro<T> tio = darTio();
            NodoRojoNegro<T> abuelo = padre.darPadre();
            r.respuesta = null;

            if (!tio.esHoja() && tio.darColor() == ROJO) {
                darPadre().cambiarColor(NEGRO);
                tio.cambiarColor(NEGRO);
                abuelo.cambiarColor(ROJO);
                abuelo.balanceoRojoNegroCaso1(r);
            } else {
                balanceoRojoNegroCaso4(r);
            }
        }

        //Cuarto caso de inserción.
        //El nodo ingresado es hijo derecho, su padre es hijo izquierdo y ambos
        //son rojos. El caso reflejado también se cubre.
        private void balanceoRojoNegroCaso4(Retorno r) {
            NodoRojoNegro<T> abuelo = padre.darPadre();
            r.respuesta = null;

            if (padre.esHijoDerecho(this) && abuelo.esHijoIzquierdo(padre)) {
                abuelo.cambiarHijoIzquierdo(padre.rotarIzquierda());
                izquierdo.balanceoRojoNegroCaso5(r);
            } else if (padre.esHijoIzquierdo(this) && abuelo.esHijoDerecho(padre)) {
                abuelo.cambiarHijoDerecho(padre.rotarDerecha());
                derecho.balanceoRojoNegroCaso5(r);
            } else {
                balanceoRojoNegroCaso5(r);
            }
        }

        //Quinto caso de inserción
        //El nodo y su padre son hijos izquierdos, son rojos y el tio es negro.
        //El caso reflejado también se cubre.
        private void balanceoRojoNegroCaso5(Retorno r) {
            NodoRojoNegro<T> abuelo = padre.darPadre();

            padre.cambiarColor(NEGRO);
            abuelo.cambiarColor(ROJO);

            if (padre.esHijoIzquierdo(this) && abuelo.esHijoIzquierdo(padre)) {
                if (abuelo.darPadre() == null) {
                    abuelo.rotarDerecha();
                } else if (abuelo.darPadre().esHijoDerecho(abuelo)) {
                    abuelo.darPadre().cambiarHijoDerecho(abuelo.rotarDerecha());
                } else {
                    abuelo.darPadre().cambiarHijoIzquierdo(abuelo.rotarDerecha());
                }

            } else {
                if (abuelo.darPadre() == null) {
                    abuelo.rotarIzquierda();
                } else if (abuelo.darPadre().esHijoDerecho(abuelo)) {
                    abuelo.darPadre().cambiarHijoDerecho(abuelo.rotarIzquierda());
                } else {
                    abuelo.darPadre().cambiarHijoIzquierdo(abuelo.rotarIzquierda());
                }
            }
            r.respuesta = padre;
        }

        // -----------------------------------------------------------------
        // Métodos de eliminación
        // -----------------------------------------------------------------
        //Elimina el nodo como si se tratara de un ABB
        protected NodoRojoNegro<T> eliminar() {
            // Encontrar el mínimo de la derecha o el máximo de la izquierda
            NodoRojoNegro<T> reemplazo = !hijoIzquierdoHoja() ? izquierdo.darMayor() : this.darMenor();

            // Hacer el cambio de los elementos en this y en reemplazo
            cambiarElem(reemplazo);

            // Ahora tenemos que eliminar reemplazo, el cual tiene como maximo un
            // hijo
            Retorno r = new Retorno(null);
            reemplazo.eliminarRojoNegro(r);

            return r.respuesta;
        }

        //Cambia los hijos de un nodo por hojas
        private void eliminarHijos() {
            derecho = new NodoRojoNegro<T>();
            izquierdo = new NodoRojoNegro<T>();
        }

        //Mantiene las propiedades del árbol cuando se va a eliminar un nodo.
        //Para este método se asume que el nodo a eliminar tiene maximo un hijo no hoja
        private void eliminarRojoNegro(Retorno r) {
            // Encuentra el hijo del nodo a eliminar. Este hijo es el unico hijo del bidi
            NodoRojoNegro<T> hijo = !hijoDerechoHoja() ? derecho : izquierdo;

            int colorBorrar = darColor();
            int colorHijo = hijo.darColor();

            cambiarElem(hijo);
            eliminarHijos();

            if (colorHijo == ROJO) {
                // Eliminar una hoja roja no efecta las propiedades del árbol;
                r.respuesta = this;
                return;
            } else if (colorHijo == NEGRO && colorBorrar == ROJO) {
                // El nodo a eliminar es negro y su hijo es una hoja roja
                r.respuesta = this;
                cambiarColor(NEGRO);
            } else {
                // El nodo a eliminar y su hijo son negros
                eliminarCaso1(r);
            }
        }

        //El nodo a eliminar es la raiz y esta no tiene hijos.
        private void eliminarCaso1(Retorno r) {
            if (padre != null) {
                this.eliminarCaso2(r);
            } else {
                r.respuesta = null;
            }
        }

        // El nodo a eliminar es negro y tiene un hermano rojo.
        private void eliminarCaso2(Retorno r) {
            // Por la estructura del árbol, este hermano nunca sera null
            NodoRojoNegro<T> hermano = darHermano();

            if (hermano.color == ROJO) {
                padre.color = ROJO;
                hermano.color = NEGRO;

                r.respuesta = hermano;

                NodoRojoNegro<T> abuelo = padre.padre;
                if (padre.esHijoDerecho(this)) {
                    if (abuelo != null) {
                        if (abuelo.esHijoDerecho(padre)) {
                            abuelo.cambiarHijoDerecho(padre.rotarDerecha());
                        } else {
                            abuelo.cambiarHijoIzquierdo(padre.rotarDerecha());
                        }
                    } else {
                        padre.rotarDerecha();
                    }
                } else {
                    if (abuelo != null) {
                        if (abuelo.esHijoDerecho(padre)) {
                            abuelo.cambiarHijoDerecho(padre.rotarIzquierda());
                        } else {
                            abuelo.cambiarHijoIzquierdo(padre.rotarIzquierda());
                        }
                    } else {
                        padre.rotarIzquierda();
                    }
                }
            }
            eliminarCaso3(r);
        }

        //El nodo a eliminar es negro y tiene un hermano negro.
        private void eliminarCaso3(Retorno r) {
            // Por la estructura del árbol, este hermano nunca sera null
            NodoRojoNegro<T> hermano = darHermano();

            if (padre.color == NEGRO && hermano.color == NEGRO && hermano.hijosNegros()) {
                hermano.cambiarColor(ROJO);
                padre.eliminarCaso1(r);
            } else {
                eliminarCaso4(r);
            }
        }

        //El nodo a eliminar es negro, su padre es rojo, su hermano es negro y
        //sus sobrinos son negros.
        private void eliminarCaso4(Retorno r) {
            // Por la estructura del árbol, este hermano nunca sera null
            NodoRojoNegro<T> hermano = darHermano();

            if (padre.color == ROJO && hermano.color == NEGRO && hermano.hijosNegros()) {
                hermano.cambiarColor(ROJO);
                padre.cambiarColor(NEGRO);
            } else {
                eliminarCaso5(r);
            }
        }

        //El nodo a eliminar es negro y es hijo izquierdo, su hermano es negro,
        //su sobrino izquierdo es rojo y su sobrino derecho es negro. El caso
        //reflejado también se cubre.
        private void eliminarCaso5(Retorno r) {
            // Por la estructura del árbol, este hermano nunca sera null
            NodoRojoNegro<T> hermano = darHermano();

            if (padre.esHijoIzquierdo(this) && hermano.color == NEGRO && !hermano.hijoIzquierdoNegro() && hermano.hijoDerechoNegro()) {
                hermano.color = ROJO;
                hermano.izquierdo.color = NEGRO;
                padre.cambiarHijoDerecho(hermano.rotarDerecha());
            } else if (padre.esHijoDerecho(this) && hermano.color == NEGRO && !hermano.hijoDerechoNegro() && hermano.hijoIzquierdoNegro()) {
                hermano.color = ROJO;
                hermano.derecho.color = NEGRO;
                padre.cambiarHijoIzquierdo(hermano.rotarIzquierda());
            }
            eliminarCaso6(r);
        }

        //El nodo a eliminar es negro y es hijo izquierdo, su hermano es negro
        //y su sobrino derecho es rojo. El caso reflejado también se cubre.
        private void eliminarCaso6(Retorno r) {
            // Por la estructura del árbol, este hermano nunca sera null
            NodoRojoNegro<T> hermano = darHermano();

            hermano.color = padre.color;
            padre.color = NEGRO;
            NodoRojoNegro<T> abuelo = padre.padre;

            r.respuesta = hermano;

            if (padre.esHijoIzquierdo(this)) {
                hermano.derecho.color = NEGRO;

                if (abuelo != null) {
                    if (abuelo.esHijoDerecho(padre)) {
                        abuelo.cambiarHijoDerecho(padre.rotarIzquierda());
                    } else {
                        abuelo.cambiarHijoIzquierdo(padre.rotarIzquierda());
                    }
                } else {
                    padre.rotarIzquierda();
                }
            } else {
                hermano.izquierdo.color = NEGRO;

                if (abuelo != null) {
                    if (abuelo.esHijoDerecho(padre)) {
                        abuelo.cambiarHijoDerecho(padre.rotarDerecha());
                    } else {
                        abuelo.cambiarHijoIzquierdo(padre.rotarDerecha());
                    }
                } else {
                    padre.rotarDerecha();
                }
            }
        }

        public String toString() {
            return (elem != null ? elem.toString() : "null") + (color == ROJO ? " red" : " black");
        }

        // -----------------------------------------------------------------
        // Clases Privadas
        // -----------------------------------------------------------------    
        private class Retorno {

            private NodoRojoNegro<T> respuesta;

            private Retorno(NodoRojoNegro<T> pRespuesta) {
                respuesta = pRespuesta;
            }
        }
    }

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    private NodoRojoNegro<T> raiz;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------    
    public ArbolRojoNegro() {
        raiz = null;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------      
    public void insertar(T elem) throws Exception {
        // Crear el nuevo nodo y agregarlo como si el arbol fuera un arbol
        // binario normal
        NodoRojoNegro<T> nodo = new NodoRojoNegro<T>(elem);

        NodoRojoNegro<T> r2 = null;

        if (raiz == null) {
            raiz = nodo;
            raiz.cambiarColor(NodoRojoNegro.NEGRO);
        } else {
            r2 = raiz.insertar(nodo);
        }

        raiz = r2 != null && r2.darPadre() == null ? r2 : raiz;
    }

    public void eliminar(T elem) throws Exception {
        if (raiz != null) {
            //throw new ElementoNoExisteException( "El Ã¡rbol se encuentra vacio" );
            if (raiz.darInfoNodo().compareTo(elem) == 0 && raiz.hijoDerechoHoja() && raiz.hijoIzquierdoHoja()) {
                raiz = null;
            } else {
                if (raiz.darNodo(elem) != null) {
                    NodoRojoNegro<T> r2 = raiz.darNodo(elem).eliminar();
                    raiz = r2 != null && r2.darPadre() == null ? r2 : raiz;
                }
            }
        }
    }

    public List<T> darPreorden() {
        List<T> preorden = new LinkedList<T>();
        if (raiz != null) {
            raiz.darPreorden(preorden);
        }
        return preorden;
    }

    public boolean existe(T elem) {
        return raiz != null ? raiz.existe(elem) : false;
    }

    public T buscar(T modelo) {
        try {
            if (raiz.darNodo(modelo) == null) {
                return null;
            }
            return raiz != null ? raiz.darNodo(modelo).darInfoNodo() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public NodoRojoNegro<T> darRaiz() {
        return raiz;
    }

    public int darPeso() {
        return raiz == null ? 0 : raiz.darPeso();
    }

    public int darAltura() {
        return raiz == null ? 0 : raiz.darAltura();
    }

    public T darMinimo() {
        return raiz == null ? null : raiz.darMenor().darInfoNodo();
    }

    public T darMayor() {
        return raiz == null ? null : raiz.darMayor().darInfoNodo();
    }
}
