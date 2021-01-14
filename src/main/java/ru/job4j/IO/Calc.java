package ru.job4j.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Calc {
    public static void main(String[] args) throws IOException {
        String result;
        FileOutputStream out = new FileOutputStream("result.txt", true);
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                result = "" + i * j;
                try {
                    out.write(result.getBytes(StandardCharsets.UTF_8));
                    out.write(" ".getBytes(StandardCharsets.UTF_8));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            out.write('\n');

        }


    }
}
