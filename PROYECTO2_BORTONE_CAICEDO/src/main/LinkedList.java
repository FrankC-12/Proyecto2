/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author giubo
 */
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return this.head;
    }

    /**
     * Constructor para inicializar una lista vacia
     *
     * @author Giulianna Bortone
     */
    public LinkedList() {
        this.head = this.tail = null;
    }

    /**
     * Constructor para inicializar una lista con un nodo
     *
     * @author Giulianna Bortone
     * @param n
     */
    public LinkedList(Node<T> n) {
        this.head = this.tail = n;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * Para saber si la lista esta vacia o no
     *
     * @author Giulianna Bortone
     * @return
     */
    private boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Tamano de la lista
     *
     * @author Giulianna Bortone
     * @return
     */
    public int size() {
        int i = 0;

        if (isEmpty()) {
            return 0;
        }

        Node<T> aux = this.head;
        while (aux != null) {
            aux = aux.getNext();
            i++;
        }
        return i;
    }

    /**
     * Para anadir el primero de la lista
     *
     * @author Giulianna Bortone
     * @param datum Datum to be added
     */
    public void addFirst(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }

    /**
     * Para insertar al final de la lista
     *
     * @author Giulianna Bortone
     * @param datum Datum to be added
     */
    public void addLast(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
    }

    /**
     * Para insertar en una posion especifica de la lista
     *
     * @author Giulianna Bortone
     * @param datum Datum to be added
     * @param i Position to be added in
     */
    public void add(T datum, int i) {
        if (isEmpty() || i == 0) {
            this.addFirst(datum);
        } else if (i >= (size() - 1)) {
            this.addLast(datum);
        } else if (i < 0) {
            this.add(datum, size() + i);
        } else {
            Node<T> n = new Node(datum);
            Node aux = this.head; // Nodo previo
            int count = 0;
            while (count < i - 1) {
                aux = aux.getNext();
                count++;
            }
            n.setNext(aux.getNext());
            aux.setNext(n);
        }
    }

    /**
     * Para eliminar el primero de la lista
     *
     * @author Giulianna Bortone
     * @return The data of the first element
     */
    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = this.head;
        this.head = this.head.getNext();
        temp.setNext(null);
        return temp.getData();
    }

    /**
     * Para eliminar el ultimo de la lista
     *
     * @author Giulianna Bortone
     * @return The data of the last element
     */
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> pre = this.head;
        while (pre.getNext().getNext() != null) {
            pre = pre.getNext();
        }
        Node<T> temp = pre.getNext();
        pre.setNext(null);
        this.tail = pre;
        temp.setNext(null);
        return temp.getData();

    }

    /**
     * Para eliminar de una posicion especifica
     *
     * @author Giulianna Bortone
     * @param i The position to be deleted
     * @return The data of the deleted element
     */
    public T delete(int i) {
        if (isEmpty()) {
            return null;
        } else if (i == 0) {
            return deleteFirst();
        } else if (i == size() - 1) {
            return deleteLast();
        } else if (i < 0) {
            return delete(size() + i);
        } else if (i > size() - 1) {
            System.out.println("\nError");
            return null;
        } else {
            Node<T> aux = this.head;
            int count = 0;
            while (count < i - 1) {
                aux = aux.getNext();
                count++;
            }
            Node<T> del = aux.getNext();
            aux.setNext(del.getNext());
            del.setNext(null);
            return del.getData();
        }
    }

    /**
     * @author Giulianna Bortone Imprime la lista
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            Node aux = this.head;
            int i = 0;
            while (aux != null) {
                System.out.print(aux.getData() + "(" + i + ")" + " -> ");
                aux = aux.getNext();
                i++;
            }
            System.out.println("");
        }
    }

    public Node[] splitList(Node n) {
        // base case
        if (n == null || n.getNext() == null) {
            return new Node[]{n, null};
        }

        Node backward = n;
        Node forward = n.getNext();

        while (forward != null) {
            forward = forward.getNext();
            if (forward != null) {
                backward = backward.getNext();
                forward = forward.getNext();
            }
        }

        // splitting the linked list
        Node[] arr = new Node[]{n, backward.getNext()};
        backward.setNext(null);

        return arr;
    }

    /**
     * Obtenemos la data de un elemento dado su index
     *
     * @author Giulianna Bortone
     * @param index index of the element to look for
     * @return Data of the element at given index
     */
    public T get(int index) {
        Node<T> aux = this.head;
        int count = 0;
        while (count < index) {
            aux = aux.getNext();
            count++;
        }

        return aux.getData();
    }

    /**
     * Reemplaza el primer nodo de la lista con otro
     *
     * @author Giulianna Bortone
     * @param datum data to be replaced in the first node
     */
    public void setFirst(T datum) {
        if (isEmpty()) {
            addFirst(datum);
        } else {
            Node<T> n = new Node(datum);
            n.setNext(this.head.getNext());
            this.head.setNext(null);
            this.head = n;
        }
    }

    /**
     * Reemplaza el primer nodo de la lista con otro
     *
     * @author Giulianna Bortone
     * @param datum data to be replaced in the last node
     */
    public void setLast(T datum) {
        Node<T> n = new Node(datum);
        Node<T> pre = this.head;
        while (pre.getNext().getNext() != null) {
            pre = pre.getNext();
        }

        Node<T> temp = pre.getNext();
        pre.setNext(n);
        this.tail = n;
        temp.setNext(null);
    }

    /**
     * Reemplaza el nodo del indice dado por otro dada la data
     *
     * @author Giulianna Bortone
     * @param i index of the node to be replaced
     * @param datam data that will contain the node to replace with
     */
    public void set(int i, T datum) {
        if (isEmpty() || i == 0) {
            setFirst(datum);
        } else if (i == size() - 1) {
            setLast(datum);
        } else if (i < 0) {
            set(size() + i, datum);
        } else if (i > size() - 1) {
            System.out.println("\nError");
        } else {
            Node<T> n = new Node(datum);
            Node<T> aux = this.head;
            int count = 0;
            while (count < i - 1) {
                aux = aux.getNext();
                count++;
            }

            Node<T> toReplace = aux.getNext();
            n.setNext(toReplace.getNext());
            aux.setNext(n);
            toReplace.setNext(null);
        }
    }

}
