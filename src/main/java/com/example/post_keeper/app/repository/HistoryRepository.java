package com.example.post_keeper.app.repository;

import com.example.post_keeper.app.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
    Optional<List<HistoryEntity>> findAllByShipmentIdOrderByDate(Long shipmentId);
}
