package com.example.post_keeper.app.repository;

import com.example.post_keeper.app.entity.ShipmentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentTypeEntity, Long> {
}
