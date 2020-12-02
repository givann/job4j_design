package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayN<T> implements Iterable<T> {
    private Object[] container;
    private final int size = 10;
    private int position;
    private int modCount = 0;

    public SimpleArrayN() {
        this.container = new Object[size];
        this.position = 0;
    }

    public void add(T model) {
        if (container.length <= position) {
            Object[] dest = new Object[size * 2];
            System.arraycopy(container, 0, dest, 0, position - 1);
            container = dest;
            position++;
            modCount++;
        } else {
            container[position++] = model;
            modCount++;
        }
        Objects.checkIndex(0, position);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int posIter = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return posIter < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[posIter++];
            }

        };
    }

    public static void main(String[] args) {
        SimpleArrayN<String> strings = new SimpleArrayN<>();
        strings.add("Str");
        strings.add("S");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("Str1");
        strings.add("luck");


        System.out.println(strings.get(0));
        System.out.println(strings.get(1));
        System.out.println(strings.get(11));

    }
}
