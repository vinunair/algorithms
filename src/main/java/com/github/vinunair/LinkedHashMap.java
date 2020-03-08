package com.github.vinunair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair<U,V> {
    U u ;
    V v; 
    Pair prev;
    Pair next;

    Pair(final U u, final V v) {
        this.u = u;
        this.v = v;
    }
}

class Bucket {
    private final List<Pair<Integer, Integer>> pairs;

    public Bucket() {
        pairs = new ArrayList<>();
    }

    public void put(Pair<Integer, Integer> pair) {
        boolean found = false;
        for (final Pair<Integer, Integer> p : pairs) {
            if (pair.u == p.u) {
                p.v = pair.v;
                found = true;
                break;
            }
        }
        if (!found)
            pairs.add(new Pair(key, value));
    }

    public int get(final int key) {
        int value = -1;
        for (final Pair<Integer, Integer> pair : pairs) {
            if (pair.u == key) {
                value = pair.v;
                break;
            }
        }

        return value;
    }

    public void remove(final int key) {
        for (final Pair<Integer, Integer> pair : pairs) {
            if (pair.u == key) {
                pairs.remove(pair);
                break;
            }
        }
    }
}

class Node {
    Node node;
    Node prev;
    Node next;
    
    Pair<Integer, Integer> val ;
    
    Node(Pair val) {
        this.val = val;
    }

}

public class LinkedHashMap {
    Node head;

    int size = 2069;

    Bucket[] buckets;

    /** Initialize your data structure here. */
    public LinkedHashMap() {
        buckets = new Bucket[size];
    }

    /** value will always be non-negative. */
    public void put(final int key, final int value) {
        final int hash = key % size;
        Pair<Integer, Integer> pair = new Pair(key,value);

        Node node = new Node(pair);
        if(head != null) {
            node.prev = head ;
            head.next = node;
        }
            head = node;
 
        buckets[hash].put(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(final int key) {
        return buckets[key % size].get(key);
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(final int key) {
        buckets[key % size].remove(key);
    }

    public static void main(final String args[]) {
        final Map<Integer, Integer> myMap = new LinkedHashMap();
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */