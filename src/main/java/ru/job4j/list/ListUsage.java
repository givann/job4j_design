package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        rsl.add(1, "four");
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.addAll(2, list);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
