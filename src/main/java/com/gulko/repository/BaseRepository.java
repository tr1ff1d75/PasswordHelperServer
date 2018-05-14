package com.gulko.repository;

import com.gulko.entity.BasePH;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaseRepository extends JpaRepository<BasePH, Long> {
}
