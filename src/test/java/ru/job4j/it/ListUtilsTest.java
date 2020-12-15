package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(Arrays.asList(1, 3, 2), Is.is(input));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void testRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.removeIf(input, x -> x > 2);
        assertThat(Arrays.asList(3), Is.is(input));

    }

    @Test
    public void testReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.replaceIf(input, x -> x > 2, 5);
        assertThat(Arrays.asList(1, 5), Is.is(input));

    }

    @Test
    public void testRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> inputNTwo = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeAll(input, inputNTwo);
        assertThat(Arrays.asList(4), Is.is(input));
    }
}
