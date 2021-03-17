package com.cleevio.task.eshop.service;

import com.cleevio.task.eshop.dao.Watch;
import com.sun.istack.NotNull;

import java.util.List;
import java.util.Optional;

public interface WatchService {
    /**
     * Create a given entity.
     *
     * @param watch must not be {@literal null}.
     * @return created watch with generated ID; will never be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null} or id is not null.
     */
    void create(@NotNull Watch watch);

    /**
     * Retrieves an Watch by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     * @throws IllegalArgumentException if {@literal id} is {@literal null}.
     */
    Optional<Watch> findById(@NotNull Long id);

    /**
     * Update a given entity.
     *
     * @param watch must not be {@literal null} and id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null} or id is null.
     */
    void update(@NotNull Watch watch);

    /**
     * Returns all instances of the Watch.
     *
     * @return all watches
     */
    List<Watch> findAll();

    /**
     * Deletes a given watch.
     *
     * @param watch must not be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null} or id is null.
     */
    void delete(@NotNull Watch watch);
}
