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
        return column < data.length && row < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (data[row][column++] == 0) {
            return column;
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] in = {
                {}, {1}
        };

        for (int[] ints : in) {
            System.out.println(Arrays.toString(ints));
        }

    }

}
