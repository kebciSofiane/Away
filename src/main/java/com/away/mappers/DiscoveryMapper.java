package com.away.mappers;

import com.away.db.models.DiscoveryEntity;
import com.away.db.models.UserEntity;
import com.away.dto.createDto.CreateDiscoveryDto;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.responseDto.ResponseDiscoveryDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateDiscoveryDto;
import com.away.dto.updateDto.UpdateUserDto;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DiscoveryMapper {

    @Mapping(target = "discoveryUser", ignore = true)
    @Mapping(target = "discoveredItem", ignore = true)
    DiscoveryEntity toDiscoveryEntity(CreateDiscoveryDto dto);

    @Mapping(target = "userId", source = "discoveryUser.userId")
    @Mapping(target = "itemId", source = "discoveredItem.itemId")
    ResponseDiscoveryDto toResponseDiscoveryDTO(DiscoveryEntity entity);

    List<DiscoveryEntity> toDiscoveryEntityList(List<CreateDiscoveryDto> createDiscoveryDtos);

    List<ResponseDiscoveryDto> toResponseDiscoveryDTOs(List<DiscoveryEntity> discoveryEntityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDiscoveryFromDto(UpdateDiscoveryDto dto, @MappingTarget DiscoveryEntity discoveryEntity);
}
