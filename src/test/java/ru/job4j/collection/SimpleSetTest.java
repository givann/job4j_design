package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.sql.Array;
import java.util.*;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest extends TestCase {

    @Test
    public void testAdd() {
        SimpleSet<Integer> sA = new SimpleSet<>();
        sA.add(10);
        sA.add(10);
        sA.add(101);
        Iterator<Integer> iterator = sA.iterator();
        assertThat(iterator.next(), is(10));
        assertThat(iterator.next(), is(101));

    }
}