package Implementaciones;

// Asegúrate de que la clase Nodo esté accesible, por ejemplo:
import Nodo.Nodo; // O la ruta correcta a tu clase Nodo
import java.util.NoSuchElementException;

/**
 * Implementación de una Lista Doblemente Enlazada genérica.
 * Permite almacenar y manipular elementos manteniendo enlaces dobles.
 *
 * @param <E> Tipo de elementos que contendrá la lista.
 */
public class ListaDoblementeEnlazada<E> {

    private Nodo<E> inicial; // Referencia al primer nodo (cabeza)
    private Nodo<E> ultimo;  // Referencia al último nodo (cola)
    private int contador;    // Número de elementos en la lista

    /**
     * Construye una lista doblemente enlazada vacía.
     */
    public ListaDoblementeEnlazada() {
        this.inicial = null;
        this.ultimo = null;
        this.contador = 0;
    }

    /**
     * Verifica si la lista no contiene elementos.
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return contador == 0;
    }

    /**
     * Devuelve el número de elementos en la lista.
     * @return El tamaño de la lista.
     */
    public int size() {
        return contador;
    }

    /**
     * Añade un elemento al principio de la lista.
     * @param dato El elemento a añadir.
     */
    public void addFirst(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (isEmpty()) {
            inicial = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(inicial);
            inicial.setAnterior(nuevoNodo);
            inicial = nuevoNodo;
        }
        contador++;
    }

    /**
     * Añade un elemento al final de la lista.
     * @param dato El elemento a añadir.
     */
    public void addLast(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (isEmpty()) {
            inicial = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
        contador++;
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     * @return El primer elemento eliminado.
     * @throws NoSuchElementException si la lista está vacía.
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista esta vacia.");
        }
        E datoEliminado = inicial.getDato();
        if (contador == 1) {
            inicial = null;
            ultimo = null;
        } else {
            inicial = inicial.getSiguiente();
            inicial.setAnterior(null);
        }
        contador--;
        return datoEliminado;
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     * @return El último elemento eliminado.
     * @throws NoSuchElementException si la lista está vacía.
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista esta vacia.");
        }
        E datoEliminado = ultimo.getDato();
        if (contador == 1) {
            inicial = null;
            ultimo = null;
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
        }
        contador--;
        return datoEliminado;
    }

    /**
     * Comprueba si la lista contiene el elemento especificado.
     * Usa el método equals() para la comparación.
     * @param dato El elemento a buscar.
     * @return true si el elemento está en la lista, false en caso contrario.
     */
    public boolean contains(E dato) {
        Nodo<E> actual = inicial;
        while (actual != null) {
            // Manejo de nulls
            if (dato == null) {
                if (actual.getDato() == null) {
                    return true;
                }
            } else {
                if (dato.equals(actual.getDato())) {
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Obtiene el elemento en la posición especificada (índice).
     * Optimizado para buscar desde el inicio o final según la cercanía.
     * @param index Índice del elemento a obtener (base 0).
     * @return El elemento en la posición dada.
     * @throws IndexOutOfBoundsException si el índice es inválido.
     */
    public E getElement(int index) {
        if (index < 0 || index >= contador) {
            throw new IndexOutOfBoundsException("indice fuera de rango: " + index + ", Tamano: " + contador);
        }

        Nodo<E> nodoBuscado;
        // Optimización: buscar desde inicio o fin
        if (index < contador / 2) {
            nodoBuscado = inicial;
            for (int i = 0; i < index; i++) {
                nodoBuscado = nodoBuscado.getSiguiente();
            }
        } else {
            nodoBuscado = ultimo;
            for (int i = contador - 1; i > index; i--) {
                nodoBuscado = nodoBuscado.getAnterior();
            }
        }
        return nodoBuscado.getDato();
    }

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    public void clear() {
        inicial = null;
        ultimo = null;
        contador = 0;
    }

    /**
     * Devuelve una representación en String de la lista.
     * Formato: [elemento1, elemento2, ..., elementoN]
     * @return La representación textual de la lista.
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<E> actual = inicial;
        while (actual != null) {
            sb.append(actual.getDato() == null ? "null" : actual.getDato().toString());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }

}