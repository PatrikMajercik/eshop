package com.cleevio.task.eshop.API;

import com.cleevio.task.eshop.dao.Watch;

import java.util.List;

public interface WatchFacade {
    void create(WatchDTO watchDTO);
    WatchDTO getById(Long id);
    void update(WatchDTO watchDTO);
    List<WatchDTO> findAll();
    void delete(WatchDTO watchDTO);
}
