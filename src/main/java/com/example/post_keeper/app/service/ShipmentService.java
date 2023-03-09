package com.example.post_keeper.app.service;

import com.example.post_keeper.app.dto.MovingShipmentDto;
import com.example.post_keeper.app.dto.RegisterShipmentDto;
import com.example.post_keeper.app.dto.ShipmentStatusDto;
import com.example.post_keeper.app.entity.ShipmentEntity;
import com.example.post_keeper.app.entity.ShipmentTypeEntity;
import com.example.post_keeper.app.exception.EntityNotFoundException;
import com.example.post_keeper.app.mapper.ShipmentMapper;
import com.example.post_keeper.app.repository.ShipmentRepository;
import com.example.post_keeper.app.repository.ShipmentTypeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {
    private final ShipmentTypeRepository shipmentTypeRepository;
    private final ShipmentRepository shipmentRepository;
    private final HistoryService historyService;
    private final ShipmentMapper shipmentMapper;

    public ShipmentService(
        ShipmentTypeRepository shipmentTypeRepository,
        ShipmentRepository shipmentRepository,
        HistoryService historyService,
        ShipmentMapper shipmentMapper
    ) {
        this.shipmentTypeRepository = shipmentTypeRepository;
        this.shipmentRepository = shipmentRepository;
        this.historyService = historyService;
        this.shipmentMapper = shipmentMapper;
    }

    public void processShipmentType(List<ShipmentTypeEntity> newType) {
        try {
            shipmentTypeRepository.saveAll(newType);
        } catch (DataIntegrityViolationException ignored) {
        }
    }

    public List<ShipmentTypeEntity> getShipmentTypes() {
        return shipmentTypeRepository.findAll();
    }

    public void registrationShipment(RegisterShipmentDto registerDto) {
        ShipmentEntity shipmentEntity = shipmentMapper.toModelByRegistrationDto(registerDto);
        shipmentRepository.save(shipmentEntity);
        historyService.move(shipmentEntity.getId(), registerDto.getPostOffice(), registerDto.getHistoryType());
    }

    public void moveShipment(MovingShipmentDto moveDto) {
        ShipmentEntity shipment = shipmentRepository.findById(moveDto.getShipmentId())
            .orElseThrow(() -> new EntityNotFoundException("shipment", moveDto.getShipmentId()));

        historyService.move(shipment.getId(), moveDto.getPostOffice(), moveDto.getHistoryType());
    }

    public ShipmentStatusDto getShipmentHistory(Long shipmentId) {

        var shipment = shipmentRepository.findById(shipmentId).orElseThrow(RuntimeException::new);
        var history = historyService.findHistoryByShipment(shipmentId);
        return shipmentMapper.toShipmentStatusDto(shipment, history);
    }
}
