/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author giubo
 */
public class HashTable<K, V> {

    private LinkedList<HashNode<K, V>> bucketArray;
    private int capacity;
    private int size;

    public HashTable() {
        this.bucketArray = new LinkedList<>();
        this.capacity = 10;
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            bucketArray.FinalInsertNodo(null);

        }

    }

    public HashTable(int capacity) {
        this.bucketArray = new LinkedList<>();
        this.capacity = capacity;
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            bucketArray.FinalInsertNodo(null);

        }

    }

    public int size() {
        return this.size;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public final int hashCode(K key) {
        String stringKey = key.toString();
        int hash = 0;
        for (int i = 0; i < stringKey.length(); i++) {
            hash = (hash + Character.codePointAt(stringKey, i) * i);

        }
        return hash;

    }

    public int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % this.capacity;
        return index;
    }

    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }

        // Insert key in chain
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

}
