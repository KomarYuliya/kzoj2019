package com.company;

public interface DAO<Entity, Key> {
    boolean create(Entity object);
    Entity read(Key key);
    boolean update(Entity object);
    boolean delete(Key key);
    String getTableView(String data);
}
