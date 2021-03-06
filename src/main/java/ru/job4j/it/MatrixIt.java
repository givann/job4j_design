package ru.job4j.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (row + 1 == data.length) {
            return column < data[row].length;
        }
        return column < data[row + 1].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[] in = {};
        System.out.println(in.length);
    }
}
