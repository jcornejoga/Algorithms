package com.cornejo.test.map;

import java.util.List;

public class MyHashMap<K, V> {

    private static final int ARRAY_SIZE = 10;

    private Node<K, V>[] _buckets = new Node[ARRAY_SIZE];

    public void put(K key, V value) {
        int hash = getHash(key);
        int index = getIndex(hash);

        if (index >= ARRAY_SIZE) {
            throw new IndexOutOfBoundsException("Invalid index" + index + " for hash " + hash);
        }

        Node<K, V> i = _buckets[index];

        Node<K, V> newNode = new Node<>(key, value, (Node<K, V>) null);;

        if (i == null) {
            _buckets[index] = newNode;
        } else {
            while (true) {
                if (i.key.equals(key)) {
                    i.value = value;
                    break;
                } else {
                    if (i.next == null) {
                        i.next = newNode;
                        break;
                    }
                }
                i = i.next;
            }
            //while (i.next != null) {
            //    i = i.next;
            //}
            //i.next = newNode;
        }
    }

    public V get(K key) {
        int hash = getHash(key);
        int index = getIndex(hash);

        Node<K, V> i = _buckets[index];

        if (i == null) {
            return null;
        } else {
            while (i != null && !key.equals(i.key)) {
                i = i.next;
            }
            if (i != null) {
                return i.value;
            }
        }

        return null;
    }

    private int getHash(K key) {
        String hashString = key.toString();
        return hashString.hashCode();
    }

    private int getIndex(int hash) {
        return hash % ARRAY_SIZE;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
