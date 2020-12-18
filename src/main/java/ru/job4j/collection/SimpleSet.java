package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    SimpleArrayN<E> simpleArrayN = new SimpleArrayN<>();
    private int simpleSize = 0;

    public void add(E e) {
        int count = 0;
        if (simpleSize == 0) {
            simpleArrayN.add(e);
            simpleSize++;
        } else {
            for (int i = 0; i < simpleSize; i++) {
                if (Objects.equals(simpleArrayN.get(i), e)) {
                    count++;
                }
            }
            if (count == 0) {
                simpleArrayN.add(e);
                simpleSize++;
            }

        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> iterator = simpleArrayN.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public E next() {
                return iterator.next();
            }
        };
    }

    public static void main(String[] args) {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();


        simpleSet.add(10);
        simpleSet.add(1);
        simpleSet.add(10);
        simpleSet.add(110);
        simpleSet.add(101);
        simpleSet.add(101);

        Iterator<Integer> iter = simpleSet.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }
}
