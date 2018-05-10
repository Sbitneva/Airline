package sbitneva.dao;

import sbitneva.entity.Entity;

public interface CRUD<T extends Entity> {
    void create(T entity);

    T read(Integer id);

    void update(T entity1, T entity2);

    void delete(Integer id);
}
