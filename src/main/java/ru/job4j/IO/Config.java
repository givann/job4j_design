package ru.job4j.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {

        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String str = "name=Petr Arsentev";
            System.out.println(str.split("="));
            values.put(read.readLine(), read.readLine());

        } catch (Exception e) {
        }
    }

    public String value(String key) {

        throw new UnsupportedOperationException("Don't impl this method yet!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String path = "src/main/java/ru/job4j/IO/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();


        System.out.println(new Config("src/main/java/ru/job4j/IO/pair_without_comment.properties"));
    }
}

