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
        return list.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        return null;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        return null;
    }

    public static void main(String[] args) {


        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ListUtils.addBefore(input, 1, 2);
        List<Integer> ii = ListUtils.removeIf(input, value -> value > 5);
        System.out.println(ii);

    }

}