package com.cleevio.task.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchesRepository extends JpaRepository<WatchesDAO,Long> {

}
