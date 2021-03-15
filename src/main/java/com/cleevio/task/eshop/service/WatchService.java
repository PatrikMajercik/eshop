package com.cleevio.task.eshop.service;

import com.cleevio.task.eshop.dao.Watch;

import java.util.List;
import java.util.Optional;

public interface WatchService {
    void create(Watch watch);
    Optional<Watch> findById(Long id);
    void update(Watch watch);
    List<Watch> findAll();
    void delete(Watch watch);
}
