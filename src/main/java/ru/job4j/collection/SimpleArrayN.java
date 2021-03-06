package ru.job4j.collection;

import java.util.*;

public class SimpleArrayN<T> implements Iterable<T> {
    private Object[] container;
    private int size = 10;
    private int position;
    private int modCount = 0;

    public SimpleArrayN() {
        this.container = new Object[size];
        this.position = 0;
    }

    public void add(T model) {
        container= checkingSize();
        container[position++] = model;
    }

    private Object[] checkingSize() {
        if (container.length <= position) {
            size = container.length * 2;
            container = Arrays.copyOf(container, size);
        }
        modCount++;
        return container;
    }

    public int getPosition() {
        return position;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) container[index];
    }

    public int getSize() {
        return size;
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
}
