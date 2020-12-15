package ru.job4j.it;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> lIter = list.listIterator();
        while (lIter.hasNext()) {
            T t = lIter.next();
            if (!filter.test(t)) {
                lIter.remove();
            }
        }
        return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> lIter = list.listIterator();
        while (lIter.hasNext()) {
            T t = lIter.next();
            if (filter.test(t)) {
                lIter.set(value);
            }
        }
        return list;

    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        ListIterator<T> lIter = list.listIterator();
        ListIterator<T> eIter = elements.listIterator();
        while (eIter.hasNext()) {
            T t = lIter.next();
            T tD = eIter.next();
            if (t == tD) {
                lIter.remove();
            }
        }
        return list;
    }
}