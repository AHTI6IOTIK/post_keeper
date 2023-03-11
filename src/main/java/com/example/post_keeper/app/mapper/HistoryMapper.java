package com.example.post_keeper.app.mapper;

import com.example.post_keeper.app.dto.MovingHistoryDto;
import com.example.post_keeper.app.entity.HistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryMapper {
    @Mapping(target = "date", source = "date")
    @Mapping(target = "type", source = "historyType.name")
    @Mapping(target = "postOffice.zipcode", source = "postOffice.zipcode")
    @Mapping(target = "postOffice.name", source = "postOffice.name")
    @Mapping(target = "postOffice.address", source = "postOffice.address")
    MovingHistoryDto toMovingDto(HistoryEntity entity);

    List<MovingHistoryDto> toMovingDtoList(List<HistoryEntity> entities);
}
