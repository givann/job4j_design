package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<Object> {
    private Object[] arr;
    private int position;

    public SimpleArray(int capacity) {
        this.arr = new Object[capacity];
        this.position = 0;
    }

    public boolean add(T model) {
        for (int i = 0; i < arr.length; i++) {
            if (i == position) {
                arr[i] = model;
                position++;
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T model) {
        Objects.checkIndex(index, arr.length);
        arr[index] = model;
        return (T) arr[index];
    }

    public boolean remove(int index) {
        Object[] dest = new Object[arr.length - 1];
        if (index < arr.length) {
            System.arraycopy(arr, 0, dest, 0, index);
            System.arraycopy(arr, index + 1, dest, index, arr.length - (index + 1));
            arr = dest;
            position--;
            return true;
        } else
            return false;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
                "arr=" + Arrays.toString(arr) +
                ", position=" + position +
                '}';
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < arr.length && arr[pos] != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[pos++];
            }
        };
    }
}
