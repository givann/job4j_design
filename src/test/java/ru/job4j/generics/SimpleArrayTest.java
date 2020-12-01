package ru.job4j.generics;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest extends TestCase {

    @Test
    public void testAdd() {
        SimpleArray<String> curr = new SimpleArray<>(4);
        curr.add("One");
        curr.add("Two");
        assertThat(curr.get(0), is("One"));
        assertThat(curr.get(1), is("Two"));
        assertThat(curr.add("Tree"), is(true));

    }

    @Test
    public void testSet() {
        SimpleArray<String> curr = new SimpleArray<>(4);
        curr.add("One");
        curr.add("Two");
        assertThat(curr.set(1, "Four"), is("Four"));
    }

    @Test (expected =ArrayIndexOutOfBoundsException.class)
    public void testRemove() {
        SimpleArray<Integer> curr = new SimpleArray<>(2);
        curr.add(1);
        curr.add(2);
        curr.remove(1);
        SimpleArray<Integer> exp = new SimpleArray<>(1);
        exp.add(1);
        assertThat(exp.toString(), is(curr.toString()));


    }

    @Test
    public void testGet() {
        SimpleArray<String> curr = new SimpleArray<>(4);
        curr.add("One");
        assertThat(curr.get(0), is("One"));
    }
}