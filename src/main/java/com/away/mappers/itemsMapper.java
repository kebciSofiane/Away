package com.away.mappers;

import com.away.db.models.ItemEntity;
import com.away.dto.createDto.CreateItemDto;
import com.away.dto.responseDto.ResponseItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface itemsMapper {



        ItemEntity toItemEntity(CreateItemDto dto);

        ResponseItemDto toResponseItemDTO(ItemEntity entity);


}
