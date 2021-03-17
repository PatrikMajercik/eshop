package com.cleevio.task.eshop.API;

import com.sun.istack.NotNull;

import java.util.List;
import java.util.Optional;

public interface WatchFacade {
    /**
     * Create a given entity.
     *
     * @param watchDTO must not be {@literal null}.
     * @return created watchDTO with generated ID; will never be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null} or id is not null.
     */
    void create(@NotNull WatchDTO watchDTO);

    /**
     * Retrieves an WatchDTO by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     * @throws IllegalArgumentException if {@literal id} is {@literal null}.
     */
    Optional<WatchDTO> findById(@NotNull Long id);

    /**
     * Update a given entity.
     *
     * @param watchDTO must not be {@literal null} and id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null} or id is null.
     */
    void update(@NotNull WatchDTO watchDTO);

    /**
     * Returns all instances of the WatchDTO.
     *
     * @return all watchesDTO
     */
    List<WatchDTO> findAll();

    /**
     * Deletes a given watch.
     *
     * @param watchDTO must not be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null} or id is null.
     */
    void delete(@NotNull WatchDTO watchDTO);
}
