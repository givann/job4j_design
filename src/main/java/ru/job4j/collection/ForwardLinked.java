package ru.job4j.collection;

import java.util.*;

public class ForwardLinked<E> implements Iterable<E> {
    private Node<E> first;

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    private Node<E> last;
    private int modCount = 0;
    private int size = 0;

    public int getSize() {
        return size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(E value) {
        Node<E> ml = last;
        Node<E> nn = new Node<>(ml, value, null);
        last = nn;
        if (ml == null) {
            first = nn;
        } else {
            ml.next = nn;
        }
        size++;
        modCount++;
    }

    private E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> nd = first;
        int tmcCount = 0;
        for (int x = 0; x < index; x++) {
            nd = nd.next;
        }
        return nd.item;
    }

    public E deleteFst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        E data = first.item;
        Node<E> tmp = first.next;
        first.item = null;
        first.next = null;
        first = tmp;
        if (tmp == null) {
            setLast(null);
        } else {
            tmp.prev = null;
        }
        size--;
        modCount++;
        return data;
    }

    public E deleteLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        E data = last.item;
        Node<E> tmp = last.prev;
        last.item = null;
        last.prev = null;
        last = tmp;
        if (tmp == null) {
            setFirst(null);
        } else {
            tmp.next = null;
        }
        size--;
        modCount++;
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return new IterFLL();
    }

    private class IterFLL implements Iterator<E> {
        int expectedModCount = modCount;
        Node<E> current = first;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = current.item;
            current = current.next;
            return value;
        }
    }

    public static void main(String[] args) {
        ForwardLinked<String> cc = new ForwardLinked<>();

        cc.add("Asus");
        cc.add("Dell");
        cc.add("Apple");

        for (String s : cc) {
            System.out.println(s);
        }
        System.out.println();


    }


}
