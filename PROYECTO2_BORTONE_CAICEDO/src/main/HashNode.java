/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author giubo
 */
public class HashNode<K, V> {

    private K key;
    private V value;
    private int hashCode;
    private HashNode<K, V> next;

    public HashNode(K key, V value, int HashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = HashCode;
        this.next = null;

    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * @return the hashCode
     */
    public int getHashCode() {
        return hashCode;
    }

    /**
     * @param hashCode the hashCode to set
     */
    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    /**
     * @return the next
     */
    public HashNode<K, V> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }
    
    
}
