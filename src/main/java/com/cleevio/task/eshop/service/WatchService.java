package com.cleevio.task.eshop.service;

import com.cleevio.task.eshop.dao.Watch;

import java.util.List;

public interface WatchService {
    void create(Watch watch);
    Watch getById(Long id);
    void update(Watch watch);
    List<Watch> findAll();
    void delete(Watch watch);
}
