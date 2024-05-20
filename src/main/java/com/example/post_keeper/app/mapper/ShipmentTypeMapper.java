package com.example.post_keeper.app.mapper;

import com.example.post_keeper.app.dto.ShipmentTypeDto;
import com.example.post_keeper.app.entity.ShipmentTypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipmentTypeMapper {
    ShipmentTypeEntity toModel(ShipmentTypeDto dto);
    List<ShipmentTypeEntity> toModelList(List<ShipmentTypeDto> list);

    ShipmentTypeDto toDto(ShipmentTypeEntity entity);
    List<ShipmentTypeDto> listEntitiesToDtoList(List<ShipmentTypeEntity> entities);
}
