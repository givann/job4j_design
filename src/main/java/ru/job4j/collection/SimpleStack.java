package ru.job4j.collection;

public class SimpleStack<T> {
    ForwardLinked<T> forwardLinked = new ForwardLinked<>();

    public T pop() {
        return forwardLinked.deleteLast();
    }

    public void push(T value) {
        forwardLinked.add(value);
    }

    public boolean isEmpty() {
        return forwardLinked.getSize() == 0;
    }

    public static void main(String[] args) {
        SimpleStack<String> stringSimpleStack = new SimpleStack<>();

        stringSimpleStack.push("Asus");
        stringSimpleStack.push("Dell");
        stringSimpleStack.push("Apple");

        System.out.println(stringSimpleStack.pop());
        System.out.println(stringSimpleStack.pop());
        System.out.println(stringSimpleStack.pop());

    }


}
