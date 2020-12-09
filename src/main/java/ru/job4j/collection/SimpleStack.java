package ru.job4j.collection;

public class SimpleStack<T> {
    ForwardLinked<T> forwardLinked = new ForwardLinked<>();

    public T pop() {
        return forwardLinked.deleteLast();
    }

    public T popFst() {
        return forwardLinked.deleteFst();
    }
    public void push(T value) {
        forwardLinked.add(value);
    }

    public static void main(String[] args) {
        SimpleStack<String> stringSimpleStack = new SimpleStack<>();

        stringSimpleStack.push("Asus");
        stringSimpleStack.push("Dell");
        stringSimpleStack.push("Apple");

        stringSimpleStack.pop();
        stringSimpleStack.pop();
        stringSimpleStack.pop();
    }
}
