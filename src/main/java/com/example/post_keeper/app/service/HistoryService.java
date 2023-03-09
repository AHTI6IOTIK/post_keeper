package com.example.post_keeper.app.service;

import com.example.post_keeper.app.entity.*;
import com.example.post_keeper.app.exception.EntityNotFoundException;
import com.example.post_keeper.app.repository.HistoryRepository;
import com.example.post_keeper.app.repository.HistoryTypeRepository;
import com.example.post_keeper.app.repository.PostOfficeRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Valid
public class HistoryService {
    private final HistoryTypeRepository historyTypeRepository;
    private final HistoryRepository historyRepository;
    private final PostOfficeRepository postOfficeRepository;

    public HistoryService(
        HistoryTypeRepository historyTypeRepository,
        HistoryRepository historyRepository,
        PostOfficeRepository postOfficeRepository
    ) {
        this.historyTypeRepository = historyTypeRepository;
        this.historyRepository = historyRepository;
        this.postOfficeRepository = postOfficeRepository;
    }

    public void processHistoryType(List<HistoryTypeEntity> newType) {
        try {
            historyTypeRepository.saveAll(newType);
        } catch (DataIntegrityViolationException ignored) {
        }
    }

    public List<HistoryTypeEntity> getHistoryTypes() {
        return historyTypeRepository.findAll();
    }

    public void move(@NotNull Long shipmentId, @NotNull Long postOfficeId, @NotNull Long shipmentTypeId) {
        Optional<HistoryTypeEntity> historyType = historyTypeRepository.findById(shipmentTypeId);
        HistoryTypeEntity historyTypeEntity = historyType.orElseThrow(() -> new EntityNotFoundException("shipment type",  shipmentTypeId));

        Optional<PostOfficeEntity> postOfficeOptional = postOfficeRepository.findById(postOfficeId);
        PostOfficeEntity postOffice = postOfficeOptional.orElseThrow(() -> new EntityNotFoundException("post office",  postOfficeId));

        HistoryEntity history = new HistoryEntity();
        ShipmentEntity shipment = new ShipmentEntity();

        shipment.setId(shipmentId);

        history.setDate(LocalDateTime.now());
        history.setShipment(shipment);
        history.setHistoryType(historyTypeEntity);
        history.setPostOffice(postOffice);

        historyRepository.save(history);
    }

    public List<HistoryEntity> findHistoryByShipment(Long shipmentId) {
        return historyRepository.findAllByShipmentIdOrderByDate(shipmentId).orElseThrow(() -> new EntityNotFoundException("history by shipment", shipmentId));
    }
}
