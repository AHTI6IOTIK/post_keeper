package com.example.post_keeper.app.repository;

import com.example.post_keeper.app.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<ShipmentEntity, Long> {
}
