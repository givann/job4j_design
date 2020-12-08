package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        linked.add(1);
        linked.deleteFst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        linked.deleteFst();
    }

    @Test
    public void whenMultiDelete() {
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.deleteFst(), is(1));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }
}