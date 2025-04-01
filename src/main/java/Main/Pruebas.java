/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Implementaciones.ListaDoblementeEnlazada;
import java.util.NoSuchElementException;

/**
 *
 * @author USER
 */
public class Pruebas {

    // --- Ejemplo de uso (Método main) ---
    public static void main(String[] args) {
        System.out.println("Probando Lista Doblemente Enlazada de Strings:");
        ListaDoblementeEnlazada<String> miLista = new ListaDoblementeEnlazada<>();

        System.out.println("Lista vacia? " + miLista.isEmpty());
        System.out.println("Tamano inicial: " + miLista.size());

        miLista.addFirst("Hola");
        miLista.addLast("Mundo");
        miLista.addFirst("Inicio");
        miLista.addLast("Final");

        System.out.println("Lista actual: " + miLista.toString());
        System.out.println("Lista vacia? " + miLista.isEmpty());
        System.out.println("Tamano: " + miLista.size());

        System.out.println("Contiene 'Hola'? " + miLista.contains("Hola"));
        System.out.println("Contiene 'Adios'? " + miLista.contains("Adios"));

        System.out.println("Elemento en indice 0: " + miLista.getElement(0));
        System.out.println("Elemento en indice 2: " + miLista.getElement(2));
        System.out.println("Elemento en indice 3: " + miLista.getElement(3));

        try {
            System.out.println("Intentando obtener indice 4 (error esperado):");
            miLista.getElement(4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepcion capturada: " + e.getMessage());
        }

        System.out.println("Eliminando primero: " + miLista.removeFirst());
        System.out.println("Lista ahora: " + miLista.toString());
        System.out.println("Tamano: " + miLista.size());

        System.out.println("Eliminando ultimo: " + miLista.removeLast());
        System.out.println("Lista ahora: " + miLista.toString());
        System.out.println("Tamano: " + miLista.size());

        miLista.clear();
        System.out.println("Lista despurs de clear: " + miLista.toString());
        System.out.println("Lista vacia? " + miLista.isEmpty());
        System.out.println("Tamano final: " + miLista.size());

        try {
            System.out.println("Intentando removeFirst en lista vacia (error esperado):");
            miLista.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("Excepcion capturada: " + e.getMessage());
        }
    }
}
