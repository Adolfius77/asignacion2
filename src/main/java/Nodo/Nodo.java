package Nodo;

/**
 * Representa un nodo individual para una lista doblemente enlazada.
 * Contiene el dato y referencias al nodo anterior y siguiente.
 *
 * @param <E> El tipo del dato almacenado en el nodo.
 */
public class Nodo<E> {

    private E dato;            
    private Nodo<E> anterior;   
    private Nodo<E> siguiente;  

    /**
     * Constructor para crear un nodo con un dato específico.
     * Los enlaces anterior y siguiente se inicializan a null.
     *
     * @param dato El dato a almacenar en el nodo.
     */
    public Nodo(E dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     * @return El dato del nodo.
     */
    public E getDato() {
        return dato;
    }

    /**
     * Establece o actualiza el dato del nodo.
     * @param dato El nuevo dato para el nodo.
     */
    public void setDato(E dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al nodo anterior.
     * @return El nodo anterior, o null si no existe.
     */
    public Nodo<E> getAnterior() {
        return anterior;
    }

    /**
     * Establece la referencia al nodo anterior.
     * @param anterior El nodo que será el anterior.
     */
    public void setAnterior(Nodo<E> anterior) {
        this.anterior = anterior;
    }

    /**
     * Obtiene la referencia al nodo siguiente.
     * @return El nodo siguiente, o null si no existe.
     */
    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al nodo siguiente.
     * @param siguiente El nodo que será el siguiente.
     */
    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Devuelve la representación en String del dato del nodo.
     * @return String que representa el dato, o "null" si el dato es null.
     */
    @Override
    public String toString() {
        return dato != null ? dato.toString() : "null";
    }
}