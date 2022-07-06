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
public class HashTable<K, V> {

    // bucketArray guarda el array of chains
    private LinkedList<HashNode<K, V>> bucketArray;

    // Capacidad del HashTable
    private int capacity;

    // Tamano actual del HashTable
    private int size;

    /**
     * Crea un nuevo HashTable con un numero limite de 10 buckets
     */
    public HashTable() {
        this.bucketArray = new LinkedList<>();
        this.capacity = 10;
        this.size = 0;
        // Create empty buckets
        for (int i = 0; i < capacity; i++) {
            bucketArray.addLast(null);
        }
    }

    /**
    
     * @author Giulianna Bortone
     * @param capacity maximum number of Buckets for the HashTable
     */
    public HashTable(int capacity) {
        this.bucketArray = new LinkedList<>();
        this.capacity = capacity;
        this.size = 0;
        // Creamos buckets vacios
        for (int i = 0; i < capacity; i++) {
            bucketArray.addLast(null);
        }
    }

    /**
     * Nos da el tamano actual del HS
     *
     * @author Giulianna Bortone
     * @return Size of the HashTable
     */
    public int size() {
        return size;
    }

    /**
     * Para saber si el HS esta vacia o no
     *
     * @author Giulianna Bortone
     * @return Boleeano que indica si el HS esta vacio o no
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Genera un unico HashCode para una llave especifica
     *
     * @param key necessary to generate
     * @author Giulianna Bortone
     * @return Unique HashCode
     */
    private final int hashCode(K key) {
    
        String keyStringified = key.toString();
   
        int hash = 0;
        for (int i = 0; i < keyStringified.length(); i++) 
        {
            hash = (hash + Character.codePointAt(keyStringified, i) * i);
        }

        return hash;
    }

    /**
     * Obtiene el bucketIndex que corresponde con la llave dada
     *
     * @author Giulianna Bortone
     * @return Index in the bucketArray
     */
    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        // hashCode % capacity nos permite obtener un indice que este dentro de los valores de la capacidad
        int index = hashCode % this.capacity;
        return index;
    }

    /**
     * Anade un nuevo par clave-valor al HashTable
     *
     * @author Giulianna Bortone
     * @param key key of the element
     * @param value value of the element
     */
    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Revisa si la llave ya esta
        while (head != null) {
            if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
        newNode.setNext(head);
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / capacity >= 0.7) {
            LinkedList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new LinkedList<>();
            capacity *= 2;
            size = 0;
            for (int i = 0; i < capacity; i++) {
                bucketArray.addLast(null);
            }

            Node bucketHead = temp.getHead();
            while (bucketHead != null) {
                HashNode<K, V> headNode = (HashNode<K, V>) bucketHead.getData();
                while (headNode != null) {
                    add(headNode.getKey(), headNode.getValue());
                    headNode = headNode.getNext();
                }
                bucketHead = bucketHead.getNext();
            }
        }

    }

    /**
     * Retorna el valor dada la llave especifica
     *
     * @author Giulianna Bortone
     * @param key to get value to
     * @return value for the specified key
     */
    public V get(K key) {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
                return head.getValue();
            }
            head = head.getNext();
        }

        // Si no se encuentra la llave
        return null;
    }

    /**
     * Elimina la llave dada del HashTable
     *
     * @param key key to be deleted
     * @author Giulianna Bortone
     * @return the value of the deleted key
     */
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null) {
            // Si la encuentra
            if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
                break;
            }

            prev = head;
            head = head.getNext();
        }

        //  Si no lo encuentra
        if (head == null) {
            return null;
        }

        size--;

        if (prev != null) {
            prev.setNext(head.getNext());
        } else {
            bucketArray.set(bucketIndex, head.getNext());
        }

        return head.getValue();
    }

    /**
     * @author Giulianna Bortone
     */
    public void print() {

        Node bucketHead = bucketArray.getHead();
        int index = 0;

        while (bucketHead != null) {

            HashNode<K, V> headNode = (HashNode<K, V>) bucketHead.getData();

            System.out.print("i" + index + ":");
            int j = 0;

            while (headNode != null) {

                System.out.print((j > 0 ? "->" : "") + headNode.getValue());
                j++;

                headNode = headNode.getNext();
            }

            index++;
            j = 0;
            System.out.println("");

            bucketHead = bucketHead.getNext();
        }
    }

}
