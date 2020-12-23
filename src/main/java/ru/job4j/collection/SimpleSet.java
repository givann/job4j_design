package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    SimpleArrayN<E> simpleArrayN = new SimpleArrayN<>();

    private boolean contains(E e) {
    boolean res = false;
        for (E e1 : simpleArrayN) {
            if (Objects.equals(e1, e)){
                res = true;
                break;
            }
        }
        return res;
    }

    public void add(E e) {
        if (contains(e)) {
            return;
        }
        simpleArrayN.add(e);
    }


    @Override
    public Iterator<E> iterator() {
        return simpleArrayN.iterator();
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
