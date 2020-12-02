package ru.job4j.generics;

import javax.management.relation.Role;

public class RoleStore implements Store<Rol> {

    private final Store<Rol> store = new MemStore<>();

    @Override
    public void add(Rol model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Rol model) {
        return store.replace(id, model);

    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public Rol findById(String id) {
        return store.findById(id);
    }
}
