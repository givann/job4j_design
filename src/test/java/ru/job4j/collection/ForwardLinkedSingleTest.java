package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedSingleTest extends TestCase {

    @Test
    public void testRevert() {
        ForwardLinkedSingle<Integer> linked = new ForwardLinkedSingle<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }
}