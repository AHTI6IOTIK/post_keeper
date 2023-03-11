package com.example.post_keeper.app.mapper;

import com.example.post_keeper.app.dto.HistoryTypeDto;
import com.example.post_keeper.app.entity.HistoryTypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryTypeMapper {
    HistoryTypeDto toDto(HistoryTypeEntity entity);
    List<HistoryTypeDto> toDtoList(List<HistoryTypeEntity> entities);

    HistoryTypeEntity toModel(HistoryTypeDto dto);
    List<HistoryTypeEntity> toModelList(List<HistoryTypeDto> dtos);
}
