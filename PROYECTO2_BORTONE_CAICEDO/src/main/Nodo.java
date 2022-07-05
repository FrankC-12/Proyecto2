/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author giubo
 */
public class Nodo<T> {

    private T dato;
    private Nodo pnext;

    // Constructor cuando se que quiero que guarde mi Nodo pero no se a que quiero que apunte
    public Nodo(T dato) {
        this.dato = dato;
        this.pnext = null;
    }

    // constructor cuando no se a que quiero que apunte mi Nodo y no se a que quiero que apunte
    public Nodo() {
        this.dato = (T) "";
        this.pnext = null;
    }

    // constructor cuando se que quiero que guarde mi Nodo y a que quiero que punte
    public Nodo(T dato, Nodo nodito) {
        this.dato = dato;
        this.pnext = nodito;

    }

    /**
     * @return the dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return the pnext
     */
    public Nodo getPnext() {
        return pnext;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }

}
