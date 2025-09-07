package com.away.mappers;

import com.away.db.models.ItemEntity;
import com.away.db.models.UserEntity;
import com.away.dto.createDto.CreateItemDto;
import com.away.dto.responseDto.ResponseItemDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemsMapper {



        @Mapping(target = "userId", source = "itemUser.userId")
        ResponseItemDto toResponseItemDTO(ItemEntity itemEntity);

        List<ItemEntity> toItemEntityList(List<CreateItemDto> CreateItemDtos);

        List<ResponseItemDto> toResponseItemDTOs(List<ItemEntity> itemEntityList);

        @Mapping(target = "itemUser", ignore = true)
        ItemEntity toItemEntity(CreateItemDto createItemDto);
}
