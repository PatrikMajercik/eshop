package com.cleevio.task.eshop.API;

import java.util.List;
import java.util.Optional;

public interface WatchFacade {
    void create(WatchDTO watchDTO);

    Optional<WatchDTO> findById(Long id);

    void update(WatchDTO watchDTO);

    List<WatchDTO> findAll();

    void delete(WatchDTO watchDTO);
}
