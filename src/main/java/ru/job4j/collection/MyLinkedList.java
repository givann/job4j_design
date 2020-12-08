package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;
    private int size = 0;

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
        for (int x = 0; x <= index; x++) {
            nd = nd.next;
        }
        return nd.item;
    }

    private class IterFLL implements Iterator<E> {
        private int posIter = 0;
        int expectedModCount = modCount;
        Node<E> current = first;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            return posIter < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                posIter++;
                E value = current.item;
                current = current.next;
                return value;
            }
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new IterFLL();
    }
}
