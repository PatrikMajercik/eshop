package com.cleevio.task.eshop.service;

import com.cleevio.task.eshop.dao.Watch;
import com.cleevio.task.eshop.dao.WatchRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchServiceImpl implements WatchService {

    @Autowired
    WatchRepository watchRepository;

    @Override
    public void create(@NotNull Watch watch) {
        if (watch.getId() != null) {
            throw new IllegalArgumentException("ID must be null for creation");
        }
        watchRepository.save(watch);
    }

    @Override
    public Watch getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID can not be null");
        }
        return watchRepository.getOne(id);
    }

    @Override
    public void update(Watch watch) {
        if (watch.getId() == null) {
            throw new IllegalArgumentException("ID must be non-null for creation");
        }
        watchRepository.save(watch);
    }

    @Override
    public List<Watch> findAll() {
        return watchRepository.findAll();
    }

    @Override
    public void delete(Watch watch) {
        if (watch.getId() != null) {
            throw new IllegalArgumentException("ID can not be null");
        }

        watchRepository.delete(watch);
    }
}
