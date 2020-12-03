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
        if (position == arr.length) {
            return false;
        } else {
            arr[position++] = model;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T model) {
        Objects.checkIndex(index, position);
        arr[index] = model;
        return (T) arr[index];
    }

    public T remove(int index) {
        Objects.checkIndex(index, position);
        T value = (T) arr[index];
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
        arr[arr.length - 1] = null;
        position--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, position);
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
                return pos < position;
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

    public static void main(String[] args) {
        SimpleArray<Integer> dd = new SimpleArray<>(6);
        dd.add(1);
        dd.add(2);
        dd.add(3);
        dd.add(4);
        dd.add(5);
        dd.add(6);
        Iterator<Object> iter = dd.iterator();

        dd.remove(1);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
