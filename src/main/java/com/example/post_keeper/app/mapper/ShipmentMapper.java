package com.example.post_keeper.app.mapper;

import com.example.post_keeper.app.dto.RegisterShipmentDto;
import com.example.post_keeper.app.dto.ShipmentStatusDto;
import com.example.post_keeper.app.entity.HistoryEntity;
import com.example.post_keeper.app.entity.ShipmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {ShipmentMapperResolver.class, HistoryMapper.class})
public interface ShipmentMapper {
    @Mapping(target = "id", ignore = true)
    ShipmentEntity toModelByRegistrationDto(RegisterShipmentDto dto);

    @Mapping(target = "shipmentType", source = "shipment.shipmentType.name")
    @Mapping(target = "recipientZipcode", source = "shipment.recipientZipcode")
    @Mapping(target = "recipientAddress", source = "shipment.recipientAddress")
    @Mapping(target = "recipientName", source = "shipment.recipientName")
    @Mapping(target = "historyList", source = "histories")
    ShipmentStatusDto toShipmentStatusDto(ShipmentEntity shipment, List<HistoryEntity> histories);

}
