package com.example.post_keeper.app.repository;

import com.example.post_keeper.app.entity.HistoryTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryTypeRepository extends JpaRepository<HistoryTypeEntity, Long> {
}
