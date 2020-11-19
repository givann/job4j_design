package ru.job4j.it;

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
        return column <= data[row][data.length-1];
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row++][column++];

    }

    public static void main(String[] args) {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        if (it.hasNext()){
            System.out.println(it.next());
        };

    }
}
