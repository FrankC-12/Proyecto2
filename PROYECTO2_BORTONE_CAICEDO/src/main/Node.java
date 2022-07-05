/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author giubo
 */
public class Node<T> {
    private T data;
    private Node next;
    
    /**
     *
     * @param datum
     */
    public Node (T datum) {
        this.data = datum;
        this.next = null;
    }

    /**
     * Get Node's data
     * @return the data inside Node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets new data to Node
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return a reference to the next Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets new Node to reference to
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
  
    
}