package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    Node<E> first;
    Node<E> last;
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
        if (ml == null)
            first = nn;
        else
            ml.next = nn;
        size++;
        modCount++;
    }

    E get(int index) {
        E e = null;
        int tmcCount = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (index == tmcCount) {
                e = x.item;
                tmcCount++;
            } else {
                tmcCount++;
            }
        }
        return e;
    }
    private class IterFLL implements Iterator<E>{
        private int posIter = 0;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
            return posIter < size;
        }

        @Override
        public E next() {
            return get(posIter++);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new IterFLL();
    }

    public static void main(String[] args) {
        MyLinkedList<String> mmm = new MyLinkedList<>();
        Iterator<String> iter = mmm.iterator();

        mmm.add("ER");
        mmm.add("ERa");
        mmm.add("ERu");

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

//        System.out.println(mmm.get(0));
//        System.out.println(mmm.get(1));
//        System.out.println(mmm.get(2));
    }
}
