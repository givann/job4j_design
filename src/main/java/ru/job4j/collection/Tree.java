package ru.job4j.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> prnt = findBy(parent);
        if (prnt.isPresent()) {
            Node<E> prntNod = prnt.get();
            if (findBy(child).isEmpty()) {
                rsl = prntNod.getChildren().add(new Node<>(child));
            } else {
                rsl = false;
            }
        }

        return rsl;
    }

    public Optional<Node<E>> find(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }


    public boolean isBinary() {
        return find(p -> p.getChildren().size() > 2).isEmpty();

    }

    public Optional<Node<E>> findBy(E value) {
        return find(p -> p.getValue().equals(value));
    }


    public static void main(String[] args) {
        Tree<Integer> integerTree = new Tree<>(1);

        integerTree.add(1, 2);
        integerTree.add(1, 3);
        integerTree.add(1, 4);
//        integerTree.add(1, 46);

//        System.out.println(integerTree.isBinary());

        System.out.println(integerTree.findBy(4));

    }

}
