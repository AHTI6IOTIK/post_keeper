package com.example.post_keeper.app.mapper;

import com.example.post_keeper.app.dto.PostOfficeDto;
import com.example.post_keeper.app.entity.PostOfficeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostOfficeMapper {
    PostOfficeDto toDto(PostOfficeEntity entity);
    List<PostOfficeDto> toDtoList(List<PostOfficeEntity> entities);

    PostOfficeEntity toModel(PostOfficeDto dto);
    List<PostOfficeEntity> toModelList(List<PostOfficeDto> dtos);
}
