package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public void push(T value) {
        in.push(value);
    }

    public T poll() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        T t = out.pop();
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return t;
    }
}
