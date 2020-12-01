package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        mem.set(Integer.parseInt(id), model);
        if (mem.get(Integer.parseInt(id)).equals(model)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int sizeM = mem.size();
        mem.remove(Integer.parseInt(id));
        if (mem.size() == sizeM - 1) {
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.get(Integer.parseInt(id));
    }
}
