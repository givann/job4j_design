package ru.job4j.collection;

import java.util.Arrays;

public class SimpleHashMap<K, V> {

    private class Entry<K, V> {
        private K key;
        private V value;


        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int size = 4;

    private Entry<K, V> table[];

    public SimpleHashMap() {
        table = new Entry[size];
    }

    public boolean insert(K key, V value) {
        int count = 0;
        double loadFactor = table.length * 0.75;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                count++;
            }
        }
        if (count >= loadFactor) {
            int nSize = table.length * 2;
            Entry<K, V> nArr[] = new Entry[nSize];
            System.arraycopy(table, 0, nArr, 0, table.length);
            table = nArr;
        }
        int hash = key.hashCode() % table.length;
        Entry<K, V> e = table[hash];


        if (e == null) {
            table[hash] = new Entry<>(key, value);
            System.out.println(table[hash].getKey() + " " + table[hash].getValue());
            return true;
        }
        if (e.getKey() == key) {
            return false;
        }
        return false;
    }

    public V get(K key) {
        int hash = key.hashCode() % table.length;
        Entry<K, V> nn = table[hash];
        if (table[hash] == null) {
            return null;
        }
        return nn.getValue();
    }

    public boolean delete(K key) {
        int hash = key.hashCode() % table.length;
        Entry<K, V> nn = table[hash];
        if (nn.getKey() == key) {
            table[hash] = null;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();

        hashMap.insert(1, "one");
        hashMap.insert(2, "two");
        hashMap.insert(3, "three");
        hashMap.insert(4, "four");
        hashMap.insert(5, "five");

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(5));


    }


}
