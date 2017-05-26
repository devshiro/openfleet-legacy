package com.markbudai.openfleet.dao.repositories;

import java.util.List;

/**
 * Generic interface describing operations for DAO.
 * @param <T> the type of elements managed by the repository.
 */
public interface Repository<T extends Object> {
    /**
     * Store {@code T} object.
     * @param t object to store.
     */
    void add(T t);

    /**
     * Update stored {@code T} object.
     * @param t object to update.
     */
    void update(T t);

    /**
     * Gets {@code T} object by {@code id}.
     * @param id the {@code id} of the {@code T} object.
     * @return the {@code T} object with given {@code id}.
     */
    T getById(long id);

    /**
     * Gets all {@code T} objects from store.
     * @return all {@code T} objects from store.
     */
    List<T> getAll();
}