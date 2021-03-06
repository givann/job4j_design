package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedSingle<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void revert() {
        if (head == null || head.next == null) {
            return;
        }
        Node<T> fst = null;
        Node<T> cur = head;
        Node<T> lst = head.next;
        for (int i = 0; i < size; i++) {
            cur.next = fst;
            fst = cur;
            cur = lst;
            if (i == size - 1) {
                head = fst;
                return;
            } else {
                lst = lst.next;
            }
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        ForwardLinkedSingle<Integer> aa = new ForwardLinkedSingle<>();




        aa.revert();


        for (Integer integer : aa) {
            System.out.println(integer);
        }
//        for (Integer integer : aa) {
//            System.out.println(integer);
//        }
    }
}
