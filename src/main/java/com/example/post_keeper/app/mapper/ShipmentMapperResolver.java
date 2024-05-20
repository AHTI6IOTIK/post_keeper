package com.example.post_keeper.app.mapper;

import com.example.post_keeper.app.entity.ShipmentTypeEntity;
import com.example.post_keeper.app.exception.EntityNotFoundException;
import com.example.post_keeper.app.repository.ShipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ShipmentMapperResolver {
    @Autowired
    ShipmentTypeRepository shipmentTypeRepository;

    public ShipmentTypeEntity longMapToShipmentTypeEntity(Long value) {
        Optional<ShipmentTypeEntity> shipmentType = shipmentTypeRepository.findById(value);

        return shipmentType.orElseThrow(() -> new EntityNotFoundException("shipment type", value));
    }

    public Long shipmentTypeEntityMapToLong(ShipmentTypeEntity entity) {
        return entity.getId();
    }
}
