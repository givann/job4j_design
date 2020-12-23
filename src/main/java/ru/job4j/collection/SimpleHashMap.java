package ru.job4j.collection;

public class SimpleHashMap<K, V> {

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

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

    private int size = 16;

    private Entry<K, V> table[];

    public SimpleHashMap() {
        table = new Entry[size];
    }

//    public boolean insert(K key, V value){
//        int hash = key.hashCode() % size;
//
//    }

}
