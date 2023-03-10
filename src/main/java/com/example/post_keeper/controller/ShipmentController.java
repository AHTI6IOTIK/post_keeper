package com.example.post_keeper.controller;

import com.example.post_keeper.app.dto.MovingShipmentDto;
import com.example.post_keeper.app.dto.RegisterShipmentDto;
import com.example.post_keeper.app.dto.ShipmentStatusDto;
import com.example.post_keeper.app.dto.ShipmentTypeDto;
import com.example.post_keeper.app.mapper.ShipmentTypeMapper;
import com.example.post_keeper.app.service.ShipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@Tag(name = "Shipment")
@RequestMapping("/api/shipment")
public class ShipmentController {
    private final ShipmentService service;
    private final ShipmentTypeMapper shipmentTypeMapper;

    public ShipmentController(
        ShipmentService service,
        ShipmentTypeMapper shipmentTypeMapper
    ) {
        this.service = service;
        this.shipmentTypeMapper = shipmentTypeMapper;
    }

    @PostMapping
    @Operation(summary = "Registration shipment package")
    public void registrationShipment(
        @Valid @RequestBody RegisterShipmentDto registerShipmentDto,
        HttpServletResponse response
    ) {
        service.registrationShipment(registerShipmentDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @PostMapping("/move")
    @Operation(summary = "Moving shipment")
    public void moveShipment(
        @Valid @RequestBody MovingShipmentDto movingShipmentDto,
        HttpServletResponse response
    ) {
        service.moveShipment(movingShipmentDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @GetMapping("/history/{shipmentId}")
    @Operation(summary = "History of movements")
    public ShipmentStatusDto getShipmentHistory(
        @PathVariable Long shipmentId
    ) {
        return service.getShipmentHistory(shipmentId);
    }

    @GetMapping("/type")
    @Operation(
        summary = "Get all shipment types"
    )
    public ResponseEntity<List<ShipmentTypeDto>> processShipmentType() {
        return ResponseEntity.ok(shipmentTypeMapper.listEntitiesToDtoList(service.getShipmentTypes()));
    }

    @PostMapping("/type")
    @Operation(
        summary = "Create or update shipment type"
    )
    public void processShipmentType(
        @Valid @RequestBody List<ShipmentTypeDto> shipmentTypes,
        HttpServletResponse response
    ) {
        service.processShipmentType(shipmentTypeMapper.toModelList(shipmentTypes));
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
